insert into product (id, name, description, avg_duration, base_price , product_type , desc_img , alter_text) values (1, 'Mechas californianas', 'Inspiradas en las surfistas de las playas de California, pretenden emular el efecto que la constante exposición al sol dejaba sobre su pelo.', 60,35,'PELUQUERIA' , 'https://i.imgur.com/3tZkQxM.jpeg' , 'Fotografía de unas mechas californianas' );
insert into product (id, name, description, avg_duration, base_price , product_type , desc_img , alter_text) values (2, 'Tinte mujer', 'Tinte para mujer + tratamiento suavizante, el color elegido es ajeno al precio.', 45 , 28 ,'PELUQUERIA' , 'https://i.imgur.com/Pde5TXa.jpeg' , 'Fotografía de un tinte de pelo' );
insert into product (id, name, description, avg_duration, base_price , product_type , desc_img , alter_text) values (3, 'Manicura francesa', 'Un clásico de la belleza que nunca pasa de moda, además incluye tratamiento de la cutícula.', 25 ,15.5,'ESTETICA' , 'https://i.imgur.com/IalSjXO.jpeg' , 'Fotografia de un tratamiento de manicura francesa' );
insert into product (id, name, description, avg_duration, base_price , product_type , desc_img , alter_text) values (4, 'Manicura de porcelana', 'Tratamiento hidratante sobre la uña + manicura de polvo de porcelana de la máxima calidad.', 30 ,18 ,'ESTETICA' , 'https://i.imgur.com/RAb71tI.jpeg' , 'Fotografía de unas uñas de porcelana' );
insert into product (id, name, description, avg_duration, base_price , product_type , desc_img , alter_text) values (5, 'Recogido con trenza corta', 'Recogido sutil, con una trenza corta al final ideal para celebraciones casuales', 60 ,35 ,'PELUQUERIA' , 'https://i.imgur.com/Xa84NKV.jpeg' , 'Fotografía de un recogido formal' );
insert into product (id, name, description, avg_duration, base_price , product_type , desc_img , alter_text) values (6, 'Recogido con extensión de volumen', 'Recogido con prótesis extensiva, para dar efecto de volumen', 45 , 30 ,'PELUQUERIA' , 'https://i.imgur.com/uakRIEM.jpeg' , 'Fotografía de un recogido de mujer.' );
insert into product (id, name, description, avg_duration, base_price , product_type , desc_img , alter_text) values (7, 'Peinado con ondas', 'Peinado con ondas, para dar ese volumen que siempre has querido, ideal para una cita.', 40 , 25.5 ,'PELUQUERIA' , 'https://i.imgur.com/jV9rkFA.jpeg' , 'Fotografía de un peinado con ondas' );
insert into product (id, name, description, avg_duration, base_price , product_type , desc_img , alter_text) values (8, 'Alisado con keratina', 'Tratamiento de alisado con keratina , para un alisado con el máximo brillo e hidratación', 55 , 90 ,'PELUQUERIA' , 'https://i.imgur.com/adHNXcA.jpeg' , 'Fotografía de un alisado con keratina' );
insert into product (id, name, description, avg_duration, base_price , product_type , desc_img , alter_text) values (9, 'Uñas de gel', 'Tratamiento de manicura con implante de gel y pintura a tu gusto, ideal para el día a día.', 35 , 22.5 ,'ESTETICA' , 'https://i.imgur.com/rYkPojf.png' , 'Fotografía de unas uñas postizas de gel' );
insert into product (id, name, description, avg_duration, base_price , product_type , desc_img , alter_text) values (10, 'Depilación + mapa capilar', 'Depilación con asesoramiento sobre tu mapa capilar para obtener los mejores resultados.', 25 , 20 ,'ESTETICA' , 'https://i.imgur.com/mKl2LEu.png' , 'Fotografía de una depilación de cejas' );
insert into product (id, name, description, avg_duration, base_price , product_type , desc_img , alter_text) values (11, 'Tratamiento hidratante', 'Tratamiento hidratante, consta de dilatación de poros, limpieza y la posterior hidratacion de la piel con soluciones naturales', 50 , 35 ,'ESTETICA' , 'https://i.imgur.com/ULcBELU.png' , 'Fotografía de un tratamiento hidratante' );

