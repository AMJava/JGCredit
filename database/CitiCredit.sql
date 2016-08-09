CREATE SCHEMA IF NOT EXISTS `JagCredit` DEFAULT CHARACTER SET utf8 ;
USE JagCredit;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS agreements;
DROP TABLE IF EXISTS agreements_ext;
DROP TABLE IF EXISTS communications;
DROP TABLE IF EXISTS payments;

CREATE TABLE customers (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  first_name VARCHAR(25) NOT NULL,
  last_name VARCHAR(25) NOT NULL,
  personal_code VARCHAR(12) NOT NULL,
  birth_date DATE NOT NULL,
  address VARCHAR(100) NOT NULL,
  m_phone_number VARCHAR(15) NOT NULL,
  phone_number VARCHAR(15) NOT NULL,
  company_name VARCHAR(50) NOT NULL,
  job_title VARCHAR(25)  NOT NULL,
  salary VARCHAR(10) DEFAULT '0-500€' CHECK (salary IN ('<500€', '500-1000€', '1000-2000€', '>2000€')),
  PRIMARY KEY (id)
);

CREATE TABLE employees (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  first_name VARCHAR(25) NOT NULL,
  last_name VARCHAR(25) NOT NULL,
  personal_code VARCHAR(12) NOT NULL,
  birth_date DATE NOT NULL,
  address VARCHAR(100) NOT NULL,
  m_phone_number VARCHAR(15) NOT NULL,
  phone_number VARCHAR(15) NOT NULL,
  company_name VARCHAR(50) DEFAULT 'JagCredit Latvia',
  job_title VARCHAR(25)  NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE agreements (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  loan_sum DECIMAL(10,2) NOT NULL,
  interest_rate DECIMAL(6,2) NOT NULL,
  term INT(3) DEFAULT 12,
  term_unit VARCHAR(5) DEFAULT 'month' CHECK (term_unit IN('day', 'month')),
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  agreement_status CHAR(10) DEFAULT 'PROCESSING' CHECK (agreement_status IN ('CANCELLED', 'APPROVED', 'PROCESSING', 'CLOSED', 'PAID')),
  extendet_flag VARCHAR(1) DEFAULT 'N',
  user_id int(11),
  comments VARCHAR(250),
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES customers(id)
);
CREATE TABLE agreements_ext (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  ext_type VARCHAR(12) DEFAULT 'Prolongation' CHECK (ext_type IN ('Prolongation', 'Penalty')),
  ext_date DATE NOT NULL,
  end_date DATE NOT NULL,
  interest_rate DECIMAL(6,2),
  comission DECIMAL(10,2) DEFAULT 1,
  agreement_id INT(11) NOT NULL,
  comments VARCHAR(250),
  PRIMARY KEY (id),
  FOREIGN KEY (agreement_id) REFERENCES agreements(id)
);
CREATE TABLE payments (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  payment_sum DECIMAL(10,2) NOT NULL,
  payment_date DATETIME NOT NULL,
  agreement_id INT(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (agreement_id) REFERENCES agreements(id)
);

CREATE TABLE communications (
  id int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  body VARCHAR(250) NOT NULL,
  sent_date DATETIME NOT NULL,
  com_type VARCHAR(20) DEFAULT 'E-mail' CHECK (ext_type IN ('E-mail', 'SMS', 'Call')),
  customer_id INT(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (customer_id) REFERENCES customers(id)
)

--Examples:
--insert into customers values (default,'Arturs', 'Arturs','123213-123',sysdate(),'dasdas','+3753123213','+3753123213','BMW','Driver','0-500€');
--insert into employees values (default,'Antons', 'Antons','3123213-31231',sysdate(),'dadsad','+3753131223213','+375333123213','Lexus','Driver');
--insert into agreements values (default,'250.00', '0.12',100,'days',sysdate(),sysdate(),'PROCESSING','Y',1,'TEST');
--insert into agreements_ext values (default,'Prolongation', sysdate(),sysdate(),'0.22','0.12',1,'TEST');
