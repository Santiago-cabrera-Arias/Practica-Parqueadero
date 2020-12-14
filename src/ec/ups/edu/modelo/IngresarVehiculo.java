package ec.ups.edu.modelo;
import java.util.Date;
import java.util.Objects;

public class IngresarVehiculo {

    private String placa;
    private int espacioParqueadero;
    private String nombrePropietario;
    private String seleccionVehiculo;
    private String seleccionAver;
    private String marcaVehiculo;
    private String color;
    private Date fecha;
    private Date fechaSalida;


    public IngresarVehiculo() {

    }

    public IngresarVehiculo(String placa, String nombrePropietario, String seleccionVehiculo,String seleccionAver,String marcaVehiculo, String color,int espacioParqueadero,Date fechaInicio,Date fechaSalida) {


        this.setPlaca(placa);
        this.setNombrePropietario(nombrePropietario);
        this.setSeleccionVehiculo(seleccionVehiculo);
        this.setSeleccionAver(seleccionAver);
        this.setMarcaVehiculo(marcaVehiculo);
        this.setColor(color);
        this.espacioParqueadero = espacioParqueadero;
        this.fecha = fechaInicio;
        this.fechaSalida = fechaSalida;

    }

    public String validar(String cadena, int numero){

        if (cadena.length() == numero){

            return cadena;

        }else if (cadena.length() > numero){

            //si la tamanio de la cadena es menor a la cantidad que le damos

            cadena = cadena.substring(0,numero);

            return cadena;

        }else{

                for(int i = cadena.length();i< numero ;i++) {
                     cadena += " ";
                }
             }

        return  cadena;

        }


/*

PLACA = 6
NOMBRE PROPIETARIO = 20
SELECCION VEHICULO = 12\
SELECCION A VER = 15
MARCA = 20
COLOR  = 10
FECHA = 30
ESPACIO = 4

118 + 14 = 131 + 30


 */

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {

        this.placa = validar(placa,6);

    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = validar(nombrePropietario,20);
    }

    public String getSeleccionVehiculo() {
        return seleccionVehiculo;
    }

    public void setSeleccionVehiculo(String seleccionVehiculo) {
        this.seleccionVehiculo = validar(seleccionVehiculo,12);
    }

    public String getSeleccionAver() {
        return seleccionAver;
    }

    public void setSeleccionAver(String seleccionAver) {
        this.seleccionAver = validar(seleccionAver,15);
    }

    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public void setMarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = validar(marcaVehiculo,20);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = validar(color,10);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getEspacioParqueadero() {
        return espacioParqueadero;
    }

    public void setEspacioParqueadero(int espacioParqueadero) {
        this.espacioParqueadero = espacioParqueadero;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IngresarVehiculo)) return false;
        IngresarVehiculo that = (IngresarVehiculo) o;
        return getEspacioParqueadero() == that.getEspacioParqueadero() && Objects.equals(getPlaca(), that.getPlaca()) && Objects.equals(getNombrePropietario(), that.getNombrePropietario()) && Objects.equals(getSeleccionVehiculo(), that.getSeleccionVehiculo()) && Objects.equals(getSeleccionAver(), that.getSeleccionAver()) && Objects.equals(getMarcaVehiculo(), that.getMarcaVehiculo()) && Objects.equals(getColor(), that.getColor()) && Objects.equals(getFecha(), that.getFecha()) && Objects.equals(getFechaSalida(), that.getFechaSalida());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlaca(), getEspacioParqueadero(), getNombrePropietario(), getSeleccionVehiculo(), getSeleccionAver(), getMarcaVehiculo(), getColor(), getFecha(), getFechaSalida());
    }

    @Override
    public String toString() {
        return "IngresarVehiculo{" +
                "placa='" + placa + '\'' +
                ", espacioParqueadero=" + espacioParqueadero +
                ", nombrePropietario='" + nombrePropietario + '\'' +
                ", seleccionVehiculo='" + seleccionVehiculo + '\'' +
                ", seleccionAver='" + seleccionAver + '\'' +
                ", marcaVehiculo='" + marcaVehiculo + '\'' +
                ", color='" + color + '\'' +
                ", fecha=" + fecha +
                ", fechaSalida=" + fechaSalida +
                '}';
    }
}

