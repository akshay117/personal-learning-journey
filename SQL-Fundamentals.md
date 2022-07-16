# *POSTGRESQL*

## `SQL FUNDAMENTALS`

# 1 SELECT
  ```sql
  SELECT column_name FROM table_name;
  ```
  Challenge:
  ```sql
  SELECT first_name,last_name,email FROM customer;
  ```
  
  # 2 SELECT DISTINCT
  
  ```sql
  SELECT DISTINCT (release_year) FROM FILM;
  ```
  
  ```sql
  SELECT DISTINCT RATING  FROM FILM;
  ```
  
  # 3 COUNT
  
  ```sql
  SELECT COUNT DISTINCT amount  FROM payment;
  ```
  
  # 4 SELECT WHERE
   
   ```sql
   SELECT column_name FROM table_name where condition;
   ```
  
  ```sql
  SELECT * FROM customer 
  WHERE first_name = 'Jared'; 
  ```
  
  ```sql
  SELECT COUNT (title) FROM film 
WHERE rental_rate > 4 AND replacement_cost >= 19.99
And rating = 'R';
  ```
  
  ```sql
  SELECT COUNT (*) FROM film 
WHERE 
 rating = 'R' OR RATING ='PG-13'
  ```
  
  ```sql
  SELECT COUNT (*) FROM film 
WHERE 
 rating = 'R' OR RATING ='PG-13'
  ```
  
  ```sql
  SELECT COUNT (*) FROM film 
WHERE 
 rating != 'R' 
  ```
  
  # 5 ORDER BY
  
  ```sql
  SELECT column_1,column_2
  FROM table
  ORDER By column_1 ASC/DESC
  ```
  ```sql
  SELECT store_id,first_name,last_name
  FROM customer
 ORDER BY store_id,first_name;  
 
  ```
  # 6 LIMIT
  
  ```SQL
SELECT * FROM payment
ORDER BY payment_date DESC
LIMIT 5
  ```
  Challenge 1 :
  
  ```sql
  SELECT customer_id FROM payment
  ORDER BY payment_date ASC
  LIMIT 10;
  ```
  Challenge 2 :
  ```sql
  select title,length  from film
ORDER BY length
limit 5;;
  ```
  Challenge 3 :
  ```sql
  select COUNT(*) from film
WHERE length <= 50;
  ```
  
  # 7 BETWEEN 
  
  Between is inclusive
  
  Not Between is exclusive
  
   Used to match a value against a range of values:
   
   *  value BETWEEN low AND high
  ```sql
  select * from payment
  WHERE payment_date  BETWEEN '2007-02-01' AND '2007-02-15' ;
  ```
  
  # 8 IN
  
  Operator used to create a condition that checks to see if a value is included in a list of multiple options.
  
  ```SQL
  select DISTINCT(amount) from payment
  WHERE amount IN (0.99,1.98,1.99)
  ```
  
  ```sql
  select DISTINCT(amount) from payment
WHERE amount NOT IN (0.99,1.98,1.99)


  ```
  # 9 LIKE & ILIKE
  
  using pattern matching with string data.
  
  LIKE is case sensitive , iLIKE is case insensitive ..you see the irony dont you! : D
  
  Percent % - Matches any sequence of characters.
  
  Underscore _ - Matches any single Character
  
  
```sql
select * from CUSTOMER
WHERE first_name ILIKE 'J%' AND last_name LIKE 'S%' ;

```

```sql
select * from CUSTOMER
WHERE first_name LIKE '_er%' ;

```
Can be combined with NOT operator to get the opposite result.

## `GROUP BY STATEMENTS`

# -> GROUP BY 

will allow us to aggregate data and apply functions to better understand how data is distributed per category

### Aggregate Functions - Take multiple input and return a single output

```
Common aggregate functions

AVG() - RETURNS A FLOATING POINT VALUE MANY DECIMAL PLACES. USE ROUND(avg(),number of precision) TO SPECIFY PRECISION.
COUNT() 
MAX()
MIN()
SUM()

```

Group by clause must appear right after a FROM or WHERE statement.

```sql
SELECT customer_id,staff_id,SUM(amount) FROM payment
GROUP BY customer_id,staff_id
ORDER BY customer_id;
```
```sql
SELECT DATE (payment_date),SUM(amount) FROM payment
GROUP BY DATE(payment_date)
ORDER BY SUM(amount)
```
Challenge 1:

```sql
SELECT staff_id, COUNT(payment_id) FROM payment
GROUP BY staff_id
```

