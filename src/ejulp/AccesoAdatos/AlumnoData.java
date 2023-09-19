package ejulp.AccesoAdatos;

import ejulp.Entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AlumnoData {

    private Connection con = null;
    
    static boolean conexionExitosa;

    public AlumnoData() {
        
        con = Conexion.getConexion();
        
        if(con != null){
            
            conexionExitosa = true;
            
        }
    }
    
    
   public static boolean conexionExitosa() {

        return conexionExitosa;

    }

    public void guardarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumno(dni, apellido,nombre, fechaNacimiento, estado)"
                + " VALUES(?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // enviamos la insercion de datos 
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isActivo());
            ps.executeUpdate();// ejecuta el preparedStatement **********************
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, " ¡Alumno Agregado! ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno ");
        }

    }

    public void modificarAlumno(Alumno alumno) {
        
        boolean isactive = alumno.isActivo();
        String convertir_estado = isactive ? "1" : "0";
        
        String sql = "UPDATE alumno SET dni = ?, apellido = ?, nombre = ? ,fechaNacimiento = ?, estado = ? WHERE idAlumno = ? ";

        try {
            PreparedStatement ps = null;
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setString(5, convertir_estado);
            ps.setInt(5, alumno.getIdAlumno());
            
            System.out.println(sql);
            
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, " Alumno Modificado ");
            } else {
                JOptionPane.showMessageDialog(null, " Alumno no Existe ");
            }
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno ");
        }
    }

    public void eliminarAlumno(int id) {
        String sql = "UPDATE alumno SET estado= 0 WHERE idAlumno =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {

                JOptionPane.showMessageDialog(null, " Alumno eliminado ");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " error al acceder a la tabla alumno ");
        }
    }

    public Alumno buscarAlumno(int id) {
        String sql = "SELECT dni, apellido,nombre, fechaNacimiento FROM alumno WHERE idAlumno = ? AND estado= 1";
        Alumno alumno = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);
            } else {
                JOptionPane.showMessageDialog(null, " no existe ese alumno  ");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " error al acceder a la tabla alumno ");
        }
        return alumno;
    }

    public Alumno buscarAlumnoDni(int dni) {
        String sql = "SELECT idAlumno,dni, apellido,nombre, fechaNacimiento FROM alumno WHERE dni = ? AND estado= 1";
        Alumno alumno = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);
            } else {
                JOptionPane.showMessageDialog(null, " no existe ese alumno  ");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " error al acceder a la tabla alumno ");
        }
        return alumno;

    }

    public List<Alumno> listarAlumnos() {
        String sql = "SELECT idAlumno,dni, apellido,nombre, fechaNacimiento FROM alumno WHERE estado= 1";
        ArrayList<Alumno> alum = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);

                alum.add(alumno);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " error al acceder a la tabla alumno ");
        }
        return alum;
    }
    
    public boolean existeAlumno(int dni) {
        boolean existe = false;
        String sql = "SELECT COUNT(*) FROM alumno WHERE dni = ? AND estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                existe = (count > 0);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia del alumno.");
        }
        return existe;
    }

}
