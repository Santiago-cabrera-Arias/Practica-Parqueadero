package ec.ups.edu.images;

import javafx.scene.image.Image;

import java.sql.Struct;

public class ControladorImagenes {

    public Image imagenCoche(){

        return new Image(getClass().getResourceAsStream("coche (1).png"),120,30, true,true);

    }

    public Image imagenEspaciosLibres(){

        return new Image(getClass().getResourceAsStream("botonEspacios.png"),120,30,true,true);

    }

    public Image imgenEspacioReservado(){

        return new Image(getClass().getResourceAsStream("reservado.png"),120,30,true,true);

    }

    public Image imagenArrendar(){

        return new Image(getClass().getResourceAsStream("aparcamientoArrendar.png"),120,30,true,true);

    }

}
