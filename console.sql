
create database moviedb;
use moviedb;

-- auto-generated definition
create table zipcode
(
    id      int auto_increment
        primary key,
    zipcode varchar(20) null
);

insert  into zipcode(id, zipcode) VALUES
(1,'75075'),
(2,'75040'),
(3,'75080');
-- auto-generated definition
create table theater
(
    id            int auto_increment
        primary key,
    theater_name  varchar(100) null,
    zipcode_id_fk int          null,
    constraint FK_THEATER_ON_ZIPCODE_ID_FK
        foreign key (zipcode_id_fk) references zipcode (id)
);

insert into theater(id, theater_name, zipcode_id_fk) VALUES
                                                         (1,'Cinemark Central ',1),
                                                         (2,'AMC Firewheel 18 ',1),
                                                         (3,'Alamo Drafthouse Cinema ',1),
                                                         (4,'Turner Cinema',2),
                                                         (5,'Cinemark Music City Mall and XD',2),
                                                         (6,'BlanketTop Theater',2),
                                                         (7,'Moviehouse',3),
                                                         (8,'Firewheel Cinema',3),
                                                         (9,'Cinemark Cinema',3);



-- auto-generated definition
create table movie
(
    id            int auto_increment
        primary key,
    name          varchar(50)   null,
    description   varchar(1000) null,
    time_period   varchar(50)   null,
    theater_id_fk int           null,
    constraint FK_MOVIE_ON_THEATER_FKEY
        foreign key (theater_id_fk) references theater (id)
);

insert into movie (id, name, description, time_period, theater_id_fk) VALUES
(1, 'Thor: Love And Thunder', ' LOVE AND THUNDER finds Thor (Chris Hemsworth) on a journey unlike anything he’s ever faced – a quest for inner peace. ', '1HR59MIN', 1),
(2, 'Minions: The Rise Of Gru', ' Comes the untold story of one 12-year-old’s dream to become the world’s greatest supervillain, in Minions: The Rise of Gru.', '1HR27MIN', 1),
(3, 'Top Gun: Maverick', 'Maverick is drawn into a confrontation with his own deepest fears, culminating in a mission that demands the ultimate sacrifice from those who will be chosen to fly it.', '2HR11MIN', 1),
(4, 'Thor: Love And Thunder', ' LOVE AND THUNDER finds Thor (Chris Hemsworth) on a journey unlike anything he’s ever faced – a quest for inner peace. ', '1HR59MIN', 2),
(5, 'Minions: The Rise Of Gru', ' Comes the untold story of one 12-year-old’s dream to become the world’s greatest supervillain, in Minions: The Rise of Gru.', '1HR27MIN', 2),
(6, 'Top Gun: Maverick', 'Maverick is drawn into a confrontation with his own deepest fears, culminating in a mission that demands the ultimate sacrifice from those who will be chosen to fly it.', '2HR11MIN', 2),
(7, 'Thor: Love And Thunder', ' LOVE AND THUNDER finds Thor (Chris Hemsworth) on a journey unlike anything he’s ever faced – a quest for inner peace. ', '1HR59MIN', 3),
(8, 'Minions: The Rise Of Gru', ' Comes the untold story of one 12-year-old’s dream to become the world’s greatest supervillain, in Minions: The Rise of Gru.', '1HR27MIN', 3),
(9, 'Top Gun: Maverick', 'Maverick is drawn into a confrontation with his own deepest fears, culminating in a mission that demands the ultimate sacrifice from those who will be chosen to fly it.', '2HR11MIN', 3),
(10,'Thor: Love And Thunder',' LOVE AND THUNDER finds Thor (Chris Hemsworth) on a journey unlike anything he’s ever faced – a quest for inner peace. ','1HR59MIN',4),
(11,'Minions: The Rise Of Gru',' Comes the untold story of one 12-year-old’s dream to become the world’s greatest supervillain, in Minions: The Rise of Gru.','1HR27MIN',4),
(12,'Top Gun: Maverick','Maverick is drawn into a confrontation with his own deepest fears, culminating in a mission that demands the ultimate sacrifice from those who will be chosen to fly it.','2HR11MIN',4),
(13,'Thor: Love And Thunder',' LOVE AND THUNDER finds Thor (Chris Hemsworth) on a journey unlike anything he’s ever faced – a quest for inner peace. ','1HR59MIN',5),
(14,'Minions: The Rise Of Gru',' Comes the untold story of one 12-year-old’s dream to become the world’s greatest supervillain, in Minions: The Rise of Gru.','1HR27MIN',5),
(15,'Top Gun: Maverick','Maverick is drawn into a confrontation with his own deepest fears, culminating in a mission that demands the ultimate sacrifice from those who will be chosen to fly it.','2HR11MIN',5),
(16,'Thor: Love And Thunder',' LOVE AND THUNDER finds Thor (Chris Hemsworth) on a journey unlike anything he’s ever faced – a quest for inner peace. ','1HR59MIN',6),
(17,'Minions: The Rise Of Gru',' Comes the untold story of one 12-year-old’s dream to become the world’s greatest supervillain, in Minions: The Rise of Gru.','1HR27MIN',6),
(18,'Top Gun: Maverick','Maverick is drawn into a confrontation with his own deepest fears, culminating in a mission that demands the ultimate sacrifice from those who will be chosen to fly it.','2HR11MIN',6),
(19,'Thor: Love And Thunder',' LOVE AND THUNDER finds Thor (Chris Hemsworth) on a journey unlike anything he’s ever faced – a quest for inner peace. ','1HR59MIN',7),
(20,'Minions: The Rise Of Gru',' Comes the untold story of one 12-year-old’s dream to become the world’s greatest supervillain, in Minions: The Rise of Gru.','1HR27MIN',7),
(21,'Top Gun: Maverick','Maverick is drawn into a confrontation with his own deepest fears, culminating in a mission that demands the ultimate sacrifice from those who will be chosen to fly it.','2HR11MIN',7),
(22,'Thor: Love And Thunder2',' LOVE AND THUNDER finds Thor (Chris Hemsworth) on a journey unlike anything he’s ever faced – a quest for inner peace. ','1HR59MIN',8),
(23,'Minions: The Rise Of Gru',' Comes the untold story of one 12-year-old’s dream to become the world’s greatest supervillain, in Minions: The Rise of Gru.','1HR27MIN',8),
(24,'Top Gun: Maverick','Maverick is drawn into a confrontation with his own deepest fears, culminating in a mission that demands the ultimate sacrifice from those who will be chosen to fly it.','2HR11MIN',8),
(25,'Thor: Love And Thunder',' LOVE AND THUNDER finds Thor (Chris Hemsworth) on a journey unlike anything he’s ever faced – a quest for inner peace. ','1HR59MIN',9),
(26,'Minions: The Rise Of Gru',' Comes the untold story of one 12-year-old’s dream to become the world’s greatest supervillain, in Minions: The Rise of Gru.','1HR27MIN',9),
(27,'Top Gun: Maverick','Maverick is drawn into a confrontation with his own deepest fears, culminating in a mission that demands the ultimate sacrifice from those who will be chosen to fly it.','2HR11MIN',9);
