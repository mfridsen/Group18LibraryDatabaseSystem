To get this database functional:

    1. Change paths in create_lillabiblioteket.sql and create_tables.sql from

    "G:\Dropbox\Projects\Java\BookBorrowingDatabaseSystem\sql\lillabiblioteket\create_tables.sql";

    to

    "<Drive>:\Path\To\Files" on Windows systems,
    "<Drive>:Path:To:Files" on Mac,
    "home/path/to/files" on Linux

    2. Open MysQL Shell

    3. Use command "\connect root@localhost" to connect to MySQL server"

    4. Use command "\sql" to switch to SQL commands

    5. Copy, paste and run the following command:

    source "<PATH TO FILES>\lillabiblioteket\create_lillabiblioteket.sql";

    For example, on Windows:

    source "G:\Dropbox\Projects\Java\BookBorrowingDatabaseSystem\sql\lillabiblioteket\create_lillabiblioteket.sql";