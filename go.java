package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class go {

    private static String url = "";
    private static String dbname = "caragency";
    private static Connection con;

    private static void seturl() {
        url = "jdbc:mysql://localhost:3306/" + dbname + "?useUnicode=true&characterEncoding=UTF-8";
    }

    private static void setconnection() {
        try {
            seturl();
            con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException ex) {
            // JOptionPane.showMessageDialog(ex.getMessage());
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
      //connection of login form
    public static boolean checkuserandpass(String username, String password) {
        try {
            setconnection();
            Statement stmt = con.createStatement();
            String strCheck = "select * from users where " + "username='" + username + "' and " + "pass='" + password + "'";
            stmt.executeQuery(strCheck);

            while (stmt.getResultSet().next()) {
                return true;
            }
            con.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;

    }

//    insert data to database
    public static boolean runNonquery(String addcars, int addcarss, String caro, int caroo, int carooo) {
        try {
            setconnection();
            Statement stmt = con.createStatement();
            String query = "insert into cars (carName,modelnumber,CARCOLOR,CARQUANTITY,CARPRICE) values('" + addcars + "'," + addcarss + "," + "'" + caro + "'," + caroo + "," + carooo + ")";
            stmt.executeUpdate(query);
            con.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }

   //insert data to database
     public static boolean customersave( String addcars, String addcarss, String caro, int caroo,String dd) {
        try {
            setconnection();
            Statement stmt = con.createStatement();
            String query = "insert into customers (firstname,lastname,address,phonemumber,disscountcode) values('" + addcars + "',"+"'" + addcarss + "'," + "'" + caro + "'," + caroo + ",'"+dd+"')";
            //    String q="delete from bmwcar where carName='anan' ";
            stmt.executeUpdate(query);
            //      stmt.executeUpdate(q);

            con.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }
      public static boolean deleted( String deletee) {
        try {
            setconnection();
           // Statement stmt = con.createStatement();
             String query = "delete from cars where carName=?" + deletee;
                    Statement stmt = con.createStatement();
                    stmt.executeUpdate(query);
           
            con.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }

 
}
