package ejulp.AccesoAdatos;

import ejulp.Entidades.InscripcionClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class InscripcionData {

    private Connection con = null;

    public InscripcionData() {
        con = Conexion.getConexion();
    }

    public void inscripcion(InscripcionClass inscripcion) {

        String sql = "INSERT INTO inscripcion( nota, idAlumno, idMateria)"
                + " VALUES(?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setDouble(1, inscripcion.getNota());
            ps.setInt(2, inscripcion.setAlumno(idAlumno));
            ps.setInt(3, inscripcion.setMateria(idMateria ));

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                inscripcion.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, " Alumno Inscripto ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno ");
        }

    }

}
