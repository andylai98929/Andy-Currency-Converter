package com.bootcamp.java;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExchangeRateConverter {

    public BigDecimal targetRate;

    public ExchangeRateConverter( Currency from, Currency to, String inputPath) {
        this.targetRate = getExactTargetRate(from, to, inputPath);
    }

    public static BigDecimal getExactTargetRate(Currency from, Currency to, String inputPath){
        ExchangeRateExtractor exchangeRateExtractor = new ExchangeRateExtractor(inputPath);

        if (from == to) {
            return BigDecimal.ONE;
        }

        if (from == Currency.EUR){
            return exchangeRateExtractor.getDailyExchangeRate().get(to);
        }

        if (to == Currency.EUR){
            return BigDecimal.ONE.divide(exchangeRateExtractor.getDailyExchangeRate().get(from), 6, RoundingMode.HALF_EVEN);
        }

        BigDecimal fromCurrencyRate = exchangeRateExtractor.getDailyExchangeRate().get(from);
        BigDecimal toCurrencyRate = exchangeRateExtractor.getDailyExchangeRate().get(to);
        BigDecimal targetRate = toCurrencyRate.divide(fromCurrencyRate, 6, RoundingMode.HALF_EVEN);

        return targetRate;
        //to/from  = target
        //input from value n to value , output exact rate

    }


}
