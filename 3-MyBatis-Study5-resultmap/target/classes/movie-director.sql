drop table movie;
drop table director;

drop table director;
create table director(
	director_id number primary key,
	director_name varchar2(100) not null,
	intro varchar2(100) not null
)
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
create sequence movie_seq;

select * from movie;


--movie 와 director inner join (title, director_name)
SELECT m.title,d.director_name 
FROM director d, movie m
WHERE d.director_id=m.director_id

--movie 와 director outer join
SELECT m.title,d.director_name 
FROM director d, movie m
WHERE m.director_id(+)=d.director_id

--movie id가 1인 영화의 모든 정보와 감독의 모든 정보를 조회
SELECT m.move_id,m.title,m.attendance, d.director_id d.director_name,d.intro
FROM movie m, director d
WHERE m.director_id= d.director_id
AND m.movie_id=1;

SELECT title, genre, attendance, director_id,directroe_name,intro
FROM 











