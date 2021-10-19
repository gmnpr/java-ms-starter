CREATE TABLE goods (
    id          SERIAL PRIMARY KEY,
    user_id     SERIAL,
    message     TEXT,
    send_date   TIMESTAMP
);