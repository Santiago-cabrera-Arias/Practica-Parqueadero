package ec.ups.edu.vista;

import ec.ups.edu.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaEleccion  {

    public Button btnListarVehiculo;
    public Button btnIngresarVehiculo;
    public Button btnRetirarVehiculos;
    public Button btnAtras;


    public void comparar(Usuario objeto){

        if (objeto.getTipoUsuario().trim().equals("Usuario")){

            this.btnListarVehiculo.setVisible(false);

        }

    }


    public void EventoBotonListarVehiculos(ActionEvent actionEvent) {

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("buscarVehiculo.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();



        }catch (IOException exception){

            exception.printStackTrace();

        }


    }

    public void EventoBotonIngresarVehiculos(ActionEvent actionEvent) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("VetanaIngresarVehiculo.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage =  (Stage) this.btnIngresarVehiculo.getScene().getWindow();
            myStage.close();

        }catch(IOException ex){

            System.out.println("Error de lectura y escritura");
            ex.printStackTrace();

        }

    }

    public void EventoBotonRetirarVehiculos(ActionEvent actionEvent) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaRetirarVehiculo.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage)this.btnRetirarVehiculos.getScene().getWindow();
            myStage.close();

        }catch (IOException exception){

            exception.printStackTrace();

        }



    }

    public void EventoBotonSalir(ActionEvent actionEvent) {

            System.exit(0);

    }


    public void EventoBotonReservaciones(ActionEvent actionEvent) {


        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaEstacionamiento.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();


        }catch (IOException exception){

            exception.printStackTrace();

        }

    }

    public void EventoBotonParqueadero(ActionEvent actionEvent) {

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("VentaParqueadero.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();


        }catch (IOException exception){

            exception.printStackTrace();

        }


    }

    public void EventoAtras(ActionEvent actionEvent) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaLogin.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.btnAtras.getScene().getWindow();
            myStage.close();

        }catch (IOException ex){

            System.out.println("Error de lectura y escritura");
            ex.printStackTrace();

        }

    }
}
