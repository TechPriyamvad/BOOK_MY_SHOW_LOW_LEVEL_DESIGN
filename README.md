# How to create a user in database and grant all privileges
### Below are the command to achieve the above task
```sql
CREATE DATABASE <DATABASE_NAME>;
USE <DATABASE_NAME>;
CREATE USER 'USER_NAME'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON <DATABASE_NAME>.* TO <USER_NAME>;
FLUSH PRIVILEGES;      
```

