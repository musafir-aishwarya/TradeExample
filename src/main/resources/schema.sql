DROP TABLE IF EXISTS URL;  
CREATE TABLE URL (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
short_url VARCHAR(50) NOT NULL,
long_url VARCHAR(50) NOT NULL, 
count INT(8) NOT NULL  
);