--liquibase formatted sql

--changeset seba:1
CREATE TABLE sala (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    capacidad INT,
    tipo VARCHAR(255),
    cine_id BIGINT
);

--changeset seba:2
INSERT INTO sala (nombre, capacidad, tipo, cine_id) VALUES
('Sala 1', 80, '2D', 1),
('Sala 2', 120, '3D', 1),
('Sala VIP', 50, 'VIP', 1),
('Sala IMAX', 200, 'IMAX', 2),
('Sala 5', 90, '2D', 2),
('Sala Premium', 70, 'VIP', 2),
('Sala 7', 100, '3D', 3),
('Sala XD', 150, 'XD', 3),
('Sala Familiar', 60, '2D', 4),
('Sala Ultra', 180, 'IMAX', 5);