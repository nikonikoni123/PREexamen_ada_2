package nomina;

public final class EmpleadoPorHora extends Empleado {
    private final double horas;
    private final double tarifaPorHora;

    public EmpleadoPorHora(String nombre, double horas, double tarifaPorHora) {
        super(nombre);
        this.horas = noNegativo(horas, "error.horas");
        this.tarifaPorHora = noNegativo(tarifaPorHora, "error.tarifa");
    }

    @Override
    public double salario() {
        return horas * tarifaPorHora;
    }
}
