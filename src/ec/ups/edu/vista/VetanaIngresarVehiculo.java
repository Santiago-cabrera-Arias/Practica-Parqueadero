package ec.ups.edu.vista;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import ec.ups.edu.controlador.ControladorIngresarVehiculo;
import ec.ups.edu.modelo.IngresarVehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class VetanaIngresarVehiculo implements Initializable {

    public TextField txtPlaca;
    public TextField txtNombrePropietario;
    public Button btnRegistrar;
    public ComboBox comboVehiculos;
    public DatePicker PickerFecha;
    public Button btnAtras;
    public TextField txtMarcaVehiculo;
    public TextField txtEspacioParqueadero;
    public TextField txtColorCoche;
    public TextField txtFechaIngreso;
    public ComboBox comboVehiculos1;


    ControladorIngresarVehiculo controladorIngresarVehiculo;



    //propio de JavaFx es como un arrayList
    private ObservableList<IngresarVehiculo> lista;//esta lista le vamos setiando a la tabla.



    IngresarVehiculo i;

    public VetanaIngresarVehiculo(){

        controladorIngresarVehiculo = controladorIngresarVehiculo.getInstancia();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

         ObservableList<String> list = FXCollections.observableArrayList("Automovil","Motocicleta");
         ObservableList<String> listax = FXCollections.observableArrayList("Parqueo ","Arrendamiento","Reservacion");
        //aniadimos los datos al combo box.
        comboVehiculos.setItems(list);
        comboVehiculos1.setItems(listax);

    }



    public void EventoBotonRegistrar(ActionEvent actionEvent) {


        String nombrePropietario = txtNombrePropietario.getText();
        String placa = txtPlaca.getText();
        String seleccionVehiculo = (String) comboVehiculos.getSelectionModel().getSelectedItem();
        String color = txtColorCoche.getText();
        String marcaVehiculo = txtMarcaVehiculo.getText();
        String fechaInicio = txtFechaIngreso.getText();
        Date fechaI = controladorIngresarVehiculo.fechaInicial();
        String seleccionAver = (String) comboVehiculos1.getSelectionModel().getSelectedItem();


        //Date fechaI = controladorIngresarVehiculo.fechaInicial();
        int espacio = Integer.parseInt(txtEspacioParqueadero.getText());


        int opcion = JOptionPane.showConfirmDialog(null, "Quiere generar una factura?");

        if (nombrePropietario.isEmpty() || placa.isEmpty() || seleccionVehiculo.isEmpty() ||
                color.isEmpty() || marcaVehiculo.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Llene los campos");

        } else {

            if (espacio <= 50) {

                txtFechaIngreso.setText(fechaI + "");
                IngresarVehiculo ingresarVehiculo = new IngresarVehiculo(placa, nombrePropietario, seleccionVehiculo,seleccionAver, marcaVehiculo, color,espacio,fechaI,null);
                System.out.println(ingresarVehiculo);
                controladorIngresarVehiculo.create(ingresarVehiculo);

                JOptionPane.showMessageDialog(null, "Se ha registrado con exito");

                if (opcion == JOptionPane.YES_OPTION) {

                    Document document = new Document();

                    try {

                        PdfWriter.getInstance(document, new FileOutputStream("documento.pdf"));
                        document.open();
                        document.add(new Paragraph("FACTURA EMOV-EC"));
                        document.add(new Paragraph("------------------------"));
                        document.add(new Paragraph("Espacio Estacionamiento: " + espacio));
                        document.add(new Paragraph("Placa Vehiculo: " + placa));
                        document.add(new Paragraph("Nombre propietario: " + nombrePropietario));
                        document.add(new Paragraph("Tipo Vehiculo: " + seleccionVehiculo));
                        document.add(new Paragraph("Marca del Vehiculo : " + marcaVehiculo));
                        document.add(new Paragraph("Color Vehiculo: " + color));
                        document.add(new Paragraph("Fecha Ingreso Vehiculo: " + fechaI));

                    } catch (DocumentException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } finally {

                        document.close();

                    }
                }
            }else{

                JOptionPane.showMessageDialog(null,"No existe el espacio ingresado");

            }
        }




    }

    public void EventoBotonAtras(ActionEvent actionEvent) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaEleccion.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.btnAtras.getScene().getWindow();
            myStage.close();



        }catch (IOException exception){

            exception.printStackTrace();


        }


    }
}
