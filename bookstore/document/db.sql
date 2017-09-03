��ƷID 	��Ʒ���� 	��Ʒ��� 	��λ���� 	����
create table t_books(
	id number(18) primary key,  --��ƷID 
	title varchar2(32 char) not null, --��Ʒ����
	catalog_id number(18) not null, -- ��������ţ��������Ҫ�����������������ԡ�
	foreign key(catalog_id) references t_catalogs(id) on delete cascade, -- ����ɾ��
	unit varchar2(3 char) default '��', --��Ʒ��λ
	price number(8,2) default 0.0, -- ����
	pic varchar2(50) default 'images/nopic.jpg'  -- �鼮����
);
create sequence seq_books start with 1 maxvalue 999999999999999999;

insert into t_books(id,title,catalog_id) values(seq_books.nextval,'Java���˼��','2');
insert into t_books(id,title,catalog_id) values(seq_books.nextval,'PHP���˼��','2');
insert into t_books(id,title,catalog_id) values(seq_books.nextval,'C++���˼��','2');
insert into t_books(id,title,catalog_id) values(seq_books.nextval,'���˼�����ʷ','5');
insert into t_books(id,title,catalog_id) values(seq_books.nextval,'���˼�����ʷ','5');
insert into t_books(id,title,catalog_id) values(seq_books.nextval,'κ��˼�����ʷ','5');
insert into t_books(id,title,catalog_id) values(seq_books.nextval,'�ع�˼�����ʷ','5');
insert into t_books(id,title,catalog_id) values(seq_books.nextval,'����','4');
insert into t_books(id,title,catalog_id) values(seq_books.nextval,'���','4');
insert into t_books(id,title,catalog_id) values(seq_books.nextval,'���','4');

create table t_catalogs(
	id number(18) primary key,  --����� 
	title varchar2(32 char) not null --��Ʒ����
);

create sequence seq_catalogs start with 1 maxvalue 999999999999999999;

insert into t_catalogs values(seq_catalogs.nextval,'�����ͼ��');
insert into t_catalogs values(seq_catalogs.nextval,'��ѧͼ��');
insert into t_catalogs values(seq_catalogs.nextval,'���ͼ��');
insert into t_catalogs values(seq_catalogs.nextval,'��ʷͼ��');


create table t_users(
	id number(18) primary key,
	username varchar2(20 char) not null unique,  --unique Ψһ��Լ��
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

//������
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

