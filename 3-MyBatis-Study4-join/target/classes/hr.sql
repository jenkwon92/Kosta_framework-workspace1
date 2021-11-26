drop table spring_department;
drop table spring_employment;
create table spring_department(
	deptno number primary key,
	dname varchar2(100) not null,
	loc varchar2(100) not null
)
create table spring_employment(
	empno number primary key,
	ename varchar2(100) not null,
	sal number not null,
	deptno number not null,
	constraint fk_spring_deptno foreign key(deptno) references spring_department(deptno)
)
-- 부서 테이블에는 40번 부서가 없으므로 error , 참조 무결성 제약조건 위배 
-- insert into spring_employment values(1,'아이유',300,40);
insert into spring_employment values(1,'아이유',300,10);
insert into spring_employment values(2,'조승우',500,10);
insert into spring_employment values(3,'배두나',400,20);

insert into spring_department values(10,'전략기획','판교');
insert into spring_department values(20,'해양수산','부산');
insert into spring_department values(30,'공공사업','판교');
commit
select * from spring_department;
select * from spring_employment;
-- JOIN SQL : 하나 이상의 테이블을 결합하여 조회
-- INNER JOIN : 조인 조건에 부합되는 정보를 조회
-- OUTER JOIN : 조인 조건에 부합되지 않는 정보까지 모두 조회
-- SELF JOIN : 하나의 테이블 자체에서 조인

SELECT e.ename, d.dname, d.loc
FROM spring_employment e , spring_department d
WHERE  e.deptno=d.deptno AND e.empno=1

SELECT e.empno,  e.ename, e.sal, d.deptno, d.dname, d.loc
FROM spring_employment e, spring_department d
WHERE  e.deptno(+)=d.deptno
--LEFT OUTER JOIN 으로 표현
SELECT e.empno,  e.ename, e.sal, d.deptno, d.dname, d.loc
FROM spring_department d
LEFT OUTER JOIN spring_employment e
ON  e.deptno=d.deptno

--20번 부서 해양수산 사원수 1명
--10번 부서 전략기획 사원수 2명
SELECT deptno, count(*) as emp_count
FROM spring_employment
GROUP BY deptno

SELECT e.deptno, d.dname, e.emp_count
 FROM (
 	SELECT deptno, count(*) as emp_count
	FROM spring_employment
	GROUP BY deptno ) e , spring_department d
WHERE e.deptno = d.deptno
ORDER BY e.deptno DESC
 
-- 조회 결과가 null 인 값을 다른 값으로 치환하는 함수 nvl(컬럼, 치환값)
SELECT nvl(null,0) from dual;

--5번
SELECT d.deptno, d.dname, e.emp_count
FROM spring_department d
LEFT OUTER JOIN (SELECT deptno,COUNT(*) as emp_count FROM spring_employment) e
ON  e.deptno=d.deptno

--inline view 를 이용해서 outer join -> 부서명을 조회 (조회시 사원이 없는 부서 정보도 조회)
SELECT d.deptno, d.dname, nvl(e.emp_count,0) AS emp_count
 FROM (
 	SELECT deptno, count(*) as emp_count
	FROM spring_employment
	GROUP BY deptno ) e , spring_department d
WHERE e.deptno(+) = d.deptno
ORDER BY e.deptno DESC
