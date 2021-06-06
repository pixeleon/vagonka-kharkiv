package net.khpi.shevvaddm.vagonka.export;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import net.khpi.shevvaddm.vagonka.dto.AdminProductDto;
import net.khpi.shevvaddm.vagonka.dto.DtoUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ExportUtils {

    private static final String PDF_FONT_SRC = "src/main/resources/times.ttf";
    private final String[] productHeaders = { "Продукт", "Тип дерева",
            "Тип дерева", "Цена (грн.)", "Ед. изм.", "Кол-во", "Видимый" };

    private DtoUtils dtoUtils;

    @Autowired
    public void setDtoUtils(DtoUtils dtoUtils) {
        this.dtoUtils = dtoUtils;
    }

    public void exportProductsToPdf(List<AdminProductDto> products) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document,
                    new FileOutputStream("products.pdf"));

            document.open();

            writePdfTitle(products, document);

            Font tableFont = FontFactory
                    .getFont(PDF_FONT_SRC, BaseFont.IDENTITY_H, true, 12);

            PdfPTable table = new PdfPTable(7);

            writePdfTableHeader(tableFont, table);

            writePDfTableRows(products, tableFont, table);

            document.add(table);

            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private void writePDfTableRows(List<AdminProductDto> products, Font tableFont,
            PdfPTable table) {
        for (AdminProductDto dto : products) {
            for (String value : dtoUtils.mapAdminProductDtoToStringArray(dto)) {
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(new Phrase(value, tableFont));
                table.addCell(cell);
            }
        }
    }

    private void writePdfTableHeader(Font tableFont, PdfPTable table) {
        Stream.of(productHeaders).forEach(columnTitle -> {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(1);
            header.setPhrase(new Phrase(columnTitle, tableFont));
            table.addCell(header);
        });
    }

    private void writePdfTitle(List<AdminProductDto> products, Document document)
            throws DocumentException {
        Font titleFont = FontFactory
                .getFont(PDF_FONT_SRC, BaseFont.IDENTITY_H, true, 24);
        Chunk chunk =
                new Chunk("СПИСОК ПРОДУКТОВ (" + products.size() +
                        " единиц)", titleFont);

        document.add(chunk);
        document.add(new Phrase("\n\n"));
    }

    public void exportProductsToExcel(List<AdminProductDto> products) {
        try {
            File currDir = new File(".");
            String path = currDir.getAbsolutePath();
            String fileLocation =
                    path.substring(0, path.length() - 1) + "products.xls";

            WritableWorkbook workbook = Workbook
                    .createWorkbook(new File(fileLocation));

            WritableSheet sheet = workbook.createSheet("Страница 1", 0);

            writeExcelTableHeader(sheet);

            WritableCellFormat cellFormat = getCellFormat();

            for (int i = 1; i < products.size(); i++) {
                AdminProductDto dto = products.get(i - 1);
                writeExcelTableRow(sheet, cellFormat, i, dto);
            }

            workbook.write();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }

    @NotNull
    private WritableCellFormat getCellFormat() throws WriteException {
        WritableCellFormat cellFormat = new WritableCellFormat();
        cellFormat.setWrap(true);
        return cellFormat;
    }

    private void writeExcelTableRow(WritableSheet sheet, WritableCellFormat cellFormat,
            int i, AdminProductDto dto) throws WriteException {
        Label cellLabel = new Label(0, i, dto.getTypeName(), cellFormat);
        sheet.addCell(cellLabel);
        cellLabel = new Label(1, i, dto.getWoodType(), cellFormat);
        sheet.addCell(cellLabel);
        cellLabel = new Label(2, i, dto.getWoodKind(), cellFormat);
        sheet.addCell(cellLabel);
        Number cellNumber = new Number(3, i, dto.getPrice().doubleValue(), cellFormat);
        sheet.addCell(cellNumber);
        cellLabel = new Label(4, i, dto.getMuAbbr(), cellFormat);
        sheet.addCell(cellLabel);
        cellNumber = new Number(5, i, dto.getAmount(), cellFormat);
        sheet.addCell(cellNumber);
        cellLabel = new Label(6, i, dto.getVisible().toString(), cellFormat);
        sheet.addCell(cellLabel);
    }

    private void writeExcelTableHeader(WritableSheet sheet)
            throws WriteException {

        WritableCellFormat headerFormat = getHeaderFormat();
        for (int i = 0; i < productHeaders.length; i++) {
            Label headerLabel = new Label(i, 0, productHeaders[i], headerFormat);
            sheet.setColumnView(0, 40);
            sheet.addCell(headerLabel);
        }
    }

    private WritableCellFormat getHeaderFormat()
            throws WriteException {
        WritableCellFormat headerFormat = new WritableCellFormat();
        WritableFont font =
                new WritableFont(WritableFont.TIMES, 12, WritableFont.BOLD);
        headerFormat.setFont(font);
        headerFormat.setBackground(Colour.GREY_25_PERCENT);
        headerFormat.setWrap(true);
        return headerFormat;
    }

    public void exportProductsToCsv(List<AdminProductDto> products) {
        try (FileWriter fileWriter = new FileWriter("products.csv");
             CSVPrinter printer = new CSVPrinter(fileWriter,
                CSVFormat.DEFAULT.withHeader(productHeaders))) {
            for (AdminProductDto dto : products) {
                printer.printRecord(dtoUtils.mapAdminProductDtoToStringArray(dto));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exportProductsToTxt(List<AdminProductDto> products) {
        try (FileWriter fileWriter = new FileWriter("products.txt");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println("СПИСОК ПРОДУКТОВ (" + products.size() + " единиц)");
            printWriter.printf("%n%-20s %-10s %-10s %-15s %-10s %-10s %-10s %n",
                    (Object[]) productHeaders);
            for (AdminProductDto dto : products) {
                printWriter.printf("%-20s %-10s %-10s %-15s %-10s %-10s %-10s %n",
                                dtoUtils.mapAdminProductDtoToStringArray(dto).toArray());
                printWriter.println();
            }
            printWriter.println("Получено " + LocalDate.now());
            printWriter.println("© Вагонка Харьков");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
