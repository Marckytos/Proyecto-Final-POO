package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class CafeModelo {
    private int id;
    private String marca;
    private String origen;
    private String descafeinado;
    private String grano;
    private String urlFoto;

    public CafeModelo() {

    }

    public CafeModelo(int id, String marca, String origen, String descafeinado, String grano, String urlFoto) {
        this.id = id;
        this.marca = marca;
        this.origen = origen;
        this.descafeinado = descafeinado;
        this.grano = grano;
        this.urlFoto = urlFoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDescafeinado() {
        return descafeinado;
    }

    public void setDescafeinado(String descafeinado) {
        this.descafeinado = descafeinado;
    }

    public String getGrano() {
        return grano;
    }

    public void setGrano(String grano) {
        this.grano = grano;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    @Override
    public String toString() {
        return "CafeModelo{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", origen='" + origen + '\'' +
                ", descafeinado='" + descafeinado + '\'' +
                ", grano='" + grano + '\'' +
                ", urlFoto='" + urlFoto + '\'' +
                '}';
    }
    public ImageIcon createIcon(){

        ImageIcon resultado= null;

        try{
            URL urlImagen = new URL(this.urlFoto);
            resultado = new ImageIcon(urlImagen);

        }catch(MalformedURLException mue){

            System.out.println(mue.toString());
        }
        return resultado;

    }
}
