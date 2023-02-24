CREATE TABLE IF NOT EXISTS customer(
    id SERIAL,
    nui VARCHAR(10),
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    email VARCHAR(50),
    PRIMARY KEY (id)
);