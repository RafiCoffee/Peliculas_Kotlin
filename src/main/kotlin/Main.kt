
fun main(args: Array<String>) {
    val pelis: MutableMap<Int, Pelicula> = mutableMapOf();
    var contadorCodigo : Int = 0;
    var opcion: Int = 0;
    var nombre: String; var estrenada: Boolean; var nota: Int;


    do{
        println(Menu());
        opcion = readln().toInt();

        when(opcion){
            1 -> {
                pelis[contadorCodigo] = InsertarPelicula(contadorCodigo)
                println("Pelicula insertada correctamente")
                contadorCodigo++;
            };

            2 -> MostrarPeliculas(pelis);

            3 -> println(BuscarPelicula(pelis));

            4 -> BorrarPelicula(pelis);

            5 -> EditarPelicula(pelis);

            6 -> println("Saliendo del programa");

            else -> println("Opción no válida");
        }
    }while (opcion in 1..5 || opcion > 6);

}

fun Menu() = "-----Bienvenido al menu de el diccionario de peliculas-----\n\n" +
        "1. Insertar película\n" +
        "2. Mostrar películas\n" +
        "3. Buscar película\n" +
        "4. Borrar película\n" +
        "5. Editar película\n" +
        "6. Salir del programa";

fun MenuEditarNoEstrenada() = "-----Bienvenido al menu de edición de películas-----\n\n" +
        "1. Cambiar nombre\n" +
        "2. Se ha estrenado la película\n" +
        "3. Salir del menu"

fun MenuEditarEstrenada() = "-----Bienvenido al menu de edición de películas-----\n\n" +
        "1. Cambiar nombre\n" +
        "2. Cambiar nota\n" +
        "3. Salir del menu"

fun InsertarPelicula (codigo: Int): Pelicula{
    var pEstrenada: String = "";
    val estrenada: Boolean;
    var nota: Int = 0;

    println("Inserta el nombre de la película")
    val nombre: String = readln();

    while (pEstrenada != "S" && pEstrenada != "N"){
        println("¿La película ya esta estrenada? S/N")
        pEstrenada = readln();

        if(pEstrenada != "S" && pEstrenada != "N"){
            println("Respuesta no válida")
        }
    }
    if(pEstrenada == "S"){
        estrenada = true;

        do{
            println("Inserta la nota que tiene la película del 0 al 5")
            nota = readln().toInt();

            if(nota < 0 || nota > 5){
                println("Nota no válida")
            }
        }while(nota < 0 || nota > 5);

        val p: Pelicula = Pelicula(codigo, nombre, estrenada, nota);
        return p;
    }else{
        estrenada = false;

        val p: Pelicula = Pelicula(codigo, nombre, estrenada, nota);
        return p;
    }
}

fun MostrarPeliculas (pelis: MutableMap<Int, Pelicula>){
    pelis.forEach(){
        println(pelis[it.key].toString())
    }
}

fun BuscarPelicula (pelis: MutableMap<Int, Pelicula>): String{
    var codigo: Int = 0;
    do{
        println("Inserta un código para buscar la película");
        codigo = readln().toInt();

        if(codigo < 0 || codigo > pelis.size){
            println("Código no válido")
        }
    }while(codigo < 0 || codigo > pelis.size);

    return pelis[codigo].toString();

}

fun BorrarPelicula (pelis: MutableMap<Int, Pelicula>){
    var codigo: Int = 0;
    do{
        println("Inserta un código para borrar una película");
        codigo = readln().toInt();

        if(codigo < 0 || codigo > pelis.size){
            println("Código no válido")
        }
    }while(codigo < 0 || codigo > pelis.size);

    pelis.remove(codigo);

    println("Película borrada correctamente");
}

fun EditarPelicula (pelis: MutableMap<Int, Pelicula>){
    var codigo: Int = 0;
    var opcion: Int = 0;
    var nombre: String = "";
    var nota: Int = 0;
    do{
        println("Inserta un código para editar la película");
        codigo = readln().toInt();

        if(codigo < 0 || codigo > pelis.size){
            println("Respuesta no válida")
        }
    }while(codigo < 0 || codigo > pelis.size);

    if(!pelis[codigo]!!.estrenada){
        do{
            println(MenuEditarNoEstrenada());
            opcion = readln().toInt();
            when(opcion){
                1 -> {
                    println("Introduce un nuevo nombre");
                    nombre = readln();
                    pelis[codigo]!!.nombre = nombre;
                }

                2 -> {
                    if(pelis[codigo]!!.estrenada){
                        println("Está película ya esta estrenada");
                    }else{
                        pelis[codigo]!!.estrenada = true;

                        println("Introduce una nueva nota");
                        nota = readln().toInt();
                        pelis[codigo]!!.nota = nota;
                    }
                }

                3 -> println("Saliendo del menu");

                else -> println("Opción no válida");
            }
        }while(opcion == 1 || opcion > 3);
    }else{
        do{
            println(MenuEditarEstrenada());
            opcion = readln().toInt();
            when(opcion){
                1 -> {
                    println("Introduce un nuevo nombre");
                    nombre = readln();
                    pelis[codigo]!!.nombre = nombre;
                }

                2 -> {
                    println("Introduce una nueva nota");
                    nota = readln().toInt();
                    pelis[codigo]!!.nota = nota;
                }

                3 -> println("Saliendo del menu");
            }
        }while(opcion in 1..2 || opcion > 3);
    }
}