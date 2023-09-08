
package ejulp.AccesoAdatos;

import ejulp.AccesoAdatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EjULP {

    public static void main(String[] args) {
       // invoca la conexion
        Connection con=null;
        
        PreparedStatement ps =null;
       // crea una varible alumno para traer en algun MOMENTO Alumno alumno= null;
        
//crea la conexion 
        con = Conexion.getConexion();
        // hacer un insert en la base de datos 
    }
    
}
