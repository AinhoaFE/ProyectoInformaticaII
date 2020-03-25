/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package care2all;


import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author ainho
 */
public class MetodosLogin {
    
   
   //ConexionSQL metodospool = new Pool();
    
    public void validar_ingreso(){
       
        ConexionSQL cSQL=new ConexionSQL();
        Connection con=cSQL.co;
        int resultado=0;
        String usuario=InicioGeneral.txtUsuario.getText();
        System.out.println("usuario"+usuario);
        String password=String.valueOf(InicioGeneral.txtPassword.getPassword());
         System.out.println("password"+password);
        //System.out.println("SELECT * FROM usuarios WHERE usuario='"+usuario+"' AND password='"+password+"'");
           String SSQL="SELECT * FROM usuarios WHERE usuario='"+usuario+"' AND password='"+password+"'";
           String SSQL1="SELECT acceso FROM usuarios WHERE usuario='"+usuario+"' AND password='"+password+"'";
         
           
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(SSQL);
            Statement st2=con.createStatement();
            ResultSet rs2=st2.executeQuery(SSQL1);
            if(rs.next()){
                resultado=1;
                if(resultado==1){
                
                  JOptionPane.showMessageDialog(null, "Bienvenido " + usuario , "Inicio sesión", JOptionPane.INFORMATION_MESSAGE);
                    if( rs2.next()){  
                       
                            if("paciente".equals(rs2.getString("acceso"))){
                                 PacienteGeneral pg=new PacienteGeneral();
                                 pg.setVisible(true);
                                
                     
                    JOptionPane.showMessageDialog(null, "Bienvenido Paciente " + usuario , "Inicio sesión", JOptionPane.INFORMATION_MESSAGE);
                   
                            } 
                        else if("medico".equals(rs2.getString("acceso"))){
                                 JOptionPane.showMessageDialog(null, "Bienvenido Medico " + usuario , "Inicio sesión", JOptionPane.INFORMATION_MESSAGE);
                }
                              else if("tutor".equals(rs2.getString("acceso"))){
                                 JOptionPane.showMessageDialog(null, "Bienvenido Tutor " + usuario , "Inicio sesión", JOptionPane.INFORMATION_MESSAGE);
                }
                }
            }
            }
            else{
            
              JOptionPane.showMessageDialog(null, "Clave y/o usuario incorrecto " , "Inicio sesión", JOptionPane.ERROR_MESSAGE);
	}
            
        } catch (SQLException ex) {
            Logger.getLogger(MetodosLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
             
   
}
}
