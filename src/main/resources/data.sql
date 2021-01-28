DROP TABLE IF EXISTS credit_transaction;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL  
);

CREATE TABLE credit_transaction (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  id_customer INT NOT NULL,
  amount decimal(15,2) NOT NULL,
  time TIMESTAMP NOT NULL
);
