package nomina;

import java.util.Optional;
import java.util.function.Predicate;

public abstract class Empleado {
    private static int contador = 0;

    private final int id;
    private final String nombre;

    protected Empleado(String nombre) {
        this.nombre = validar(nombre, texto -> !texto.isBlank(), "error.nombre").strip();
        this.id = ++contador;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double salario();

    @Override
    public String toString() {
        return Mensajes.get("empleado.detalle", id, nombre, salario());
    }

    protected static double noNegativo(double valor, String claveError) {
        return validar(valor, numero -> numero >= 0, claveError);
    }

    private static <T> T validar(T valor, Predicate<T> esValido, String claveError) {
        return Optional.ofNullable(valor)
                .filter(esValido)
                .orElseThrow(() -> new IllegalArgumentException(Mensajes.get(claveError, valor)));
    }
}
