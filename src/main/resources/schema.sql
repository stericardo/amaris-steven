DROP TABLE IF EXISTS PRICES;

CREATE TABLE PRICES (
  id bigint AUTO_INCREMENT  PRIMARY KEY,
  BRAND_ID INT,
    PRODUCT_ID INT,
    PRIORITY INT,
    PRICE DOUBLE,
    PRICE_LIST INT,
    CURR VARCHAR(250) NOT NULL,
        START_DATE DATETIME(3),
        END_DATE DATETIME(3)
);

