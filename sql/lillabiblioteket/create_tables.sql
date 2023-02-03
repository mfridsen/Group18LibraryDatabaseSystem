-- Creates all tables

-- Base Tables

-- publisher
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\base_tables\create_publisher_table.sql";
-- users
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\base_tables\create_user_tables.sql";
-- classification
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\base_tables\create_classification_table.sql";
-- item
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\base_tables\create_item_tables.sql";
-- reservations
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\base_tables\create_reservation_table.sql";
-- author
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\base_tables\create_author_table.sql";
-- checkout
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\base_tables\create_checkout_table.sql";


-- Join Tables

-- item_publisher
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\join_tables\create_item_publisher_table.sql";
-- item_author
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\join_tables\create_item_author_table.sql";
-- item_checkout
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\join_tables\create_item_checkout_table.sql";
-- item_classification
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\join_tables\create_item_classification_table.sql";


-- Triggers

-- source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\triggers\create_triggers.sql";