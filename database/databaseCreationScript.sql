SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `JGCredit` DEFAULT CHARACTER SET utf8 ;
USE JGCredit;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS loans;
DROP TABLE IF EXISTS communications;

CREATE TABLE users (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  version bigint(11),
  login VARCHAR(16) NOT NULL,
  login_pw VARCHAR(80) NOT NULL,
  first_name VARCHAR(25) NOT NULL,
  last_name VARCHAR(25) NOT NULL,
  email VARCHAR(50) NOT NULL,
  gender VARCHAR(6) DEFAULT 'Male' CHECK (gender IN ('Male', 'Female')),
  personal_code VARCHAR(12) NOT NULL,
  birth_date DATE NOT NULL,
  address VARCHAR(100) NOT NULL,
  phone_number VARCHAR(15) NOT NULL,
  company_name VARCHAR(50),
  job_title VARCHAR(25),
  secret_qeastion VARCHAR(100) NOT NULL DEFAULT 'Best childhood friend' CHECK (secret_qeastion IN ('Best childhood friend', 'Name of first pet', 'Favorite teacher', 'Favorite historical person')),
  secret_answer VARCHAR(100) NOT NULL,
  salary VARCHAR(10) DEFAULT '0-500€' CHECK (salary IN ('<500€', '500-1000€', '1000-2000€', '>2000€')),
  photo longblob,
  term CHAR(1) DEFAULT 'N',
  PRIMARY KEY (id)
);

CREATE TABLE employees (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  version bigint(11),
  login VARCHAR(16) NOT NULL,
  login_pw VARCHAR(80) NOT NULL,
  first_name VARCHAR(25) NOT NULL,
  last_name VARCHAR(25) NOT NULL,
  email VARCHAR(50) NOT NULL,
  gender VARCHAR(6) DEFAULT 'Male' CHECK (gender IN ('Male', 'Female')),
  personal_code VARCHAR(12) NOT NULL,
  birth_date DATE NOT NULL,
  address VARCHAR(100) NOT NULL,
  phone_number VARCHAR(15) NOT NULL,
  company_name VARCHAR(50) DEFAULT 'JagCredit Latvia',
  job_title VARCHAR(25)  NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE loans (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  version bigint(11),
  loan DECIMAL(10,2) NOT NULL,
  loan_sum DECIMAL(10,2) NOT NULL,
  interest_rate DECIMAL(10,3) NOT NULL,
  duration INT(2) DEFAULT 12,
  term_unit VARCHAR(250) DEFAULT 'monthly' CHECK (term_unit IN('weekly', 'monthly')),
  term_payment DECIMAL(10,2) NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  extended_date DATE,
  loan_status VARCHAR(10) DEFAULT 'PROCESSING' CHECK (loan_status IN ('CANCELLED', 'APPROVED', 'PROCESSING', 'CLOSED', 'PAID')),
  extended_flag VARCHAR(1) DEFAULT 'N',
  user_id int(11),
  employee_id int(11),
  bank_acc_number VARCHAR(50),
  comments VARCHAR(250),
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (employee_id) REFERENCES employees(id)
);

CREATE TABLE communications (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  version bigint(11),
  subj VARCHAR(250) NOT NULL,
  body VARCHAR(250) NOT NULL,
  sent_date DATETIME NOT NULL,
  direction_type VARCHAR(20) NOT NULL DEFAULT 'Outbound' CHECK (direction_type IN ('Outbound', 'Inbound')),
  com_type VARCHAR(20) NOT NULL DEFAULT 'E-mail' CHECK (ext_type IN ('E-mail', 'SMS', 'Call')),
  destination VARCHAR(250),
  user_id INT(11),
  loan_id INT(11),
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (loan_id) REFERENCES loans(id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1002;

CREATE TABLE rates (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  version bigint(11),
  duration int(2) NOT NULL,
  term VARCHAR(250) NOT NULL,
  rate DECIMAL(10,3) NOT NULL
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1002;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

/*Examples:*/
insert into users values (default,0,'user','111','Antons', 'Antonovs','asda@inbox.lv','Male','139091-1234',sysdate(),'Lenina iela 20-3','+37543432412','Samsung Latvia','Operator','0-500€','Name of first pet','Ezis',null,'Y');
insert into employees values (default,0,'employee','222','Antons', 'Vasiljevs','232131@inbox.lv','Male','112049-1231',sysdate(),'Lomonosova iela - 4','+37543432423','JagCredit Latvia','Operator');
insert into loans values (default,0,'200','250.00', '0.12',12,'monthly','200.4',sysdate(),sysdate(),sysdate(),'PROCESSING','Y',1,1,'3123123123','TEST');

insert into rates values (default,0,12, 'monthly','1.225');
insert into rates values (default,0,12, 'weekly','1.15');
insert into rates values (default,0,18, 'monthly','1.25');
insert into rates values (default,0,18, 'weekly','1.22');
insert into rates values (default,0,24, 'monthly','1.28');
insert into rates values (default,0,24, 'weekly','1.2');
