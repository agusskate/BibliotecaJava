//PARA CREAR LIBROS

public class Libros {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponibilidad;

public Libros(String titulo, String autor, String isbn, boolean disponibilidad){
    this.titulo = titulo;
    this.autor = autor;
    this.isbn = isbn;
    this.disponibilidad = disponibilidad;
    }

public String getTitulo() {
    return titulo;
}

public void setTitulo(String titulo) {
    this.titulo = titulo;
}

public String getAutor() {
    return autor;
}

public void setAutor(String autor) {
    this.autor = autor;
}

public String getIsbn() {
    return isbn;
}

public void setIsbn(String isbn) {
    this.isbn = isbn;
}

public boolean isDisponobilidad() {
    return disponibilidad;
}

public void setDisponobilidad(boolean disponibilidad) {
    this.disponibilidad = disponibilidad;
}   

//TOSTRING
@Override
    public String toString() {
        return "Título: " + titulo + "\n" +
               "Autor: " + autor + "\n" +
               "ISBN: " + isbn + "\n" +
               "Disponibilidad: " + (disponibilidad ? "Disponible" : "No disponible");
            //    Si disponibilidad es true, entonces la expresión devuelve "Disponible".
            //     Si disponibilidad es false, entonces la expresión devuelve "No disponible"
    }

}