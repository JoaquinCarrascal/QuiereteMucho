# Proyecto final: Quiérete Mucho WEB.

![Logo del negocio](https://i.imgur.com/zZp6k66.png)

#### Nota:
Dentro del proyecto en forma de documento PDF se encuentra una pequeña guía para facilitar la corrección en relación con el apartado de LMSGI, para que sirva como mapa de puntos de interés.

## Descripción del sistema (de manera breve)

Éste documento va relacionado al sistema de gestión WEB de una
peluquería/estética, enfocado principalmente a facilitar el proceso de petición y
gestión de servicios (citas para la peluquería/estética), y en un plano secundario
también tendrá funcionalidades/implementaciones enfocadas al acercamiento de los
trabajadores del negocio al cliente (blog) y la capacidad de mantener por parte de
los administradores de la página un control sobre los ingresos (posibles o
conseguidos) en el negocio incluyendo, en la vista de administrador una vista que denota:
los ingresos estimados con citas futuras(a partir del dia de hoy), ganancias totales en materia de peluquería o estética
(hasta el dia de hoy) , ganancias totales del año actual (donde aparecen las previstas y las ya cobradas), 
además de un abanico de posibilidades , tales como;
posibilidad de crear alertas, que serán dinámicas y globales en toda la web, con un listado de alertas
pre-cargado para hacer un test, posibilidad de contestar reportes a los clientes, ya que estos pueden
expresar sus quejas por medio de un formulario y éste será contestado (o borrado) por un administrador de
la página.

# ¿Qué se podrá hacer en la web? 
Cada rol podrá hacer lo del anterior más lo determinado en el suyo.

## Como usuario anónimo (sin hacer login):

+ Consultar el apartado de : 'Sobre nosotros'

+ Consultar el inicio de la página en el que se encuentra un carousel de imagenes reales de peinados
    + Ademas en dicha vista se encuentra una selección de los productos mas vendidos, que se actualizan dinámicamente por medio de una consulta a BBDD recogiendo los productos más presentes en ventas (abiertas o cerradas)

+ Consultar los servicios de la web por medio del botón mostrar más en el inicio o el botón de Servicios en el menú de navegación donde aparecerán deshabilitados hasta que se inicie sesión y con el botón de contratar cambiado.

+ Consultar el mapa de la peluquería que se encuentra en el footer, el mapa es una foto con vista de pájaro que cuando es activado con un click despliega un modal de BS5 que muestra un mapa interactivo implementado con un iframe de Google Maps.

+ Consultar el apartado de Aviso Legal, se accede a el mediante un link en la última línea del footer.

+ Hacer login en la página, tendrá la posibilidad de entrar con una de las cuentas creadas en la página:
    + Administrador -> username: **admin** /// password: **admin**
    + Usuario -> username: **user** /// password: **1234**
    
    Con éstos sería suficiente para probar la página, pero dejo por aquí alguno más:

    + Usuario -> username: **rayheredia** /// password: **rayheredia**
    + Usuario -> username: **ninobravo** /// password: **ninobravo**
    + Administrador -> username: **rocio** /// password: **rocio**
    + Administrador -> username: **elena** /// password: **elena**

+ Registrar un usuario, se facilita un formulario en la parte superior del menú en el icono de usuario, y luego haciendo click en crear cuenta.
    + El formulario está validado con Js en los siguientes aspectos;
        
        Las contraseñas han de ser iguales.
        
        El correo electrónico ha de seguir el patrón de una RegEx, para que tenga una letra/número al menos, el @ y luego otra letra/número un punto "." y una extensión.

        El número de teléfono tiene que tener 9 o más caracteres.

    + El formulario también comprueba que el campo *username* no se complete con un nombre que esté ya siendo usado, si se da el caso se lanza un error y se recoge en el documento en forma de alerta de BS5.

## Como cliente:

Una vez logueado o creada una cuenta y posteriormente logueado, se adquiere el rol de USER.

Con este rol además de las anteriores se nos desbloquean las siguientes funcionalidades / características:

+ Saludo personalizado en la parte superior de la página entre el apartado de alertas y el menú de navegación.

+ En el menú de navegacion aparecen 3 nuevos apartados;

    ![3 opciones nuevas](https://i.imgur.com/Uw4oXwz.png)

    **De izquierda a derecha:**    
    + El botón de reclamaciones: que permite crear una reclamación, el formulario añade una comprobación que determina si estás intentando poner una queja para un dia posterior a hoy.
    + El menú del usuario, que incorpora: la posibilidad de cambiar los datos del perfil de usuario (actualizando el security context para que no se requiera de logout ) y su contraseña , añadiendo como medida preventiva para conservar la integridad de ésta credencial un logout automático (se avisa de antemano con una alert-info de BS5). Además el menú de usuario también tiene la opción de ver reclamaciones, en el que se extrae una lista con sus reclamaciones y se deja ver si han sido contestadas, además de la posibilidad de borrarlas o editarlas. Como último apartado del menu de cliente se incluye una vista con las citas que están vinculadas a la cuenta, con la posiblidad de ampliar los detalles de la misma o borrarlas, la edición queda limitada a las citas que estan abiertas en el carrito.
    + El botón de logout, para cerrar sesión y devolvernos a la página principal.

+ Se desbloquea el carrito (que por defecto es una vista con un aviso informando que está vacio) permitiendo tanto añadir productos desde la página de inicio como desde la página de "Servicios" , en la vista del carrito permite, bajar la cantidad de una línea de venta eliminándola si es que llega a cero, aumentar su cantidad , y quitar directamente la línea con un botón al final de la misma, está pensado de esta forma ya que no se espera que un cliente quiera agregar 500 peinados, lo común es que se reserven 1-3 por cada tipo.

    ![Línea de venta carrito](https://i.imgur.com/32Pfq9Z.png)

    En el carrito también se encuentra la opción de pagar que por falta de tiempo no he terminado de rematar todo lo bien que me hubiera gustado en la primera versión y en éste caso sólamente se permite escoger una fecha que sea posterior a hoy. En un principio yo tenía pensado un sistema mucho más complejo en el que se gestionaría también la hora y la disponibilidad de las trabajadoras pero no ha sido posible debido al limitado tiempo. Por tanto y en resumidas cuentas el ciclo de vida del carrito termina pulsando el botón de pagar poniendo una fecha válida, es ese momento se actualiza el atributo de *pagado* y aparece como pagada en el menú user.

    Quiero remarcar que el carrito que he diseñado / programado, está hecho únicamente con la base de la estructura y funcionamiento lógico que se planteó en clase pero el cómo funciona internamente está ideado por mi, con esto quiero decir que no va a ser perfecto, pero gestiona básicamente todo lo que yo quería y funciona que es lo más importante así que espero que sea suficiente, al menos para la primera versión del programa.
