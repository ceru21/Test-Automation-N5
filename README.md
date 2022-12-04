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

# Desafío Netflix
El desafío que realizamos para automatizar es un escenario de un usuario que ingresa a Netflix y el sistema validara que tenga un titulo y la url que
tiene presente en el momento de validar el titulo
El proyecto se realiza con el patron de diseño POM una estrategia de automatizacion por medio de paginas, explicado de la siguiente manera: Una pagina principal donde tendremos todas las acciones generales del proyecto como los clicks, las esperas implicitas-explicitas, el scroll, togo lo general que un usuario hace en una página, esto se hace en una pagina que es la basePge para que en las otras páginas podamos utilizar esas acciones sin volverlas a crear.
Después de crear las páginas se realizan los pasos de los escenarios de pruebas, esta lógica ira en los steps y en los stepDefinitions es donde se invoca los pasos que el runner tomara para ejecutar las pruebas, también agregamos cucumber al proyecto que es donde realizamos los escenarios con Gherkin, este lenguaje especifico de dominio que es nuestro conector con todo el equipo de desarrollo y de producto, ya que es una forma en el que todo el equipo entendera que se va a ejecutar la automatizacion.
Agregandole al proyecto la libreria Serenity, puesto que esta nos ayudara a le mejor forma de crear los escenarios de prueba y lo utilizamos para los reportes, puesto que nos da una gran información al momento de la ejecución y resultados de las pruebas para así finalizar cerrar el ciclo de la automatización 

## Estrutuctura del proyecto
Para la estructura del proyecto utilizamos maven y sus dependencias agregadas en el archivo pom.xml

![Screen Shot 2022-12-04 at 12 24 50 AM](https://user-images.githubusercontent.com/36672893/205475970-66c18260-7d73-43bf-a4c0-31605ef5881c.png)


## Escenario de prueba
Para los escenarios de pruebas que van en los features ponemos todos los escenarios en gherkin en esta ocasión hacemos una descripción de feature y los pasos del escenario.

```
@Netflix
Feature: Netflix
 I as a user
 I want to go www.netflix.com/co

 Scenario: Validate netflix
   Given that a user enters Netflix
   When the user validates the page title
   Then the system must be on netflix

```
## Pasos a Paso de los escenarios
Dentro de los steps y stepsDefinitions vamos a agregar todos los paso a paso de las pruebas, en estos dos procesos ponemos las indicaciones que creamos en el feature.
```
public class NetflixSteps {

   @Steps
   NetflixPage netflixPage;

   @Step
   public void openBrowser(){
       netflixPage.open();
   }

   @Step
   public void getCurrentUrl(){
       netflixPage.obtainTheCurrentUrl();
   }

   @Step
   public void getTitle(){
       netflixPage.setLblTittle();
       Assert.assertEquals("Validate title text", netflixPage.setLblTittle(),
               "Netflix Colombia: Ve series online, ve películas online");
   }

   @Step
   public void verifyUrlCurrent() {
       Assert.assertEquals("Validate the current Url", netflixPage.obtainTheCurrentUrl(),
               "https://www.netflix.com/co/");
   }
}


```
```
public class NetflixDefinitions {

   @Steps
   NetflixSteps netflixSteps;

   @Given("^that a user enters Netflix$")
   public void navigateToNetflix(){
       netflixSteps.openBrowser();
   }

   @When("^the user validates the page title$")
   public void validateTittle(){
       netflixSteps.getTitle();
   }

   @Then("^the system must be on netflix$")
   public void validateCurrentURL(){
       netflixSteps.getCurrentUrl();
       netflixSteps.verifyUrlCurrent();
   }

}


```
## BasePage
Dentro del patron de diseno page object model definimos una pagina base con todas las acciones generales y vamos defininedo cada pagina del proyecto, cabe aclara que en este caso no la declare ya que solo utilizamos una pagina y la extendimos de PageObject para utilizar la libreria de serenity, en esta pagina tambien debemos declarar los localizadores, para esta prueba no necesite de localizadores

```
public class NetflixPage  extends PageObject {

   public String setLblTittle() {
       waitFor(5000);
      return getDriver().getTitle();
   }

   /**
    * Extract the current url
    */
   public String obtainTheCurrentUrl() {
       setImplicitTimeout(5, SECONDS);
       return  getDriver().getCurrentUrl();
   }
}


```
## Reportes 

Al momento de correr el proyecto y este finaliza su ejecución con la integración de serenity hacemos uso de la forma en que hacen los reportes, estos reportes quedan en la carpeta target/site/serenity/index.html

<img width="1422" alt="Screen Shot 2022-12-04 at 12 23 09 AM" src="https://user-images.githubusercontent.com/36672893/205475920-1a42b462-5412-4839-8f61-8781c8a423b3.png">
<img width="1409" alt="Screen Shot 2022-12-04 at 12 23 29 AM" src="https://user-images.githubusercontent.com/36672893/205475929-c54644be-2d53-4bd0-9acd-72ab196e07b8.png">
<img width="1410" alt="Screen Shot 2022-12-04 at 12 23 55 AM" src="https://user-images.githubusercontent.com/36672893/205475946-c68564cd-41e9-4656-b9b0-0e27238d302c.png">

