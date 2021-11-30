/*
		SQL : 데이터베이스를 정의 조작 제어하는 언어 
		1. DDL 데이터 정의어 - CREATE , DROP, ALTER
		2. DML 데이터 조작어 - INSERT, SELECT, UPDATE, DELETE  ( CRUD ) 
		3. DCL 데이터 제어어 - COMMIT, ROLLBACK
*/
-- DATA TYPE : 문자열 - 오라클에서 권장하는 문자열 타입 VARCHAR2(10)
--					 정수,실수 - NUMBER 

-- DDL : CREATE 테이블 생성 
CREATE TABLE typetest(
	name VARCHAR2(9) PRIMARY KEY,
	money NUMBER NOT NULL
)
-- DML : INSERT 
-- ERROR : NAME의 최대사이즈가 9 , 아래는 10 이므로 ERROR 
INSERT INTO typetest(name,money) VALUES('abcdefghij',100);
INSERT INTO typetest(name,money) VALUES('abcdefghi',100);
-- 한글은 3byte를 차지 , 아래는 12byte 이므로 error 
INSERT INTO typetest(name,money) VALUES('아이유님',100);
INSERT INTO typetest(name,money) VALUES('아이유',100);

-- DML : SELECT
SELECT name,money FROM TYPETEST;

-- DML : UPDATE 
-- NAME이 아이유인 대상의 MONEY를 +200 누적해본다
UPDATE typetest SET money=money+200 WHERE name='아이유';

-- DDL : DROP - 테이블 삭제 
DROP TABLE typetest;

-- DDL : ALTER - 테이블 정보를 변경 ( TABLE 명 변경 , COLUMN 명 변경, 제약조건 및 타입변경 등 )
CREATE TABLE altertest(
	id VARCHAR2(100) PRIMARY KEY,
	hit NUMBER DEFAULT 0
)  
-- DEFAULT 제약조건 : 별도로 INSERT 하지 않으면 0으로 초기값이 저장 
-- DML : INSERT , hit는 0으로 저장된다 
INSERT INTO altertest(id) VALUES('java');
SELECT id,hit FROM altertest;

-- DDL : ALTER를 이용해서 테이블명을 altertest2로 변경해본다 
ALTER TABLE altertest RENAME TO altertest2;
SELECT id,hit FROM altertest2;
-- DDL : ALTER를 이용해서 컬럼명을 hit에서 count로 변경해본다 
ALTER TABLE altertest2 RENAME COLUMN hit to count;

SELECT * FROM altertest2;

/*
 	테이블명 : product 
 	컬럼명 : id , name, maker , price 
 	데이터타입 : id, price 는 number 
 				  name , maker 는 varchar2(100)
 	제약조건 : id 는 primary key 
 				name, maker 는 not null 
 				price 는 default 0 				
 */
-- DDL 
CREATE TABLE product(
	 id NUMBER PRIMARY KEY,
	 name VARCHAR2(100) NOT NULL,
	 maker VARCHAR2(100) NOT NULL,
	 price NUMBER DEFAULT 0
)
-- DML : INSERT 
INSERT INTO PRODUCT values(1,'불닭볶음면','삼양',1500);
INSERT INTO PRODUCT values(2,'진라면','오뚜기',1100);
INSERT INTO PRODUCT values(3,'테라','하이트진로',1800);
INSERT INTO PRODUCT values(4,'참이슬후레쉬','하이트진로',1300);

-- DCL 
COMMIT 

-- DML : SELECT 
SELECT * FROM PRODUCT;

-- 데이터베이스 함수 테스트 
--  COUNT(*) 
SELECT COUNT(*) FROM PRODUCT; -- 총 상품수 
SELECT COUNT(*) FROM MEMBER; -- 총 회원수 

-- 상품 최저가 
SELECT MIN(PRICE) FROM PRODUCT;
-- 상품 최고가 
SELECT MAX(PRICE) FROM PRODUCT;
-- 상품 평균가 
SELECT AVG(PRICE) FROM PRODUCT;
-- 상품 평균가 반올림 
SELECT ROUND(AVG(PRICE)) FROM PRODUCT;

-- 정렬 : 오름차순 정렬 , 내림차순 정렬 
-- PRICE 오름차순 정렬 
-- ORDER BY 만 명시하면 기본 오름차순 정렬 
SELECT NAME,PRICE FROM PRODUCT ORDER BY PRICE;
SELECT NAME,PRICE FROM PRODUCT ORDER BY PRICE ASC;
-- PRICE 내림차순 정렬 
SELECT NAME,PRICE FROM PRODUCT ORDER BY PRICE DESC;
/*
 *    SELECT
 *    FROM 
 * 	  WHERE 
 * 	  ORDER BY
 */
-- MAKER가 하이트진로 인 상품의 ID, NAME, PRICE를 조회하되 
-- PRICE 내림차순으로 정렬되게 하세요 
SELECT ID,NAME,PRICE
FROM PRODUCT
WHERE MAKER='하이트진로'
ORDER BY PRICE DESC;

SELECT * FROM PRODUCT;
-- PRICE가 1300 이상 , 2000 이하 인 상품의 NAME과 PRICE 를 조회 ( PRICE 오름차순 ) 
SELECT NAME,PRICE
FROM PRODUCT
WHERE PRICE>=1300 AND PRICE<=2000
ORDER BY PRICE ASC;

-- BETWEEN  AND 로 위의 SQL을 표현할 수 있다 
SELECT NAME,PRICE
FROM PRODUCT
WHERE PRICE BETWEEN 1300 AND 2000
ORDER BY PRICE ASC;

-- PRIMARY KEY로 검색해서 상품 존재 유무 확인 
SELECT COUNT(*) FROM PRODUCT WHERE ID=1; -- 존재하면 1
SELECT COUNT(*) FROM PRODUCT WHERE ID=7; -- 없으면 0 

-- 컬럼 별칭 
SELECT MIN(PRICE) AS 최저가 FROM PRODUCT;

-- MAKER 조회 ( 중복된 MAKER 정보까지 모두 조회 ) 
SELECT MAKER FROM PRODUCT;

-- DISTINCT :  MAKER 종류를 조회 ( 중복없이 MAKER 종류만 조회 )  
SELECT DISTINCT MAKER FROM PRODUCT;

-- LIKE 연산자 : 일부가 포함되는 내용을 검색하는 연산자 ( 웹의 검색 기능에서 많이 사용됨 ) 
-- WHERE 컬럼명 LIKE '%검색키워드%' 
-- % : 0개 이상의 문자
SELECT * FROM PRODUCT WHERE NAME LIKE '%면%';
SELECT * FROM PRODUCT WHERE MAKER LIKE '%트진%';
-- 어플리케이션 테스트 : 04-jdbc 에서 TestGuestBookDAO4에서 확인해본다 




















