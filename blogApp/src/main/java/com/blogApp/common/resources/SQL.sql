DROP DATABASE IF EXISTS BLOGAPP;
CREATE DATABASE BLOGAPP;
USE BLOGAPP;

SHOW TABLES;



INSERT INTO ST_USER_ROLE (USER_ROLE_ID,USER_ROLE_DESC) VALUES (1,"Admin"),(2,"User");

SHOW TABLES;

SELECT * FROM ST_BLOG_USER;
SELECT * FROM ST_USER_ROLE;

DESC ST_BLOG_USER;
DESC ST_USER_ROLE;

SELECT USER_NAME,USER_PASSWORD,FIRST_NAME,LAST_NAME,USER_ROLE_DESC FROM ST_BLOG_USER U,ST_USER_ROLE R WHERE U.USER_ROLE = R.USER_ROLE_ID;

DELETE FROM ST_BLOG_USER;
