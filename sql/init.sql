DROP TABLE IF EXISTS account;

CREATE TABLE account (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    email VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(50) NOT NULL,
    role INT NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO account(email, name, role, password) VALUES
	('admin@gmail.com', 'admin', 0, '$2a$10$V2P4daPnPXxBsYNGNpBwmu.A91IXrzyJUUsU8E21Iz5foXhVlN3Sq');