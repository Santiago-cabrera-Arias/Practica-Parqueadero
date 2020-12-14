package ec.ups.edu.vista;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.zugferd.checkers.basic.DateFormatCode;
import ec.ups.edu.controlador.ControladorIngresarVehiculo;
import ec.ups.edu.modelo.IngresarVehiculo;
import ec.ups.edu.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class VentanaRetirarVehiculo {

    ControladorIngresarVehiculo controladorIngresarVehiculo;
    IngresarVehiculo ingresarVehiculo;

    public VentanaRetirarVehiculo() {

        this.controladorIngresarVehiculo = controladorIngresarVehiculo.getInstancia();

    }

    @FXML
        private Button btnRetirar;

        @FXML
        private TextField txtPlaca;

        @FXML
        private Button btnAtras;

        @FXML
        private TextField txtHoraEntrada;

        @FXML
        private TextField txtValorAPagar;

        @FXML
        private DatePicker pickerCalendar;

        @FXML
        private Button btnBuscar;

        @FXML
        private Button btnCalcular;

        @FXML
        void EventoBuscar(ActionEvent event) {

            String placa = txtPlaca.getText();

            if (placa.isEmpty()){

                JOptionPane.showMessageDialog(null,"Llene el campo ");

            }else{

                IngresarVehiculo ingresarVehiculo = controladorIngresarVehiculo.read(placa);

                if (ingresarVehiculo != null){

                    txtHoraEntrada.setText(ingresarVehiculo.getFecha()+"");

                    this.ingresarVehiculo = ingresarVehiculo;

                }

            }

        }


        IngresarVehiculo i = new IngresarVehiculo();

        @FXML
        void EventoCalcular(ActionEvent event) {

            double precio = 0;

            String fechaSalida = txtPlaca.getText();
            String fechaInicio = txtHoraEntrada.getText();


            DateFormat fechaFormato = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'COT' yyyy", Locale.ENGLISH);
            Date fechaIn = null;

            try {

                fechaIn = fechaFormato.parse(fechaInicio);

            } catch (ParseException exception) {

                exception.printStackTrace();

            }



            DateFormat fechaSal = new SimpleDateFormat("YYYY-MM-dd");
            Date fechaSali = null;

            try {

                fechaSali = fechaSal.parse(pickerCalendar.getValue()+"");

            } catch (ParseException exception) {

                exception.printStackTrace();

            }

           int anioI = fechaIn.getYear()*365;
           int mesI = fechaIn.getYear()*30;
           int diaI = fechaIn.getDay();

            System.out.println(pickerCalendar.getValue());

           int anioS = fechaSali.getYear()*365;
           int mesS = fechaSali.getMonth()*30;
           int diaS = fechaSali.getDay();

           int DatoI = anioI+mesI+diaI;
           int DatoS = anioS+mesS+diaS;

           int fin =  DatoI-DatoS;

           int tiempo = fin;

           precio = tiempo * 1.0;

           txtValorAPagar.setText(precio+"");


        }

        @FXML
        void EventoRetirar(ActionEvent event) {

            String placa = txtPlaca.getText();
            String fechaInicio = txtHoraEntrada.getText();
            String fechaSalida = txtPlaca.getText();
            String valorACalcular = txtValorAPagar.getText();

            DateFormat fechaFormato = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'COT' yyyy", Locale.ENGLISH);
            Date fechaIn = null;

            try {

                fechaIn = fechaFormato.parse(fechaInicio);

            } catch (ParseException exception) {

                exception.printStackTrace();

            }

            DateFormat fechaSal = new SimpleDateFormat("YYYY-MM-dd");
            Date fechaSali = null;

            try {

                fechaSali = fechaSal.parse(pickerCalendar.getValue()+"");

            } catch (ParseException exception) {

                exception.printStackTrace();

            }

            if (placa.isEmpty() || fechaInicio.isEmpty() || fechaSalida.isEmpty() || valorACalcular.isEmpty()){

                JOptionPane.showMessageDialog(null,"Llene los campos");

            }else {

               IngresarVehiculo ingresarVehiculo = new IngresarVehiculo(placa,this.ingresarVehiculo.getNombrePropietario(),
                       this.ingresarVehiculo.getSeleccionVehiculo(),"Retirado",this.ingresarVehiculo.getMarcaVehiculo(),this.ingresarVehiculo.getColor(),this.ingresarVehiculo.getEspacioParqueadero(),fechaIn,fechaSali);

               boolean cent = controladorIngresarVehiculo.update(ingresarVehiculo);

               if (cent){


                   Document document = new Document();

                   try {

                       PdfWriter.getInstance(document, new FileOutputStream("documento.pdf"));
                       document.open();
                       document.add(new Paragraph("FACTURA EMOV-EC"));
                       document.add(new Paragraph("------------------------"));
                       document.add(new Paragraph("Placa Vehiculo: " + placa));
                       document.add(new Paragraph("Tipo Vehiculo: "+this.ingresarVehiculo.getSeleccionVehiculo()));
                       document.add(new Paragraph("Nombre Propietario: " + this.ingresarVehiculo.getNombrePropietario()));
                       document.add(new Paragraph("Ingresa Vehiculo: " + this.ingresarVehiculo.getMarcaVehiculo()));
                       document.add(new Paragraph("Color : " + this.ingresarVehiculo.getColor()));
                       document.add(new Paragraph("Espacio parqueadero : " + this.ingresarVehiculo.getEspacioParqueadero()));
                       document.add(new Paragraph("fecha Ingreso: " + fechaInicio));
                       document.add(new Paragraph("fecha Salida: " + fechaSalida));
                       document.add(new Paragraph("Valor pago : " + valorACalcular));

                   } catch (DocumentException e) {
                       e.printStackTrace();
                   } catch (FileNotFoundException e) {
                       e.printStackTrace();
                   } finally {

                       document.close();

                   }



                JOptionPane.showMessageDialog(null,"Se ha actualizado correctamente");

               }else{

                   JOptionPane.showMessageDialog(null,"No se ha podido actualizar");

               }

            }


        }


    public void EventoAtras(ActionEvent actionEvent) {

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaEleccion.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.btnAtras.getScene().getWindow();
            myStage.close();

        }catch (IOException exception){

            System.out.println("Error de lectura y escritura");
            exception.printStackTrace();

        }

    }
}
