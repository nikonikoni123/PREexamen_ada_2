package estacionamiento;

public class Estacionamiento {
    private static final int DEFECT_CAP = 50;

    private final int capacidad;
    private int ocupados;
    private String estado = Mensajes.get("ESTADO_INICIAL");

    public Estacionamiento() {
        this(DEFECT_CAP);
    }

    public Estacionamiento(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException(Mensajes.get("CAPACIDAD_INVALIDA"));
        }
        this.capacidad = capacidad;
        this.ocupados = 0;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getOcupados() {
        return ocupados;
    }

    public String getEstado() {
        return estado;
    }

    public String resumen() {
        return String.format(Mensajes.get("RESUMEN"), ocupados, cuposLibres());
    }

    private boolean setOcupados(int nuevoValor) {
        if (nuevoValor < 0 || nuevoValor > capacidad) {
            return false;
        }
        this.ocupados = nuevoValor;
        return true;
    }

    public boolean entrar() {
        boolean entro = setOcupados(ocupados + 1);
        estado = entro ? Mensajes.get("ENTRA_AUTO") + Mensajes.get("TOTAL") + " (" + ocupados + ")" : Mensajes.get("LLENO");
        return entro;
    }

    public boolean salir() {
        boolean salio = setOcupados(ocupados - 1);
        estado = salio ? Mensajes.get("SALE_AUTO") + Mensajes.get("TOTAL") + " (" + ocupados + ")" : Mensajes.get("VACIO");
        return salio;
    }

    public int cuposLibres() {
        return capacidad - ocupados;
    }
}
