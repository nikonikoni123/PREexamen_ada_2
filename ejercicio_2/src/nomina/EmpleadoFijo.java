package nomina;

public class EmpleadoFijo extends Empleado {
    private final double salarioMensual;

    public EmpleadoFijo(String nombre, double salarioMensual) {
        super(nombre);
        this.salarioMensual = noNegativo(salarioMensual, "error.salario");
    }

    @Override
    public double salario() {
        return salarioMensual;
    }
}
