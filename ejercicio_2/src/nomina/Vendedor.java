package nomina;

public final class Vendedor extends EmpleadoFijo {
    private final double comision;

    public Vendedor(String nombre, double salarioMensual, double comision) {
        super(nombre, salarioMensual);
        this.comision = noNegativo(comision, "error.comision");
    }

    @Override
    public double salario() {
        return super.salario() + comision;
    }
}
