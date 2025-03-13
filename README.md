# tienda-en-java
Tienda de renta de peliculas tipo BlockBuster en Java

Antes de iniciar el programa, revisar los archivos de texto en la carpeta "Archivos" para conocer los valores preestablecidos para realizar una simulacion de renta. Esto es, revisar los datos de usuario con los que se ingresara al menu principal y revisar los datos de los productos a rentar.

Para ejecutar la aplicación, solo se debe ingresar a la carpeta "src", luego a "PIA" y ejecutar el archivo "Main.java" como una aplicación de Java.

Existe un error al momento de crear un ticket de venta que, una vez terminada la aplicación, no permite iniciarla de nuevo, ya que se detecta un error en el archivo de "Clientes.txt" que no permite la lectura adecuada del mismo. Es necesario abrir el archivo y modificarlo para dejarlo de la siguiente forma: 

001	Claudia Vazquez	8181808081	P_101,S_203
002	Manuel Gausin	8181808881	P_101,S_201,V_302
003	Lucia Rojas	8180818081	S_201

Esto permitira nuevamente iniciar la aplicación, pero desafortunadamente se tiene que realizar cada vez.
