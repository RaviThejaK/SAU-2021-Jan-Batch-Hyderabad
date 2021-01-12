##CREATE SCHEMA `hamensprivatelimited` ;


create table Category
(
CategoryId int,
CategoryName varchar(20),
PRIMARY KEY (CategoryId)
);


create table Product
(
ProductCode int NOT NULL,
ProductName varchar(20),
UnitPrice int,
CategoryId int NOT NULL,
PRIMARY KEY (ProductCode),
FOREIGN KEY (CategoryId) REFERENCES Category(CategoryId)
);

create table Location
(
LocationCode int,
LocationName varchar(20),
PRIMARY KEY (LocationCode)

);

create table SalesExecutive
(
SalesExecutiveId int,
Name varchar(20),
DOB date,
mobile bigint(10),
gender varchar(20),
PRIMARY KEY (SalesExecutiveId)
);

create table Customer
(
CustomerId int,
Name varchar(20),
DOB date,
mobile bigint(10),
gender varchar(20),
PRIMARY KEY (CustomerId)
);

create table Sales (
TransactionId int,
SalesExecutiveId int,
CustomerId int,
ProductCode int,
LocationCode int,
PRIMARY KEY (TransactionId) ,
FOREIGN KEY (SalesExecutiveId) REFERENCES SalesExecutive(SalesExecutiveId),
FOREIGN KEY (ProductCode) REFERENCES Product(ProductCode),
FOREIGN KEY (CustomerId) REFERENCES Customer(CustomerId),
FOREIGN KEY (LocationCode) REFERENCES Location(LocationCode)

);

create table Purchase
(
TransactionId int,
DateOfPurchase date,
NoOfUnits int,
PRIMARY KEY (TransactionId) 
);

insert into Customer (CustomerId, Name, DOB, Mobile, Gender) values (901,"P",'1998-06-17',6666666666,"Male");
insert into Customer (CustomerId, Name, DOB, Mobile, Gender) values (902,"Q",'1999-07-18',7777777777,"Male");
insert into Customer (CustomerId, Name, DOB, Mobile, Gender) values (903,"R",'2000-08-19',8888888888,"Male");
insert into Customer (CustomerId, Name, DOB, Mobile, Gender) values (904,"S",'2001-09-20',9999999999,"FeMale");
insert into Customer (CustomerId, Name, DOB, Mobile, Gender) values (905,"T",'2002-10-21',1234567890,"FeMale");

insert into SalesExecutive (SalesExecutiveId, Name, DOB, Mobile, Gender) values (801,"A",'1997-06-16',1111111111,"Female");
insert into SalesExecutive (SalesExecutiveId, Name, DOB, Mobile, Gender) values (802,"B",'1996-05-15',2222222222,"Female");
insert into SalesExecutive (SalesExecutiveId, Name, DOB, Mobile, Gender) values (803,"C",'1994-04-14',3333333333,"Female");
insert into SalesExecutive (SalesExecutiveId, Name, DOB, Mobile, Gender) values (804,"D",'1993-03-13',4444444444,"Male");
insert into SalesExecutive (SalesExecutiveId, Name, DOB, Mobile, Gender) values (805,"E",'1993-02-12',5555555555,"Male");

insert into Location (LocationCode, LocationName) values (500000,"Hyderabad");
insert into Location (LocationCode, LocationName) values (600000,"Banglore");
insert into Location (LocationCode, LocationName) values (100000,"Chennai");

insert into Category (CategoryId, CategoryName) values (1,"Electronics");
insert into Category (CategoryId, CategoryName) values (2,"Vehicle");
insert into Category (CategoryId, CategoryName) values (3,"Furniture");

insert into Product (ProductCode, ProductName, UnitPrice, CategoryId) values (11,"Laptop", 40, 1);
insert into Product (ProductCode, ProductName, UnitPrice, CategoryId) values (12,"Tab", 25, 1);
insert into Product (ProductCode, ProductName, UnitPrice, CategoryId) values (13,"Phone", 20, 1);


insert into Product (ProductCode, ProductName, UnitPrice, CategoryId) values (21,"Car", 100, 2);
insert into Product (ProductCode, ProductName, UnitPrice, CategoryId) values (22,"Bike", 65, 2);
insert into Product (ProductCode, ProductName, UnitPrice, CategoryId) values (23,"Jeep", 140, 2);

