package EjercicioObjetos;

public class App {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Profesor dani = new Profesor();
        Alumno[] alumnos = dani.getAlumnos();
        boolean encendido = true;
        while(encendido){
            System.out.println("***** BIENVENIDO PROFE *****");
        System.out.println("Elige una opcion:");
        System.out.println("1- Insertar alumno");
        System.out.println("2- Poner falta a un alumno");
        System.out.println("3- Evaluar a un alumno");
        System.out.println("4- Listar alumnos");
        System.out.println("5- Ver faltas de un alumno en concreto");
        System.out.println("6- Ver notas de un alumno en concreto");
        System.out.println("7- Salir");
        int opcion = sc.nextInt();

        switch(opcion){
            case 1:
                System.out.print("Ingresa el nombre del alumno: ");
                String nombAlu = sc.next();
                System.out.print("Ingresa el dni del alumno: ");
                String dniAlu = sc.next();
                dani.anadirAlumno(new Alumno(nombAlu,dniAlu));
                break;
            case 2:
                System.out.print("A que alumno quieres poner la falta: ");
                nombAlu = sc.next();
                alumnos = dani.getAlumnos();
                for (int i = 0; i < alumnos.length; i++) {
                    if(alumnos[i].getNombre().equalsIgnoreCase(nombAlu)){
                        dani.ponerFalta(alumnos[i]);
                    } else {
                        System.out.println("Ese alumno no existe");
                    }
                }
                break;
            case 3:
                System.out.println("Escribe la nota del alumno: ");
                int notaAlu = sc.nextInt();
                System.out.println("Escribe el nombre del alumno: ");
                nombAlu = sc.next();
                alumnos = dani.getAlumnos();
                for (int i = 0; i < alumnos.length; i++) {
                    if(alumnos[i].getNombre().equalsIgnoreCase(nombAlu)){
                        dani.ponerNota(alumnos[i], notaAlu);
                    } else {
                        System.out.println("Ese alumno no existe");
                    }
                }
                break;
            case 4:    
                alumnos = dani.getAlumnos();
                for (int i = 0; i < alumnos.length; i++) {
                    System.out.println(alumnos[i]);
                }
                break;
            case 5:
                System.out.println("Escribe el nombre de el alumno: ");
                nombAlu = sc.next();
                alumnos = dani.getAlumnos();
                for (int i = 0; i < alumnos.length; i++) {
                    if(alumnos[i].getNombre().equalsIgnoreCase(nombAlu)){
                        System.out.println("El alumno " + alumnos[i].getNombre() + " tiene un total de " + alumnos[i].getNum_faltas() + " faltas");
                    } else {
                        System.out.println("Ese alumno no existe");
                    }
                }
                break;
            case 6:
            System.out.println("Escribe el nombre de el alumno: ");
            nombAlu = sc.next();
            alumnos = dani.getAlumnos();
            for (int i = 0; i < alumnos.length; i++) {
                if(alumnos[i].getNombre().equalsIgnoreCase(nombAlu)){
                    System.out.println("El alumno " + alumnos[i].getNombre() + " tiene un " + alumnos[i].getNota() + " en tu asignatura");
                } else {
                    System.out.println("Ese alumno no existe");
                }
            }
            break;
            default:
                System.out.println("Adios...");
                encendido = false;
                break;
        }
        }
        


    }


    
}

