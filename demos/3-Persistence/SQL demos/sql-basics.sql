--this is a comment "sql-basics.sql"

--DDL = data definition language = SQL  that focuses on the DB structure known as schema 
--single comment
/*
 * multiple comment
 */

--to start making your own databases, we must create a script that lays out the structure of the schema 

--commonly, we would see a series of DROP table statements at the beginning of any table creation script 
drop table if exists products;
drop table if exists employees;
drop table if exists departments;

--now let's make some tables by using the CREATE command
create table departments (
	--here we will set up our columns for this table along with placing any constraints to our columns 
	-- a constraint is a unique delimiter to the data in that category (ex. UNIQUE, NULL, NOT NULL, PRIMARY KEY, etc.)
	--name of column = id 
	--datatype = serial = autoincremented integer type (based off of a sequence, it will autoincrement)
	id serial constraint department_pk primary key, --inline constraint declaration
	--varchar = string values
	name varchar(25) unique not null, --varchar(size) = max num of characters that can be in that string
	--numeric is for decimal values
	monthly_budget numeric(8, 2) --numeric(#, #) = 1st is precision (# of digits allowed), 2nd is scale (# of decimal places)
);

create table employees(
	id serial,
	first_name varchar(25) not null,
	last_name varchar(25) not null,
	birthdate date not null,
	monthly_income numeric(7, 2),
	department_id int,
	hire_date date default current_date,
	job_title varchar(25) not null,
	email varchar(255) not null,
	
	--another way to declaring constraints (restrictions that we place on a column's behavior)
	--external constraint declaration here 
	constraint employees_pk
	primary key (id),
	
	--foreign key constraint here 
	--primary key is the unique identifer for any given table; is unique and not null column 
	--foreign key = the unique identifer from another table that holds a referenial integrity with one other table 
	-- aka PK from another table 
	constraint employee_department_fk
	foreign key (department_id)
	references departments 
	
	--NOTE: by default, FKs automatically point to the PK of the referenced table 
	--FKs can also point to non-PKs in a referenced table, so long as the referenced column is UNIQUE 
);

create table products(
	id serial,
	name varchar(50) not null,
	price numeric(7, 2) default 0,
	expiration_date date not null
);

--what DDL command can I use to modify my column with the Products table? ALTER!!
--BEWARE: do NOT confuse the UPDATE command with the ALTER. ALTER is DDL, UPDATE is always DML
alter table products 
add constraint products_pk primary key (id);
--No need to COMMIT the above statements because DDL statements are implicitly committed

--creating a FK constraint between products and employees
--1. product table needs a column that make it relatable back to employees
alter table products 
add logged_by int;

--2. make the FK constraint 
alter table products 
add constraint products_employees_fk
foreign key (logged_by)
references employees(id);

--to add a new record to a database table, you must use the INSERT command
--SQL strings are single-quoting ('') 
insert into departments values (1, 'Accounting', 200000);

--DDL multiple insert statements 
-- changing the way the schema looks
insert into departments (name, monthly_budget)
values
	('IT', 300000),
	('Human Resources', 25000),
	('Customer Service', 20000),
	('Internal Affairs', 5000);
	
insert into employees (first_name, last_name, birthdate, monthly_income, department_id, hire_date, job_title, email)
values 
	('John', 'SMITH', date '1995-01-01', 4000.00, 1, date '2015-03-28', 'AC_ACCOUNT', 'jsmith@company.com'),
	('JAMES', 'BOSH', date '1992-02-15', 3500.00, 2, date '2014-07-01', 'MK_REP', 'JBOSH'),
	('LUISA', 'JACKSON', date '1970-03-08', 4500.00, 3, date '2013-08-29', 'IT_PROG', 'LJACKSON'),
	('STUART', 'GARCIA', date '1965-04-12', 2000.00, 4, date '2010-02-15', 'HR_REP', 'SGARCIA'),
	('JUSTIN', 'BLACK', date '1990-05-16', 2550.00, 1, date '2015-05-02', 'AC_ACCOUNT', 'JBLACK'),
	('ANGIE', 'CROOD', date '1998-06-22', 1500.00, 1, date '2015-07-01', 'AC_ACCOUNT', 'ACROOD'),
	('CHARLES', 'DEAN', date '1973-06-08', 2250.00, 3, date '2002-03-01', 'IT_PROG', 'CDEAN'),
	('EDDIE', 'FARREL', date '1980-07-28', 3000.00, 1, date '2009-04-20', 'AC_ACCOUNT', 'EFARREL'),
	('GEORGE', 'HAYES', date '1982-08-03', 2500.00, 2, date '2012-09-22', 'MK_REP', 'GHAYES'),
	('IGOR', 'OSBOURNE', date '1987-09-11', 6000.00, 3, date '2014-11-14', 'IT_PROG', 'IKEYS'),
	('LUKE', 'MINT', date '1985-10-19', 5000.00, 4, date '2011-01-08', 'HR_REP', 'LMINT'),
	('NIGEL', 'OAKS', date '1997-11-05', 4750.00, 4, date '2014-10-01', 'HR_REP', 'NOAKS'),
	('LUKE', 'GREEN', date '1995-02-05', 4750.00, 4, date '2015-09-01', 'HR_REP', 'LGREEN');

insert into products (name, price, expiration_date, logged_by)
values 
	('Aspirin', 5.00, date '2022-12-31', 1),
	('Penicillin', 10.00, date '2019-04-30', 1),
	('Insulin', 25.50, date '2023-05-31', 1),
	('BadMedX', 6.00, date '1874-09-17', 1),
	('GoodMed3000', 1300.25, date '2025-12-31', 1);