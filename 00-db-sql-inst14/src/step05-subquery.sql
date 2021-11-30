/*
	SubQuery : 서브쿼리 , 부쿼리 , 하위쿼리 
    			   SQL 내의 SQL 
*/
SELECT * FROM PRODUCT;

-- 상품 정보 중 가장 비싼 가격의 상품명은 ? 
-- 1) 상품 최고가를 조회 , 2200
select max(price) from product;
-- 2) 최고가인 2200 price를 가진 상품명을 조회 
select name from product where price=2200;

-- 위의 1) 2) sql을 subquery를 이용해 한번에 조회 
select name from product where price=(select max(price) from product);

-- 전체 상품의 평균가격보다 높은 가격의 상품들 중 가장 낮은 가격의 name,maker,price를 조회 
-- 1) 전체 상품 평균가 : 1600
select avg(price) from product;
-- 2) 상품 평균가보다 높은 가격의 상품들 중 가장 낮은 가격은? 1700
select min(price) from product where price>1600;
-- 3) 상품 평균가보다 높은 가격의 상품들 중 가장 낮은 가격의 상품 정보를 조회 
select name,maker,price from product where price=1700;

-- 1, 2 번 sql을 subquery로 표현 
select min(price) from product where price>(select avg(price) from product);

-- 1,2,3 을 subquery를 이용해 하나의 sql로 표현 
select name,maker,price from product where price=(
	select min(price) from product where price>(select avg(price) from product)
)

-- 연습)  product 중 가장 낮은 price 의 상품의 maker는 ?  오뚜기 
select maker from product where price=(select min(price) from product);


-- 사원 테이블 
create table s_employee(
	empno number primary key,
	name varchar2(100) not null,
	job varchar2(100) not null,
	salary number not null
)
-- 시퀀스 
create sequence s_employee_seq;

insert into S_EMPLOYEE(empno,name,job,salary) values(s_employee_seq.nextval,'아이유','개발',700);

insert into S_EMPLOYEE(empno,name,job,salary) values(s_employee_seq.nextval,'강하늘','개발',900);
insert into S_EMPLOYEE(empno,name,job,salary) values(s_employee_seq.nextval,'유재석','총무',600);
insert into S_EMPLOYEE(empno,name,job,salary) values(s_employee_seq.nextval,'박보검','개발',900);
insert into S_EMPLOYEE(empno,name,job,salary) values(s_employee_seq.nextval,'이상순','총무',600);


select * from S_EMPLOYEE;


/*
  해당 job (직종) 의 사원 중 가장 높은 salary를 받는
  사원 정보를 조회하는 메서드 
*/
-- job 에 해당하는 사원의 가장 높은 salary 를 조회 
	select max(salary) from s_employee where job='개발';
-- 위 sql에서 조회된 salary를 받는 사원 정보( job 에 해당하는 사원에 한해)  
	select empno,name,job,salary 
	from s_employee
	where job='개발' 
	and salary=(select max(salary) from s_employee where job='개발')



