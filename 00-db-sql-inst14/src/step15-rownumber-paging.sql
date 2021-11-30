/*
	row_number() over() : 조회된 row(행)에 대한 순차적인 번호를 제공하는 함수 
	
	Inline View : SQL 문장에서 FROM 절에 사용되는 SubQuery 
					FROM 절에 서브쿼리로 SELECT 되는 조회결과를 테이블처럼 사용 
					ex)  SELECT 컬럼,컬럼 
						  FROM (
						  	서브쿼리 
						  ) 별칭 
*/
drop table player;
create table player(
 no number primary key,
 title varchar2(100) not null,
 singer varchar2(30) not null,
 price number not null
)

select * from player;

create sequence mp3_seq;

insert into player(no,title,singer,price) values(mp3_seq.nextval,'잊어야 한다는 마음으로','아이유',700);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'사람','지코',1000);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'밤편지','아이유',1000);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'도망가자','선우정아',1000);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'그날','박효신',1000);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'좋은밤 좋은꿈','너드커넥션',500);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'사계','태연',600);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'제발','이소라',1000);
commit
select count(*) from player;


-- 내림차순 정렬 
select * from player order by no desc;

delete from player where no=7;

-- row_number() over(정렬) 
select row_number() over(order by no desc) as rnum,no,title from player;
-- rnum이 3 이하인 곡들을 조회 --> error  조회된 결과에 대해 행번호(row number)를 부여하기 때문 
select row_number() over(order by no desc) as rnum,no,title from player where rnum<=3;

--  Inline View(From 절에 사용되는 Subquery)를 사용하면 된다 
select rnum,no,title
from (
	select row_number() over(order by no desc) as rnum,no,title from player
) where rnum<=3;

-- 1 page에서 3곡을 보여주려고 하고 2page에 해당하는 3곡을 보여주기 위해 rnum 이 4 이상 6 이하인 곡을 조회 
select rnum,no,title
from (
	select row_number() over(order by no desc) as rnum,no,title from player
) where rnum>=4 and rnum<=6;
-- between 으로 표현 가능 
select rnum,no,title
from (
	select row_number() over(order by no desc) as rnum,no,title from player
) where rnum  between 4 and 6;












