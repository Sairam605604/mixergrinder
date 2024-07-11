create table mixergrinder
(
	id int auto_increment primary key,
	name varchar(20) NOT NULL,
	colour varchar(20) NOT NULL,
	price bigint(10) NOT NULL6
);

alter table mixergrinder auto_increment=1001;

insert into mixergrinder(name, colour, price) values('Pigeon', 'Red', 12000);
insert into mixergrinder(name, colour, price) values('Prestige', 'Blue',12500);

