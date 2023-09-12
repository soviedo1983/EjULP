package ejulp.AccesoAdatos;

import ejulp.Entidades.InscripcionClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

            ps.setDouble(1,inscripcion.getNota());
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
    public List<InscripcionClass> obtenerInscripto() {
        String sql = "SELECT idInscripcion, nota, idAlumno, idMateria FROM inscripcion WHERE estado= 1";
        ArrayList<InscripcionClass> insc = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                InscripcionClass inscripcion = new InscripcionClass();
               inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));

                insc.add(inscripcion);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " error al acceder a la tabla alumno ");
        }
        return alum;
    }
}
