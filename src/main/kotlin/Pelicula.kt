class Pelicula constructor(codigo: Int, nombre: String, estrenada: Boolean, nota: Int) {

    val codigo: Int;
    var nombre: String;
    var estrenada: Boolean;
    var nota: Int;

    init {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estrenada = estrenada;
        this.nota = nota;
    }

    override fun toString() =
        if (this.estrenada) {
            "Código: $codigo - Nombre: $nombre - Nota: $nota";
        } else{
            "Código: $codigo - Nombre: $nombre - No estrenada";
        }
}