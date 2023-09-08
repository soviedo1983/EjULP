
package ejulp.AccesoAdatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    private static String url="jdbc:mariadb://localhost:3306/ulp";
    private static String usuario= "root";
    private static String pass="";

    private static Conexion conexion= null;
    
    private Conexion() {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"clase conexion :Error al cargar driver");
        }
        
    }

   public static Connection getConexion(){
       Connection con=null;
       if(conexion==null){
           conexion=new Conexion();
           
           JOptionPane.showMessageDialog(null,"conexion exitosa");
       }
   try{
       con = DriverManager.getConnection(url+"?useLegacyDatetimeCode=false&serverTimezone=UTC"+"&user="+usuario+"&password="+pass);
       
   }catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,"Error de conexion");
    
}return con ;
      
   }
}
