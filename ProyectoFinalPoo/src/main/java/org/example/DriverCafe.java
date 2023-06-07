package org.example;

import org.example.controlador.ControladorCafe;
import org.example.modelo.CafeModelo;
import org.example.persistencia.CafeDAO;
import org.example.vista.VentanaCafe;

import java.sql.SQLException;

public class DriverCafe {
    public static void main(String[] args) {

        VentanaCafe caf = new VentanaCafe("Cafe MVC y JDBC");
        ControladorCafe controller = new ControladorCafe(caf);


    }
}