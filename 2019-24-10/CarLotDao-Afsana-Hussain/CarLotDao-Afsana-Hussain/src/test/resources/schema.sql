
create schema if not exists car_lot_test;
use car_lot_test;
create table if not exists car (
id      INT NOT NULL AUTO_INCREMENT,
make  VARCHAR(50) NOT NULL,
model VARCHAR(50) NOT NULL,
year  VARCHAR(4) NOT NULL,
color VARCHAR(50) NOT NULL,
PRIMARY KEY (id)
);