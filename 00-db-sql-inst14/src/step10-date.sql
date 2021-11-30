/*
	DATE 타입 : 데이터베이스 시간( 년,월,일,시,분,초 ) 를 관리하는 데이터 타입 
	
	주요 함수 
	1. to_char() : 데이터베이스에 저장된 DATE 형의 정보를 문자열로 반환받을 때 사용하는 함수 
	2. to_date() : 문자타입의 시간 정보를 데이터베이스의 DATE형으로 변환해 저장할 때 사용하는 함수 
	
	SYSDATE 예약어 : 현재 시간을 표현하는 키워드 
	
	참고)  Oracle DUAL 테이블 : 오라클에서 제공하는 기본 테이블 , 함수 및 키워드를 실행할 때 사용 
*/
SELECT SYSDATE FROM DUAL;
-- TO_CHAR() 를 이용해 원하는 시간 포맷을 설정해 문자열로 반환받아 본다 
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD') FROM DUAL;
SELECT TO_CHAR(SYSDATE,'YYYY. MM. DD') FROM DUAL;
SELECT TO_CHAR(SYSDATE,'YYYY') FROM DUAL;
SELECT TO_CHAR(SYSDATE,'MM') FROM DUAL;
SELECT TO_CHAR(SYSDATE,'DD') FROM DUAL;

SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD HH:MI:SS') FROM DUAL;

-- DAY 는 요일 
SELECT TO_CHAR(SYSDATE,'DAY') FROM DUAL;

-- 테이블 생성해서 테스트 
CREATE TABLE date_test(
	id VARCHAR2(100) PRIMARY KEY,
	mydate DATE NOT NULL
)
INSERT INTO date_test(id,mydate) VALUES('java',sysdate);

SELECT * FROM date_test;

-- mydate 를 년 월 일 로만 조회 
SELECT id,TO_CHAR(mydate,'YYYY.MM.DD') FROM date_test;

-- 어플리케이션에서 문자열 정보로 년,월,일 로 정보를 받아와 db에 정보를 insert 
-- TO_DATE(시간정보,시간포맷)
INSERT INTO date_test(id,mydate) VALUES('jsp',TO_DATE('2019.2.2','YYYY.MM.DD'));
INSERT INTO date_test(id,mydate) VALUES('DBCP',TO_DATE('2021.8.2','YYYY.MM.DD'));

-- DATE 연산 
-- 하루전 
SELECT id,mydate,mydate-1 FROM date_test;
-- 몇일이 경과했는 지 조회 ( 현재시간과 저장시간의 일수를 확인 ) 
SELECT id,mydate,sysdate-mydate FROM date_test;
-- 소수점 이하는 제외 trunc() 을 이용 
SELECT id,mydate,trunc(sysdate-mydate) FROM date_test;
-- 몇개월 경과  months_between(현재시간,등록시간) 
SELECT id,mydate,trunc(months_between(sysdate,mydate)) FROM date_test;
-- 몇년 경과 
SELECT id,mydate,trunc(months_between(sysdate,mydate)/12) FROM date_test;

















