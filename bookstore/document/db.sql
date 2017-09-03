商品ID 	商品名称 	商品类别 	单位数量 	单价
create table t_books(
	id number(18) primary key,  --商品ID 
	title varchar2(32 char) not null, --商品名称
	catalog_id number(18) not null, -- 所属类别编号，外键，需要参照类别表【参照完整性】
	foreign key(catalog_id) references t_catalogs(id) on delete cascade, -- 级联删除
	unit varchar2(3 char) default '本', --商品单位
	price number(8,2) default 0.0, -- 单价
	pic varchar2(50) default 'images/nopic.jpg'  -- 书籍封面
);
create sequence seq_books start with 1 maxvalue 999999999999999999;

insert into t_books(id,title,catalog_id) values(seq_books.nextval,'Java编程思想','2');
insert into t_books(id,title,catalog_id) values(seq_books.nextval,'PHP编程思想','2');
insert into t_books(id,title,catalog_id) values(seq_books.nextval,'C++编程思想','2');
insert into t_books(id,title,catalog_id) values(seq_books.nextval,'蜀国思想家历史','5');
insert into t_books(id,title,catalog_id) values(seq_books.nextval,'吴国思想家历史','5');
insert into t_books(id,title,catalog_id) values(seq_books.nextval,'魏国思想家历史','5');
insert into t_books(id,title,catalog_id) values(seq_books.nextval,'秦国思想家历史','5');
insert into t_books(id,title,catalog_id) values(seq_books.nextval,'川菜','4');
insert into t_books(id,title,catalog_id) values(seq_books.nextval,'湘菜','4');
insert into t_books(id,title,catalog_id) values(seq_books.nextval,'浙菜','4');

create table t_catalogs(
	id number(18) primary key,  --类别编号 
	title varchar2(32 char) not null --商品名称
);

create sequence seq_catalogs start with 1 maxvalue 999999999999999999;

insert into t_catalogs values(seq_catalogs.nextval,'计算机图书');
insert into t_catalogs values(seq_catalogs.nextval,'文学图书');
insert into t_catalogs values(seq_catalogs.nextval,'烹饪图书');
insert into t_catalogs values(seq_catalogs.nextval,'历史图书');


create table t_users(
	id number(18) primary key,
	username varchar2(20 char) not null unique,  --unique 唯一性约束
	password varchar2(20) not null,
	realname varchar2(10 char) not null,
	sex number(1) default 1,
	addr varchar2(50 char) not null,
	postcode char(6),
	tel varchar2(12) not null,
	email varchar2(32),
	locked number(1) default 0
);

create sequence seq_users start with 1 maxvalue 999999999999999999;

//订单表
create table t_order(
	id number(18) primary key,
	user_id number(18) not null,
	foreign key(user_id) references t_users(id) on delete cascade,
	realname varchar2(10 char) not null,
	tel varchar2(12) not null,
	addr varchar(50 char) not null,
	email varchar2(50),
	postcode char(6),
	all_price number(8,2) default 0.0,
	odate date default sysdate
);

create table t_items(
	id  number(18) primary key,
	order_id number(18) not null,
	foreign key(order_id) references t_order(id) on delete cascade,
	book_id number(18) not null,
	foreign key(book_id) references t_books(id) on delete cascade,
	price number(8,2),
	num number(6)
);

create sequence seq_order start with 1 maxvalue 999999999999999999;
create sequence seq_item start with 1 maxvalue 999999999999999999;

