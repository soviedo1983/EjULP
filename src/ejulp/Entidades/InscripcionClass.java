
package ejulp.Entidades;

import ejulp.Entidades.MateriaClass;
import ejulp.Entidades.Alumno;


public class InscripcionClass {
    
    private int inscripcion;
    Alumno alumno ;
    MateriaClass materia;
    double nota ;

    public InscripcionClass(int inscripcion, Alumno alumno, MateriaClass materia, double nota) {
        this.inscripcion = inscripcion;
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

    public int getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(int inscripcion) {
        this.inscripcion = inscripcion;
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
            
}
