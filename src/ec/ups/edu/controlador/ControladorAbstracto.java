package ec.ups.edu.controlador;

import javafx.collections.ObservableList;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public abstract class ControladorAbstracto <T>{

    public abstract void create(T objeto);
    public abstract T read(String cedula);
    public abstract boolean update(T objeto);
    public abstract void delete(T objeto);
    public abstract List<T> findAll();


}

