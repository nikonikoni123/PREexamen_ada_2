import nomina.EmpleadoFijo;
import nomina.EmpleadoPorHora;
import nomina.Nomina;
import nomina.Vendedor;

public class App {
    public static void main(String[] args) {
        Nomina nomina = new Nomina();
        nomina.agregar(new EmpleadoFijo("Ana", 2_500_000));
        nomina.agregar(new EmpleadoPorHora("Luis", 120, 15_000));
        nomina.agregar(new Vendedor("Marta", 2_000_000, 350_000));
        System.out.println(nomina.resumen() + "\n");
        nomina.agregar(new EmpleadoFijo("Pedro", 3_000_000));
        
        System.out.println("\n================================");

        try {
            nomina.agregar(new EmpleadoPorHora("Lucas", -5, 15_000));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(nomina.resumen() + "\n");

        System.out.println("================================");

        nomina.eliminar("Pedro");
        System.out.println(nomina.resumen() + "\n");

        System.out.println("================================");

        nomina.eliminar(2);
        System.out.println(nomina.resumen());
    }
}
