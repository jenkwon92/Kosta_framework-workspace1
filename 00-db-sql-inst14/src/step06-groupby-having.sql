/*
 	group by ~ having 
 	
 	group by : 테이블에서 특정컬럼을 기준으로 그룹화하여 검색할 때 사용 
 				데이터를 원하는 그룹으로 나눌 수 있다 
 	having : group by 와 함께 사용하는 조건절 ( 그룹에 대한 조건을 지정 ) 
 	
 	예 ) 상품 테이블에서 제조사별 상품수, 평균가 
 	     사원 테이블에서 부서별 사원수, 평균월급 			 			 
 */
select * from product;

-- maker별 상품수 조회 
select maker,count(*) as 상품수
from product
group by maker
order by 상품수 desc

-- maker별 상품수 조회하되 상품수가 1개를 초과하는 maker(그룹)들만 조회 ( group by ~ having ) 
select maker,count(*) as 상품수
from product
group by maker
having count(*)>1
order by 상품수 desc

-- maker별 상품 평균가(avg())를 조회하되 평균가 내림차순으로 정렬 ( maker , 평균가 가 조회 ) 
select maker,round(avg(price)) as 평균가
from product
group by maker
order by 평균가 desc

-- maker별 상품 평균가(소수점이하 반올림) 가 1540원을 초과하는 제조사maker를 조회하되 
-- maker별 상품수, 평균가를 조회한다 ( maker, 상품수 , 평균가 )
-- 상품수 오름차순으로 조회 
select maker,count(*) as 상품수, round(avg(price)) as 평균가
from product
group by maker
having round(avg(price))>1540
order by 상품수 asc;



select * from S_EMPLOYEE;

-- job 별 사원수 ( job , 사원수 ) 를 조회하되 사원수 내림차순 정렬 
select job,count(*) as 사원수
from s_employee
group by job
order by 사원수 desc;

-- job 별 평균월급(avg(salary))을 조회하되 평균월급 내림차순 정렬 ( job, 평균월급 )
-- 평균월급이 700을 초과하는 job에 한해서 조회한다 
select job,avg(salary) as 평균월급
from S_EMPLOYEE
group by job
having avg(salary)>700
order by 평균월급 desc

-- sql test 
--s_employee 의 job 별  사원수, 최고 salary 를 조회 ( 최고 salary 내림차순 ) 
select job,count(*), max(salary) as highestsal
from S_EMPLOYEE
group by job
order by highestsal desc

-- 전체 사원의 평균월급(730)보다 job 그룹별 평균월급액이 작은 job 그룹의 job,평균월급을 조회(평균월급 내림차순) 
select avg(salary) from S_EMPLOYEE;
select avg(salary) from S_EMPLOYEE where job='영업'; -- 영업 600
select avg(salary) from S_EMPLOYEE where job='개발'; -- 개발 833.33..
select avg(salary) from S_EMPLOYEE where job='총무'; -- 총무 720 

-- 총무직종 , 영업직종 조회결과로 나와야 한다 ( group by ~ having , subquery ) 
총무 720
영업 600

select job,avg(salary) as avgsal
from S_EMPLOYEE
group by job
having avg(salary)<(select avg(salary) from S_EMPLOYEE)
order by avgsal desc

-- product 
select * from product
-- 
--  제조사별 상품의 평균가(having)가   전체 상품의 평균가(subquery)보다 작은 제조사의 이름과 상품평균가를 조회하되 평균가 내림차순으로 정렬한다  
select maker,round(avg(price)) as avgprice
from product
group by maker
having round(avg(price))<(select round(avg(price)) from product)
order by avgprice desc;























