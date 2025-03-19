-- ROLE INSERT
insert into roles (role_name) values ('Customer'), ('Manager');

-- ACCOUNT INSERT
insert into accounts (role_id, password, username) values (2, '1234', 'manager');
insert into accounts (role_id, password, username) values (1, '1234', 'customer');
insert into accounts (role_id, password, username) values (2, '1234', 'manager2');

-- USER INSERT
insert into users (account_id, first_name, last_name, phone, email) values (1, 'Valeria', 'Tapia', '5527619502', 'valeria@gmail.com');
insert into users (account_id, first_name, last_name, phone, email) values (2, 'Azael', 'Baeza', '5530142829', 'azael@gmail.com');
insert into users (account_id, first_name, last_name, phone, email) values (3, 'Hector', 'Lopez', '5580172940', 'hector@gmail.com');

-- Loan insert
INSERT INTO loans (amount_requested, loan_status_id, loan_type_id, user_id, last_update, manager_update, status_reason) values (100, null, null,1, '2025-14-3', '2025-16-3', 'IDK');
INSERT INTO loans (amount_requested, loan_status_id, loan_type_id, user_id, last_update, manager_update, status_reason) values (300, null, null,2, '2025-20-5', '2025-21-3', 'IDK´2');