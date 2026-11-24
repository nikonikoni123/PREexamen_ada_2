package estacionamiento;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Estacionamiento {
    private static final int DEFECT_CAP = 50;

    private static final Properties MENSAJES = cargarMensajes();
    private static final String ENTRA_AUTO = MENSAJES.getProperty("ENTRA_AUTO");
    private static final String SALE_AUTO = MENSAJES.getProperty("SALE_AUTO");
    private static final String LLENO = MENSAJES.getProperty("LLENO");
    private static final String VACIO = MENSAJES.getProperty("VACIO");

    private final int capacidad;
    private int ocupados;
    private String estado = MENSAJES.getProperty("ESTADO_INICIAL");

    public Estacionamiento() {
        this(DEFECT_CAP);
    }

    public Estacionamiento(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException(MENSAJES.getProperty("CAPACIDAD_INVALIDA"));
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
        return "Autos dentro: " + ocupados + " | Cupos libres: " + cuposLibres();
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
        estado = entro ? ENTRA_AUTO + MENSAJES.getProperty("TOTAL") + " (" + ocupados + ")" : LLENO;
        return entro;
    }

    public boolean salir() {
        boolean salio = setOcupados(ocupados - 1);
        estado = salio ? SALE_AUTO + MENSAJES.getProperty("TOTAL") + " (" + ocupados + ")" : VACIO;
        return salio;
    }

    public int cuposLibres() {
        return capacidad - ocupados;
    }

    private static Properties cargarMensajes() {
        Properties props = new Properties();
        try (InputStream in = Estacionamiento.class.getResourceAsStream("mensajes.properties")) {
            if (in == null) {
                throw new IllegalStateException("No se encontro mensajes.properties");
            }
            props.load(new InputStreamReader(in, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new UncheckedIOException("No se pudo leer mensajes.properties", e);
        }
        return props;
    }
}
