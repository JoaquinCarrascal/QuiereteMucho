insert into product (id, name, description, avg_duration, base_price , product_type , desc_img) values (1, 'Mechas californianas', 'Inspiradas en las surfistas de las playas de California, pretenden emular el efecto que la constante exposición al sol dejaba sobre su pelo.', 60,35,'PELUQUERIA' , 'https://i.imgur.com/3tZkQxM.jpeg');
insert into product (id, name, description, avg_duration, base_price , product_type , desc_img) values (2, 'Tinte mujer', 'Tinte para mujer + tratamiento suavizante, el color elegido es ajeno al precio.', 45 , 28 ,'PELUQUERIA' , 'https://i.imgur.com/Pde5TXa.jpeg');
insert into product (id, name, description, avg_duration, base_price , product_type , desc_img) values (3, 'Manicura francesa', 'Un clásico de la belleza que nunca pasa de moda, además incluye tratamiento de la cutícula.', 25 ,15.5,'ESTETICA' , 'https://i.imgur.com/IalSjXO.jpeg');
insert into product (id, name, description, avg_duration, base_price , product_type , desc_img) values (4, 'Manicura de porcelana', 'Tratamiento hidratante sobre la uña + manicura de polvo de porcelana de la máxima calidad.', 30 ,18 ,'ESTETICA' , 'https://i.imgur.com/RAb71tI.jpeg');

ALTER SEQUENCE product_seq RESTART WITH 54;

insert into alert (id, description , name , active) values (1, 'Cierra los ojos y piensa en algo bonito... , quiérete como nadie, Quiérete Mucho.' , 'Alerta por defecto' , true);

ALTER SEQUENCE alert_seq RESTART WITH 51;

insert into clientuser (id, username, user_last_name, email, tel_number, password, address, points) values (1, 'Mireille', 'Munning', 'mmunning0@barnesandnoble.com', '6451632768', 'Mireille6', '22 Lakewood Gardens Terrace', 912);
insert into clientuser (id, username, user_last_name, email, tel_number, password, address, points) values (2, 'Hube', 'Fedder', 'hfedder1@princeton.edu', '3565879596', 'Hube3', null, 875);
insert into clientuser (id, username, user_last_name, email, tel_number, password, address, points) values (3, 'Lucienne', 'Ormerod', 'lormerod2@amazonaws.com', '4582462801', 'Lucienne4', '658 Menomonie Plaza', 1015);
insert into clientuser (id, username, user_last_name, email, tel_number, password, address, points) values (4, 'Joshuah', 'Stretton', 'jstretton3@so-net.ne.jp', '2057056583', 'Joshuah2', '3 Fulton Trail', 830);
insert into clientuser (id, username, user_last_name, email, tel_number, password, address, points) values (5, 'Liv', 'Alster', 'lalster4@domainmarket.com', '5213905064', 'Liv5', '8 Mesta Hill', 250);
insert into clientuser (id, username, user_last_name, email, tel_number, password, address, points) values (6, 'Evanne', 'Fitzer', 'efitzer5@google.fr', '6205820463', 'Evanne6', null, 10);
insert into clientuser (id, username, user_last_name, email, tel_number, password, address, points) values (7, 'Jennie', 'Hasling', 'jhasling6@google.ru', '3527545888', 'Jennie3', '99 Tennyson Way', 1174);
insert into clientuser (id, username, user_last_name, email, tel_number, password, address, points) values (8, 'Missy', 'Kynson', 'mkynson7@buzzfeed.com', '6322671456', 'Missy6', null, 459);

ALTER SEQUENCE clientuser_seq RESTART WITH 58;