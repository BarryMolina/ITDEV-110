IF  DB_ID('HoltDistributors') IS NOT NULL
DROP DATABASE HoltDistributors;
GO
 
CREATE DATABASE HoltDistributors;
GO
 
USE HoltDistributors;
 
Create Table Territory
(TerritoryNumber         Int             Primary Key     Identity,
TerritoryName            VarChar(255)    Not Null,
Region                   VarChar(255)    Not Null,
Quota                    Money           Not Null        Default 1000.00);
 
Create Table SalesRep
(EmployeeID              Int             Primary Key     Identity   References Employees (EmployeeID),
MTDSales                 Money           Not Null        Default 0.00,
YTDSales                 Money           Not Null        Default 0.00,
MTDCommission            Money           Not Null        Default 0.00,
YTDCommission            Money           Not Null        Default 0.00,
CommissionRate           Money           Not Null        Default 5.00,
TerritoryNumber          Int             Not Null        References Territory (TerritoryNumber));

Create Table Employee
(EmployeeID              Int              Primary Key     Identity,
EmpName                  VarChar(255)     Not Null,
EmpAddress1              VarChar(60)                    Default Null,
EmpAddress2              VarChar(60)                    Default Null,
EmpCity                  VarChar(40)      Not Null,
EmpState                 VarChar(2)       Not Null,
EmpZip                   VarChar(10)      Not Null,
EmpPhone                 VarChar(12)      Not Null);

Create Table Customer
(CustomerNumber          Int              Primary Key     Identity,
FName                    VarChar(60)      Not Null,
LName                    VarChar(60)      Not Null,
Address1                 VarChar(60)                    Default Null,
Address2                 VarChar(60)                    Default Null,
City                     VarChar(40)      Not Null,
State                    VarChar(2)       Not Null,
ZipCode                  VarChar(10)      Not Null,
PhoneNum                 VarChar(12)      Not Null,
MTDSales                 Money            Not Null        Default 0.00,
YTDSales                 Money            Not Null        Default 0.00,
CurrentBalance           Money            Not Null        Default 0.00,
CreditLimit              Money            Not Null        Default 1000.00,
ShipName                 VarChar(255)     Not Null,
ShipAddress1             VarChar(60)                      Default Null,
ShipAddress2             VarChar(60)                      Default Null,
ShipCity                 VarChar(40)      Not Null,
ShipState                VarChar(2)       Not Null,
ShipZipCode              VarChar(10)      Not Null,
CurrentInvoiceTotal      Money            Not Null        Default 0.00,
CurrentPaymentTotal      Money            Not Null        Default 0.00,
CurrentAmount            Money            Not Null        Default 0.00,
Over30                   INT              NOT NULL        DEFAULT 0,
Over60                   INT              NOT NULL        DEFAULT 0,
Over90                   INT              NOT NULL        DEFAULT 0,
PreviousBalance          Money            Not Null        Default 0.00,
EmployeeID               Int              Not Null        References SalesRep (EmployeeID));

Create Table Part
(PartNumber              Int              NOT NULL,
VendorNumber             Int              NOT NULL        References Vendor (VendorNumber),
PartDescription          TEXT             NOT NULL,
UnitPrice                MONEY            NOT NULL,
MTDSales                 Money            Not Null        Default 0.00,
YTDSales                 Money            Not Null        Default 0.00,
UnitsOnHand              Int              Not NULL        Default 0,
UnitsAllocated           Int              Not NULL        Default 0,
ReorderPoint             Int              Not NULL        Default 10,
VendorPrice              MONEY            NOT NULL,
MinimumOrderQuantity     Int              Not NULL        Default 1,
ExpectedLeadTimeDays     Int              Not NULL        Default 2,
Primary Key (PartNumber, VendorNumber));

Create Table Vendor
(VendorNumber            Int              Primary Key     Identity,
Name                     VarChar(255)     Not Null,
Address1                 VarChar(60)                      Default Null,
City                     VarChar(40)      Not Null,
State                    VarChar(2)       Not Null,
ZipCode                  VarChar(10)      Not Null,
PhoneNum                 VarChar(12)      Not Null,
CreditLimit              Money            Not Null        Default 1000.00,);
