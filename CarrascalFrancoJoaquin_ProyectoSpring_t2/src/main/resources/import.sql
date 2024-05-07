insert into product (id, name, description, avg_duration, base_price , product_type , desc_img) values (1, 'Mechas californianas', 'Inspiradas en las surfistas de las playas de California, pretenden emular el efecto que la constante exposición al sol dejaba sobre su pelo.', 60,35,'PELUQUERIA' , 'https://i.imgur.com/3tZkQxM.jpeg');
insert into product (id, name, description, avg_duration, base_price , product_type , desc_img) values (2, 'Tinte mujer', 'Tinte para mujer + tratamiento suavizante, el color elegido es ajeno al precio.', 45 , 28 ,'PELUQUERIA' , 'https://i.imgur.com/Pde5TXa.jpeg');
insert into product (id, name, description, avg_duration, base_price , product_type , desc_img) values (3, 'Manicura francesa', 'Un clásico de la belleza que nunca pasa de moda, además incluye tratamiento de la cutícula.', 25 ,15.5,'ESTETICA' , 'https://i.imgur.com/IalSjXO.jpeg');
insert into product (id, name, description, avg_duration, base_price , product_type , desc_img) values (4, 'Manicura de porcelana', 'Tratamiento hidratante sobre la uña + manicura de polvo de porcelana de la máxima calidad.', 30 ,18 ,'ESTETICA' , 'https://i.imgur.com/RAb71tI.jpeg');

ALTER SEQUENCE product_seq RESTART WITH 54;

insert into alert (id, description , name , active) values (1, 'Cierra los ojos y piensa en algo bonito... , quiérete como nadie, Quiérete Mucho.' , 'Alerta por defecto' , true);

ALTER SEQUENCE alert_seq RESTART WITH 51;

insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (1, 'Mireille', 'Munning', 'mmunning0@barnesandnoble.com', '6451632768', 'rOc&`bEcb1QW~9%_', '22 Lakewood Gardens Terrace', 912);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (2, 'Hube', 'Fedder', 'hfedder1@princeton.edu', '3565879596', 'hLQV&K|C9OydM.', null, 875);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (3, 'Lucienne', 'Ormerod', 'lormerod2@amazonaws.com', '4582462801', 'sIH@}ZEDJ', '658 Menomonie Plaza', 1015);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (4, 'Joshuah', 'Stretton', 'jstretton3@so-net.ne.jp', '2057056583', 'zKe>os5>Q', '3 Fulton Trail', 830);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (5, 'Liv', 'Alster', 'lalster4@domainmarket.com', '5213905064', 'sSe)AZK8', '8 Mesta Hill', 250);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (6, 'Evanne', 'Fitzer', 'efitzer5@google.fr', '6205820463', 'fXskK`*n<{}', null, 10);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (7, 'Jennie', 'Hasling', 'jhasling6@google.ru', '3527545888', 'bU")qLkLxJwnknXK', '99 Tennyson Way', 1174);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (8, 'Missy', 'Kynson', 'mkynson7@buzzfeed.com', '6322671456', 'lW~>d1GN"j0BVC*z', null, 459);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (9, 'Nalani', 'James', 'njames8@weebly.com', '6494374562', 'nR56>usuu2l', '90726 Melvin Street', 1008);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (10, 'Johnny', 'Hayne', 'jhayne9@illinois.edu', '9509014561', 'aABKHT(5Ig!', null, 1148);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (11, 'Rosamund', 'Lyffe', 'rlyffea@house.gov', '5049823379', 'rIH!w$\sX<m', null, 947);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (12, 'Gabriellia', 'Geraud', 'ggeraudb@yale.edu', '4052356020', 'xC/mkMyc8<', '9318 Muir Court', 15);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (13, 'Janifer', 'Mattheis', 'jmattheisc@360.cn', '8733206484', 'jO5yY,VT?00hy*m', '11017 Alpine Drive', 628);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (14, 'Evangelin', 'Forgan', 'eforgand@nature.com', '4823094493', 'bF(8}!9=Qw<(+l', '33 Bayside Alley', 213);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (15, 'Sher', 'Littlewood', 'slittlewoode@theatlantic.com', '7819851251', 'lI{Wt''Q''("', null, 1123);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (16, 'Kat', 'Edwicke', 'kedwickef@icio.us', '4822281537', 'oVUGpfGI4~%h<.93', null, 387);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (17, 'Alyssa', 'Avarne', 'aavarneg@soundcloud.com', '1091311055', 'sO`tFJi05dBoNgH', null, 13);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (18, 'Hillary', 'Danher', 'hdanherh@artisteer.com', '4093908018', 'qY,AX533s5t', '761 Clarendon Point', 1214);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (19, 'Chuck', 'Dillicate', 'cdillicatei@domainmarket.com', '5127996333', 'iIc.aq|c|uq3Tz', '03967 Thackeray Trail', 487);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (20, 'Clareta', 'Starmore', 'cstarmorej@discuz.net', '2972585994', 'pRY7v=kFjE+V', '3301 Buena Vista Plaza', 527);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (21, 'Waldon', 'Giacobillo', 'wgiacobillok@hatena.ne.jp', '4161023445', 'zN,2|IWyPZjHLSz', '6 Bobwhite Park', 288);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (22, 'Lyda', 'Karadzas', 'lkaradzasl@google.it', '4914128628', 'mCX|i+\,1YNx', '924 Iowa Trail', 706);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (23, 'William', 'Kordes', 'wkordesm@berkeley.edu', '2611911552', 'nOWdW>NJR', '02 Artisan Pass', 1036);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (24, 'Winnah', 'Kort', 'wkortn@ca.gov', '7634404384', 'xNv*s@,<S/En1mmH', null, 994);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (25, 'Alexi', 'Rigney', 'arigneyo@cbslocal.com', '9712119564', 'uJ,("\Q*#wk)H', null, 772);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (26, 'Oliy', 'Yard', 'oyardp@technorati.com', '9854394588', 'mLzcHrowr8&', '241 Bultman Drive', 409);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (27, 'Adolf', 'Elph', 'aelphq@creativecommons.org', '4534995251', 'kD|t!VsH+7`C}I', null, 447);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (28, 'Amandie', 'Newlove', 'anewlover@upenn.edu', '8025396707', 'zAdA=)G!_4', '88768 Michigan Parkway', 262);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (29, 'Gene', 'Tyrer', 'gtyrers@about.me', '2132942621', 'iG5m*ACl`', '9671 Sunbrook Lane', 97);
insert into clientuser (id, user_name, user_last_name, email, tel_number, pass, address, points) values (30, 'Natalina', 'Simmonett', 'nsimmonettt@scribd.com', '6185719262', 'mHu9V~g@X~7H', '0150 Larry Center', 204);

ALTER SEQUENCE clientuser_seq RESTART WITH 70;