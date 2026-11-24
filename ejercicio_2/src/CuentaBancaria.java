public class CuentaBancaria {
    // no tiene abstraccion esto hace a este atributo accesible desde cualquier clase.
    public double saldo;

    // No posee constructor, al declararse un objeto de esta clase no se inicializa el atributo.

    public void depositar(double m) {
        // No hay validacion de que el monto sea positivo, por lo que se puede depositar un monto negativo y disminuir el saldo.
        // Se puede simplificar la operacion de suma con el operador +=
        // Se puede depositar un monto igual a cero, lo que no tiene sentido para la regla de negocio.
        // el atributo m no tiene un retorno o log, por lo que no se puede saber si la operacion fue exitosa o no.
        saldo = saldo + m;
    }

    public void retirar(double m) {
        // No hay validacion de que el monto ingresado sea positivo, por lo que se puede extraer un monto negativo y aumentar el saldo.
        // Se puede simplificar la operacion de resta con el operador -=
        // Se puede extraer un monto igual a cero, lo que no tiene sentido para la regla de negocio.
        // el atributo m no tiene un retorno o log, por lo que no se puede saber si la operacion fue exitosa o no.
        saldo = saldo - m;
    }

    // No hay metodos de retorno para obtener el saldo actual, por lo que no se puede saber el estado de la cuenta bancaria.
    // No tiene getters ni setters.
    // En base al nombre de la clase, se puede asumir que es una cuenta bancaria, pero no hay validaciones de usuario.
    // No hay validaciones de que tipeo de dato que se ingresa.
}

// FRASE: 
    // El código de la clase CuentaBancaria tiene problemas de encapsulamiento, validación de datos y manejo de errores, 
    // lo que puede llevar a inconsistencias en el saldo y dificultades para mantener la integridad de la cuenta bancaria.
