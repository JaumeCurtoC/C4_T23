
DROP TABLE IF EXISTS empleado;

create table empleado(
	id int auto_increment,
    nombre varchar(250),
    trabajo ENUM('PROGRAMADOR', 'DISEÑADOR', 'ASISTENTE'),
    salario double
);

insert into empleado (nombre, trabajo, salario) 
values ('Jaume', 'PROGRAMADOR',2200.0);
insert into empleado (nombre, trabajo, salario) 
values ('Pedro', 'DISEÑADOR',2100.0);
insert into empleado (nombre, trabajo, salario) 
values ('Mario', 'ASISTENTE',1500.0);