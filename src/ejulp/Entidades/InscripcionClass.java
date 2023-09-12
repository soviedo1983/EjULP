
package ejulp.Entidades;

import ejulp.Entidades.MateriaClass;
import ejulp.Entidades.Alumno;


public class InscripcionClass {
    
    private int idInscripcion;
    private Alumno alumno ;
    private MateriaClass materia;
    private double nota ;

    public InscripcionClass(int idInscripcion, Alumno alumno, MateriaClass materia, double nota) {
        this.idInscripcion = idInscripcion;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public InscripcionClass(Alumno alumno, MateriaClass materia, double nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public InscripcionClass() {
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public MateriaClass getMateria() {
        return materia;
    }

    public void setMateria(MateriaClass materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    
    

    @Override
    public String toString() {
        String insc = idInscripcion +" "+alumno.getApellido()+", "+alumno.getNombre()+" "+materia.getNombre();
        return insc;
    }
            
}
