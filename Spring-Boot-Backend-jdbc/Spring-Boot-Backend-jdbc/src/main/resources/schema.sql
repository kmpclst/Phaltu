CREATE TABLE IF NOT EXISTS product (
    prod_id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    prod_name VARCHAR(255) NOT NULL UNIQUE,
    price     INT          NOT NULL
);
