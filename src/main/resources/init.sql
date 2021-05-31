CREATE TABLE IF NOT EXISTS user_role
(
    user_role_id   IDENTITY,
    user_role_name VARCHAR(48) UNIQUE NOT NULL,
    PRIMARY KEY (user_role_id)
);

CREATE TABLE IF NOT EXISTS us_er
(
    user_id      IDENTITY,
    username     VARCHAR(48) UNIQUE NOT NULL,
    password     VARCHAR(128)       NOT NULL,
    email        VARCHAR(128)       NOT NULL,
    user_role_id BIGINT             NOT NULL,
    PRIMARY KEY (user_id),
    FOREIGN KEY (user_role_id) REFERENCES user_role (user_role_id) ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS product_mu
(
    mu_id   IDENTITY,
    mu_abbr VARCHAR(8) NOT NULL UNIQUE,
    PRIMARY KEY (mu_id)
);

CREATE TABLE IF NOT EXISTS product_type
(
    type_id   IDENTITY,
    type_name VARCHAR(48) NOT NULL UNIQUE,
    PRIMARY KEY (type_id)
);

CREATE TABLE IF NOT EXISTS product
(
    product_id IDENTITY,
    type_id    BIGINT        NOT NULL,
    mu_id      BIGINT        NOT NULL,
    wood_type  VARCHAR(48)   NOT NULL,
    wood_kind  VARCHAR(48)   NOT NULL,
    price      DECIMAL(8, 2) NOT NULL,
    amount     INT           NOT NULL,
    visible    BOOLEAN       NOT NULL DEFAULT FALSE,
    PRIMARY KEY (product_id),
    FOREIGN KEY (type_id) REFERENCES product_type (type_id) ON UPDATE CASCADE,
    FOREIGN KEY (mu_id) REFERENCES product_mu (mu_id) ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS ord_er
(
    order_id       IDENTITY,
    customer_name  VARCHAR(48) NOT NULL,
    customer_phone VARCHAR(48) NOT NULL,
    customer_email VARCHAR(48),
    order_details  TEXT,
    order_date     TIMESTAMP                                        DEFAULT CURRENT_TIMESTAMP(),
    order_status   ENUM ('NEW', 'PROCESSED', 'CLOSED', 'CANCELLED') DEFAULT 'NEW',
    PRIMARY KEY (order_id)
);

CREATE TABLE IF NOT EXISTS order_product
(
    order_id       BIGINT  NOT NULL,
    product_id     BIGINT  NOT NULL,
    amount_ordered INT     NOT NULL,
    price_order    NUMERIC NOT NULL,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES ord_er (order_id) ON UPDATE CASCADE,
    FOREIGN KEY (product_id) REFERENCES product (product_id) ON UPDATE CASCADE
);

INSERT INTO user_role (USER_ROLE_ID, USER_ROLE_NAME)
VALUES (1, 'just_user'),
       (2, 'admin');

INSERT INTO us_er (username, password, email, user_role_id)
VALUES ('admin1',
        '$2y$12$UhGlCTnmR3oACSVhWzYvNe7Le9NRN8X/A0vLA/Y2l3LbeQ6qbEKZ.',
        'admin.one@geemail.com', '2'),
       ('admin2',
        '$2y$12$LvJ.2Bjf5tBeJV8molIUh.v/ruAgRmBj3dgA4gcutJ6Tpd9sPVRDu',
        'admin.two@geemail.com', '2');

INSERT INTO PRODUCT_TYPE (TYPE_NAME)
VALUES ('Вагонка'),
       ('Блок-хаус'),
       ('Доска пола'),
       ('Террасная доска'),
       ('Палубная доска'),
       ('Фальш-брус'),
       ('Планкен'),
       ('Нащельник'),
       ('Нащельник с косичкой'),
       ('Плинтус'),
       ('Уголок');

INSERT INTO PRODUCT_MU (MU_ABBR)
VALUES ('м2'),
       ('м.п.'),
       ('вагонка');

INSERT INTO PRODUCT (TYPE_ID, MU_ID, WOOD_TYPE, WOOD_KIND, PRICE, AMOUNT)
VALUES (1, 1, 'Сосна', 'Первый', 110.0, 1092),
       (1, 1, 'Смерека', 'Первый', 100.0, 3050),
       (1, 1, 'Липа', 'Второй', 190.0, 1811),
       (1, 1, 'Липа', 'Первый', 140.0, 2021),
       (1, 1, 'Ольха', 'Второй', 190.0, 1639),
       (1, 1, 'Ольха', 'Первый', 299.0, 879),
       (2, 1, 'Смерека', 'Первый', 250.0, 672),
       (2, 1, 'Сосна', 'Второй', 250.0, 449),
       (2, 1, 'Сосна', 'Первый', 385.0, 412),
       (3, 1, 'Сосна', 'Первый', 385.0, 380),
       (3, 1, 'Сосна', 'Второй', 250.0, 717),
       (3, 1, 'Смерека', 'Первый', 330.0, 57),
       (4, 1, 'Сосна', 'Первый', 385.0, 53),
       (5, 1, 'Сосна', 'Первый', 385.0, 57),
       (6, 1, 'Сосна', 'Первый', 280.0, 2002),
       (6, 1, 'Смерека', 'Первый', 250.0, 1100),
       (7, 1, 'Сосна', 'Первый', 250.0, 6103),
       (8, 1, 'Смерека', 'Первый', 10.14, 196),
       (9, 1, 'Смерека', 'Первый', 13.65, 190);

UPDATE PRODUCT
SET VISIBLE = true;

INSERT INTO ORD_ER (CUSTOMER_NAME, CUSTOMER_PHONE, CUSTOMER_EMAIL,
                    ORDER_DETAILS, ORDER_DATE, ORDER_STATUS)
VALUES ('Аркадий', '+7777777', 'arkm@html.com', 'нащельник 3 штуки',
        '2020-05-15 12:20:22', 'CLOSED')
        ,
       ('Тест', '+050050', 'manager@vagonka.kharkov.ua',
        'просто проверяю отправку контрактов', '2020-05-14 22:46:27',
        'CANCELLED')
        ,
       ('Аня', '+09090', '', 'хочу заказать плинтус', '2020-05-15 10:33:16',
        'PROCESSED')
        ,
       ('Фёдор', '+099388444', 'gaz38gaz@mail.ru',
        'хотел бы заказать досок пола, штук 50, если можно',
        '2020-05-17 19:03:27', 'PROCESSED')
        ,
       ('Антон', '099999999', 'antzant@xmail.com',
        'хочу оформить заказ. можете перезвонить?', '2020-05-17 19:03:16',
        'NEW')
        ,
       ('Эрнест', '+033773377', 'ernesty@mylo.ua',
        'Добрый день! Хочу заказать вагонку смереку 2 на 3 150 м2. Срочно!',
        '2020-05-15 22:41:58', 'NEW')
        ,
       ('Алекс', '+3334333', 'xelalex@mirbig.ru', 'нащельник 30 м2',
        '2020-05-17 13:49:53', 'NEW')
        ,
       ('Максим', '+050505005', 'pcws@gh.com', 'хотел бы сотрудничать с вами',
        '2020-05-17 21:14:36', 'CANCELLED');