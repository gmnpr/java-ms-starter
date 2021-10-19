CREATE TABLE pays (
    id        SERIAL PRIMARY KEY,
    user_id   SERIAL
);

CREATE TABLE contents (
    id         SERIAL PRIMARY KEY,
    goods_id   SERIAL,
    count      SMALLSERIAL,
    pay_id     SERIAL,

    CONSTRAINT FK_PAY FOREIGN KEY (pay_id) REFERENCES pays (id)
);