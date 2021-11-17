drop table if exists hibernate_sequence;
create table hibernate_sequence 
(next_val bigint not null);
 

INSERT INTO hibernate_sequence  (next_val) 
values (1);