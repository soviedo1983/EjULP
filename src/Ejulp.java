
import ejulp.AccesoAdatos.AlumnoData;
import ejulp.Entidades.Alumno;
import java.time.LocalDate;


public class Ejulp {

   
    public static void main(String[] args) {
        // creo un objeto alumno para  insertar una alumno
       Alumno juan = new Alumno (1213232,"Luna"," Juan ",LocalDate.of(1980, 4, 25),false);
             AlumnoData alu = new AlumnoData();
             // inserto esto a la base de datos **************************************
                //alu.guardarAlumno(pepe);
        //------silcita modificar el alumno desde el constructor ingreso el dato y solicito el metodo modificar 
                          alu.modificarAlumno(juan);
       // solicita eliminar el alumno  con el id cambia su estado a 0*********************************************                  
                  //        alu.eliminarAlumno(1);
          //    busca los alumnos por id *************************************************
           /*   Alumno  alumnoencontrado = alu.buscarAlumno(2);
                     System.out.println("dni :" +alumnoencontrado.getDni());
                     System.out.println("apellido :"+alumnoencontrado.getApellido());     */
// busca los alumnos por dni**************************************************************
        /* Alumno alumnoencontrado = alu.buscarAlumnoDni(23132356);
                     System.out.println("dni :"+alumnoencontrado.getDni());
                     System.out.println("apellido :"+alumnoencontrado.getApellido());     */
    
       //muestra la lista de los alumnos activos*****************************************
        /*      for(Alumno alumno :alu.listarAlumnos()){
                       System.out.println(alumno.getDni());
                       System.out.println(alumno.getApellido());
                       System.out.println(alumno.getNombre());
                       System.out.println(alumno.getFechaNac());      
    
       } */
        
        for(inscripcion insc:id.obtenerIncripto()){
            
        }
    }
}