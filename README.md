# Test-Automation-N5
El siguiente ejercicio de automatizacion que vamos a visualizar fue realizado con las siguientes caracteristicas:

* Patron de diseño page object model
* Libreria Serenity BDD para el diseño de pruebas y reporte de estas
* Gerkin con Cucumber para el diseño de los escenarios
* Maven para la gestion y construccion del proyecto


# Buenas practicas al momento de automatizar
Antes de hablar de codigo debemos saber que la automatizacion de pruebas va mas alla que escribir codigo, al momento de pensar 
en la automatizacion de pruebas nos sujetamos a un arduo proceso de QA, que dentro de este al momento de escuchar esta palabra
para muchos puede ser hacer prueba y que el sistema funcione bien, el proceso QA empieza desde que el cliente piensa en un proyecto
porque esta persona de calidad tiene la capacidad de pensar tecnica y funcionalmente sobre un proyecto al momento de recibir requerimientos, 
observando desde las piezas mas pequeñas hasta las mas importante que debe tener encuenta para la realizacion de este, por consiguiente 
implementara todo lo que conlleva a un ciclo de vida de pruebas y alcanzar un producto estable, con esta introduccion empiezo con una 
de las primeras buenas practicas al momento de automatizar es tener encuenta que somos ese QA que codificara un framework para ejecutar pruebas, 
esto nos conlleva a conocer todos los procesos posibles del proyecto y saber que escenarios fueron ejecutados por los QA manuales para analizar 
y implementar las pruebas automatizadas.

<img width="636" alt="Screen Shot 2022-12-01 at 5 07 03 PM" src="https://user-images.githubusercontent.com/36672893/205169199-56c8de77-34c0-4363-988b-80f7f5a995fe.png">

Explicación de la pirámide de Mike Cohn:

Pruebas Unitarias: Se utilizan para comprobar el correcto funcionamiento de una porción reducida de código, por ejemplo, un método. Son el punto de partida para detectar fallos, si una prueba falla en este punto, lo más probable es que también fallen las pruebas de los subsiguientes niveles (integración, API, funcional etc.)

Pruebas de API, integración de componentes, servicios: Estas pruebas verifican que la comunicación e intercambio de datos, entre los diferentes módulos de la aplicación o con otras aplicaciones. Sirven para detectar fallos en la forma en la que los diferentes módulos de la aplicación actúan y se integran los unos con los otros.

Pruebas de interfaz gráfica: Requieren elevado tiempo de desarrollo y son lentos en su ejecución y con muchas dependencias con otros componentes. La interfaz gráfica es donde los cambios se dan más frecuentemente, por eso también estas pruebas suelen ser las más inestables, requiriendo actualización periódicamente. Sí, hay que automatizar las pruebas de GUI de las funcionalidades críticas, pero es mejor hacerlo después de haber automatizado los niveles más bajos de la aplicación.
