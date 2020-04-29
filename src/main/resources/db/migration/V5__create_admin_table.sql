CREATE TABLE admin_table (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

CREATE UNIQUE INDEX idx_admin_table_name ON admin_table(name);