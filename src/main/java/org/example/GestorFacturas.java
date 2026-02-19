package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GestorFacturas {

    private final List<LineaFactura> misFacturas;


    public GestorFacturas() {

        this.misFacturas = new ArrayList<>();
    }


    public void addFactura(LineaFactura factura) {

        this.misFacturas.add(factura);
    }


    public void printFactures(BigDecimal iva) {
        System.out.println("---FACTURAS---");
        for (LineaFactura factura : this.misFacturas) {

            System.out.println(factura.getConcept() + " - " + factura.calculateTotal(iva) + " €");
        }
    }

    public LineaFactura searchByConcept(String conceptoAbuscar) {

        for (LineaFactura factura : this.misFacturas) {
            if (factura.getConcept().equalsIgnoreCase(conceptoAbuscar)) {
                return factura;
            }
        }

        return null;
    }


    public BigDecimal sumarTiemposTotales() {
        BigDecimal acumulador = BigDecimal.ZERO;
        for (LineaFactura fact : misFacturas) {
            acumulador = acumulador.add(fact.getTotalWorkingTime());
        }
        return acumulador;
    }


    public List<LineaFactura> filterFact(double precioMin) {
        List<LineaFactura> resultado = new ArrayList<>();
        for (LineaFactura fact : misFacturas) {
            if (fact.getMoneyPerHour().doubleValue() > precioMin) {
                resultado.add(fact);
            }
        }
        return resultado;
    }

    public List<LineaFactura> topFacturesMoreValues(BigDecimal iva) {
        LineaFactura fact1 = null;
        LineaFactura fact2 = null;
        for (LineaFactura fact : misFacturas) {
            BigDecimal totalActual = fact.calculateTotal(iva);
            if (fact1 == null || totalActual.compareTo(fact1.calculateTotal(iva)) > 0) {
                fact2 = fact1;
                fact1 = fact;
            } else if (fact2 == null || totalActual.compareTo(fact2.calculateTotal(iva)) > 0) {
                fact2 = fact;
            }
        }
        List<LineaFactura> top2 = new ArrayList<>();
        if (fact1 != null) {
            top2.add(fact1);
        }
        if (fact2 != null) {
            top2.add(fact2);
        }
        return top2;


    }
}