# SQL Notes
*The following are topics that you may be asked about in QC or a client interview*.

SQL: Structured Query Language

- Is the standard language for relational database systems
  - Many different dialects
    - MySQL
    - **PostgreSQL**
    - OracleSQL
    - Microsoft SQL Server

A Database is an organized collection of data, stored in an organized format

- Allows us to input, manage, organize, and retrieve data quickly
- Traditionally, it is organized into tables with records as rows and fields as columns
- Data is the intersection between rows and columns

RDBMS: Relational Database Management System

- A database management system that upholds specified relationships between tables
- It includes functions that maintain the security, accuracy, integrity, and consistency of the data

## SQL Sublanguages

- DDL: Data Definition Language
  - A sublanguage for creation/alteration of table structure
  - Commands: CREATE, ALTER, DROP, TRUNCATE
- DML: Data Manipulation Language
  - Pertains to the changing/modification of the data within a table
  - Commands: INSERT, SELECT, UPDATE, DELETE
  - Referred to as CRUD operations (Create, Read, Update, Delete)
- DQL: Data Query Language
  - Kind of a sublanguage, depends on who you talk to
  - Only 1 command: SELECT
  - Sort of counts as both DML and DQL
- DCL: Data Control Language
  - Regulates access to data (provides security) by imposing restrictions like user permissions
  - Commands: GRANT, REVOKE
- TCL: Transaction Control Language
  - Pertaining to work on the database and finalizing or reverting changes
  - Commands: COMMIT (persist data), ROLLBACK (revert data), SAVEPOINT, SET TRANSACTION (used to set isolation level)

## Constraints

Constraint: Rules (or conditions) to follow for enforcing database table relationships
There are 6 kinds
  - Primary Key: Data in this column(s) is unique, not null, and uniquely identifies all records in the table
  - Foreign Key: Any column(s) in a table referencing a primary key in another table
    - Establishes relationship between 2 columns in the same table or between different tables
  - Unique: No duplicate values
    - Null is not counted, you can still have multiple nulls
  - Not Null: Make sure a column does not contain null values
  - Default: Will default the column to some specified value of your choosing
  - Check: Adds an extra condition on inserted data (like x > 5)

Note that a primary key that consists of more than 1 column is called a composite key.

So, with these basic commands, we can see some simple SQL queries like the following:

```SQL
CREATE TABLE employee (
  employee_id SERIAL PRIMARY KEY,
  first_name VARCHAR (50) NOT NULL,
  last_name VARCHAR (50) NOT NULL,
  email VARCHAR (55) UNIQUE NOT NULL DEFAULT 'N/A',
  salary INTEGER NOT NULL
);

INSERT INTO employee (first_name, last_name, salary)
  VALUES ('John', 'Smith', 50000);
INSERT INTO employee (first_name, last_name, email, salary)
  VALUES ('Jane', 'Doe', 'jane.doe@gmail.com', 150000);

SELECT * FROM employee;
SELECT first_name, last_name FROM employee;

SELECT first_name || ' ' || last_name FROM employee
  WHERE salary > 100000;

UPDATE employee SET email = 'email2@work.com'
  WHERE first_name = 'John' AND last_name = 'Smith';
```

## Cardinality

Cardinality: Describes the numerical relationship between 2 tables
There are 3 (technically 4) kinds:
  - 1 : 1 (one to one)
    - Individual records are associated with only 1 other record
    - Can be created by using a primary key and a unique foreign key
    - Ex: Social Security
  - 1 : n or n : 1 (1 to many or many to 1)
    - Individual records in one table are associated with many records in the other (1 way)
    - A primary key linked to a non-unique foreign key
    - Ex: Beehive to bees
  - n : n (many to many)
    - Records in both tables are associated with many records in the other (2 way)
    - This is best represented using a join table
    - Ex: Students and courses

## Normalization

- Database Normalization: Design pattern for databases that aims to reduce both duplicate data and redundancy
- Ensure **Referential Integrity**
- Atomic Data: Data that has been broken down into the smallest possible unit
- Levels of Normalization
  0. 0 Normal Form: No normalization
  1. 1st Normal Form: All data must be atomic, and should have a unique identifier
  2. 2nd Normal Form: Also in 1st plus no partial dependencies
    - Which means all values must identified by a single column (no composite keys)
  3. 3rd Normal Form: Also in 2nd plus no transitive dependencies
    - Which means no column is dependent on a column that is not the primary key

## Joins

- Join tables are useful in describing many to many relationships
- A "join" operation is what we use to bring the data of two tables together
- There are several types of joins:
  - Inner Join: Only shows records with the compared value existing in both tables
  - Full Outer Join: Fully join all tables together, substituting nulls where data is absent
  - Left/Right Join: All data from the left/right table paired with the other and substituting nulls where necessary
  - Cross Join: Cartesian cross product of recrods from both tables, so you get a list of permutations from the tables
  - Self Join: Any join that acts on only 1 table

```SQL
SELECT <columns> FROM <left> <JOIN TYPE> JOIN <right>
ON <left.column> = <right.column>;
```

## Transactions

A transaction is a unit of work preformed against a database. It is the propagation of one or more changes to the database. Generally used with UPDATE, DELETE, and INSERT operations.

You want to group multiple operations together and execute them all at once.

## ACID (Properties of transactions)

A. Atomicity: The operations either occur successfully or not at all. Otherwise transactions will be aborted and changes will be rolled back.

C. Consistency: Ensures that the database properly changes states upon a successfully committed transaction. No transaction should have any adverse effect on the data residing in the DB. (Referential Integrity and constraints are maintained)

I. Isolation: Enables transactions to operate independently of each other.

D. Durability: Ensures that the result or effect of a committed transaction persists in case of system failure.

### Transaction Problems

There are some issues that can arise when following ACID principles. We try to handle transactions concurrently because it is faster. But, what happens when one transaction reads data from another transaction, but then the second transaction gets rolled back? We retrieved data that should not have existed.

- Dirty Read: Occurs when a transaction reads data that has been added by a different transaction but has not been committed
- Non-Repeatable Read: Transaction re-reads data that it has previously read and finds another committed transaction has modified or deleted data
- Phantom Read: Transaction re-runs a query to find that the number of records has changed

### Transaction Isolation levels

- The degree to which two transactions will interact with each other over the same data
- As our applications become more complex, we must account for transactions that may occur at the same time
- The higher the isolation level, the more careful the system is about avoiding conflicts, but the locking overhead can increase as concurrency decreases.

Isolation Level |    Dirty Read    | Non-Repeatable Read |   Phantom Read   |
:---------------|------------------|---------------------|------------------|
Read Uncommitted|:heavy_check_mark:|:heavy_check_mark:   |:heavy_check_mark:|
Read Committed  |                  |:heavy_check_mark:   |:heavy_check_mark:|
Repeatable Read |                  |                     |:heavy_check_mark:|
Serializable    |                  |                     |                  |

By default, PostgreSQL is set to Read Committed.