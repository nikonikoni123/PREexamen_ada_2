package estacionamiento;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

final class Mensajes {
    private static final Properties PROPS = cargar();

    private Mensajes() {
        
    }

    static String get(String clave) {
        return PROPS.getProperty(clave);
    }

    private static Properties cargar() {
        Properties props = new Properties();
        try (InputStream in = Mensajes.class.getResourceAsStream("mensajes.properties")) {
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
