CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT,
    fecha_creacion DATETIME,
    activo BOOLEAN DEFAULT TRUE,
    status ENUM('NUEVO', 'ACTUALIZADO', 'ESPERA', 'CUMPLIDO','INACTIVO') NOT NULL,
    id_curso BIGINT,
    id_usuario BIGINT NOT NULL,
    FOREIGN KEY (id_curso) REFERENCES cursos(id) ON DELETE SET NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id) ON DELETE CASCADE
)