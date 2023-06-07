package org.example.vista;

import org.example.modelo.CafeModelo;
import org.example.modelo.ModeloTablaCafe;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class VentanaCafe extends JFrame {
    private JLabel lblid;
    private JLabel lblmarca;
    private JLabel lblorigen;
    private JLabel lbldescafeinado;
    private JLabel lblgrano;
    private JLabel lblurlFoto;
    private JTextField txtid;
    private JTextField txtmarca;
    private JTextField txtorigen;
    private JTextField txtdescafeinado;
    private JTextField txtgrano;
    private JTextField txturlFoto;
    private GridLayout layout;
    private JScrollPane scroll;
    private JTable tblTabla;
    private JButton btnAgregar;
    private JButton btnCargar;
    private JButton btnEliminar;
    private JButton btnActualizar;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private ModeloTablaCafe modelo;
    private ArrayList<CafeModelo> info;
    private JLabel lblImagenCafe;
    private JLabel lblid2;
    private JLabel lblmarca2;
    private JLabel lblorigen2;
    private JLabel lbldescafeinado2;
    private JLabel lblgrano2;
    private JLabel lblurlFoto2;
    private JTextField txtid2;
    private JTextField txtmarca2;
    private JTextField txtorigen2;
    private JTextField txtdescafeinado2;
    private JTextField txtgrano2;
    private JTextField txturlFoto2;
    private JLabel lblAgregar;
    private JLabel lblEliminarId;
    private JTextField txtElminarId;
    private JLabel lblSeparacion;

    public VentanaCafe(String title) throws HeadlessException {
        super(title);
        this.setSize(800,600);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);


        //Panel 1
        panel1= new JPanel(new FlowLayout());
        panel1.setBackground(new Color(12, 248, 51, 242));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

        lblid = new JLabel("ID");
        txtid = new JTextField(4);
        txtid.setText("0");
        txtid.setEnabled(false);
        panel1.add(lblid);
        panel1.add(txtid);

        lblmarca = new JLabel("Marca");
        txtmarca = new JTextField(6);
        panel1.add(lblmarca);
        panel1.add(txtmarca);

        lblorigen = new JLabel("Origen");
        txtorigen = new JTextField(10);
        panel1.add(lblorigen);
        panel1.add(txtorigen);

        lbldescafeinado = new JLabel("Descafeinado?");
        txtdescafeinado = new JTextField(3);
        panel1.add(lbldescafeinado);
        panel1.add(txtdescafeinado);

        lblgrano = new JLabel("Tipo de grano");
        txtgrano = new JTextField(6);
        panel1.add(lblgrano);
        panel1.add(txtgrano);

        lblurlFoto = new JLabel("URL");
        txturlFoto = new JTextField(30);
        panel1.add(lblurlFoto);
        panel1.add(txturlFoto);

        btnAgregar = new JButton("Agregar");
        panel1.add(btnAgregar);
        this.getContentPane().add(panel1,0);

        //Panel 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(250, 108, 6, 219));
        this.getContentPane().add(panel2,1);
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);
        tblTabla = new JTable();
        scroll = new JScrollPane(tblTabla);
        panel2.add(scroll);




        //Panel 3
        panel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel3.setBackground(new Color(222, 17, 48, 249));
        this.getContentPane().add(panel3,2);
        lblImagenCafe = new JLabel("...");
        this.panel3.add(lblImagenCafe);
        this.getContentPane().add(panel3,2);

        //Panel 4;
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(224, 12, 248, 242));
        panel4.setLayout(new FlowLayout());
        this.getContentPane().add(panel4,3);

       lblid2 = new JLabel("Nuevo ID");
       txtid2 = new JTextField(3);
       panel4.add(lblid2);
       panel4.add(txtid2);

       lblmarca2 = new JLabel("Nueva marca");
       txtmarca2 = new JTextField(10);
       panel4.add(lblmarca2);
       panel4.add(txtmarca2);

       lblorigen2 = new JLabel("Nuevo Origen");
       txtorigen2 = new JTextField(10);
       panel4.add(lblorigen2);
       panel4.add(txtorigen2);

        lbldescafeinado2 = new JLabel("Nuevo descafeinado?");
        txtdescafeinado2 = new JTextField(3);
        panel4.add(lbldescafeinado2);
        panel4.add(txtdescafeinado2);

        lblgrano2 = new JLabel("Nuevo tipo de grano");
        txtgrano2 = new JTextField(5);
        panel4.add(lblgrano2);
        panel4.add(txtgrano2);

        lblurlFoto2 = new JLabel("Nueva URL");
        txturlFoto2 = new JTextField(45);
        panel4.add(lblurlFoto2);
        panel4.add(txturlFoto2);

        btnActualizar = new JButton("Actualizar Datos");
        panel4.add(btnActualizar);

        lblSeparacion = new JLabel("----------------------------------------------------------------------" +
                "--------------------------------------------------------------------------------------------");
        panel4.add(lblSeparacion);

        lblEliminarId = new JLabel("ID a eliminar: ");
        txtElminarId = new JTextField(5);
        panel4.add(lblEliminarId);
        panel4.add(txtElminarId);

        btnEliminar = new JButton("Eliminar");
        panel4.add(btnEliminar);




        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);



    }

    public JLabel getLblid() {
        return lblid;
    }

    public void setLblid(JLabel lblid) {
        this.lblid = lblid;
    }

    public JLabel getLblmarca() {
        return lblmarca;
    }

    public void setLblmarca(JLabel lblmarca) {
        this.lblmarca = lblmarca;
    }

    public JLabel getLblorigen() {
        return lblorigen;
    }

    public void setLblorigen(JLabel lblorigen) {
        this.lblorigen = lblorigen;
    }

    public JLabel getLbldescafeinado() {
        return lbldescafeinado;
    }

    public void setLbldescafeinado(JLabel lbldescafeinado) {
        this.lbldescafeinado = lbldescafeinado;
    }

    public JLabel getLblgrano() {
        return lblgrano;
    }

    public void setLblgrano(JLabel lblgrano) {
        this.lblgrano = lblgrano;
    }

    public JLabel getLblurlFoto() {
        return lblurlFoto;
    }

    public void setLblurlFoto(JLabel lblurlFoto) {
        this.lblurlFoto = lblurlFoto;
    }

    public JTextField getTxtid() {
        return txtid;
    }

    public void setTxtid(JTextField txtid) {
        this.txtid = txtid;
    }

    public JTextField getTxtmarca() {
        return txtmarca;
    }

    public void setTxtmarca(JTextField txtmarca) {
        this.txtmarca = txtmarca;
    }

    public JTextField getTxtorigen() {
        return txtorigen;
    }

    public void setTxtorigen(JTextField txtorigen) {
        this.txtorigen = txtorigen;
    }

    public JTextField getTxtdescafeinado() {
        return txtdescafeinado;
    }

    public void setTxtdescafeinado(JTextField txtdescafeinado) {
        this.txtdescafeinado = txtdescafeinado;
    }

    public JTextField getTxtgrano() {
        return txtgrano;
    }

    public void setTxtgrano(JTextField txtgrano) {
        this.txtgrano = txtgrano;
    }

    public JTextField getTxturlFoto() {
        return txturlFoto;
    }

    public void setTxturlFoto(JTextField txturlFoto) {
        this.txturlFoto = txturlFoto;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JTable getTblTabla() {
        return tblTabla;
    }

    public void setTblTabla(JTable tblTabla) {
        this.tblTabla = tblTabla;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public ModeloTablaCafe getModelo() {
        return modelo;
    }

    public void setModelo(ModeloTablaCafe modelo) {
        this.modelo = modelo;
    }

    public ArrayList<CafeModelo> getInfo() {
        return info;
    }

    public void setInfo(ArrayList<CafeModelo> info) {
        this.info = info;
    }

    public JLabel getLblImagenCafe() {
        return lblImagenCafe;
    }

    public void setLblImagenCafe(JLabel lblImagenCafe) {
        this.lblImagenCafe = lblImagenCafe;
    }

    public JLabel getLblid2() {
        return lblid2;
    }

    public void setLblid2(JLabel lblid2) {
        this.lblid2 = lblid2;
    }

    public JLabel getLblmarca2() {
        return lblmarca2;
    }

    public void setLblmarca2(JLabel lblmarca2) {
        this.lblmarca2 = lblmarca2;
    }

    public JLabel getLblorigen2() {
        return lblorigen2;
    }

    public void setLblorigen2(JLabel lblorigen2) {
        this.lblorigen2 = lblorigen2;
    }

    public JLabel getLbldescafeinado2() {
        return lbldescafeinado2;
    }

    public void setLbldescafeinado2(JLabel lbldescafeinado2) {
        this.lbldescafeinado2 = lbldescafeinado2;
    }

    public JLabel getLblgrano2() {
        return lblgrano2;
    }

    public void setLblgrano2(JLabel lblgrano2) {
        this.lblgrano2 = lblgrano2;
    }

    public JLabel getLblurlFoto2() {
        return lblurlFoto2;
    }

    public void setLblurlFoto2(JLabel lblurlFoto2) {
        this.lblurlFoto2 = lblurlFoto2;
    }

    public JTextField getTxtid2() {
        return txtid2;
    }

    public void setTxtid2(JTextField txtid2) {
        this.txtid2 = txtid2;
    }

    public JTextField getTxtmarca2() {
        return txtmarca2;
    }

    public void setTxtmarca2(JTextField txtmarca2) {
        this.txtmarca2 = txtmarca2;
    }

    public JTextField getTxtorigen2() {
        return txtorigen2;
    }

    public void setTxtorigen2(JTextField txtorigen2) {
        this.txtorigen2 = txtorigen2;
    }

    public JTextField getTxtdescafeinado2() {
        return txtdescafeinado2;
    }

    public void setTxtdescafeinado2(JTextField txtdescafeinado2) {
        this.txtdescafeinado2 = txtdescafeinado2;
    }

    public JTextField getTxtgrano2() {
        return txtgrano2;
    }

    public void setTxtgrano2(JTextField txtgrano2) {
        this.txtgrano2 = txtgrano2;
    }

    public JTextField getTxturlFoto2() {
        return txturlFoto2;
    }

    public void setTxturlFoto2(JTextField txturlFoto2) {
        this.txturlFoto2 = txturlFoto2;
    }

    public JLabel getLblAgregar() {
        return lblAgregar;
    }

    public void setLblAgregar(JLabel lblAgregar) {
        this.lblAgregar = lblAgregar;
    }

    public JLabel getLblEliminarId() {
        return lblEliminarId;
    }

    public void setLblEliminarId(JLabel lblEliminarId) {
        this.lblEliminarId = lblEliminarId;
    }

    public JTextField getTxtElminarId() {
        return txtElminarId;
    }

    public void setTxtElminarId(JTextField txtElminarId) {
        this.txtElminarId = txtElminarId;
    }

    public JLabel getLblSeparacion() {
        return lblSeparacion;
    }

    public void setLblSeparacion(JLabel lblSeparacion) {
        this.lblSeparacion = lblSeparacion;
    }

    public void limpiar(){
        txtmarca.setText("");
        txtorigen.setText("");
        txtdescafeinado.setText("");
        txtgrano.setText("");
        txturlFoto.setText("");
    }
    public void limpiar2(){
        txtmarca.setText("");
        txtorigen.setText("");
        txtdescafeinado.setText("");
        txtgrano.setText("");
        txturlFoto.setText("");
    }
}

