-- ROLE INSERT
insert into roles (role_name) values ('Customer'), ('Manager');

-- ACCOUNT INSERT
insert into accounts (role_id, password, username) values (2, '1234', 'manager');
insert into accounts (role_id, password, username) values (1, '1234', 'customer');
insert into accounts (role_id, password, username) values (2, '1234', 'manager2');

-- USER INSERT
insert into users (account_id, first_name, last_name, phone, email) values (1, 'Valeria', 'Tapia', '5527619502', 'valeria@gmail.com');
insert into users (account_id, first_name, last_name, phone, email) values (2, 'Azael', 'Baeza', '5546782000', 'azael@gmail.com');

-- ADDRESS INSERT
insert into address (country, state, city, street, street_num, zip) values ('Mexico', 'Chihuahua', 'Chihuahua', 'Periferico', '200', '20100');
insert into address (country, state, city, street, street_num, zip) values ('Italy', 'Rome', 'Florence', 'Ave', '22', '58900');