ALTER SEQUENCE product_seq RESTART WITH 1000;

insert into alert (id, description , name , active) values (1, 'Cierra los ojos y piensa en algo bonito... , quiérete como nadie, Quiérete Mucho.' , 'Alerta por defecto' , true);
insert into alert (id, description , name , active) values (2, 'La temporada de verano ha llegado, no pierdas el tiempo y ¡ponte guapa! , Quiérete Mucho' , 'Alerta verano' , false);
insert into alert (id, description , name , active) values (3, '¡Ya huele a Feria cariño mío! , ¿querrás estar a la última verdad? , ¡es el momento para quererte mucho!' , 'Alerta feria' , false);
insert into alert (id, description , name , active) values (4, 'Chaleco de lana, arbolito, portal de Belén... Llega la navidad y con ella las comidas con los allegados, ¡no pierdas el tiempo para quererte mucho!' , 'Alerta navidad' , false);
insert into alert (id, description , name , active) values (5, 'Llega la primavera y con ella los corazones se revolucionan, ¡aprovecha para conquistar a tu amor con tu nuevo look!' , 'Alerta por primavera' , false);
insert into alert (id, description , name , active) values (6, 'Ya está aquí el Rocío, aprovecha y ponte guapa para la ocasión' , 'Alerta Rocío' , false);

ALTER SEQUENCE alert_seq RESTART WITH 1000;

insert into userentity (id, username , name, user_last_name, email, tel_number, password, address, points , admin) values (1, 'rayheredia' , 'Ray', 'Heredia', 'ketama@barnesandnoble.com', '6451632768', '{bcrypt}$2y$10$UcBr0Mml/YB.nOHbmIbG0eezeL1OVRltzDpvKsFVEw98UCwXnT0Iu', '22 Lakewood Gardens Terrace', 912 , false);
insert into userentity (id, username , name, user_last_name, email, tel_number, password, address, points , admin) values (2, 'jeros' , 'Jeros', 'De Los Chichos', 'eldeenmedio@princeton.edu', '3565879596', '{bcrypt}$2y$10$lG.zZ6pMU1An8W2XTFwXGeV5FEUnzF29PpbkrIW3Z/iInhc4cKLXi', null, 875 , false);
insert into userentity (id, username , name, user_last_name, email, tel_number, password, address, points , admin) values (3, 'manologarcia' , 'Manolo', 'García', 'manolog@amazonaws.com', '4582462801', '{bcrypt}$2y$10$TGI02KN6jZrEA7OfRZ3aKupOiU0FgbTwfREmeB.dLU4nMexxBT7te', '658 Menomonie Plaza', 1015 , false);
insert into userentity (id, username , name, user_last_name, email, tel_number, password, address, points , admin) values (4, 'jesusdlrosa' , 'Jesús', 'De La Rosa', 'sedeunlugar@so-net.ne.jp', '2057056583', '{bcrypt}$2y$10$QrdEXk/8zqVE74NpySbReOWaBk1JhxPNHVcgg9J.E7XW59ln.JQ2W', '3 Fulton Trail', 830 , false);
insert into userentity (id, username , name, user_last_name, email, tel_number, password, address, points , admin) values (5, 'jsabina' , 'Joaquín', 'Sabina', 'jsabina@domainmarket.com', '5213905064', '{bcrypt}$2y$10$/qp5uHtzj7TJl8U9AyT6ZulSOEP3qcabhxszGROq.Oj1aRYwRgi9.', '8 Mesta Hill', 250 , false);
insert into userentity (id, username , name, user_last_name, email, tel_number, password, address, points , admin) values (6, 'ermiguebenitez' , 'Miguel', 'Benitez', 'sentimientogarrapatero@gmail.com', '563905062', '{bcrypt}$2y$10$KYN7BduYPwtGgTPYXJGdHOLlvctbDbx78Zg0kc26J6ejq5wWok7vu', 'Casa del abuelo Frederik', 341 , false);
insert into userentity (id, username , name, user_last_name, email, tel_number, password, address, points , admin) values (7, 'ninobravo' , 'Nino', 'Bravo', 'lapuertadelamor@gmail.com', '4423905062', '{bcrypt}$2y$10$WpjthBSnI3DWERR86JTlzevE1Zewy.VToExv5DUdej/BdzStlKV8O', 'C/ America nº 9', 90 , false);
insert into userentity (id, username , name, user_last_name, email, tel_number, password, address, points , admin) values (8, 'rocio' , 'Rocio', 'Carrascal', 'francarras82@gmail.com', '3433905062', '{bcrypt}$2y$10$WA2qoZxE9GawHjoTA0EM5eCu6XBqGlYohTkfKxRH5Iff4d7LmiEOe', 'C/ Huelva nº 22', 450 , true);
insert into userentity (id, username , name, user_last_name, email, tel_number, password, address, points , admin) values (9, 'elena' , 'Elena', 'Campos', 'helenamail@gmail.com', '4413905062', '{bcrypt}$2y$10$IVkyqCblsDejrEvqmZ4XT.YZpWHaWfsJ18m22k513sccjHVMPMuj6', 'C/ Bulerias nº 1', 450 , true);
insert into userentity (id, username , name, user_last_name, email, tel_number, password, address, points , admin) values (10, 'admin' , 'Joaquín', 'Carrascal', 'j.carrascalfranco@gmail.com', '6213905062', '{bcrypt}$2y$10$j47xaZhCvw3XJiroC3w.COnN3Pw54Xpt2sQxkua1d3XFnsp/LrDIS', 'C/ Huelva 22', 250 , true);
insert into userentity (id, username , name, user_last_name, email, tel_number, password, address, points , admin) values (11, 'user' , 'Pepe', 'Botika', 'arribaExtremoduro@gmail.com', '2213905062', '{bcrypt}$2y$10$cscpMQySZO.n6rfX49tpRORdl6qCsi4UqmPfAYVd3GcjyBfGp4Ifq', 'Prisión Alcalá Meco , Madrid II', 290 , false);


