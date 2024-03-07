package EjercicioObjetos;

public class Profesor {
    
    Alumno[] alumnos = new Alumno[0];

    public void anadirAlumno(Alumno alum){
        Alumno[] aux = new Alumno[alumnos.length + 1];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = alum;
        }
        alumnos = aux;
    }

    public void ponerFalta(Alumno alum){
        alum.setNum_faltas(alum.getNum_faltas() + 1);
    }

    public void ponerNota(Alumno alum, int nota){
        alum.setNota(nota);
    }

    public Profesor() {
    }

    
    public Profesor(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }

    public Alumno[] getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }
    /*
    public Alumno buscarAlumno(String dni){

    }
    */
}

