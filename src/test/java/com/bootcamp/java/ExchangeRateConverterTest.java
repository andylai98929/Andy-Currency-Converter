package com.bootcamp.java;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.bootcamp.java.ExchangeRateConverter.getExactTargetRate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExchangeRateConverterTest {

    @Test
    public void shouldGetExactTargetRate(){
        ExchangeRateExtractor exchangeRateExtractor = new ExchangeRateExtractor("fx-rates.xml");
        ExchangeRateConverter exchangeRateConverter = new ExchangeRateConverter(Currency.USD, Currency.CAD, "fx-rates.xml");
        assertEquals(BigDecimal.valueOf(1.278813), exchangeRateConverter.targetRate);
        // eg USD to CAD, hardcode assertEqual;
    }

    @Test
    public void shouldGetExactTargetRateWhenFromEUR(){
        ExchangeRateExtractor exchangeRateExtractor = new ExchangeRateExtractor("fx-rates.xml");
        ExchangeRateConverter exchangeRateConverter = new ExchangeRateConverter(Currency.EUR, Currency.CAD, "fx-rates.xml");
        assertEquals(BigDecimal.valueOf(1.3526), exchangeRateConverter.targetRate);
        // eg USD to CAD, hardcode assertEqual;
    }
    @Test
    public void shouldGetExactTargetRateWhenSameCurrency(){
        ExchangeRateExtractor exchangeRateExtractor = new ExchangeRateExtractor("fx-rates.xml");
        ExchangeRateConverter exchangeRateConverter = new ExchangeRateConverter(Currency.USD, Currency.USD, "fx-rates.xml");
        assertEquals(BigDecimal.valueOf(1), exchangeRateConverter.targetRate);
        // eg USD to CAD, hardcode assertEqual;
    }

    @Test
    public void shouldGetExactTargetRateWhenToEUR(){
        ExchangeRateExtractor exchangeRateExtractor = new ExchangeRateExtractor("fx-rates.xml");
        ExchangeRateConverter exchangeRateConverter = new ExchangeRateConverter(Currency.USD, Currency.EUR, "fx-rates.xml");
        assertEquals(new BigDecimal("0.945448"), exchangeRateConverter.targetRate);
        // eg USD to CAD, hardcode assertEqual;
    }




}
