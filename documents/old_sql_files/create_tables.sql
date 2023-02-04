-- Creates all tables

-- Base Tables

-- publisher
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\base_tables\create_publisher_table.sql"; --copied
-- users
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\base_tables\create_user_tables.sql"; --copied
-- classification
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\base_tables\create_classification_table.sql"; --copied
-- item
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\base_tables\create_item_tables.sql"; --copied
-- reservations
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\base_tables\create_reservation_table.sql"; --copied
-- author
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\base_tables\create_author_table.sql"; --copied
-- checkout
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\base_tables\create_checkout_table.sql"; --copied


-- Join Tables

-- item_publisher
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\join_tables\create_item_publisher_table.sql"; --copied
-- item_author
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\join_tables\create_item_author_table.sql"; --copied
-- item_checkout
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\join_tables\create_item_checkout_table.sql"; --copied
-- item_classification
source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\join_tables\create_item_classification_table.sql"; --copied


-- Triggers

-- source "G:\Dropbox\Projects\Java\Group18LibraryDatabaseSystem\sql\lillabiblioteket\triggers\create_triggers.sql";