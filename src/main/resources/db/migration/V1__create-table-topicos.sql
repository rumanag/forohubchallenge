
create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(100) not null,
    fecha_creacion date,
    curso varchar(100) not null,
    respuesta varchar(100),
    usuario varchar (100) not null,

    primary key(id)
)