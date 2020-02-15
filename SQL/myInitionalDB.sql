CREATE TABLE IF NOT EXISTS automobile
(
    id          BIGSERIAL       PRIMARY KEY,
    name        VARCHAR(100)    NOT NULL,
    brand       VARCHAR(100)    NOT NULL,
    cost        DECIMAL         NOT NULL,
    photo       VARCHAR(200)    DEFAULT NULL,
    description VARCHAR(10000)  DEFAULT NULL
);
CREATE TABLE IF NOT EXISTS users
(
    id      BIGSERIAL   PRIMARY KEY,
    name    VARCHAR(100)    NOT null,
    pswd    VARCHAR(100)    NOT null
);

insert into users VALUES (DEFAULT, 'guest', '$2a$10$UtAu1sHyr6rhzaibfzPd7OwclzOIwc8UxSXjxyIWWLy6p1LNjL9sy');
GRANT ALL PRIVILEGES ON DATABASE gleba TO gleb;
INSERT INTO automobile VALUES (DEFAULT, 'Defender', 'Land Rover', '2000000', null, null);
INSERT INTO automobile VALUES (DEFAULT, 'Discovery', 'Land Rover', '580000', null, null);
INSERT INTO automobile VALUES (DEFAULT, 'Freelander', 'Land Rover', '1325000', null, null);
INSERT INTO automobile VALUES (DEFAULT, 'Citan', 'Mercedes-Benz', '800000', null, null);
INSERT INTO automobile VALUES (DEFAULT, 'Ceed', 'Kia', '735000', null, null);
INSERT INTO automobile VALUES (DEFAULT, 'ASX', 'Mitsubishi', '559999', null, null);
INSERT INTO automobile VALUES (DEFAULT, 'Eclipse', 'Mitsubishi', '270000', null, null);
INSERT INTO automobile VALUES (DEFAULT, 'Cube', 'Nissan', '329000', null, null);
INSERT INTO automobile VALUES (DEFAULT, 'Edge', 'Ford', '899000', null, null);
INSERT INTO automobile VALUES (DEFAULT, 'A5', 'Audi', '680000', null, null);
