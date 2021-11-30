drop table movie;
drop table director;

create table director(
	director_id number primary key,
	director_name varchar2(100) not null,
	intro varchar2(100) not null
)
drop sequence director_seq;
create sequence director_seq;

select * from director;


drop table movie;

create table movie(
	movie_id number primary key,
	title varchar2(100) not null,
	genre varchar2(100) not null,
	attendance number default 0,
	director_id number not null
	constraint fk_spring_director_id references director(director_id)
)
drop sequence movie_seq;
create sequence movie_seq;

select * from movie;
select * from director;
-- movie 와 director  inner join ( title, director_name )

select m.title,d.director_name
from movie m,director d
where m.director_id=d.director_id

-- outer join 
select m.title,d.director_name
from movie m,director d
where m.director_id(+)=d.director_id

-- movie_id 가 1 인 영화의 모든 정보와 감독의 모든 정보를 조회 
select m.movie_id,m.title,m.genre,m.attendance,d.director_id,d.director_name,d.intro
from movie m,director d
where m.director_id=d.director_id
and m.movie_id=1;







