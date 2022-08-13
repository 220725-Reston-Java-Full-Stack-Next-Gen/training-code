--single comment line
/*
 * multiple line comment 
 */
/* - What is SQL?
 * - stands for "structured query language"
 * - this is used to create and manage relational database using human-readable language
 * 
 * - What is a database?
 * = a collection of related data
 * 
 * - DBMS (database management system) is a collection of programs used to create and maintain a database.
 * 
 * - Why used a database?
 * = store our data in a structured format
 * = allows us concurrent use of data to many users
 * = control access to the data through usage of admin priveleges
 * = maintain data integrity aka maintain the consistency and accuracy of our data
 * = provides good data backup and recovery
 * 
 * - RDBMS (relational database management system) refers to a database that stores data in a structured format
 * consisting of tables, rows, and columns
 * 
 * table = collective group of data
 * column = data catergories
 * rows = particular instances of a data category
 * 
 * schema = layout of our database (similar to how classes are blueprints of our java objects)
 * -----------------
 * - Establishing relationships between tables through use of PKs and FKs is called "referenial integrity".
 * 
 * Ex.
 * 
 * Demo Schema:
 * 		- Departments
 * 			+ id (primary key) (unique identifer for a table = unique, not null)
 * 			+ name
 * 			+ monthly budget
 * 
 * 		- Employees
 * 			+ id (PK)
 * 			+ first_name
 * 			+ last_name
 * 			+ birthdate
 * 			+ monthly_income
 * 			+ department_id (foreign key) (unique identifer that is a PK in another table)
 * 			+ hire_date
 * 			+ job_title
 * 			+ email
 * 
 * 		- Products
 * 			+ id (PK)
 * 			+ name
 * 			+ price
 * 			+ expiration_date
 * */

/* - SQL can be broken down into 5 sublanguages:
 * 1) DDL (Data Definition Language) = used to manage the structure of datbase schema
 * Commands: CREATE, DROP, TRUNCATE, ALTER, RENAME
 * 2) DML (Data Manipulation Language) = used to manipulate the data in our database
 * Commands: INSERT, UPDATE, DELETE (commonly known as CRUD operations)(Create, Read, Update, Delete)
 * 3) DQL (Data Query Language) = used to retrieve information from our database
 * Commands: SELECT
 * 4) DCL (Data Control Language) = used to give privileges/access of our data
 * Commands: GRANT, REVOKE
 * 5) TCL (Transaction Control Language) = used to apply the changes of our data permanently into our database
 * Commands: COMMIT, ROLLBACK, SAVEPOINT
 */

-- common to see a series of DROP table statements at the beginning of any table creation script
drop table if exists products;
drop table if exists employees;
drop table if exists departments;