insert into Product (ProductCode, ProductName, UnitPrice, CategoryId) values (31,"Table", 25, 3);
insert into Product (ProductCode, ProductName, UnitPrice, CategoryId) values (32,"Chair", 20, 3);
insert into Product (ProductCode, ProductName, UnitPrice, CategoryId) values (33,"Bed", 35, 3);

insert into Sales (TransactionId, SalesExecutiveId, ProductCode, CustomerId, LocationCode) values (101,801,13,901,500000);
insert into Sales (TransactionId, SalesExecutiveId, ProductCode, CustomerId, LocationCode) values (102,801,12,901,500000);
insert into Sales (TransactionId, SalesExecutiveId, ProductCode, CustomerId, LocationCode) values (103,802,11,901,500000);
insert into Sales (TransactionId, SalesExecutiveId, ProductCode, CustomerId, LocationCode) values (104,801,31,902,500000);
insert into Sales (TransactionId, SalesExecutiveId, ProductCode, CustomerId, LocationCode) values (105,802,32,903,500000);

insert into Sales (TransactionId, SalesExecutiveId, ProductCode, CustomerId, LocationCode) values (106,803,11,903,600000);
insert into Sales (TransactionId, SalesExecutiveId, ProductCode, CustomerId, LocationCode) values (107,804,33,903,600000);

insert into Sales (TransactionId, SalesExecutiveId, ProductCode, CustomerId, LocationCode) values (108,805,11,905,100000);
insert into Sales (TransactionId, SalesExecutiveId, ProductCode, CustomerId, LocationCode) values (109,805,22,905,100000);
insert into Sales (TransactionId, SalesExecutiveId, ProductCode, CustomerId, LocationCode) values (110,805,13,905,100000);
insert into Sales (TransactionId, SalesExecutiveId, ProductCode, CustomerId, LocationCode) values (111,805,32,905,100000);

insert into Purchase (TransactionId, DateOfPurchase, NoOfUnits) values (101,'2021-01-08',3);
insert into Purchase (TransactionId, DateOfPurchase, NoOfUnits) values (102,'2021-01-09',3);
insert into Purchase (TransactionId, DateOfPurchase, NoOfUnits) values (103,'2021-01-10',2);
insert into Purchase (TransactionId, DateOfPurchase, NoOfUnits) values (104,'2021-01-08',1);
insert into Purchase (TransactionId, DateOfPurchase, NoOfUnits) values (105,'2021-01-09',2);

insert into Purchase (TransactionId, DateOfPurchase, NoOfUnits) values (106,'2021-01-10',1);
insert into Purchase (TransactionId, DateOfPurchase, NoOfUnits) values (107,'2021-01-08',2);
insert into Purchase (TransactionId, DateOfPurchase, NoOfUnits) values (108,'2021-01-09',2);
insert into Purchase (TransactionId, DateOfPurchase, NoOfUnits) values (109,'2021-01-10',1);
insert into Purchase (TransactionId, DateOfPurchase, NoOfUnits) values (110,'2021-01-08',2);

insert into Purchase (TransactionId, DateOfPurchase, NoOfUnits) values (111,'2021-01-09',2);


ANSWER 2

create view Table1 as 
select * from Purchase where TransactionId in (select TransactionId from Sales where LocationCode = '500000');

create view Table2 as
select * from Table1 P1 INNER JOIN 
(select DateOfPurchase as DOP, max(NoOfUnits) as MNU from Table1 group by DateOfPurchase ) P2
on P1.DateOfPurchase = P2.DOP and P1.NoOfUnits =P2.MNU ;

create view Table3 as
select ProductCode from Sales where TransactionId in (select TransactionId from Table2);

select * from Product where ProductCode in (select ProductCode from Table3);


ANSWER 3

create view NewTable as
select SalesExecutiveId, NoOfUnits from Sales s inner join Purchase p on s.TransactionId = p.TransactionId 

select * from SalesExecutive se inner join 
(select SalesExecutiveId as SE, SUM(NoOfUnits) from NewTable group by SalesExecutiveId) nt
on se.SalesExecutiveId = nt.SE;
