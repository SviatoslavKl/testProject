USE calendly_db;

CREATE TABLE IF NOT EXISTS calendly_entity (
     id int(11) NOT NULL AUTO_INCREMENT,
     type varchar(30) DEFAULT NULL,
     name varchar(20) DEFAULT NULL,
     description varchar(255) DEFAULT NULL,
     duration int(11) DEFAULT NULL,
     slug varchar(50) DEFAULT NULL,
     color varchar(20) DEFAULT NULL,
     created_at bigint(20) DEFAULT NULL,
     updated_at bigint(20) DEFAULT NULL,
     active boolean DEFAULT NULL,
     url varchar(255) DEFAULT NULL,
     PRIMARY KEY (id)
);