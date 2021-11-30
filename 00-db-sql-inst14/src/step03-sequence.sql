/* 
오라클 시퀀스(sequence)

: 순차적으로 증가, 유일한 값을 생성하기 위한 객체 
주로 primary key ( unique + not null ) 를 생성하기 위해 사용
테이블과는 독립적 구조 

실제 적용시  시퀀스명.nextval : 다음 시퀀스 값이 반환 

ex ) 실제 DAO 적용사례   
     insert into guestbook(guestbook_no,title) values(guestbook_seq.nextval, ? )

현재 시퀀스 값을 반환 -> 시퀀스명.currval 
단 currval 은  시퀀스를 nextval 한 세션 내에서만 사용가능 (연결시작~연결종료시까지 즉 nextval한 컨넥션 내에서만 currval을 이용할 수 있다)
( 참고 - session :  database에 사용자가 접속~접속 종료시까지 유지되는 정보 ) 


​CREATE SEQUENCE 시퀀스명 
[START WITH 시작번호]
[INCREMENT BY 증가값]
[MAXVALUE 최대값] 
[MINVALUE 최소값]
[ CYCLE or NOCYCLE ] 
[ NOCACHE ] 


Oracle dual table 
: 오라클에서 제공하는 기본 테이블 
컬럼 하나만 존재 , 주로 시퀀스 또는 날짜함수, 산술연산에 사용
sys Admin 계정에서 관리하고 수정 및 삭제 등 조작은 불가 

*/
-- 시퀀스 생성  : 시퀀스명 test_seq 
CREATE SEQUENCE test_seq;
-- 시퀀스 삭제 
DROP SEQUENCE test_seq;

-- 오라클에서 제공하는 dual 테이블을 조회 
SELECT * FROM DUAL;
-- 연산시 사용
SELECT 2*5 FROM DUAL;
-- 현재시간 SYSDATE 
SELECT SYSDATE FROM DUAL;
-- DUAL TABLE을 이용해 시퀀스 값을 확인 
-- 시퀀스명.NEXTVAL -> 시퀀스 다음 값을 생성 
SELECT test_seq.nextval FROM DUAL;
-- DROP 한 test_seq 시퀀스명으로 다시 시퀀스를 생성해본다 ( 옵션을 start with 7 적용해서 생성 ) 
CREATE SEQUENCE test_seq START WITH 7;

-- CAR TABLE 을 생성해서 SEQUENCE를 이용해 본다 
CREATE TABLE car(
	car_no number primary key,
	model varchar2(100) not null
)
-- car_seq sequence를 생성한다 
create sequence car_seq;
-- insert 시에 sequence 를 이용해 car_no 를 등록한다 
insert into car(car_no,model) values(car_seq.nextval,'테슬라');
insert into car(car_no,model) values(car_seq.nextval,'아이오닉');

select * from car;

-- guestbook table 에 sequence를 이용 
CREATE TABLE guestbook(
	guestbook_no NUMBER PRIMARY KEY,
	title VARCHAR2(100) NOT NULL,
	content VARCHAR2(1000) NOT NULL
)
CREATE SEQUENCE guestbook_seq;

-- 시퀀스명.nextval 
select guestbook_seq.nextval from dual;
-- 시퀀스명.currval : 단독으로 사용될 수 없고 nextval 한 컨넥션 내에서 currval을 사용할 수 있다 ( 동일한 세션 내에서만 사용 가능 ) 
select guestbook_seq.currval from dual;





















