package nomina;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public final class Mensajes {
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("nomina.mensajes");

    private Mensajes() {
    }

    public static String get(String clave, Object... argumentos) {
        return MessageFormat.format(BUNDLE.getString(clave), argumentos);
    }
}
