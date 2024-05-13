insert into product (id, name, description, avg_duration, base_price , product_type , desc_img , alter_text) values (1, 'Mechas californianas', 'Inspiradas en las surfistas de las playas de California, pretenden emular el efecto que la constante exposición al sol dejaba sobre su pelo.', 60,35,'PELUQUERIA' , 'https://i.imgur.com/3tZkQxM.jpeg' , 'Fotografía de unas mechas californianas' );
insert into product (id, name, description, avg_duration, base_price , product_type , desc_img , alter_text) values (2, 'Tinte mujer', 'Tinte para mujer + tratamiento suavizante, el color elegido es ajeno al precio.', 45 , 28 ,'PELUQUERIA' , 'https://i.imgur.com/Pde5TXa.jpeg' , 'Fotografía de un tinte de pelo' );
insert into product (id, name, description, avg_duration, base_price , product_type , desc_img , alter_text) values (3, 'Manicura francesa', 'Un clásico de la belleza que nunca pasa de moda, además incluye tratamiento de la cutícula.', 25 ,15.5,'ESTETICA' , 'https://i.imgur.com/IalSjXO.jpeg' , 'Fotografia de un tratamiento de manicura francesa' );
insert into product (id, name, description, avg_duration, base_price , product_type , desc_img , alter_text) values (4, 'Manicura de porcelana', 'Tratamiento hidratante sobre la uña + manicura de polvo de porcelana de la máxima calidad.', 30 ,18 ,'ESTETICA' , 'https://i.imgur.com/RAb71tI.jpeg' , 'Fotografía de unas uñas de porcelana' );

ALTER SEQUENCE product_seq RESTART WITH 1000;

insert into alert (id, description , name , active) values (1, 'Cierra los ojos y piensa en algo bonito... , quiérete como nadie, Quiérete Mucho.' , 'Alerta por defecto' , true);

ALTER SEQUENCE alert_seq RESTART WITH 1000;

insert into userentity (id, username , name, user_last_name, email, tel_number, password, address, points , admin) values (1, 'mireillemun6' , 'Mireille', 'Munning', 'mmunning0@barnesandnoble.com', '6451632768', '{bcrypt}$2y$10$XnBqx0XYEzMlyywp3ziP.ehlKIkdzgbrQTg71zLcebzGsnRQxO5g.', '22 Lakewood Gardens Terrace', 912 , false);
insert into userentity (id, username , name, user_last_name, email, tel_number, password, address, points , admin) values (2, 'hubefed3' , 'Hube', 'Fedder', 'hfedder1@princeton.edu', '3565879596', '{bcrypt}$2y$10$x2Apt2Mq7CGNy8wFR9ew9ulAsMzKVgLRfkHwhmyIKL7.U6o5Mc8bO', null, 875 , false);
insert into userentity (id, username , name, user_last_name, email, tel_number, password, address, points , admin) values (3, 'lucienneorm4' , 'Lucienne', 'Ormerod', 'lormerod2@amazonaws.com', '4582462801', '{bcrypt}$2y$10$o94PvR8KzkaUB1LpUAvsgOEGLlSZhKTtTDZVlrPnAiFamCkW8ng6S', '658 Menomonie Plaza', 1015 , false);
insert into userentity (id, username , name, user_last_name, email, tel_number, password, address, points , admin) values (4, 'joshuahstr2' , 'Joshuah', 'Stretton', 'jstretton3@so-net.ne.jp', '2057056583', '{bcrypt}$2y$10$qR.QhRSF.0krqhAaVeUyNeQCPC.RJAWGV48EaF2iCRJnGjjE3/Kiq', '3 Fulton Trail', 830 , false);
insert into userentity (id, username , name, user_last_name, email, tel_number, password, address, points , admin) values (5, 'livals5' , 'Liv', 'Alster', 'lalster4@domainmarket.com', '5213905064', '{bcrypt}$2y$10$I4vNZiNWEj3Gsd4dGkQDYeBBm4oI3bkXAhqDcQmFkwVLhWb3Aembe', '8 Mesta Hill', 250 , false);
insert into userentity (id, username , name, user_last_name, email, tel_number, password, address, points , admin) values (6, 'admin' , 'Joaquín', 'Carrascal', 'j.carrascalfranco@gmail.com', '6213905062', '{bcrypt}$2y$10$j47xaZhCvw3XJiroC3w.COnN3Pw54Xpt2sQxkua1d3XFnsp/LrDIS', 'C/ Huelva 22', 250 , true);
insert into userentity (id, username , name, user_last_name, email, tel_number, password, address, points , admin) values (7, 'user' , 'Pepe', 'Botika', 'arribaExtremoduro@gmail.com', '2213905062', '{bcrypt}$2y$10$cscpMQySZO.n6rfX49tpRORdl6qCsi4UqmPfAYVd3GcjyBfGp4Ifq', 'Prisión Alcalá Meco , Madrid II', 290 , false);


ALTER SEQUENCE userentity_seq RESTART WITH 1000;

insert into report (report_date , client_id , id , description , reply , title) values ('2024-05-06' , 2 , 1 , 'La cisterna del baño no funciona, y pasé mucha verguenza' , null , 'Cisterna del baño');
insert into report (report_date , client_id , id , description , reply , title) values ('2024-03-01' , 1 , 2 , 'La máquina de café suelta aguachirri , a ver si la vamos arreglando...' , null , 'Máquina de café asquerosa');
insert into report (report_date , client_id , id , description , reply , title) values ('2024-04-23' , 5 , 3 , 'He tenido que estar esperando de pie porque no había ni un asiento libre, esto se tiene que preveer hombre.' , null , 'Estancia desagradable');
insert into report (report_date , client_id , id , description , reply , title) values ('2024-01-11' , 7 , 4 , 'El local de al lado estaba montando una fiesta y se escuchaba todo, que incómodo' , null , 'Ruidos desagradables');

ALTER SEQUENCE report_seq RESTART WITH 1000;