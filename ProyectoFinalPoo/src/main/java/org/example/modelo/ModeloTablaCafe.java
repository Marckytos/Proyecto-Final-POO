package org.example.modelo;

import org.example.persistencia.CafeDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaCafe implements TableModel {
    public static final int COLS = 6;
    private ArrayList<CafeModelo> datos;
    private CafeDAO cdao;

    public ModeloTablaCafe() {
        datos = new ArrayList<>();
        cdao = new CafeDAO();
    }

    public ModeloTablaCafe(ArrayList<CafeModelo> datos) {
        this.datos = datos;
        cdao = new CafeDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLS;
    }

    @Override
    public String getColumnName(int rowIndex) {
        switch (rowIndex) {
            case 0:
                return "ID";
            case 1:
                return "Marca";
            case 2:
                return "Origen";
            case 3:
                return "Descafeinado";
            case 4:
                return "Grano";
            case 5:
                return "URL Foto";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CafeModelo tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getMarca();
            case 2:
                return tmp.getOrigen();
            case 3:
                return tmp.getDescafeinado();
            case 4:
                return tmp.getGrano();
            case 5:
                return tmp.getUrlFoto();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                //datos.get(rowIndex).setId((Integer) aValue);
                break;
            case 1:
                datos.get(rowIndex).setMarca((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setOrigen((String) aValue);
                break;
            case 3:
                datos.get(rowIndex).setDescafeinado((String) aValue);
                break;
            case 4:
                datos.get(rowIndex).setGrano((String) aValue);
                break;
            case 5:
                datos.get(rowIndex).setUrlFoto((String) aValue);
                break;
            default:
                System.out.println("No se modifica nada");
        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
    public boolean agregarCafe(CafeModelo caf) {
        boolean resultado = false;
        try {
            if (cdao.insertar(caf)) {
                datos.add(caf);
                resultado = true;

            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }

        return resultado;

    }
    public boolean eliminarCafe(CafeModelo caf){
        boolean resultado = false;
        try {
            if (cdao.delete(String.valueOf(caf))){
                datos.add(caf);
                resultado = true;
            }else {
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
    public boolean actualizarCafe(CafeModelo caf){
        boolean resultado = false;
        try {
            if (cdao.update(caf)){
                datos.add(caf);
                resultado = true;
            }else {
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public CafeModelo obtenerCafe(int rowIndex) throws IndexOutOfBoundsException {
        return datos.get(rowIndex);
    }

    public void cargarDatos() {
        try {
            datos = cdao.obtenerTodo();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }

    }










    }