ALTER SEQUENCE userentity_seq RESTART WITH 1000;

insert into report (report_date , client_id , id , description , reply , title) values ('2024-05-06' , 2 , 1 , 'La cisterna del baño no funciona, y pasé mucha verguenza' , null , 'Cisterna del baño');
insert into report (report_date , client_id , id , description , reply , title) values ('2024-03-01' , 1 , 2 , 'La máquina de café suelta aguachirri , a ver si la vamos arreglando...' , null , 'Máquina de café asquerosa');
insert into report (report_date , client_id , id , description , reply , title) values ('2024-04-23' , 5 , 3 , 'He tenido que estar esperando de pie porque no había ni un asiento libre, esto se tiene que preveer hombre.' , null , 'Estancia desagradable');
insert into report (report_date , client_id , id , description , reply , title) values ('2024-01-11' , 11 , 4 , 'El local de al lado estaba montando una fiesta y se escuchaba todo, que incómodo' , null , 'Ruidos desagradables');
insert into report (report_date , client_id , id , description , reply , title) values ('2020-02-04' , 5 , 5 , 'Estando en la peluquería parece que me han robado el mes de abril...' , null , 'nullpointer en Abril');
insert into report (report_date , client_id , id , description , reply , title) values ('2024-02-14' , 4 , 6 , 'Sé de un lugar donde brotan las flores para ti, donde el río y el monte se aman, claramente no es éste negocio, huele a muerto' , null , 'Olor insoportable');
insert into report (report_date , client_id , id , description , reply , title) values ('2024-02-03' , 7 , 7 , 'Noelia , Noelia , Noelia es lo único que he escuchado en todo el tiempo que he estado en el establecimiento, la vecina, que parece llamarse Noelia no paraba de gritar.' , null , 'Noelia, JARTIBLE');
insert into report (report_date , client_id , id , description , reply , title) values ('2021-12-02' , 3 , 8 , 'Viendo la organización del negocio, me entran ganas de hacer pájaros de barro y echarlos a volar' , null , 'República bananera');
insert into report (report_date , client_id , id , description , reply , title) values ('2019-5-05' , 1 , 9 , 'Dedicado para todas las mujeres bellas de la vida, dedicaos a otra cosa porque para peinar no valéis.' , null , 'Migración al grado de panadería');

