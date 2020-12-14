package ec.ups.edu.vista;

import ec.ups.edu.controlador.ControladorUsuario;
import ec.ups.edu.modelo.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VentanaLogin implements Initializable {

    public TextField txtUsuario;
    public PasswordField txtContrasena;
    public ComboBox comboBox;
    public Button btnIniciarSesion;


    ControladorUsuario controladorUsuario;

    ObservableList<String> list = FXCollections.observableArrayList("Usuario","Administrador");

    public VentanaLogin() {

        controladorUsuario = controladorUsuario.getInstancia();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        comboBox.setItems(list);

    }


    public void EventoBotonRegistrarse(ActionEvent actionEvent) {

        String usuario = txtUsuario.getText();
        String contrasena = txtContrasena.getText();
        String tipoUsuario = (String) comboBox.getSelectionModel().getSelectedItem();

        if (usuario.isBlank() || contrasena.isEmpty())
            JOptionPane.showMessageDialog(null,"Llene todos los campos");

        else{

            Usuario usuario1 = new Usuario(usuario,contrasena,tipoUsuario);

            controladorUsuario.create(usuario1);
            JOptionPane.showMessageDialog(null,"Registrado con exito");

            }

    }

    public void EventoBotonIniciarSesion(ActionEvent actionEvent) {

        String usuario = txtUsuario.getText();
        String contrasena = txtContrasena.getText();
        String tipoUsuario = (String) comboBox.getSelectionModel().getSelectedItem();



        if (usuario.isEmpty() || contrasena.isEmpty() || tipoUsuario.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Llene los campos.");
        }else {

            Usuario usuario1 = new Usuario(usuario, contrasena, tipoUsuario);
            Usuario usuario2 = controladorUsuario.iniciarSesion(usuario1);

            if (usuario2 != null) {

                try{

                    JOptionPane.showMessageDialog(null,"Sesion iniciada con exito");

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaEleccion.fxml"));
                    Parent root = loader.load();

                    VentanaEleccion ve = loader.getController();
                    ve.comparar(usuario2);

                    Scene scene = new Scene(root);
                    Stage stage = new Stage();

                    stage.setScene(scene);
                    stage.show();

                    Stage myStage = (Stage) this.btnIniciarSesion.getScene().getWindow();
                    myStage.close();

                }catch(IOException ex){

                    System.out.println("Error de lectura y escritura");
                    ex.printStackTrace();

                }

                }else{

                    JOptionPane.showMessageDialog(null, "No se encuentra el usuario");

                }

            }

    }




}
