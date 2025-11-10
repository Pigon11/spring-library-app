-- Создаем таблицу команд
CREATE TABLE IF NOT EXISTS team (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    city VARCHAR(255),
    stadium VARCHAR(255),
    coach VARCHAR(255)
);

-- Создаем таблицу игроков
CREATE TABLE IF NOT EXISTS player (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    position VARCHAR(255),
    jersey_number INT,
    team_id BIGINT,
    FOREIGN KEY (team_id) REFERENCES team(id)
);

-- Добавляем тестовые данные - команды РПЛ
INSERT INTO team (name, city, stadium, coach) VALUES
('Зенит', 'Санкт-Петербург', 'Газпром Арена', 'Сергей Семак'),
('Спартак', 'Москва', 'Открытие Банк Арена', 'Деян Станкович'),
('ЦСКА', 'Москва', 'ВЭБ Арена', 'Фабио Челестини');

-- Добавляем тестовых игроков
INSERT INTO player (name, position, jersey_number, team_id) VALUES
('Александр Соболев', 'Нападающий', 22, 1),
('Луиз Энрике', 'Нападающий', 10, 1),
('Вилиан Барриос', 'Защитник', 3, 1),
('Леонель Месси', 'Нападающий', 7, 2),
('Квинси Промес', 'Нападающий', 10, 2),
('Егор Селезнев', 'Нападающий', 9, 3);