/*
 * With any database, you must be able to do the following:
 * 1. Drop tables
 * 2. Create tables
 * 3. Insert starting data
 * 4. Other needed queries that JDBC will be running for me
 */

/*1. DROP STATEMENTS*/
drop table if exists accounts;
drop table if exists users;
drop table if exists bank_roles;
drop table if exists account_status;
drop table if exists account_type;
drop table if exists bank_transaction;

/*2. CREATE STATEMENTS*/
create table accounts(
	account_id serial primary key,
	account_balance decimal(15, 2) not null,
	account_status varchar(30),
	account_type varchar(30),
	account_user_id int,
	account_creation_date date
);

create table users(
	user_id serial primary key,
	username varchar(30) unique not null,
	user_password varchar(30) not null,
	user_first_name varchar(50) not null,
	user_last_name varchar(50) not null,
	user_email varchar(100) not null,
	user_role_type varchar(30) not null
);

--setting the FK between users and accounts 
-- userid is the foreign key in the accounts table 
alter table accounts
add constraint fk_accounts_users
foreign key (account_user_id)
references users(user_id);

CREATE TABLE account_types(
	type_id INT PRIMARY KEY, 
	type_name VARCHAR(50) NOT NULL
);

--ACCOUNT ID IS FOREIGN KEY IN ACCOUNT_TYPES TABLE
ALTER TABLE account_types
ADD CONSTRAINT fk_constraint_accountTypesToAccounts
FOREIGN KEY (type_id)
REFERENCES accounts(account_id);

CREATE TABLE account_status(
	status_id INT PRIMARY KEY, 
	status_state VARCHAR(50) NOT NULL
);

--ACCOUNT ID IS FOREIGN KEY IN ACCOUNT_STATUS TABLE
ALTER TABLE account_status
ADD CONSTRAINT fk_accountStatusToAccounts
FOREIGN KEY (status_id)
REFERENCES accounts(account_id);

CREATE TABLE bank_roles(
	role_Type varchar(30) NOT NULL,
	role_id INT PRIMARY KEY
);
--USER ID IS FOREIGN KEY IN BANK_ROLES TABLE
ALTER TABLE bank_roles
ADD CONSTRAINT fk_constraint_bankRolesToUsers
FOREIGN KEY (role_id)
REFERENCES users (user_id);

CREATE TABLE bank_transactions(
	trans_id serial PRIMARY KEY,
	trans_account_id int,
	trans_time_stamp timestamp,
	trans_amount DECIMAL(15, 2) NOT NULL,
	trans_description_code int NOT NULL 
);
--account id is foreign key in bank_transactions table
ALTER TABLE bank_transactions
ADD CONSTRAINT fk_constraint_bankTransactionsToAccounts
FOREIGN KEY (trans_account_id)
REFERENCES accounts(account_id);

/*3. INSERT STATEMENTS*/
INSERT INTO users(username, user_password, user_first_name, user_last_name, user_email, user_role_type) 
	VALUES('aaknox','password', 'Azhya', 'Knox', 'azhya.knox@gmail.com', 'ADMIN');
INSERT INTO users(username, user_password, user_first_name, user_last_name, user_email, user_role_type) 
	VALUES('employee001','password', 'John', 'Smith', 'john.smith@yahoo.com', 'EMPLOYEE');
INSERT INTO users(username, user_password, user_first_name, user_last_name, user_email, user_role_type) 
	VALUES('customer001','suits123', 'Steve', 'Harvey', 'sharvey@gmail.com', 'CUSTOMER');
INSERT INTO users(username, user_password, user_first_name, user_last_name, user_email, user_role_type) 
	VALUES('customer002','sheready', 'Tiffany', 'Haddish', 'tiff.haddish34@hotmail.com', 'CUSTOMER');
INSERT INTO users (username, user_password, user_first_name, user_last_name, user_email, user_role_type) 
	VALUES ('trigga', 'songz123', 'Trey', 'Songz', 'trey.songz@gmail.com', 'CUSTOMER');

INSERT INTO accounts(account_type, account_status, account_balance, account_creation_date) VALUES('CHECKING','OPEN', 1500.25, '2017-01-15');
INSERT INTO accounts(account_type, account_status, account_balance, account_creation_date) VALUES('CHECKING','OPEN', 754.25, '2018-12-22');
INSERT INTO accounts(account_type, account_status, account_balance, account_creation_date) VALUES('SAVINGS','OPEN', 49.01, '2019-06-14');

UPDATE accounts SET account_user_id = 3 WHERE account_id = 1;
UPDATE accounts SET account_user_id = 3 WHERE account_id = 2;
UPDATE accounts SET account_user_id = 3 WHERE account_id = 3;

INSERT INTO bank_roles (role_id, role_type) VALUES (1, 'ADMIN');
INSERT INTO bank_roles (role_id, role_type) VALUES (2, 'EMPLOYEE');
INSERT INTO bank_roles (role_id, role_type) VALUES (3, 'CUSTOMER');
INSERT INTO bank_roles (role_id, role_type) VALUES (4, 'CUSTOMER');
INSERT INTO bank_roles (role_id, role_type) VALUES (5, 'CUSTOMER');

INSERT INTO account_status (status_id, status_state) VALUES(1, 'OPEN');
INSERT INTO account_status (status_id, status_state) VALUES(2, 'OPEN');
INSERT INTO account_status (status_id, status_state) VALUES(3, 'OPEN');

INSERT INTO account_types (type_id, type_name) VALUES(1, 'CHECKING');
INSERT INTO account_types (type_id, type_name) VALUES(2, 'CHECKING');
INSERT INTO account_types (type_id, type_name) VALUES(3, 'SAVINGS');

INSERT INTO bank_transactions (trans_account_id, trans_time_stamp, trans_amount, trans_description_code) VALUES (1, '2017-01-15 09:05:06', 1500.25, 200);
INSERT INTO bank_transactions (trans_account_id, trans_time_stamp, trans_amount, trans_description_code) VALUES (2, '2018-12-22 11:45:23', 754.25, 200);
INSERT INTO bank_transactions (trans_account_id, trans_time_stamp, trans_amount, trans_description_code) VALUES (3, '2019-06-14 14:33:12', 49.01, 200);

/*4. JDBC STATEMENTS*/
--Think CRUD!!
select * from users;
select * from users where user_id = 1;
select * from users where username = 'aaknox';
select * from bank_roles;

update users 
set 
	username = 'bob', 
	user_password = 'pass', 
	user_first_name = 'Ralph', 
	user_last_name = 'Smith', 
	user_email = 'email@aol.com', 
	user_role_type = 'EMPLOYEE' 
where user_id = 1;
