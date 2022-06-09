package com.bootcamp.java;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class PrincipalCalculator {
    public static BigDecimal getResultingPrincipal( Currency from, Currency to, BigDecimal amount, String inputPath){
        ExchangeRateConverter exchangeRateConverter = new ExchangeRateConverter(from, to ,inputPath);
        MathContext m = new MathContext(4);
        BigDecimal resultingPrincipal = exchangeRateConverter.targetRate.multiply(amount).setScale(2, RoundingMode.HALF_EVEN);
        return resultingPrincipal;
    }

}
