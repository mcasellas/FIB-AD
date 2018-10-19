# Desarrollo de la práctica
El servicio web SOAP tiene que proporcionar las funcionalidades de registro, modificación, listado y búsqueda implementadas en la Práctica 2.

En esta práctica no se pide que se puedan subir las imágenes al servidor, simplemente realizar inserciones, actualizaciones y consultas a la información almacenada en la base de datos.

Por simplicidad, vamos a utilizar la misma base de datos que en la Práctica 2, así que se puede reaprovechar el código de conexión, inserción y consulta.
El servicio web tiene que implementar, como mínimo, las siguientes operaciones:

- Registrar una imagen
- Modificar una imagen
- Listar imágenes
- Buscar una imagen por su identificador
- Buscar imágenes por título
- Buscar imágenes por fecha de creación
- Buscar imágenes por palabra clave
- Buscar imágenes por autor

Las cabeceras de estas operaciones son como se muestra a continuación:

```Java
/*
      Registrar una nueva imagen
*/
int RegisterImage (ImageWS image);
/*
      Modificar una imagen existente
*/
int ModifyImage (ImageWS image);
/*
      Listar las imágenes en el sistema
*/
List ListImages ();
/*
      Devuelve la imagen identificada por id
*/
ImageWS SearchbyId (int id);
/*
      Devuelve la lista de imágenes que contienen title en su título
*/
List SearchbyTitle (String title);
/*
      Devuelve la lista de imágenes de una fecha determinada
*/
List SearchbyCreaDate (String creaDate);
/*
      Devuelve la lista de imágenes de un usuario
*/
List SearchbyAuthor (String author);
/*
      Devuelve la lista de imágenes que contienen keywords en sus
      palabras clave
*/
List SearchbyKeywords (String keywords);
```

Para comprobar que el servicio web funciona correctamente desarrolla dos tipos distintos de aplicación cliente, una Aplicación Java y una nueva aplicación web.

## Trabajo adicional:

Para mejorar la nota de esta parte de la práctica, podéis implementar una operación que realice una búsqueda combinada, por ejemplo, por título y autor o por título y descripción.

## Entrega de la práctica:

Se tiene que entregar un documento con la respuesta a las cuestiones iniciales y el código del servicio web desarrollado. También se tiene que entregar un informe que explique brevemente el trabajo realizado y las ampliaciones desarrolladas.
