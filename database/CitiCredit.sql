CREATE SCHEMA IF NOT EXISTS `JagCredit` DEFAULT CHARACTER SET utf8 ;
USE JagCredit;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS agreement;
DROP TABLE IF EXISTS extension;
DROP TABLE IF EXISTS message;
DROP TABLE IF EXISTS tranche;
DROP TABLE IF EXISTS reserved;

CREATE TABLE customer (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  fName varchar(25) NOT NULL,
  lName varchar(25) NOT NULL,
  personCode VARCHAR(12) NOT NULL,
  birthDate DATE NOT NULL,
  addres VARCHAR(100) NOT NULL,
  pnoneMob INT(8) NOT NULL,
  phoneLand INT(8) NOT NULL,
  workPlace VARCHAR(50) NOT NULL,
  workPosition VARCHAR(25)  NOT NULL,
  PRIMARY KEY (ID)
);
CREATE TABLE employee (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  fName varchar(25) NOT NULL,
  lName varchar(25) NOT NULL,
  personCode VARCHAR(12) NOT NULL,
  birthDate DATE NOT NULL,
  address VARCHAR(100) NOT NULL,
  pnoneMob INT(8) NOT NULL,
  phoneLand INT(8) NOT NULL,
  workPlace VARCHAR(50) DEFAULT 'JagCredit, Riga, Proletarskaya ulica 1',
  workPosition VARCHAR(25)  NOT NULL,
  PRIMARY KEY (ID)
);
CREATE TABLE agreement (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  sum DECIMAL(10,2) NOT NULL,
  interestRate DECIMAL(2,2) NOT NULL,
  term INT(3) DEFAULT 12,
  termUnit VARCHAR(5) DEFAULT 'month' CHECK (TERM_UNIT IN('day', 'month')),
  startDate DATE NOT NULL,
  endDate DATE NOT NULL,
  agreementStatus CHAR(10) DEFAULT 'PROCESSING' CHECK (AGREEMENT_STATUS IN ('CANCELLED', 'APPROVED', 'PROCESSING')),
  isExtended BIT DEFAULT 0,
  userId INT(11) ,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES 	user(id)
); 
CREATE TABLE extension (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  extType VARCHAR(12) DEFAULT 'prolongation' CHECK (EXT_TYPE ('prolongation', 'penalty')),
  interestRate DECIMAL(2,2),
  comission DECIMAL(10,2) DEFAULT 1,
  agreementId INT(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (agreementId) REFERENCES agreement(id)
);
CREATE TABLE tranche (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  sum DECIMAL(11,2) NOT NULL,
  paymentDate DATE NOT NULL,
  agreementId INT(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (agreementId) REFERENCES agreement(id)
);
#to be refactored I guess
CREATE TABLE message (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  body TEXT NOT NULL,
  mesDate DATE NOT NULL,
  senderId INT(11) NOT NULL,
  receiverId INT(11) NOT NULL,
  PRIMARY KEY (id)
);
