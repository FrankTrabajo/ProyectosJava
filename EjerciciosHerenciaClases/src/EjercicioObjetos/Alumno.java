package EjercicioObjetos;

public class Alumno {
    
    String nombre;
    String dni;
    int nota;
    int num_faltas;
    
    public Alumno(String nombre, String dni, int nota, int num_faltas) {
        this.nombre = nombre;
        this.dni = dni;
        this.nota = nota;
        this.num_faltas = num_faltas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getNum_faltas() {
        return num_faltas;
    }

    public void setNum_faltas(int num_faltas) {
        this.num_faltas = num_faltas;
    }
}
