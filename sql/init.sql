drop table if exists account;

create table account(
	id int primary key not null auto_increment,
    email varchar(50) not null unique,
    name varchar(50) not null,
    role int not null,
    password varchar(255) not null
);

insert into account(email, name, role, password) values
	('admin@gmail.com', 'admin', 0, '$2a$10$V2P4daPnPXxBsYNGNpBwmu.A91IXrzyJUUsU8E21Iz5foXhVlN3Sq');