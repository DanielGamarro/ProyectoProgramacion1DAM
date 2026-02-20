package org.example;

import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() {

        BigDecimal ivaActual = new BigDecimal("0.21");
        GestorFacturas gestor = new GestorFacturas();

        try {
            // Añadimos datos de prueba
            gestor.addFactura(new LineaFactura(10, "Desarrollo Web", 50));
            gestor.addFactura(new LineaFactura(2, "Mantenimiento", 30));
            gestor.addFactura(new LineaFactura(20, "Consultoría App", 60));

            // 1. Probamos el Listado
            gestor.printFactures(ivaActual);

            // 2. Probamos el Top 2 (Lógica de Ranking)
            System.out.println("\n--- TOP 2 FACTURAS MÁS CARAS ---");
            for (LineaFactura f : gestor.topFacturesMoreValues(ivaActual)) {
                System.out.println(f.getConcept() + ": " + f.calculateTotal(ivaActual) + " €");
            }


            System.out.println("\n--- PROBANDO VALIDACIÓN ---");
            gestor.addFactura(new LineaFactura(1, "Web", 10));

        } catch (InvalidConceptException e) {
            System.out.println("Error controlado: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

}
