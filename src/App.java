import java.util.ArrayList;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        
        //DECLARACION USUARIOS
        Usuarios usuario1 = new Usuarios("David", "Alonso", 123456, "david@gmail.com");
        Usuarios usuario2 = new Usuarios("Gus", "Mes", 54321, "gus@gmail.com");
        Usuarios usuario3 = new Usuarios("Paola", "nuni", 567890, "paola@gmail.com");
        //LISTA USUARIOS
        ArrayList<Usuarios>Lista_usuarios = new ArrayList<>();
        //AGREGAR USUARIOS
        Lista_usuarios.add(usuario1);
        Lista_usuarios.add(usuario2);
        Lista_usuarios.add(usuario3);


        //DECLARACION LIBROS
        Libros libro1 = new Libros("El cid", "Pedrito s.", "S23123", true);
        Libros libro2 = new Libros("Sancho adventure", "Leo Messi s.", "G78989", true);
        Libros libro3 = new Libros("El meu deus", "Pedrito camela.", "I8273", true);
        //LISTA LIBROS
        ArrayList<Libros>lista_libros_totales = new ArrayList<>();
        //AGREGAR LIBROS
        lista_libros_totales.add(libro1);
        lista_libros_totales.add(libro2);
        lista_libros_totales.add(libro3);


        //METODO AGREGAR LIBROS PENDIENTES EN USUARIOS
        //usuario1.agregarLibro(libro1);
        //usuario2.agregarLibro(libro2);

        
 
        
        String panel = "";
        while (!panel.equals("6")) {
            panel = JOptionPane.showInputDialog
            (
                "1. Consultar usuarios\n" +
                "2. Consultar libros del catalogo\n" +
                "3. Consultar libros pendientes\n" +
                "4. Pedir un libro (para usuario) \n"+
                "5. Devolver un libro (para usuario)\n"
            );

            switch (panel) {
                //Consultar usuarios
                case "1":
                //segun el nombre de usuario muestre la info del mismo
                String infoUsuario = "";
                String nombreUsuario = JOptionPane.showInputDialog("Ingrese el nombre del usuario a consultar");
                boolean usuarioEncontrado = false;
                
                for (Usuarios usuario : Lista_usuarios) {
                    if (usuario.getNombre().equals(nombreUsuario)) {
                        infoUsuario = "Nombre " + usuario.getNombre() + "\n" +
                                      "Apellido " + usuario.getApellido() + "\n" +
                                      "Telefono " + usuario.getTelefono() + "\n" +
                                      "Email " + usuario.getEmail() + "\n" +
                                      "Libros pendientes\n" + usuario.mostrarLIbroPendiente() + "\n";
                        usuarioEncontrado = true;
                        break;
                    }
                }
                
                if (!usuarioEncontrado) {
                    JOptionPane.showMessageDialog(null, "No se encontró el usuario");
                } else {
                    JOptionPane.showMessageDialog(null, infoUsuario);
                }
                     break;

                    //Mostrar libros disponibles
                    case "2":
                    for(Libros libro : lista_libros_totales){
                        if(libro.isDisponobilidad() == true )
                        JOptionPane.showMessageDialog(null, libro.toString());
                    }
                    break;


                    //MOSTRAR LIBROS PENDIENTES DE CADA USUARIO
                    case"3":
                        String usuarioSeleccionado = JOptionPane.showInputDialog("Ingrese el nombre de usuario para ver los libros sin devolver");
                        for(Usuarios usuario : Lista_usuarios){
                        if(usuario.getNombre().equalsIgnoreCase(usuarioSeleccionado)){
                            JOptionPane.showMessageDialog(null, usuario.getLibrosPendientesDevolver());
                            break;
                        }
                    }

                    case "4":
                    //PEDIR UN LIBRO PARA EL  USUARIO
                    boolean usuarioAcertado = false;
                    String usuarioSeleccionado2 = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
                    for (Usuarios usuarios : Lista_usuarios){
                        
                        if(usuarios.getNombre().equalsIgnoreCase(usuarioSeleccionado2)){
                            usuarioAcertado = true;
                            String libroQuePido = JOptionPane.showInputDialog("Indique que libro quiere llevarse");

                            boolean libroAcertado = false;
                            for(Libros libro : lista_libros_totales){
                                if(libro.getTitulo().equalsIgnoreCase(libroQuePido) && libro.isDisponobilidad()==true){
                                    libroAcertado = true;
                                    lista_libros_totales.remove(libro);
                                    usuarios.agregarLibro(libro);
                                    JOptionPane.showMessageDialog(null, usuarioSeleccionado2 + " Has añadido tu libro a tu cesta");
                                    break;
                                } 
                            }
                            if(!libroAcertado){
                                JOptionPane.showMessageDialog(null, "Libro no encontrado");
                            }
                        } 
                        
                        }
                        if (!usuarioAcertado) {
                            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                    }                                     
                    break;

                    case "5":
                    boolean usuarioCorrecto = false;
                    String usuarioSeleccionado3 = JOptionPane.showInputDialog("Ingrese el nombre del usuario que quiera devolver un libro: ");
                    
                    for (Usuarios usuarios : Lista_usuarios){
                        if (usuarioSeleccionado3.equalsIgnoreCase(usuarios.getNombre())){
                            usuarioCorrecto = true;

                            String libroAcertado = JOptionPane.showInputDialog("Ingrese el libro que quiere devolver: ");
                            boolean libroCorrecto = false;

                            for (Libros libroDevolver : usuarios.getLibrosPendientesDevolver()){
                                if(libroDevolver.getTitulo().equalsIgnoreCase(libroAcertado)){
                                    libroCorrecto = true;
                                    usuarios.getLibrosPendientesDevolver().remove(libroDevolver);
                                    lista_libros_totales.add(libroDevolver);
                                    JOptionPane.showMessageDialog(null, "El libro " + libroDevolver + " \n Se ha devuelto correctamente");
                                    break;
                                }
                            }
                        }
                    }

                }
           
            }
