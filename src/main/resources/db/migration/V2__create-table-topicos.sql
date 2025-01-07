
create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(100) not null,
    fecha_creacion date,
    status varchar(100) not null,
    curso varchar(100) not null,
    respuesta varchar(100),
    usuario_id bigint not null,

    primary key(id),
    CONSTRAINT fk_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
)