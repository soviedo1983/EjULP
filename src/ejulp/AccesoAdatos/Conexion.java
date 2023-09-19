package ejulp.AccesoAdatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private static final String URL = "jdbc:mariadb://localhost:3306/ulp";
    private static final String USUARIO = "root";
    private static final String PASS = "";

    private static Conexion conexion = null;

    private Conexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "¡Error al cargar el Driver de Conexion!");
        }

    }

    public static Connection getConexion() {
        Connection con = null;
        if (conexion == null) {

            conexion = new Conexion();

        }
        try {
            con = DriverManager.getConnection(URL + "?useLegacyDatetimeCode=false&serverTimezone=UTC" + "&user=" + USUARIO + "&password=" + PASS);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error de conexion.");

        }
        return con;

    }
}
