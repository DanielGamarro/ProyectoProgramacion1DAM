package org.example;

import java.math.BigDecimal;

public abstract class LineaBase {

    private String concept;

    public LineaBase(String concept) {
        if (concept == null || concept.length() < 5) {
            throw new InvalidConceptException("El concepto " + concept + " es demasiado corto");
        }
        this.concept = concept;
    }

    public String getConcept() {
        return concept;
    }


    public abstract BigDecimal calculateTotal(BigDecimal tax);


}
