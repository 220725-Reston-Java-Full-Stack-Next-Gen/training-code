-- Topic: Joins
/*
 * - What is a join?
 * - a join is used to combine rows from two or more tables based on a related column between them
 * 
 * - Types of joins:
 * 		- INNER
 * 			+ FULL
 * 			+ RIGHT
 * 			+ LEFT
 * 		- OUTER
 * 			+ FULL
 * 			+ RIGHT
 * 			+ LEFT
 * 		- SELF (a join to combine information between a table and itself)
 * 		- CROSS
 * 		- Theta joins (when your ON clause uses an arbituary comparsion <, >, >=, <=, etc.
 * 		- Equi Joins
 * 			+ "Natural joins"
 * 			+ the join occurs on a column whose name is shared between two tables
 * 			+ can use the USING clause to simplify the query (instead of the ON clause)
 */

select * from artist;
select * from album;

--inner join with an ON clause
--inner keyword is implicitly applied to a join statement if not given
select album.album_id, album.title, artist.name
from album 
inner join artist
on album.artist_id = artist.artist_id;

--inner join with the using clause
select a.album_id, a.title, art.name as artist_name
from album a 
join artist art
using (artist_id);

--self-join example
select * from employee;

--self join (table joins itself)
--provides additional information about our table's FK by providing names to the reports_to person
select e1.first_name, e1.last_name, e1.title, e2.first_name, e2.last_name, e2.title 
from employee e1
join employee e2
on e1.reports_to = e2.employee_id;

-- multi-table join
select
	track.name as track_name,
	album.title as album_title,
	artist.name as artist_name 
from track
join album
using (album_id)
join artist
using (artist_id)
order by artist_name, album_title;

--cross join example 
create table sizes (
	id serial constraint sizes_pk primary key,
	size varchar(10)
);

create table colors(
	id serial constraint colors_pk primary key,
	color varchar(20)
);

insert into sizes (size) values 
	('S'), ('M'), ('L'), ('XL'), ('XXL');
	
insert into colors (color) values 
	('red'), ('orange'), ('yellow'), ('green'), ('blue'), ('purple'), ('pink');

-- cross joins multiply your rows in your resultset based on each table's number of records
select s.size, c.color
from sizes s
cross join colors c;