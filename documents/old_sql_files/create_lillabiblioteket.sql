-- run using MySQL Shell
-- after opening MySQL Shell type '\connect root@localhost
-- then type \sql to switch from JS to SQL
-- once connected, use the following command to execute everything in this file:
-- source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\create_lillabiblioteket.sql";

drop database if exists lillabiblioteket;
create database lillabiblioteket;
use lillabiblioteket;

source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\create_tables.sql";
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\fill_test_data.sql";

show tables;