import java.util.ArrayList;
//PARA CREAR USUARIOS

import javax.print.DocFlavor.STRING;

public class Usuarios {
private String nombre;
private String apellido;
private int telefono;
private String email;
//este es un array dinamico, que cambia segun queramos su tamaño
private ArrayList<Libros>librosPendientesDevolver = new ArrayList<>();

//METODO AGREGAR LIBROS A LA LISTA DE LIBROS PENDIENTES  DEL USUARIO
public  void agregarLibro(Libros libro){
    librosPendientesDevolver.add(libro);
}

//"CONVERTIR ARRAY EN STRING" 
public String mostrarLIbroPendiente(){
    String LibrospendientesMostrarMenu = "";
    for(Libros libroPendiente : librosPendientesDevolver){
        LibrospendientesMostrarMenu += 
        "Titulo: " + libroPendiente.getTitulo() + "\n";
        // "Autor: " +  libroPendiente.getAutor() + "\n" +
        // "Isbn: " + libroPendiente.getIsbn() + "\n" ;
     }
     return LibrospendientesMostrarMenu;
}
 

//CONVERTIR CON .TOSTRING
// public String mostrarLibrosPendientes() {
//     StringBuilder librosPendientesMostrarMenu = new StringBuilder();
//     for (Libros libroPendiente : librosPendientesDevolver) {
//         librosPendientesMostrarMenu.append("Título: ").append(libroPendiente.getTitulo()).append("\n")
//                                    .append("Autor: ").append(libroPendiente.getAutor()).append("\n")
//                                    .append("ISBN: ").append(libroPendiente.getISBN()).append("\n")
//                                    .append("Disponibilidad: ").append(libroPendiente.isDisponible() ? "Disponible" : "No disponible").append("\n\n");
//     }
//     return librosPendientesMostrarMenu.toString();
// }
//
// public String mostrarLIbrosPendientes(){
//     return librosPendientesDevolver.toString();
// }

public Usuarios(String nombre, String apellido, int telefono, String email){
    this.nombre = nombre;
    this.apellido =apellido;
    this.email = email;
    this.telefono =telefono;

}


public String getNombre() {
    return nombre;
}


public void setNombre(String nombre) {
    this.nombre = nombre;
}


public String getApellido() {
    return apellido;
}


public void setApellido(String apellido) {
    this.apellido = apellido;
}


public int getTelefono() {
    return telefono;
}


public void setTelefono(int telefono) {
    this.telefono = telefono;
}


public String getEmail() {
    return email;
}


public void setEmail(String email) {
    this.email = email;
}


public ArrayList<Libros> getLibrosPendientesDevolver() {
    return librosPendientesDevolver;
}


public void setLibrosPendientesDevolver(ArrayList<Libros> librosPendientesDevolver) {
    this.librosPendientesDevolver = librosPendientesDevolver;
}

//METODO TOSTRING
    // public String toString() {
    //     return "Nombre: " + nombre + "\n" +
    //            "Apellido: " + apellido + "\n" +
    //            "Teléfono: " + telefono + "\n" +
    //            "Email: " + email + "\n" +
    //            "Libros pendientes:\n" + mostrarLibrosPendientes() + "\n";
    // }

}