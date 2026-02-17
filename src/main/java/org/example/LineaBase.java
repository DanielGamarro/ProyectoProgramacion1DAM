package org.example;

import java.math.BigDecimal;

public class LineaBase {

    protected String concept;
    public LineaBase(String concept){
        if (concept==null || concept.length()<5){
            throw new ExcepcionInvalidoConcepto("El concepto " + concept + " es demasiado corto");
        }
        this.concept=concept;
    }

    public String getConcept() {
        return concept;
    }

    public BigDecimal calculateTotal(BigDecimal tax){
        return BigDecimal.ZERO;
    }
}
