package Ejercicio05;

public class RegistroEstudiantes {

    private Estudiante[] estudiantes;
    private int cantidad;

    private ValidadorEstudiante validador;
    private BuscadorEstudiantes buscador;

    public RegistroEstudiantes(int capacidad) {

        estudiantes = new Estudiante[capacidad];
        cantidad = 0;

        validador = new ValidadorEstudiante();
        buscador = new BuscadorEstudiantes();
    }

    public void agregarEstudiante(
            Estudiante estudiante) {

        validador.validarNombre(
                estudiante.getNombre()
        );

        if (cantidad >= estudiantes.length) {

            throw new IllegalArgumentException(
                    "El registro esta lleno."
            );
        }

        estudiantes[cantidad] = estudiante;
        cantidad++;

        System.out.println(
                "Estudiante agregado correctamente."
        );
    }

    public Estudiante buscarEstudiante(
            String nombre) {

        return buscador.buscar(
                estudiantes,
                cantidad,
                nombre
        );
    }

    public void mostrarEstudiantes() {

        System.out.println(
                "\n=== REGISTRO DE ESTUDIANTES ==="
        );

        if (cantidad == 0) {

            System.out.println(
                    "No hay estudiantes registrados."
            );

            return;
        }

        for (int i = 0; i < cantidad; i++) {

            System.out.println(
                    (i + 1) + ". "
                    + estudiantes[i].getNombre()
            );
        }
    }
}