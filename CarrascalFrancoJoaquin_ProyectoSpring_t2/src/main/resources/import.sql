insert into product (id, name, description, avg_duration, base_price , product_type) values (1, 'Mechas californianas', 'Inspiradas en las surfistas de las playas de California, pretenden emular el efecto que la constante exposición al sol dejaba sobre su pelo.', 60,35,'PELUQUERIA');
insert into product (id, name, description, avg_duration, base_price , product_type) values (2, 'Tinte mujer', 'Tinte para mujer + tratamiento suavizante, el color elegido es ajeno al precio.', 45 , 28 ,'PELUQUERIA');
insert into product (id, name, description, avg_duration, base_price , product_type) values (3, 'Manicura francesa', 'Un clásico de la belleza que nunca pasa de moda, además incluye tratamiento de la cutícula.', 25 ,15.5,'ESTETICA');
insert into product (id, name, description, avg_duration, base_price , product_type) values (4, 'Manicura de porcelana', 'Tratamiento hidratante sobre la uña + manicura de polvo de porcelana de la máxima calidad.', 30 ,18 ,'ESTETICA');

ALTER SEQUENCE product_seq RESTART WITH 5;

insert into alert (id, description , name) values (1, 'Cierra los ojos y piensa en algo bonito... , quiérete como nadie, Quiérete Mucho.' , 'Alerta por defecto');

ALTER SEQUENCE alert_seq RESTART WITH 2;