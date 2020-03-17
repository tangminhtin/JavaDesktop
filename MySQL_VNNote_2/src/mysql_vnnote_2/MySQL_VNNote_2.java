/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_vnnote_2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tangminhtin
 */
public class MySQL_VNNote_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DBManagement db = new DBManagement();

            Connection connection;  // Use to stores current connection
            connection = db.getConnection();

            Statement statement;    // Use to stores SQL Statements includes SELECT, INSERT, DELETE, UPDATE
            statement = connection.createStatement();

            ResultSet resultSet;    // Stores result of SQL statement

            String sql = "SELECT * FROM `tl` WHERE 1";

            resultSet = statement.executeQuery(sql);

            int maTuLoai;
            int maNgonNgu;
            String tenTuLoai;

            ArrayList<TuLoai> arrayList = new ArrayList<>();
            if (!resultSet.first()) {
                System.out.println("Khong co tu loai nao trong CSDL");
            } else {
                while(resultSet.next()) {
                    maTuLoai = resultSet.getInt("tl_ma");
                    maNgonNgu = resultSet.getInt("nn_ma");
                    tenTuLoai = resultSet.getString("tl_tl");

                    arrayList.add(new TuLoai(maTuLoai, maNgonNgu, tenTuLoai));
                }
                
                int stt = 0;
                for(TuLoai tl: arrayList) {
                    System.out.println("#" + (++stt) + " " + tl.toString());
                }
            }
            db.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MySQL_VNNote_2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
