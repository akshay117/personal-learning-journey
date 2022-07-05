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


## `SQL JOINS`


## `ADVANCED SQL COMMANDS`


## `CREATING DATABASES AND TABLES`


## `CONDITIONAL EXPRESSIONS AND PROCEDURES`
