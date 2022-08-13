/* Subqueries:
 * 	aka nested queries
 * are combined sql statements that can be used within:
 * 	+ WHERE clause
 * 	+ column selector list
 * 	+ FROM clause
 */

select * from genre;

--subquery in a from clause (effectively queries a result set; similar to querying a view)
select some_name.* --alias to be defined soon
from(
	select * 
	from genre
	where name like 'R%' --like operator is case-sensitive, and the % is a wildcard
) as some_name
where some_name.genre_id > 6;

--subquery in a where clause 
select * from employee;

select hire_date 
from employee
order by hire_date
limit 5;

select * 
from employee
where hire_date in ( --the in operator is for checking to see if a value is included within a result set of other values
	select hire_date
	from employee
	order by hire_date 
	limit 5 --limits the result set to x number of records (i.e. 5 records in this example)
);

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++

/*
 * Views
 * 		When we execute a query, we generate a result set.
 * 		Sometimes we may frequently use that result set as a 
 * 		base for executing other queries.
 * 
 * 		Views are just the result sets of saved queries that 
 * 		have a name and can be referenced by other queries.
 * 		Views act as a sort of "virtual table".
 */
drop table if exists trainers;

create table trainers (
	id serial constraint trainer_pk primary key,
	fn varchar not null check (fn <> ''),
	ln varchar not null check (ln <> '')
);

insert into trainers (fn, ln)
values ('Azhya', 'Knox');

--check places a conditional constraint on your column 
-- this gives us an error
--insert into trainers (fn, ln)
--values ('Does not work', '');

insert into trainers (fn, ln)
values 
	('John', 'Smith'),
	('Brandon', 'Pinkerton'),
	('Crystal', 'Springs');
	
select * from trainers;

select * from trainers where id >= 2;

--here is how you create a view 
create view view_trainers as 
select * from trainers where id >= 2;

select * from view_trainers where id = 1; --Azhya doesn't show up here because that record is not represented by the view_trainer view 
select * from view_trainers where id = 3;

--can i insert more records into a view?
--seems to work
insert into view_trainers (fn, ln)
values 
	('Mark', 'Moore'),
	('Harvey', 'Hill');
	
select * from view_trainers;

--what effect did that have on the underlying table?
select * from trainers;
--inserting/updating/removing values from a view will impact the underlying table 

--what about manipulating the underlying table and seeing the impact on the view?
insert into trainers (fn, ln)
values
	('Trey', 'McGill'),
	('Kevin', 'Childs'),
	('Tom', 'George');
	
select * from view_trainers;

--views can be thought of as a syntaxically prettier version of the following:
select sq.*
from (
	select *
	from trainers
	where id >= 2
) as sq;