create table respuestas(

	id bigint not null auto_increment,
	mensaje varchar(100) not null,
	fecha_creacion DATE,
	solucion varchar(200) not null,
	activo boolean,
	usuario varchar(100),
	topico varchar(100),

	primary key(id)
    )