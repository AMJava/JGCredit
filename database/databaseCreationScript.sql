SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `JGCredit` DEFAULT CHARACTER SET utf8 ;
USE JGCredit;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS loans;
DROP TABLE IF EXISTS loans_ext;
DROP TABLE IF EXISTS communications;
DROP TABLE IF EXISTS payments;

CREATE TABLE users (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
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
  PRIMARY KEY (id)
);

CREATE TABLE employees (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
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
  loan_sum DECIMAL(10,2) NOT NULL,
  interest_rate DECIMAL(6,2) NOT NULL,
  term INT(3) DEFAULT 12,
  term_unit VARCHAR(5) DEFAULT 'month' CHECK (term_unit IN('day', 'month')),
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  loan_status VARCHAR(10) DEFAULT 'PROCESSING' CHECK (loan_status IN ('CANCELLED', 'APPROVED', 'PROCESSING', 'CLOSED', 'PAID')),
  extendet_flag VARCHAR(1) DEFAULT 'N',
  user_id int(11),
  employee_id int(11),
  bank_acc_number VARCHAR(50),
  comments VARCHAR(250),
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (employee_id) REFERENCES employees(id)
);
CREATE TABLE loans_ext (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  ext_type VARCHAR(12) DEFAULT 'Prolongation' CHECK (ext_type IN ('Prolongation', 'Penalty')),
  ext_status VARCHAR(10) DEFAULT 'PROCESSING' CHECK (ext_status IN ('CANCELLED', 'APPROVED', 'PROCESSING', 'CLOSED', 'PAID')),
  ext_date DATE NOT NULL,
  end_date DATE NOT NULL,
  interest_rate DECIMAL(6,2),
  comission DECIMAL(10,2) DEFAULT 1,
  loan_id INT(11) NOT NULL,
  bank_acc_number VARCHAR(50),
  comments VARCHAR(250),
  PRIMARY KEY (id),
  FOREIGN KEY (loan_id) REFERENCES loans(id)
    ON DELETE CASCADE
);
CREATE TABLE payments (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  payment_type VARCHAR(20) DEFAULT 'Outcome' CHECK (payment_type IN ('Outcome', 'Income')),
  payment_sum DECIMAL(10,2) NOT NULL,
  payment_date DATETIME NOT NULL,
  bank_acc_number VARCHAR(50),
  loan_id INT(11),
  loan_ext_id INT(11),
  PRIMARY KEY (id),
  FOREIGN KEY (loan_id) REFERENCES loans(id),
  FOREIGN KEY (loan_ext_id) REFERENCES loans_ext(id)
);

CREATE TABLE communications (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  subj VARCHAR(250) NOT NULL,
  body VARCHAR(250) NOT NULL,
  sent_date DATETIME NOT NULL,
  direction_type VARCHAR(20) NOT NULL DEFAULT 'Outbound' CHECK (direction_type IN ('Outbound', 'Inbound')),
  com_type VARCHAR(20) NOT NULL DEFAULT 'E-mail' CHECK (ext_type IN ('E-mail', 'SMS', 'Call')),
  destination VARCHAR(250),
  user_name VARCHAR(250),
  user_id INT(11),
  loan_id INT(11),
  loan_ext_id INT(11),
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (loan_id) REFERENCES loans(id),
  FOREIGN KEY (loan_ext_id) REFERENCES loans_ext(id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1002;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

/*Examples:*/
insert into users values (default,'user','111','Antons', 'Antonovs','asda@inbox.lv','Male','139091-1234',sysdate(),'Lenina iela 20-3','+37543432412','Samsung Latvia','Operator','0-500€','Name of first pet','Ezis',null);
insert into employees values (default,'employee','222','Antons', 'Vasiljevs','232131@inbox.lv','Male','112049-1231',sysdate(),'Lomonosova iela - 4','+37543432423','JagCredit Latvia','Operator');
insert into loans values (default,'250.00', '0.12',100,'days',sysdate(),sysdate(),'PROCESSING','Y',1,1,'3123123123','TEST');
insert into loans_ext values (default,'Prolongation', 'PROCESSING',sysdate(),sysdate(),'0.22','0.12',1,'123213213','TEST');
insert into payments values (default,'Outcome', '100',sysdate(),'12312312',1,null);
insert into payments values (default,'Outcome', '100',sysdate(),'123213132',null,1);
