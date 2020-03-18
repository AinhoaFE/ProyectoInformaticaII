/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package care2all;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ainho
 */
public class ConexionSQL {
    //Connection con;
    Connection co=null;
   // Statement stm;
    public ConexionSQL(){
    
         try {

            Class.forName("com.mysql.jdbc.Driver"); 
          System.out.println("Registro exitoso");
            co= DriverManager.getConnection("jdbc:mysql://localhost/care2all", "root", "");
           // Statement stm = co.createStatement();
          //  System.out.println("Conectado correctamente a la Base de Datos");
      //  } catch (ClassNotFoundException e) {
        //    System.out.println("Clase no encontrada: "+e);
        } catch (SQLException e) {
            System.out.println("Error de conexion: "+e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error desconocido: "+e);
        }
    }
        
        
}