-- create my tables 
create table departments(
--serial is a autoincremented numeric datatype in SQL
-- varchar is for string values
-- numeric is for decimal numbers
	id serial constraint department_pk primary key, --inline constraint declaration
	name varchar(25) unique not null, --candidate key (a column that COULD be a primary key)
	monthly_budget numeric(8, 2) -- first # is precision (# of digits allowed), second # is scale (# of decimal places)
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
	email varchar(320) not null,
	
	--another way of declaring constraints (restrictions to a column's behavior)
	constraint employees_pk
	primary key (id),
	
	--foreign key constraint here
	constraint employee_department_fk
	foreign key (department_id)
	references departments
	
	--by default, FKs automatically point to the PK of the referenced table 
	--FKs can point to non-PK columns in a referenced table, so long as the referenced column is UNIQUE
);

create table products(
	id serial,
	name varchar(50) not null,
	price numeric(7, 2) default 0,
	expiration_date date not null
);

alter table products
add constraint products_pk primary key (id);
-- No need to COMMIT the above statements, DDL statements are implicitly commited

/* INSERT STATEMENTS */
-- sql strings are single-quoted
insert into departments values (1, 'Accounting', 20000);
insert into departments (name, monthly_budget) values('Marketing', 15000);

--inserting multiple values
insert into departments (name, monthly_budget)
values
	('IT', 30000),
	('Human Resources', 25000),
	('Customer Service', 2000),
	('Internal Affairs', 5000);

insert into employees (first_name, last_name, birthdate, monthly_income, department_id, hire_date, job_title, email)
values 
	('John', 'Smith', date '1995-01-01', 4000.00, 1, date '2015-03-28', 'AC_ACCOUNT', 'jsmith@company.com'),
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

insert into products (name, price, expiration_date)
values 
	('Aspirin', 5.00, date '2022-12-31'),
	('Penicillin', 10.00, date '2019-04-30'),
	('Insulin', 25.50, date '2023-05-31'),
	('BadMedX', 6.00, date '1874-09-17'),
	('GoodMed3000', 1300.25, date '2025-12-31');

/* SELECT STATEMENTS */
--query the records within the table 
-- * is the the wildcard for all columns within a given table
select * from departments;

-- to narrow down my info search to a particular id numbers 
-- where clause is used to filter our information based on a condition
select * from departments where id = 4;
select name, monthly_budget from departments where id = 3;

select * from employees e; --this 'e' is a "table alias" (alternative name)
select * from employees e where e.department_id = 1; --this 'e' is a "table alias" (alternative name)

select * from products p;

-- DML statements must be explicitly committed
-- Even though DBeaver auto-commits for you, don't rely on this.
commit;

delete from products; --a delete statement without a where clause will delete all records from the table

rollback; --takes you back to the previous SAVEPOINT or commit 
-- rolling back to a savepoint and then rolling back again will take you to the previous commit
-- you cannot rollback past a commit 
-- making a savepoint when one already exists will overwrite the previous one (aka only one savepoint can exist at a time)

--++++++++++++++++++++++++++
--ERD = entity relational diagram = a visualization of our table schema in our database


--get all products
-- ORDER BY (sorts the records of the result set)
--by default it will be in ascending order
--asc (ascending) is implied and not required (ok to include though)
select * from products order by expiration_date;

select * from products where expiration_date > date '2023-01-01'; --preferred date syntax

select * from products where expiration_date > '01-JAN-2023'; --the date keyword provides date formatting for your records

-- and combines where clause conditions together, while or will return what is true in either condition
select * from products where name like 'A%' or name like 'a%';
--the like keyword will filter your search based on a pattern
--the % serves as a wildcard character in the pattern format
--overall, this is using regular expression (regex) to make these patterns
select * from products where name like '%a%' or name like '%A%';

--the as keyword allows us to make column alias
select name, price as original_price, (price - (price * .3)) as sales_price from products;

--multiple conditionals in where 
select *
from products
where 
(
	id < 5
	or name = 'Aspirin'
	and price > 10
)
and
(
	price <= 10
	or expiration_date = '2018-04-30'
);

--and, or, not are logical operators in sql

--distinct keyword eliminates duplicates from the result set
select distinct department_id from employees;

--a record is considered a duplicate if all of the values of the record match to another
select distinct first_name, last_name, department_id from employees;

/* Scalar Functions
 * - aka single-row/value function
 * - returns a value of every row that is processed in a query
 * 
 * - Types:
 * 		- Numeric functions
 * 		- Character functions
 * 		- Date functions
 */

select substring('test', 1, 3); --inclusive range, index-1 based 
select abs(-11);
--floor will go to the lowest possible whole number of the given digit
--ceiling will go to the next whole number of given digit 
-- round will go to the closest promixed integer of the given digit (within a .5 range it will go up or down to a whole number)
select floor(2.678) as floor_value, ceiling(2.678) as ceiling_value, round(2.678, 2) as round_value;

select first_name, last_name, age(current_date, birthdate) as current_age from employees;

/* Aggregate functions
 * 	- Operations which can be performed on a group of records in order to provide a single value/result
 */

select min(price) as min_price, max(price) as max_price, avg(price) as average_price, sum(price) as sum_price
from products;

--the count function only counts non-null values!
select count(name) from products;

-- add a new column to products for an abbreviated name for each product
alter table products
add column abbr_name varchar(4);

-- update the values within the newly added column to contain the abbreviate name of each product
update products 
set abbr_name = substring(name, 1, 4);

--LIMIT can either restrict how your column takes in information for a record or delimited the number of items in your result set
select * from products limit 5;


/* Normalization is the concept that all data in our database is structured with referenial integrity.
 * 
 * - We can achieve this by eliminating data reduncancy to enhance the integrity
 * 0NF = a single mass of chaos as your database (you have everything in one table)
 * 1NF = every table has a unique identifer (aka must have PKs)
 * ex. everyone vs. SSNs
 * 
 * 2NF = database has already followed 1st NF and there are no partial dependencies among your tables
 * 	- there should not be any field with any table that can qualify as a candidate key
 * 	- candidate keys are unique and not null columns that can become a primary key
 * 
 * 3NF = database has already 2nd NF and there are no transient dependencies amoung your tables
 * 	- should be no composite keys (if you do have this, then you need to make an additional table aka split current table into two)
 * 	- ensure that there is no reduction of data duplication by having solid foreign key relationships
 */
 * 
 */