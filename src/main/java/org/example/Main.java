package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        try {
            LineaFactura lineaBien = new LineaFactura(10, "Web", 50);
            System.out.println("Esto se imprime");
            LineaFactura lineaMal = new LineaFactura(-5, "Error", 50);
            System.out.println("Esto NUNCA se imprimirá");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