ALTER SEQUENCE report_seq RESTART WITH 1000;

insert into appointment (appointment_date, full_price, paid, client_id, id) values ('2024-03-02' , 0 , true , 1 , 1);
insert into appointment (appointment_date, full_price, paid, client_id, id) values ('2024-01-02' , 0 , true , 4 , 2);
insert into appointment (appointment_date, full_price, paid, client_id, id) values ('2023-04-23' , 0 , true , 7 , 3);
insert into appointment (appointment_date, full_price, paid, client_id, id) values ('2023-12-29' , 0 , true , 1 , 4);
insert into appointment (appointment_date, full_price, paid, client_id, id) values ('2023-07-14' , 0 , true , 3 , 5);
insert into appointment (appointment_date, full_price, paid, client_id, id) values ('2024-02-14' , 0 , true , 2 , 6);
insert into appointment (appointment_date, full_price, paid, client_id, id) values ('2024-08-12' , 0 , false , 11 , 7);
insert into appointment (appointment_date, full_price, paid, client_id, id) values ('2024-09-03' , 0 , false , 2 , 8);
insert into appointment (appointment_date, full_price, paid, client_id, id) values ('2024-06-02' , 0 , false , 7 , 9);
insert into appointment (appointment_date, full_price, paid, client_id, id) values ('2024-08-10' , 0 , false , 8 , 10);
insert into appointment (appointment_date, full_price, paid, client_id, id) values ('2024-12-12' , 0 , false , 5 , 11);

ALTER SEQUENCE appointment_seq RESTART WITH 1000;

insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (1 , 0 , 1 , 1 , 1);
insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (2 , 0 , 1 , 2 , 10);

insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (2 , 0 , 2 , 3 , 10);
insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (1 , 0 , 2 , 4 , 8);
insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (3 , 0 , 2 , 5 , 11);

insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (1 , 0 , 3 , 6 , 2);
insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (2 , 0 , 3 , 7 , 4);
insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (1 , 0 , 3 , 8 , 7);
insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (2 , 0 , 3 , 9 , 11);

insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (1 , 0 , 4 , 10 , 3);
insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (1 , 0 , 4 , 11 , 4);
insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (1 , 0 , 4 , 12 , 6);

insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (2 , 0 , 5 , 13 , 2);
insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (2 , 0 , 5 , 14 , 3);

insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (1 , 0 , 6 , 15 , 6);

insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (1 , 0 , 7 , 16 , 7);
insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (1 , 0 , 7 , 17 , 8);
insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (1 , 0 , 7 , 18 , 3);

insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (3 , 0 , 8 , 19 , 8);
insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (1 , 0 , 8 , 20 , 2);
insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (2 , 0 , 8 , 21 , 7);
insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (1 , 0 , 8 , 22 , 10);

insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (1 , 0 , 9 , 23 , 1);
insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (1 , 0 , 9 , 24 , 4);

insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (2 , 0 , 10 , 25 , 8);

insert into appointmentline (quantity, sub_total, appointment_id, id, product_id) values (3 , 0 , 11 , 26 , 1);

ALTER SEQUENCE appointmentline_seq RESTART WITH 1000;

UPDATE appointmentline al SET al.sub_total = {SELECT p.base_price*al.quantity FROM product p WHERE p.id=al.product_id };
UPDATE appointment a SET a.full_price = {SELECT SUM(al.sub_total) FROM appointmentline al WHERE al.appointment_id=a.id};