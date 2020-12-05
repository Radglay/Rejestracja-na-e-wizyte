CREATE TABLE POST (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(400) NOT NULL,
    content VARCHAR(2000) NULL
);

CREATE TABLE USER (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    imie VARCHAR(100) NOT NULL,
    nazwisko VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    haslo VARCHAR(50) NOT NULL,
    pesel VARCHAR(11) NOT NULL,
    telefon VARCHAR(9) NOT NULL,
    typ ENUM('klient', 'lekarz', 'administrator') --tylko jedna z tych
);

CREATE TABLE LEKARZ( --rozszerza uzytkownika
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    specjalizacja TEXT(100) NOT NULL,
    FOREIGN KEY(user_id) REFERENCES user(id)

);

CREATE TABLE ADMINISTRATOR(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL UNIQUE,
    FOREIGN KEY(user_id) REFERENCES user(id)
);


CREATE TABLE SKIEROWANIE (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    lekarz_id BIGINT NOT NULL,
    typ_lekarza VARCHAR(50) NOT NULL,
    FOREIGN KEY(user_id) REFERENCES user(id),
    FOREIGN KEY (lekarz_id) REFERENCES lekarz(id)
);

CREATE TABLE RECEPTA(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    lekarz_id BIGINT NOT NULL,
    notatka TEXT(300) NOT NULL,
    FOREIGN KEY(user_id) REFERENCES user(id),
    FOREIGN KEY (lekarz_id) REFERENCES lekarz(id)
);

