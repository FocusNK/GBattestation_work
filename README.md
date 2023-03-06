## Информация о проекте
Решение заданий для промежуточной аттестации.

## Задание
1. Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).
![Task 1](https://i.ibb.co/w0GryMx/task1.png)
2. Создать директорию, переместить файл туда.
![Task 2](https://i.ibb.co/TtF2X7L/task2.png)
3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория.
4. Установить и удалить deb-пакет с помощью dpkg.
5. Выложить историю команд в терминале ubuntu
![Task 3,4,5](https://i.ibb.co/TbJRMXr/task3.png)
6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы).
![Task 6](https://i.ibb.co/3yv3qD9/task4.png)
7. В подключенном MySQL репозитории создать базу данных “Друзья
человека”
```sql
CREATE DATABASE man_friends;
```

8. Создать таблицы с иерархией из диаграммы в БД
```sql
USE man_friends;
CREATE TABLE animal_class
(
	Id INT AUTO_INCREMENT PRIMARY KEY, 
	Class_name VARCHAR(30)
);

INSERT INTO animal_class (Class_name)
VALUES ('beasts_of_burden'),
('home_pets');  


CREATE TABLE beasts_of_burden
(
	  Id INT AUTO_INCREMENT PRIMARY KEY,
    Genus_name VARCHAR (30),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animal_class (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO beasts_of_burden (Genus_name, Class_id)
VALUES ('horse', 1),
('camels', 1),  
('donkeys', 1); 
    
CREATE TABLE home_pets
(
	  Id INT AUTO_INCREMENT PRIMARY KEY,
    Genus_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animal_class (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO home_pets (Genus_name, Class_id)
VALUES ('dogs', 2),
('cats', 2),  
('hamster', 2); 

CREATE TABLE cats 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES home_pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
```
9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения
```sql
INSERT INTO cats (Name, Birthday, Commands, Genus_id)
VALUES ('Басти', '2017-03-11', 'кис-кис', 1),
('Василиса', '2022-07-10', "Фу", 1),  
('Гека', '2011-09-02', "Кушать", 1); 

CREATE TABLE dogs 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES home_pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO dogs (Name, Birthday, Commands, Genus_id)
VALUES ('Шарик', '2019-12-23', 'голос, фас, лапу', 2),
('Барбос', '2021-03-12', "сидеть, лежать, фу", 2),  
('Цезарь', '2018-05-03', "сидеть, место, лапу", 2), 
('Терминатор', '2012-10-02', "сидеть, лежать, фу, место", 2);

CREATE TABLE hamsters 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES home_pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO hamsters (Name, Birthday, Commands, Genus_id)
VALUES ('Кощей', '2022-10-12', 'кушать', 3),
('Маша', '2021-03-12', "внезапно умирать", 3),  
('Теди', '2022-07-11', "теряться", 3), 
('Стерик', '2022-05-10', NULL, 3);

CREATE TABLE horses 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES beasts_of_burden (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO horses (Name, Birthday, Commands, Genus_id)
VALUES ('Перри', '2016-02-12', 'щипать траву, пастись', 1),
('Молния', '2011-03-12', "бегом, щипать траву, размножаться", 1),  
('Честер', '2012-07-12', NULL, 1), 
('Мила', '2020-11-10', "бегом, шагом, хоп", 1);

CREATE TABLE donkeys 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES beasts_of_burden (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO donkeys (Name, Birthday, Commands, Genus_id)
VALUES ('Иа', '2019-04-10', NULL, 2),
('Ослик', '2020-03-12', "ходить за морковкой", 2),  
('Не придумал', '2021-07-12', "", 2), 
('Бррр', '2022-12-10', NULL, 2);

CREATE TABLE camels 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES beasts_of_burden (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO camels (Name, Birthday, Commands, Genus_id)
VALUES ('Шах', '2012-02-10', 'вернись', 3),
('Камел', '2019-03-11', "остановись", 3),  
('Ара', '2015-07-02', "повернись", 3), 
('Гордый', '2013-12-10', "улыбнись", 3);
```

10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
```sql
SET SQL_SAFE_UPDATES = 0;
DELETE FROM camels;

SELECT Name, Birthday, Commands FROM horses
UNION SELECT  Name, Birthday, Commands FROM donkeys;
```

11. Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице
```sql
CREATE TEMPORARY TABLE animals AS 
SELECT *, 'horses' as genus FROM horses
UNION SELECT *, 'donkeys' AS genus FROM donkeys
UNION SELECT *, 'dogs' AS genus FROM dogs
UNION SELECT *, 'cats' AS genus FROM cats
UNION SELECT *, 'hamsters' AS genus FROM hamsters;

CREATE TABLE yong_animal AS
SELECT Name, Birthday, Commands, genus, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS Age_in_month
FROM animals WHERE Birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);
 
SELECT * FROM y0ng_animal;
```
12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.
```sql
SELECT h.Name, h.Birthday, h.Commands, pa.Genus_name, ya.Age_in_month 
FROM horses h
LEFT JOIN yong_animal ya ON ya.Name = h.Name
LEFT JOIN beasts_of_burden pa ON pa.Id = h.Genus_id
UNION 
SELECT d.Name, d.Birthday, d.Commands, pa.Genus_name, ya.Age_in_month 
FROM donkeys d 
LEFT JOIN yong_animal ya ON ya.Name = d.Name
LEFT JOIN beasts_of_burden pa ON pa.Id = d.Genus_id
UNION
SELECT c.Name, c.Birthday, c.Commands, ha.Genus_name, ya.Age_in_month 
FROM cats c
LEFT JOIN yong_animal ya ON ya.Name = c.Name
LEFT JOIN home_pets ha ON ha.Id = c.Genus_id
UNION
SELECT d.Name, d.Birthday, d.Commands, ha.Genus_name, ya.Age_in_month 
FROM dogs d
LEFT JOIN yong_animal ya ON ya.Name = d.Name
LEFT JOIN home_pets ha ON ha.Id = d.Genus_id
UNION
SELECT hm.Name, hm.Birthday, hm.Commands, ha.Genus_name, ya.Age_in_month 
FROM hamsters hm
LEFT JOIN yong_animal ya ON ya.Name = hm.Name
LEFT JOIN home_pets ha ON ha.Id = hm.Genus_id;
```

13. Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
14. Написать программу, имитирующую работу реестра домашних животных.
В программе должен быть реализован следующий функционал:
14.1 Завести новое животное
14.2 определять животное в правильный класс
14.3 увидеть список команд, которое выполняет животное
14.4 обучить животное новым командам
14.5 Реализовать навигацию по меню
15. Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆
значение внутренней̆ int переменной̆ на 1 при нажатии “Завести новое
животное” Сделайте так, чтобы с объектом такого типа можно было работать в
блоке try-with-resources. Нужно бросить исключение, если работа с объектом
типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
считать в ресурсе try, если при заведении животного заполнены все поля.