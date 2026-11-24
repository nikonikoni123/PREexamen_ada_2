package nomina;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Nomina {
    private final List<Empleado> empleados = new ArrayList<>();

    public void agregar(Empleado empleado) {
        empleados.add(Objects.requireNonNull(empleado, () -> Mensajes.get("error.empleado")));
    }

    public boolean eliminar(String nombre) {
        return empleados.removeIf(empleado -> empleado.getNombre().equalsIgnoreCase(nombre));
    }

    public boolean eliminar(int id) {
        return empleados.removeIf(empleado -> empleado.getId() == id);
    }

    public static double pagarTotal(List<? extends Empleado> lista) {
        Objects.requireNonNull(lista, () -> Mensajes.get("error.lista"));
        return lista.stream()
                .mapToDouble(Empleado::salario)
                .sum();
    }

    public String resumen() {
        StringBuilder texto = new StringBuilder();
        for (Empleado empleado : empleados) {
            texto.append(empleado).append(System.lineSeparator());
        }
        return texto.append(Mensajes.get("nomina.total", pagarTotal(empleados))).toString();
    }
}
