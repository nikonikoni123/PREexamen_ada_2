public class App {
    public static void main(String[] args) {
        // Test de la clase CuentaBancaria:
        CuentaBancaria cuenta = new CuentaBancaria();
        cuenta.saldo = 1000.0;
        cuenta.depositar(500.0);

        // Se rompio :C
        System.out.println("Saldo inicial: " + cuenta.saldo);
        cuenta.retirar(2000.0);
        System.out.println("Saldo después de retiro: " + cuenta.saldo);
        cuenta.retirar(-100.0);
        System.out.println("Saldo después de retiro negativo: " + cuenta.saldo);
        cuenta.depositar(-50.0);
        System.out.println("Saldo después de depósito negativo: " + cuenta.saldo);
    }
}
