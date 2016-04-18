drop database if exists hibernate;

create database hibernate;

use hibernate;

CREATE TABLE category_inf (
  category_id bigint(20) NOT NULL auto_increment,
  name varchar(255) default NULL,
  eff_start_date datetime default NULL,
  eff_end_date datetime default NULL,
  PRIMARY KEY  (category_id)
);
INSERT INTO category_inf VALUES
(1,'it产品', ADDDATE(now() , - 200) , ADDDATE(now() , 20)),
(2,'工业产品', ADDDATE(now() , - 180) , ADDDATE(now() , 34)),
(3,'输出设备', ADDDATE(now() , - 223) , ADDDATE(now() , 42));

CREATE TABLE product_inf (
  product_id bigint(20) NOT NULL auto_increment,
  product_name varchar(255) default NULL,
  stock_number int(11) default NULL,
  eff_start_date datetime default NULL,
  eff_end_date datetime default NULL,
  PRIMARY KEY  (product_id)
);

INSERT INTO product_inf VALUES 
(1,'显示器',20040404 , ADDDATE(now() , - 90) , ADDDATE(now() , 20)),
(2,'键盘',20040219 ,  ADDDATE(now() , - 78) , ADDDATE(now() , 19)),
(3,'机箱',20040915 , ADDDATE(now() , - 56) , ADDDATE(now() , 15));


CREATE TABLE product_category (
  category_id bigint(20) NOT NULL,
  product_id bigint(20) NOT NULL,
  PRIMARY KEY  (product_id,category_id),
  KEY FKA0303E4E64F7AABC (category_id),
  KEY FKA0303E4E142E1558 (product_id),
  FOREIGN KEY (product_id) REFERENCES product_inf(product_id),
  FOREIGN KEY (category_id) REFERENCES category_inf (category_id)
);

INSERT INTO product_category VALUES 
(1,1),
(1,3),
(2,1),
(2,2),
(3,1),
(3,2),
(3,3);
