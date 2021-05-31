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
    order_date     TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    order_status ENUM('NEW', 'PROCESSED', 'CLOSED', 'CANCELLED') DEFAULT 'NEW',
    PRIMARY KEY (order_id)
);

CREATE TABLE IF NOT EXISTS order_product
(
    order_id       BIGINT NOT NULL,
    product_id     BIGINT NOT NULL,
    amount_ordered INT    NOT NULL,
    price_order    NUMERIC NOT NULL,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES ord_er (order_id) ON UPDATE CASCADE,
    FOREIGN KEY (product_id) REFERENCES product (product_id) ON UPDATE CASCADE
)


