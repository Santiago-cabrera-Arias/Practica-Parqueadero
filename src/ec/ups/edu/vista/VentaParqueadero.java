package ec.ups.edu.vista;

import ec.ups.edu.controlador.ControladorIngresarVehiculo;
import ec.ups.edu.images.ControladorImagenes;
import ec.ups.edu.modelo.IngresarVehiculo;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class VentaParqueadero implements Initializable {

    public Pane visualizarEstacionamiento;
    public Button btnRegresar;

    ControladorIngresarVehiculo controladorIngresarVehiculo;
    ControladorImagenes controladorImagenes;

    public VentaParqueadero() {

        this.controladorIngresarVehiculo = controladorIngresarVehiculo.getInstancia();

        this.controladorImagenes = new ControladorImagenes();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        vistaParqueadero();


    }

    GridPane pane = new GridPane();


    public void vistaParqueadero() {

        List<IngresarVehiculo> lista = controladorIngresarVehiculo.findAll();

        System.out.println(lista);

        Label label1 = null;
        int cont = 1;

        //filas
        for (int i = 0; i < 5; i++) {
            //columnas
            for (int j = 0; j < 10; j++) {

                boolean controlador = false;

                label1 = new Label();
                label1.setText(" " + cont + " ");
                label1.setPrefSize(150, 40);

                for(IngresarVehiculo lista1 : lista){

                    if (lista1.getEspacioParqueadero() == cont){

                        controlador = true;

                        switch (lista1.getSeleccionAver().trim()){

                            case "Parqueo":

                                label1.setGraphic(new ImageView(controladorImagenes.imagenCoche()));


                                break;

                            case "Arrendamiento":


                                label1.setGraphic(new ImageView(controladorImagenes.imagenArrendar()));

                                break;

                            case "Reservacion":

                                label1.setGraphic(new ImageView(controladorImagenes.imgenEspacioReservado()));

                                break;

                            case "Retirado":

                                label1.setGraphic(new ImageView(controladorImagenes.imagenEspaciosLibres()));

                                break;

                            default:
                                JOptionPane.showMessageDialog(null,"No existe esa opcion.");

                        }
                    }
                }

                if (controlador != true){

                    label1.setGraphic(new ImageView( controladorImagenes.imagenEspaciosLibres()));

                }

                    GridPane.setConstraints(label1, i, j);
                    pane.getChildren().add(label1);
                    cont++;


                }

            }

            pane.setGridLinesVisible(true);
            visualizarEstacionamiento.getChildren().add(pane);

        }

    public void EventoBotonRegresar(ActionEvent actionEvent) {

        Stage stage = (Stage)this.btnRegresar.getScene().getWindow();
        stage.close();

    }
}

