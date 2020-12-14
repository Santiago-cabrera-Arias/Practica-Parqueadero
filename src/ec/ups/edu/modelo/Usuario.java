package ec.ups.edu.modelo;

import java.util.Objects;

public class  Usuario {

    private String usuario;
    private String contrasena;
    private String tipoUsuario;

    public Usuario(String usuario, String contrasena,String tipoUsuario) {

        this.setUsuario(usuario);
        this.setContrasena(usuario);
        this.setTipoUsuario(tipoUsuario);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {

        this.usuario = validarEspacios(usuario,15);

    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {

        this.contrasena = validarEspacios(contrasena,15);
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {

        this.tipoUsuario = validarEspacios(tipoUsuario,30);

    }



    public String validarEspacios(String cadena,int numero ){

            if (cadena.length() == numero)
                return cadena;
            else if (cadena.length() > numero){
                return cadena.substring(0,numero);
            }else{
                for (int i = cadena.length();i < numero;i++){

                    cadena += " ";

                }
                return cadena;
            }

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario1 = (Usuario) o;
        return Objects.equals(getUsuario(), usuario1.getUsuario()) && Objects.equals(getContrasena(), usuario1.getContrasena()) && Objects.equals(getTipoUsuario(), usuario1.getTipoUsuario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsuario(), getContrasena(), getTipoUsuario());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                '}';
    }
}
