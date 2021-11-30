/*
	복합키 : 두 개 이상의 컬럼을 이용해 식별자(pk)를 만드는 것을 말한다   
 */
create table shares(
	customer_id varchar2(100),
	stock_id varchar2(100),
	quantity number not null,
	constraint pk_shares primary key(customer_id,stock_id)
)
insert into shares(customer_id,stock_id,quantity) values('java','삼성',10);
insert into shares(customer_id,stock_id,quantity) values('spring','삼성',5);
insert into shares(customer_id,stock_id,quantity) values('java','LG',20);
-- 복합키의 제약조건에 위배되므로 ERROR ( customer_id 와 stock_id의 조합된 정보가 유일해야 하는 조건이므로 ) 
insert into shares(customer_id,stock_id,quantity) values('java','삼성',5);
-- 위의 insert가 아니라 update quantity가 되어야 한다 
update shares set quantity=quantity+5 where customer_id='java' and stock_id='삼성';

select * from shares;



