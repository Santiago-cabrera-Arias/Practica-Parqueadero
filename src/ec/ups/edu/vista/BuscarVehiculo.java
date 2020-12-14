package ec.ups.edu.vista;

import ec.ups.edu.controlador.ControladorIngresarVehiculo;
import ec.ups.edu.modelo.IngresarVehiculo;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.util.Date;

public class BuscarVehiculo {
    public Button btnBuscar;
    public TextField txtNombrePropietario;
    public TextField txtSeleccionVehiculo;
    public TextField txtMarcaVehiculo;
    public TextField txtColor;
    public TextField txtFecha;
    public TextField txtEspacioParqueadero;
    public TextField txtBuscarPlaca;
    public Button btnActualizar;

    ControladorIngresarVehiculo controladorIngresarVehiculo;

    public BuscarVehiculo(){

        controladorIngresarVehiculo = controladorIngresarVehiculo.getInstancia();

    }


    public void EventoBuscar(ActionEvent actionEvent) {

        String placa = txtBuscarPlaca.getText();

        if (placa.isEmpty()){

            JOptionPane.showMessageDialog(null,"Llene el campo");

        }else{

            IngresarVehiculo ingresar  = controladorIngresarVehiculo.read(placa);

            if (ingresar != null){

                txtNombrePropietario.setText(ingresar.getNombrePropietario());
                txtSeleccionVehiculo.setText(ingresar.getSeleccionVehiculo());
                txtMarcaVehiculo.setText(ingresar.getMarcaVehiculo());
                txtColor.setText(ingresar.getColor());
                txtFecha.setText(ingresar.getFecha()+"");
                txtEspacioParqueadero.setText(ingresar.getEspacioParqueadero()+"");

                System.out.println(ingresar);

            }else {

                JOptionPane.showMessageDialog(null,"No se encuentra esos datos");

            }

        }

    }

}
