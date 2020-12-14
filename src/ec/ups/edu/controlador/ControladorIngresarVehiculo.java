package ec.ups.edu.controlador;


import ec.ups.edu.modelo.IngresarVehiculo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ControladorIngresarVehiculo extends ControladorAbstracto<IngresarVehiculo> {

    /*
     placa; = 6
     nombrePropietario; 20
     rbMotocicleta;  11
     rbAutomovil; = 9

    46 + 2 + 2 + 2 + 2 =  54

    */

    private RandomAccessFile archivo;
    private int salto = 0;
    private int registro = 0;


    private static ControladorIngresarVehiculo instancia;

    public static ControladorIngresarVehiculo getInstancia() {

        if (instancia == null) {

            instancia = new ControladorIngresarVehiculo();

        }

        return instancia;

    }


    IngresarVehiculo i = new IngresarVehiculo();

    public ControladorIngresarVehiculo() {

        try {

            archivo = new RandomAccessFile("ingresarVehiculo.txt", "rw");

        } catch (IOException exception) {

            System.out.println("Error de lectura y escritura.");
            exception.printStackTrace();

        }

    }


    public Date fechaInicial(){

        Date fecha = new Date();
        return fecha;

    }

    public Date fechaC(String fecha1){

        DateFormat fechaFormato = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'COT' yyyy", Locale.ENGLISH);
        Date fechax = null;

        if (fecha1.trim().equals("")){

            return null;

        }

        System.out.println(fecha1);

        try{

            fechax = fechaFormato.parse(fecha1);
            System.out.println(fecha1);

        }catch (ParseException exception){

           exception.printStackTrace();

        }

        return fechax;

    }

    public String validarFechaSalida(Date fechaSalida){

        String  hola = "";
        if (fechaSalida == null){
            for(int i = 0;  i<28;i++){

                hola += " ";
            }

        }else{
            hola = fechaSalida+"";
        }
        return hola;


    }


    @Override
    public void create(IngresarVehiculo objeto) {

        try {

            archivo.seek(archivo.length());
            archivo.writeUTF(objeto.getPlaca());
            archivo.writeUTF(objeto.getNombrePropietario());
            archivo.writeUTF(objeto.getSeleccionVehiculo());
            archivo.writeUTF(objeto.getColor());
            archivo.writeUTF(objeto.getMarcaVehiculo());
            archivo.writeInt(objeto.getEspacioParqueadero());
            archivo.writeUTF(objeto.getSeleccionAver());
            archivo.writeUTF(objeto.getFecha()+"");
            archivo.writeUTF(validarFechaSalida(objeto.getFechaSalida()));


        } catch (IOException exception) {

            System.out.println("Error de lectura y escritura.");
            exception.printStackTrace();
        }

    }

    @Override
    public IngresarVehiculo read(String placa) {

        registro = 159;
        salto = 0;

        try {

            while (salto < archivo.length()) {

                archivo.seek(salto);
                String placaArchivo = archivo.readUTF().trim();

                    if (placaArchivo.equals(placa)) {

                        String nombre = archivo.readUTF();
                        String seleccionVehiculo = archivo.readUTF();
                        String color = archivo.readUTF();
                        String marca = archivo.readUTF();
                        int espacio = archivo.readInt();
                        String seleccionAver = archivo.readUTF();
                        Date fecha = fechaC(archivo.readUTF());
                        Date fechaSalida = fechaC(archivo.readUTF());

                        IngresarVehiculo ingresarVehiculo = new IngresarVehiculo(placaArchivo,nombre,seleccionVehiculo,seleccionAver,
                                marca,  color, espacio,fecha,fechaSalida);

                        return ingresarVehiculo;


                }

                salto += registro;

            }

            }catch(IOException ex){

                System.out.println("Error de lectura y escritura.");
                ex.printStackTrace();

            }

        return null;

        }




    @Override
    public boolean update(IngresarVehiculo objeto) {

        salto = 0;
        registro = 159;

        try{

            while (salto < archivo.length()){

                archivo.seek(salto);
                String placaDelArchivo = archivo.readUTF();

                System.out.println(placaDelArchivo);

                System.out.println(objeto.getPlaca());



                if (placaDelArchivo.equals(objeto.getPlaca())){

                    archivo.seek(salto);
                    archivo.writeUTF(placaDelArchivo);

                    archivo.writeUTF(objeto.getNombrePropietario());
                    archivo.writeUTF(objeto.getSeleccionVehiculo());
                    archivo.writeUTF(objeto.getColor());
                    archivo.writeUTF(objeto.getMarcaVehiculo());
                    archivo.writeUTF(objeto.getEspacioParqueadero()+"");
                    archivo.writeUTF(objeto.getSeleccionAver());
                    archivo.writeUTF(objeto.getFecha()+"");
                    archivo.writeUTF(validarFechaSalida(objeto.getFechaSalida()));

                    return true;


                }

                salto += registro;

            }

        }catch (IOException ex){

            System.out.println("Error de lectura y escritura.");
            ex.printStackTrace();

        }

        return false;

    }

    @Override
    public void delete(IngresarVehiculo objeto) { }





    @Override
    public List<IngresarVehiculo> findAll() {

       List<IngresarVehiculo> lista = new ArrayList<>();

        salto = 0;
        registro = 159;

        try {

            while (salto < archivo.length()) {

                archivo.seek(salto);
                String placaArchivo = archivo.readUTF().trim();

                if (!placaArchivo.equals("")){

                    /*PLACA = 6
                    NOMBRE PROPIETARIO = 20
                    SELECCION VEHICULO = 12\
                    SELECCION A VER = 15
                    MARCA = 20
                    COLOR  = 10
                    FECHA = 30
                    ESPACIO = 4

                    129*/


                    String nombre = archivo.readUTF();
                    String seleccionVehiculo = archivo.readUTF();
                    String color = archivo.readUTF();
                    String marca = archivo.readUTF();
                    int espacio = archivo.readInt();
                    String seleccionAver = archivo.readUTF();
                    Date fecha = fechaC(archivo.readUTF());
                    Date fechaSalida = fechaC(archivo.readUTF());


                    System.out.println(nombre);
                    System.out.println(seleccionAver);
                    System.out.println(seleccionVehiculo);
                    System.out.println(marca);
                    System.out.println(color);
                    System.out.println(fecha);
                    System.out.println(espacio);
                    System.out.println(fechaSalida);


                    IngresarVehiculo ingresarVehiculo = new IngresarVehiculo(placaArchivo,nombre,seleccionVehiculo,seleccionAver,
                             marca,  color, espacio,fecha,fechaSalida);

                     lista.add(ingresarVehiculo);

                }

                salto += registro;

            }


        } catch (IOException exception) {

            System.out.println("Error de lectura y escritura.");
            exception.printStackTrace();

        }

        return lista;



    }


}
