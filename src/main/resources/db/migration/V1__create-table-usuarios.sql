create table usuarios(

	id bigint not null auto_increment,
	nombre varchar(100) not null,
	email varchar(100) not null,
	contrasena varchar(100) not null,
	activo boolean,
	perfil varchar(100),
	topico varchar(100),
    respuesta varchar(100),

	primary key(id)
)