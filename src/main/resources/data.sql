SET SCHEMA my_save;

DROP TABLE IF EXISTS save;
CREATE TABLE save(
    id INT PRIMARY KEY,
    arquivo BLOB,
    usuario_nome VARCHAR(255),
    data_criacao DATE,
    nome_jogo VARCHAR(255),
    emulador VARCHAR(255)
);

INSERT INTO save (id, arquivo, usuario_nome, data_criacao, nome_jogo, emulador) VALUES (2, null, 'Usuario Nome 2', '1990-05-15', 'Super Mario World', 'SNES');

INSERT INTO save (id, arquivo, usuario_nome, data_criacao, nome_jogo, emulador) VALUES (3, null, 'Usuario Nome 3', '1995-11-22', 'The Legend of Zelda: Ocarina of Time', 'Nintendo 64');

INSERT INTO save (id, arquivo, usuario_nome, data_criacao, nome_jogo, emulador) VALUES (4, null, 'Usuario Nome 4', '2002-09-03', 'Grand Theft Auto: Vice City', 'PlayStation 2');

INSERT INTO save (id, arquivo, usuario_nome, data_criacao, nome_jogo, emulador) VALUES (5, null, 'Usuario Nome 5', '2007-03-12', 'The Elder Scrolls IV: Oblivion', 'Xbox 360');

INSERT INTO save (id, arquivo, usuario_nome, data_criacao, nome_jogo, emulador) VALUES (6, null, 'Usuario Nome 6', '2010-10-24', 'Red Dead Redemption', 'PlayStation 3');

INSERT INTO save (id, arquivo, usuario_nome, data_criacao, nome_jogo, emulador) VALUES (7, null, 'Usuario Nome 7', '2013-05-07', 'The Last of Us', 'PlayStation 3');

INSERT INTO save (id, arquivo, usuario_nome, data_criacao, nome_jogo, emulador) VALUES (8, null, 'Usuario Nome 8', '2015-09-22', 'The Witcher 3: Wild Hunt', 'PC');

INSERT INTO save (id, arquivo, usuario_nome, data_criacao, nome_jogo, emulador) VALUES (9, null, 'Usuario Nome 9', '2018-02-18', 'God of War', 'PlayStation 4');

INSERT INTO save (id, arquivo, usuario_nome, data_criacao, nome_jogo, emulador) VALUES (10, null, 'Usuario Nome 10', '2021-11-30', 'The Legend of Zelda: Breath of the Wild', 'Nintendo Switch');

INSERT INTO save (id, arquivo, usuario_nome, data_criacao, nome_jogo, emulador) VALUES (11, null, 'Usuario Nome 11', '2024-04-29', 'Elden Ring', 'PlayStation 5');