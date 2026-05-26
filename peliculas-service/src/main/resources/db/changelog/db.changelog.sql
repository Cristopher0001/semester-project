-- liquibase formatted sql

-- changeset cristopher:1
CREATE TABLE pelicula (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255),
    descripcion VARCHAR(255),
    duracion INT,
    genero VARCHAR(255),
    clasificacion VARCHAR(255)
);

-- changeset cristopher:2
INSERT INTO pelicula (titulo, descripcion, duracion, genero, clasificacion) VALUES
('El Padrino', 'Historia de una poderosa familia mafiosa italiana.', 175, 'Drama', 'R'),
('Interestelar', 'Un grupo de astronautas viaja por un agujero de gusano.', 169, 'Ciencia Ficcion', 'PG-13'),
('Titanic', 'Romance y tragedia a bordo del famoso transatlantico.', 195, 'Romance', 'PG-13'),
('Avengers: Endgame', 'Los heroes intentan revertir el caos causado por Thanos.', 181, 'Accion', 'PG-13'),
('Toy Story', 'Juguetes cobran vida cuando los humanos no estan presentes.', 81, 'Animacion', 'G'),
('El Conjuro', 'Una familia experimenta sucesos paranormales aterradores.', 112, 'Terror', 'R'),
('Gladiador', 'Un general romano busca venganza tras ser traicionado.', 155, 'Accion', 'R'),
('La La Land', 'Dos artistas persiguen sus sueños en Los Angeles.', 128, 'Musical', 'PG-13'),
('Parasitos', 'Dos familias de clases sociales opuestas se entrelazan.', 132, 'Suspenso', 'R'),
('Spider-Man: No Way Home', 'Peter Parker enfrenta villanos de otros universos.', 148, 'Superheroes', 'PG-13');