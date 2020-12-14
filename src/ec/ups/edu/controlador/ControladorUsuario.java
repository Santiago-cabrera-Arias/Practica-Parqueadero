package ec.ups.edu.controlador;

import ec.ups.edu.modelo.Usuario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ControladorUsuario {

    private RandomAccessFile archivo;
    private int salto = 0;
    private int registro = 0;


    private static ControladorUsuario instancia;

    public static ControladorUsuario getInstancia(){

        if (instancia == null){

            instancia = new ControladorUsuario();

        }

        return instancia;

    }

    /*

    usuario = 15
    contrasena = 15
    tipoUsuario = 30

60+ 2 + 2 +2 =66

     */


    public ControladorUsuario() {

        try {
            archivo = new RandomAccessFile("usuario.txt","rw");
        } catch (IOException e) {
            System.out.println("Error de lectura y escritura.");
            e.printStackTrace();
        }

    }



    public void create(Usuario objeto){

        try {

            archivo.seek(archivo.length());
            archivo.writeUTF(objeto.getUsuario());
            archivo.writeUTF(objeto.getContrasena());
            archivo.writeUTF(objeto.getTipoUsuario());

        }catch(IOException ex){

            System.out.println("Error de lectura y escritura");
            ex.printStackTrace();

        }

    }

    public Usuario iniciarSesion(Usuario objeto){

        salto = 0;
        registro = 66;

        try {

            while (salto < archivo.length()){

            archivo.seek(salto);

            String usuarioDelArchivo =  archivo.readUTF().trim();
            String contrasenaDelArchivo = archivo.readUTF().trim();
            String tipoUsuarioArchivo = archivo.readUTF().trim();


                System.out.println(usuarioDelArchivo);
                System.out.println(contrasenaDelArchivo);
                System.out.println(tipoUsuarioArchivo);

                System.out.println(objeto.getUsuario());
                System.out.println(objeto.getContrasena());
                System.out.println(objeto.getTipoUsuario());


            if (usuarioDelArchivo.equals(objeto.getUsuario().trim()) && contrasenaDelArchivo.equals(objeto.getContrasena().trim()) &&
                    tipoUsuarioArchivo.equals(objeto.getTipoUsuario().trim())) {

                Usuario usuario1 = new Usuario(usuarioDelArchivo, contrasenaDelArchivo, tipoUsuarioArchivo);

                return usuario1;

              }

                salto += registro;

            }

        } catch (IOException exception) {

            System.out.println("Error de lectura y escritura.");
            exception.printStackTrace();
        }

           return null;

    }

}
