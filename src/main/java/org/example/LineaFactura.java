package org.example;

import java.math.*;

public class LineaFactura  extends LineaBase{


    private final BigDecimal totalWorkingTime;
    private final BigDecimal moneyPerHour;

    public LineaFactura(double totalWorkingTime,String concept, double moneyPerHour) {
        super(concept);
        if (totalWorkingTime < 0 || moneyPerHour<0) {
            throw new IllegalArgumentException("Las horas o el precio no pueden ser negativas");
        }
        this.totalWorkingTime=BigDecimal.valueOf(totalWorkingTime);
        this.moneyPerHour = BigDecimal.valueOf(moneyPerHour);

    }




    public BigDecimal getTotalWorkingTime() {
        return totalWorkingTime;
    }

    public BigDecimal getMoneyPerHour() {
        return moneyPerHour;
    }

    @Override
    public BigDecimal calculateTotal(BigDecimal iva){
        BigDecimal base=this.moneyPerHour.multiply(this.totalWorkingTime);
        BigDecimal calcularIva=base.multiply(iva);
        BigDecimal total=base.add(calcularIva);
        return total.setScale(2,RoundingMode.HALF_UP);
    }
}


