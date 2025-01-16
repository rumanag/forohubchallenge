create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(100) not null,
    fecha_creacion date not null,
    activo boolean,
    status varchar(100) not null,
    curso varchar(100) not null,
    usuario varchar(100) not null,
    id_respuesta bigint,

    primary key(id),
    CONSTRAINT fk_respuesta FOREIGN KEY (id_respuesta) REFERENCES respuestas(id)

)