Challenge 2:

```sql
SELECT rating, ROUND(AVG(replacement_cost),2 )
FROM film
GROUP BY RATING
```
Challenge 3:

```sql
SELECT  customer_id,SUM(amount)
FROM payment
GROUP BY customer_id 
order by SUM(amount) DESC
LIMIT 5;

```
# -> HAVING

The HAVING clause allows us to filter after an aggregation has aleady taken place.

```sql
SELECT  customer_id,SUM(amount) FROM payment
GROUP BY customer_id 
HAVING SUM(amount) >100

```
Challenge : 

```sql
SELECT  customer_id,COUNT(payment_id) from payment
GROUP BY customer_id
HAVING COUNT(payment_id) >= 40;
```



## `SQL JOINS`

# AS

Used in select statement only

```sql
SELECT customer_id,SUM(amount) AS total_spent
FROM payment
GROUP BY customer_id;

```

# Inner Joins
Set of records that are going to be common in 2 tables

Syntax
```sql
SELECT reg_id,Login.name,log_id FROM Registration
INNER JOIN Login
ON Registration.name = Login.name
```

# Full Outer Joins
They will allow us to specify how to deal with values only present in one of the tables being joined

```sql
SELECT * FROM Registration
FULL OUTER JOIN Login
ON Registration.name = Login.name
```
grab everything and fill in null values for others.


# -> Full Outer Joins with WHERE
Exact opposite of INNER JOIN

```sql
SELECT * FROM Registration
FULL OUTER JOIN Login
ON Registration.name = Login.name
WHERE Registration.reg_id IS null OR
login.log_id IS NULL
```

# Left Outer Joins
Known as left join. Results in the set of records that are in the left table , if there is no match in the right table the results are null.

```sql
SELECT * FROM Registration
LEFT OUTER JOIN Login
ON Registration.name = Login.name
```

# -> Left Outer Joins with WHERE
Get rows unique only to left tables

```sql
SELECT * FROM Registration
LEFT OUTER JOIN Login
ON Registration.name = Login.name
WHERE Registration.reg_id IS null OR
login.log_id IS NULL
```


# Right Joins

```sql
SELECT * FROM Registration
RIGHT OUTER JOIN Login
ON Registration.name = Login.name
```

# -> Right Outer Joins with WHERE

```sql
SELECT * FROM lOGIN
RIGHT OUTER JOIN Registration
ON  Login.name = Registration.name
WHERE Login.lof_id IS null
```
# UNION
Combine the resut set of two or more SELECT Statements.

```sql
SELECT * FROM TABLE_1
UNION
SELECT * FROM TABLE_2

```
## `ADVANCED SQL COMMANDS`

# TIMESTAMP 

Report Back time and date information.More Useful when creating our own database rather than querying an existing db.

->TIME,DATE,TIMESTAMP,TIMESTAMPZ(contains time ,date ,timezone)

-> Functions : 

 SHOW TIMEZONE

 SELECT NOW()
 
 SELECT TIMEOFDAY()

 SELECT CURRENT_TIME

 SELECT  CURRENT_DATE

#  EXTRACT 
Extract Allows to obtain a sub_content of a date value
EXTRACT()
AGE()
TO_CHAR()

```sql
SELECT EXTRACT(YEAR FROM payment_date) AS myyear FROM payment)
```

# MATH FUNCTIONS

# STRING FUNCTIONS

# SUB QUERY

# SELF JOIN



## `CREATING DATABASES AND TABLES`

# DATA TYPES

# PRIMARY AND FOREIGN KEYS

# CONSTRAINTS
Rules
# CREATE

SERIAL  : will create a sequence object and set the next value genereated automatically. Perfect for primary key
```SQL
CREATE TABLE table_name(
  column_name TYPE column_constraint,column_name TYPE column_constraint
)
```

```SQL
CREATE TABLE player(
  player_id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  age SMALLINT NOT NULL,
)
```


# INSERT

```SQL
INSERT INTO table (column1,column2,...),
VALUES
(value1,value2..),
(value1,value2...)
```

# UPDATE
```sql
UPDATE TABLE
SET column1 = value 1,
    column2 =value 2,..
WHERE
   condition    
```
# DELETE / ALTER / DROP

```sql
DELETE FROM table
WHERE row_id = 1
```

## `CONDITIONAL EXPRESSIONS AND PROCEDURES`

# CASE

# COALESCE

# NULL IF

# CAST

# VIEWS

# IMPORT AND EXPORT FUNCTIONALITY





