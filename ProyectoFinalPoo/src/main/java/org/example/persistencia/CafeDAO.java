package org.example.persistencia;

import org.example.modelo.CafeModelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CafeDAO implements InterfazDAO {
    public CafeDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO cafe(marca,origen,descafeinado,grano,url) VALUES(?,?,?,?,?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("cafeDB.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((CafeModelo)obj).getMarca());
        pstm.setString(2, ((CafeModelo)obj).getOrigen());
        pstm.setString(3, ((CafeModelo)obj).getDescafeinado());
        pstm.setString(4, ((CafeModelo)obj).getGrano());
        pstm.setString(5, ((CafeModelo)obj).getUrlFoto());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;

    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE cafe SET marca = ?, origen = ?, descafeinado = ?, grano = ?, url = ? WHERE id = ?;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("cafeDB.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((CafeModelo)obj).getMarca());
        pstm.setString(2, ((CafeModelo)obj).getOrigen());
        pstm.setString(3, ((CafeModelo)obj).getDescafeinado());
        pstm.setString(4, ((CafeModelo)obj).getGrano());
        pstm.setString(5, ((CafeModelo)obj).getUrlFoto());
        pstm.setInt(6, ((CafeModelo)obj).getId());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM cafe WHERE id = ?;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("cafeDB.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1,Integer.parseInt(id));
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM cafe";
        ArrayList<CafeModelo> resultado = new ArrayList<>();

        Statement stm = ConexionSingleton.getInstance("cafeDB.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()){
            resultado.add(new CafeModelo(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),
                    rst.getString(5),rst.getString(6)));
        }
        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM cafe WHERE id = ? ;";
        CafeModelo cafe = null;

        PreparedStatement pstm = ConexionSingleton.getInstance("cafeDB.db").getConnection().prepareStatement(sql);
        pstm.setInt(1,Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if(rst.next()){
            cafe = new CafeModelo(rst.getInt(1), rst.getString(2),rst.getString(3),rst.getString(4),
                    rst.getString(5),rst.getString(6));
            return cafe;

        }
        return null;
    }
}
