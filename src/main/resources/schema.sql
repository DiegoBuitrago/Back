CREATE TABLE CLIENT (
    document_number BIGINT PRIMARY KEY,
    document_type VARCHAR(1),
    first_name VARCHAR(20),
    middle_name VARCHAR(20),
    last_name VARCHAR(20),
    second_last_name VARCHAR(20),
    phone VARCHAR(14),
    address VARCHAR(40),
    city VARCHAR(20)
);