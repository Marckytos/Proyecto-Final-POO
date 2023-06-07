package org.example.controlador;

import org.example.modelo.CafeModelo;
import org.example.modelo.ModeloTablaCafe;
import org.example.persistencia.ConexionSingleton;
import org.example.vista.VentanaCafe;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControladorCafe extends MouseAdapter {
    private VentanaCafe view;
    private ModeloTablaCafe modelo;

    public ControladorCafe(VentanaCafe view) {
        this.view = view;
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnEliminar().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
        this.view.getTblTabla().addMouseListener(this);
        modelo = new ModeloTablaCafe();
        this.view.getTblTabla().setModel(modelo);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view.getBtnAgregar()){
            CafeModelo temp = new CafeModelo();

            temp.setId(0);
            temp.setMarca(this.view.getTxtmarca().getText());
            temp.setOrigen(this.view.getTxtorigen().getText());
            temp.setDescafeinado(this.view.getTxtdescafeinado().getText());
            temp.setGrano(this.view.getTxtgrano().getText());
            temp.setUrlFoto(this.view.getTxturlFoto().getText());

            if(modelo.agregarCafe(temp)){
                JOptionPane.showMessageDialog(view,"Se agrego correctamente","Aviso",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(view,"No se pudo agregar a la base de datos. Por favor revise su conexion",
                        "Error al insertar",JOptionPane.ERROR_MESSAGE);

            }
            this.view.getTblTabla().updateUI();
        }
        if (e.getSource() == view.getTblTabla()){
            System.out.println("Click sobre la tabla");
            int rowIndex = view.getTblTabla().getSelectedRow();
            modelo.obtenerCafe(rowIndex);
            CafeModelo temp = modelo.obtenerCafe(rowIndex);
            view.getLblImagenCafe().setText("");
            view.getLblImagenCafe().setIcon(temp.createIcon());
        }
        if(e.getSource()== this.view.getBtnCargar()){
            modelo = new ModeloTablaCafe();
            modelo.cargarDatos();
            this.view.getTblTabla().setModel(modelo);
            this.view.getTblTabla().updateUI();
        }
        this.view.limpiar();

        if(e.getSource()==this.view.getBtnEliminar()){
            int respuesta = JOptionPane.showConfirmDialog(view,"Esta usted seguro de borrar el registro?"
            ,"Confirmacion de eliminacion",JOptionPane.YES_NO_OPTION);
            if(respuesta==0){
                String sqlDelete = "DELETE FROM cafe WHERE id = ?;";
                PreparedStatement pstm= null;
                try{
                    pstm= ConexionSingleton.getInstance("cafeDB.db").getConnection().prepareStatement(sqlDelete);

                }catch (SQLException sqle){
                    throw new RuntimeException(sqle);
                }
                try{
                    pstm.setInt(1,Integer.parseInt(this.view.getTxtElminarId().getText()));
                    this.view.getTblTabla().updateUI();
                    JOptionPane.showMessageDialog(view,"Se elimino de forma exitosa","Operacion exitosa"
                    ,JOptionPane.INFORMATION_MESSAGE);
                }catch (NumberFormatException a){
                    JOptionPane.showMessageDialog(view,"Error al eliminar","Error fatal",
                            JOptionPane.ERROR_MESSAGE);
                }catch (SQLException ex){
                    System.out.println(ex.getMessage());
                }
                try{
                    pstm.executeUpdate();
                }catch (SQLException sqle){
                    JOptionPane.showMessageDialog(view,"Error en id","Id Error",
                            JOptionPane.ERROR_MESSAGE);
                    throw new RuntimeException(sqle);
                }finally {
                    this.view.limpiar2();
                }
            }

        }
        if (e.getSource() == this.view.getBtnActualizar()) {
            int respuesta = JOptionPane.showConfirmDialog(view, "Estas seguro de actualizar el registro?", "Actualizar datos", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                CafeModelo cafeModelo = new CafeModelo();
                cafeModelo.setId(Integer.parseInt((String) this.view.getTxtid2().getText()));
                cafeModelo.setMarca(this.view.getTxtmarca2().getText());
                cafeModelo.setOrigen(this.view.getTxtorigen2().getText());
                cafeModelo.setDescafeinado(this.view.getTxtdescafeinado2().getText());
                cafeModelo.setGrano(this.view.getTxtgrano2().getText());
                cafeModelo.setUrlFoto(this.view.getTxturlFoto2().getText());
                this.view.getTblTabla().updateUI();
                if (modelo.actualizarCafe(cafeModelo)) {
                    JOptionPane.showMessageDialog(view, "Se actualizo correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    this.view.getTblTabla().updateUI();
                } else {
                    JOptionPane.showMessageDialog(view, "No se pudo actualizar", "Aviso", JOptionPane.ERROR_MESSAGE);

                }
                this.view.limpiar2();
            }else {
                this.view.limpiar2();
            }
        }

        if (e.getSource() == this.view.getTblTabla()) {
            int rowIndex = this.view.getTblTabla().getSelectedRow();
            modelo.obtenerCafe(rowIndex);
            CafeModelo temp = modelo.obtenerCafe(rowIndex);
            this.view.getLblImagenCafe().setText("");
            this.view.getLblImagenCafe().setIcon(temp.createIcon());
        }
    }


    }

