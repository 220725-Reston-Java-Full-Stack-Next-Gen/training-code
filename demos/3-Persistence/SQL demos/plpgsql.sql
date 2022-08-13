/*
 * PL/pgSQL = Procedural Language extension for PostgreSQL
 * 		- NOT A SUBLANGUAGE!
 * 		- Vendor specific (every DB vendor supports it, but with their own syntax)
 * 		- Allows devs to create:
 * 			+ stored functions
 * 			+ stored procedures (since PG v11)
 * 			+ triggers
 * 			+ custom types (effectively structs, not objects!)
 * 
 * 		- Adds procedural laungage features to the normally declarative SQL syntax:
 * 			+ loops
 * 			+ conditionals
 * 			+ errors/exception handling 
 */

/* Stored Functions
 * 
 * Basic syntax:
 * 		create [or replace] function [name] (parameters)
 * 		returns [type]
 * 		as '
 * 			begin
 * 				[logic]
 * 			end
 * 		' language plpgsql;
 */

create or replace function multiply (x numeric, y numeric)
returns numeric 
as '
	begin
		return x * y;
	end
' language plpgsql;

select multiply(5, 4);

select multiply(2, '42'); --Postgre will attempt to coerce values that do not match to the expected type
select multiply(2, 'abc'); --some values cannot be reasonably coerced into the proper type, resulting in a sql error

--another way of making an stored function 
create or replace function get_last_track_info ()
returns text 
as $$ 
	declare
		last_track_id int;
		track_name text;
		result text;
	begin 
		--get the last track id
		select max(track_id)
		into last_track_id
		from track;
	
		--get the name of the track with the last id 
		select name
		into track_name 
		from track
		where track_id = last_track_id;
	
		--build the result text (assignment operator :=)(concatenation operator ||)
		result := last_track_id || ' - ' || track_name; --"123 - some song"
		
		--return result 
		return result;
	end
$$ language plpgsql;

select get_last_track_info();

select * from track order by track_id desc;

--++++++++++++++++++++++++++++++++++++++
/*
 * Triggers
 * 		
 * 		Triggers can be called when inserting, updating, or removing data from a table
 * 		and can execute code that can perform additional complex validations or 
 * 		even run additional update, insert, or delete queries to modify data in related tables.
 */

create or replace function no_more_blues()
returns trigger
as $$ 
	begin
		-- if the new inserted/updated value is "blue", return null to prevent it from being added
		if(new.color = 'blue') then
			return null;
		end if;
	
		--otherwise, let it be added 
		return new;
	end

$$ language plpgsql;

--here is how you create a trigger 
create trigger no_more_blues_trigger
before insert or update on colors
for each row 
execute function no_more_blues();

select * from colors;

insert into colors (color) values ('blue');
insert into colors (color) values ('ultraviolet');
update colors set color = 'blue' where id = 9;
update colors set color = 'scarletred' where id = 1;

-- Does the trigger fire off if we manpulate a view based on the table?
create view view_colors as 
select * from colors;

select * from view_colors order by id;

-- The trigger still fires off, preventing illegal values from being inserted/updated from a view.
insert into view_colors (color) values ('blue');