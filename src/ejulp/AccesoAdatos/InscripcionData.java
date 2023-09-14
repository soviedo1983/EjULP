package ejulp.AccesoAdatos;

import ejulp.Entidades.Alumno;
import ejulp.Entidades.InscripcionClass;
import ejulp.Entidades.MateriaClass;
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
    MateriaData matData;
    AlumnoData aluData;

    public InscripcionData() {
        con = Conexion.getConexion();
    }

    public void inscripcion(InscripcionClass inscripcion) {

        String sql = "INSERT INTO inscripcion(nota,idAlumno,idMateria)"
                + " VALUES(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, inscripcion.getNota());
            ps.setInt(2, inscripcion.getAlumno().getIdAlumno());
            ps.setInt(3, inscripcion.getMateria().getIdMateria());
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
        ArrayList<InscripcionClass> insc = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                InscripcionClass inscripcion = new InscripcionClass();
                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno alu = aluData.buscarAlumno(rs.getInt("idAlumno"));
                MateriaClass mat = matData.buscarMateria(rs.getInt("idMateria"));
                inscripcion.setAlumno(alu);
                inscripcion.setMateria(mat);
                inscripcion.setNota(rs.getDouble("nota"));
                insc.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion ");
        }
        return insc;
    }

    public List<InscripcionClass> obtenerInscriptoPorAlumno(int idAlumno) {
        ArrayList<InscripcionClass> insc = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                InscripcionClass inscripcion = new InscripcionClass();
                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno alu = aluData.buscarAlumno(rs.getInt("idAlumno"));
                MateriaClass mat = matData.buscarMateria(rs.getInt("idMateria"));
                inscripcion.setAlumno(alu);
                inscripcion.setMateria(mat);
                inscripcion.setNota(rs.getDouble("nota"));
                insc.add(inscripcion);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion.");
        }
        return insc;
    }

    public List<MateriaClass> obtenerMateriasCursadas(int idAlumno) {
        ArrayList<MateriaClass> materias = new ArrayList<>();

        try {

            String sql = "SELECT inscripcion.idMateria,nombre,año FROM inscripcion ,materia"
                    + "WHERE inscripcion.idMateria = materia.idMateria "
                    + "AND inscripcion.idAlumno = ?;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                MateriaClass materia = new MateriaClass();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " error al acceder a la tabla Inscripcion ");
        }
        return materias;

    }

    public List<MateriaClass> obtenerMateriasNoCursadas(int idAlumno) {

        ArrayList<MateriaClass> materias = new ArrayList<>();

        try {

            String sql = "SELECT * FROM materia WHERE estado=1 AND idMateria not in "
                    + "(SELECT idMateria FEOM inscripcion where idAlumno = ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                MateriaClass materia = new MateriaClass();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " error al acceder a la tabla alumno ");
        }
        return materias;

    }

    public List<Alumno> obtenerAlumnosXMateria(int idMateria) {
        ArrayList<Alumno> alumnosMateria = new ArrayList<>();
        String sql = "SELECT a.idAlumno ,dni,nombre,apellido,fechaNacimiento,estado"
                + "FROM inscripcion i,alumno a WHERE i.idAlumno =a.idAlumno AND idMateria =? AND a.estado= 1";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido "));
                alumno.setNombre(rs.getString("nombre "));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));
                alumnosMateria.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " error al acceder a la tabla  ");
        }
        return alumnosMateria;
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {

        String sql = "UPDATE inscripcion SET nota=? WHERE idAlumno=? AND idMateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);

            int fila = ps.executeUpdate();
            if (fila > 0) {
                JOptionPane.showMessageDialog(null, "Nota Actualizada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion");
        }

    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {

        String sql = "DELETE FROM inscripcion WHERE idAlumno=? AND idMateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Inscripcion Eliminada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion");
        }
    }
}
