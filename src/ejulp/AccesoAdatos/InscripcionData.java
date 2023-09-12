package ejulp.AccesoAdatos;

import ejulp.Entidades.InscripcionClass;
import ejulp.Entidades.MateriaClass;
import ejulp.Vistas.Materia;
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
               inscripcion.setNota(0);
               inscripcion.setAlumno(rs.getInt("idAlumno"));
               inscripcion.setMateria(rs.getInt("idMateria"));
                insc.add(inscripcion);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " error al acceder a la tabla alumno ");
        }
        return insc;
    }
    public InscripcionClass obtenerInscriptoPorAlumno(int id) {
        String sql = "SELECT idInscripcion, nota, idAlumno, idMateria FROM inscripcion WHERE estado= 1";
        InscripcionClass inscripcion = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                inscripcion = new InscripcionClass();
                inscripcion.setIdInscripcion(rs.getInt("idInscrpcion"));
                inscripcion.setNota(0);
                inscripcion.setAlumno(rs.getInt("idAlumno"));
                inscripcion.setMateria(rs.getInt("idMateria"));
               
            } else {
                JOptionPane.showMessageDialog(null, " no existe ese alumno  ");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " error al acceder a la tabla alumno ");
        }
        return inscripcion;

    }

    public List<MateriaClass> obtenerMateriasCursadas(int id) {
        List<MateriaClass> materias = new ArrayList<MateriaClass> ();
    
        try {
    
          String sql = "SELECT inscripcion.idMateria,nombre,año FROM inscripcion "
                  +"materia WHERE inscripcion.idMateria = materia.idMateria\n "
                  +"AND inscripcion.idAlumno = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            MateriaClass materia ;
            while(rs.next()) {
                materia = new MateriaClass();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materia.setActivo(true);
                materias.add(materia);
             
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " error al acceder a la tabla alumno ");
        }
        return materias;

            
      
}
     public List<MateriaClass> obtenerMateriasNoCursadas(int id) {
         
     }
     public void borrarInscripcionMateriaAlumno(int idAlumno,int idMateria) {
         
     }
     public void actualizarNota(int idAlumno,int idMateria, double nota){
{
         
     }
}