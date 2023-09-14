
import ejulp.AccesoAdatos.AlumnoData;
import ejulp.AccesoAdatos.InscripcionData;
import ejulp.AccesoAdatos.MateriaData;

import ejulp.Entidades.Alumno;
import ejulp.Entidades.InscripcionClass;
import ejulp.Entidades.MateriaClass;

import java.time.LocalDate;


public class Ejulp {

   
    public static void main(String[] args) {
        // creo un objeto alumno para  insertar una alumno
       Alumno juan = new Alumno (12569000,"Escalante"," Roxana ",LocalDate.of(1983, 02, 18),true);
             AlumnoData alu = new AlumnoData();
             // inserto esto a la base de datos **************************************
                alu.guardarAlumno(juan);
        //------silcita modificar el alumno desde el constructor ingreso el dato y solicito el metodo modificar 
                         // alu.modificarAlumno(juan);
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
        
        /*  
        MateriaData mater=new MateriaData();
  //GUARDAMOS UNA MATERIA
        MateriaClass asig=new MateriaClass("Geografía",3,true);
                 mater.guardarMateria(asig);
        
   //BUSCAMOS UNA MATERIA POR ID
//        MateriaClass materiaEncontrada= mater.buscarMateria(5);
//        if(materiaEncontrada != null){
//            System.out.println("NOMBRE "+materiaEncontrada.getNombre());
//            System.out.println("AÑO "+materiaEncontrada.getAnioMateria());
//        }
        
    //MODIFICAMOS UNA MATERIA
//        MateriaClass asig=new MateriaClass(3,"Lengua y Literatura",6,true);
//        mater.modificarMateria(asig);
   
    //ELIMINAMOS UNA MATERIA
       // mater.eliminarMateria(21);
        
         //LISTAMOS A LAS MATERIAS ACTIVAS
//     for(MateriaClass materia:mater.listarMaterias()){
//         
//         System.out.println("Id: "+materia.getIdMateria());
//         System.out.println("Nombre: "+materia.getNombre());
//         System.out.println("Año: "+materia.getAnioMateria());
//         System.out.println("*********************");
//     }
        */
        
       //INSCRIPCION
//       AlumnoData alu = new AlumnoData();
//       MateriaData mater=new MateriaData();
//       InscripcionData insc=new InscripcionData();
//       
//       Alumno jose=alu.buscarAlumno(2);
//       MateriaClass mat=mater.buscarMateria(5);
//       InscripcionClass ins=new InscripcionClass(jose,mat,9);
//       insc.inscripcion(ins);
//       
       
       
       // for(inscripcion insc:id.obtenerIncripto()){
            
        } 

        

    }
