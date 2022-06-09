package com.bootcamp.java;

import org.junit.jupiter.api.Test;

;import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PrincipalCalculatorTest {

    @Test
    public void shouldGiveResultingPrincipal() {
        ExchangeRateConverter exchangeRateConverter = new ExchangeRateConverter(Currency.USD, Currency.CAD, "fx-rates.xml");
        BigDecimal targetRate = exchangeRateConverter.targetRate;
        BigDecimal amount = BigDecimal.valueOf(10000);
        assertEquals(BigDecimal.valueOf(12788.13), PrincipalCalculator.getResultingPrincipal(Currency.USD, Currency.CAD, amount, "fx-rates.xml") );
    }


}
