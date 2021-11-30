-- sql 한줄 주석 
/*  sql 여러줄 주석 
 *  sql 은 대소문자 구별하지 않는다 
 * 
 * SQL (Structured Query Language) : 데이터베이스를 제어하는 언어 
  											  데이터베이스를 정의,조작,제어하는 언어
 
   DDL, DML , DCL ( SQL은 다음과 같은 범주로 구분될 수 있다 ) 
   1. DDL ( Data Definition Lanaguage : 데이터 정의어 ) - CREATE 생성 , DROP 삭제 , ALTER 수정 
   2. DML ( Data Manipulation Language : 데이터 조작어 ) -   INSERT 삽입, SELECT 조회 , UPDATE 수정  , DELETE 삭제   ( CRUD - Create, Read, Update, Delete ) 
   3. DCL ( Data Control Language : 데이터 제어어 ) - COMMIT 실제DB에 반영 , ROLLBACK 작업을 취소하고 원상태로 되돌린다 
   															  GRANT 권한부여 , REVOKE 권한취소 
   															  
   TABLE - 데이터를 저장하는 공간 
   COLUMN - 속성 attribute 
   CONSTRAINT - 제약조건   ex)  PRIMARY KEY ( PK, 기본키, 주키 ) -> 중복 허용하지 않고 NOT NULL이어야 한다 ( UNIQUE + NOT NULL ) 
   DATA TYPE - 문자열 VARCHAR2(100) , 숫자형 NUMBER ... 															     															    
 */

-- sql 실행 단축키 : 영역 지정 후  ALT + X  

-- DDL : 테이블 생성 
CREATE TABLE member(
	id VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	address VARCHAR2(100)
)
-- DDL : 테이블 삭제 
DROP TABLE member;
-- DML : 데이터 조회 Read(정보를 읽는다) 
SELECT * FROM member;
-- DML : 데이터 삽입 Create(정보를 생성한다) 
INSERT INTO member(id,password,name,address) VALUES('java','a','아이유','오리');

INSERT INTO member(id,password,name,address) VALUES('spring','s','서정우','용인');

-- 특정 컬럼( id , name ) 만 조회 
SELECT id,name FROM member;

-- ERROR : id 의 제약조건 primary key -> unique + not null , id가 중복되므로 error 
INSERT INTO member(id,password,name,address) VALUES('java','b','어이유','죽전');
-- ERROR : id 의 제약조건 primary key -> unique + not null , id가 null이므로 error 
INSERT INTO member(password,name,address) VALUES('b','어이유','죽전');
-- ERROR : password 컬럼의 제약조건 not null 이므로 반드시 insert시에 데이터를 삽입해야 한다 
INSERT INTO member(id,name,address) VALUES('jdbc','어이유','죽전');
-- SUCCESS : address 컬럼은 별도의 제약조건이 없으므로 null이 허용 
INSERT INTO member(id,password,name) VALUES('jdbc','star','박보검');

SELECT * FROM member;

-- WHERE 조건절을 이용해 정보 조회 
-- id 가 java 인 회원의 name과 address를 조회 
SELECT name,address FROM member WHERE id='java';
SELECT name,address FROM member WHERE id='java2';
-- name이 아이유 이고 address가 오리인 회원의 id를 조회 
SELECT id FROM member WHERE name='아이유' AND address='오리';

-- id 가 jdbc인 회원 정보를 조회 
SELECT * FROM member WHERE id='jdbc';
-- id가 jdbc인 회원 주소를 제주로 업데이트 
UPDATE member SET address='제주' WHERE id='jdbc';

-- id가 jdbc인 회원 정보를 삭제 
DELETE  FROM member WHERE id='jdbc';

-- 실제 DB에 작업 결과를 반영 
COMMIT 

-- DML ( CRUD : Create - insert , Read - select , Update - update , Delete - delete ) 연습 

-- 회원 아이디 angel  , 패스워드 kind , 이름 이상순 , 주소  애월읍  정보를 insert 
INSERT INTO member(id,password,name,address) VALUES('angel','kind','이상순','애월읍');
-- 회원 name이 이상순 이고 address가 애월읍인 회원의 id와 password를 select 
SELECT id,password FROM member WHERE name='이상순' AND address='애월읍';
-- 회원의 address가 애월읍인 회원의 address를 오리로 update를 한다 
UPDATE member SET address='오리' WHERE address='애월읍';
-- 회원의 address가 오리인 회원의 id와 name을 조회한다 select 
SELECT id,name FROM member WHERE address='오리';
-- 회원의 id가 angel이고 password가 kind인 회원 정보를 삭제 delete 
DELETE FROM member WHERE id='angel' AND password='kind';
-- 회원 id가 angel 인 회원의 name을 조회 select ( 삭제했으므로 조회 결과는 없다 ) 
SELECT name FROM member WHERE id='angel';

COMMIT



