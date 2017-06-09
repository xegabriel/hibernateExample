# hibernateExample
A simple database connection using Hibernate built with Maven and tested with JUnit.
## First time running
### 1. Database setup
* Create a sql database called _'hibernateExample'_, with username _'root'_ and no password ''. To customize, go [here](https://github.com/1Mihail/hibernateExample/blob/master/src/main/resources/hibernate.cfg.xml).
* Create a table called _customer_.
```
CREATE TABLE IF NOT EXISTS CUSTOMER (
  CUSTOMER_ID INT(5) NOT NULL,
  LASTNAME VARCHAR(20) NOT NULL,
  FIRSTNAME VARCHAR(20) NOT NULL,
  EMAIL VARCHAR(20) NOT NULL
  PRIMARY KEY ( CUSTOMER_ID ) )
```
### 2. Download the project
```
cd %PATH%
git clone https://github.com/1Mihail/hibernateExample.git
```
### 3. Configure the project to run on eclipse.
`mvn eclipse:eclipse`
