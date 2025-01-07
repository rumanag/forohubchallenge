create table usuarios(

	id bigint not null auto_increment,
	nombre varchar(100) not null,
	correo_electronico varchar(100) not null,
	contrasena varchar(100) not null,
	perfil varchar (50),

	 primary key(id)
)