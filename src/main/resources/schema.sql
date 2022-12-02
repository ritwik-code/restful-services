CREATE TABLE COURSE
(
ID BIGINT NOT NULL,
NAME VARCHAR(255),
AUTHOR VARCHAR(255) NOT NULL,
PRIMARY KEY (ID)
);


insert into course(id,name,author)
values
(1,'Brave new world', 'Aldous Huxley'),
(2,'Infinite Jest', 'David Foster Wallace'),
(3,'Thus spoke Zarathustra', 'Friedrich Nietzsche');