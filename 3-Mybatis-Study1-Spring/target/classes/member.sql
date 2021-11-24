CREATE TABLE mybatis_member(
	id VARCHAR2(100)  PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	address VARCHAR2(100) NOT NULL
)
INSERT INTO mybatis_member VALUES('java','a','아이유','오리');
commit
SELECT * FROM mybatis_member;