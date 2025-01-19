CREATE TABLE respuestas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME,
    solucion VARCHAR(255),
    activo BOOLEAN DEFAULT TRUE,
    id_usuario BIGINT,
    id_topico BIGINT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id) ON DELETE SET NULL,
    FOREIGN KEY (id_topico) REFERENCES topicos(id) ON DELETE CASCADE
)