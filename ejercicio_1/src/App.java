import estacionamiento.Estacionamiento;

public class App {
    public static void main(String[] args) throws Exception {
        Estacionamiento parqueadero = new Estacionamiento(3);
        System.out.println(parqueadero.getEstado());
        System.out.println(parqueadero.resumen());
        System.out.println();
        parqueadero.entrar();
        System.out.println(parqueadero.getEstado());
        parqueadero.entrar();
        System.out.println(parqueadero.getEstado());
        parqueadero.entrar();
        System.out.println(parqueadero.getEstado());
        parqueadero.entrar();
        System.out.println(parqueadero.getEstado());
        System.out.println(parqueadero.resumen());
        System.out.println();
        parqueadero.salir();
        System.out.println(parqueadero.getEstado());
        parqueadero.salir();
        System.out.println(parqueadero.getEstado());
        parqueadero.salir();
        System.out.println(parqueadero.getEstado());
        parqueadero.salir();
        System.out.println(parqueadero.getEstado());
        System.out.println(parqueadero.resumen());
        System.out.println();
        try {
            new Estacionamiento(0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
