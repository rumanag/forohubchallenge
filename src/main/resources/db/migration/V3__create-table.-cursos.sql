create table cursos(

	id bigint not null auto_increment,
	nombre_curso varchar(100) not null,
	categoria varchar(50),
	activo boolean,
	id_topico varchar(100),

	primary key(id)
)