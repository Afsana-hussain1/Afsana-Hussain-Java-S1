SELECT * FROM car_lot.car;
-- Insert values for everything except model_year
INSERT INTO car_lot.car (id, make, model, model_year,color) 
VALUES 
(24,'Honda', 'Accord', 2012, 'Red'),
(16,'Chevy', 'Impala', 2017, 'Black'),
(67,'Ford', 'F-150', 2019,'silver'),
(34,'Subaru', 'outback', 2020, 'white'),
(49, 'Ford', 'Mustang', 2015, 'silver'),
(32, 'Honda', 'Ridgeline', 2018,'blue'),
(21,'Chevy', 'Silverado', 2017,'gray');

UPDATE car_lot.car
SET color ='black'
WHERE car.model ='Honda';

UPDATE car_lot.car
Set make ='Chevrolet'
WHERE car.make ='Chevy';

UPDATE car_lot.car
SET year = 2019
where year = 2020;

-- What are the categories of products in the database?
-- What products are made by Dell?
-- List all the orders shipped to Pennsylvania.
select * from northwind.orders
where ship_state =('Pennsylvania') AND order_status =('Shipped');
-- order with id # 4587 , shipped to Debra Sanchez


-- List the first name and last name of all employees with last names that start with w 
SELECT *FROM northwind.employees
where last_name like 'w%';


-- List all customers from zipcodes that start with 55
SELECT * FROM northwind.customers
where postal_code like 55% ;

-- List all customers from zipcodes that end with 0
select * from northwind.customers
where postal_code like '%0';

-- List the first name, last name, and email for all customers with a .org email address
SELECT * from northwind.customers
where email like '%.org';

-- List the first name, last name, and phone number for all customers from the 202 area code
select* from northwind.customers
where phone like 1-(202%);

-- List the order id for each order placed by George Wilson
select* from northwind.orders
where ship_name = ('George wilson');

-- List all the products and quantities associated with order 4003
select*from northwind.products
where id = 4003;





 
 







