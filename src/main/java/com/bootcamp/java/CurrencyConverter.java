package com.bootcamp.java;

import org.apache.commons.cli.*;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CurrencyConverter {

    public CurrencyConverter(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public String inputFilePath;

    public static void main(String[] args) {
        Options options = new Options();
        Option fromCurrency = new Option("f",
                "from",
                true,
                "from currency");

        fromCurrency.setRequired(true);
        options.addOption(fromCurrency);

        Option toCurrency = new Option ("t",
                "to",
                true,
                "to currency");
        toCurrency.setRequired(true);
        options.addOption(toCurrency);

        Option amount = new Option("a",
                "amount",
                true,
                "amount");
        amount.setRequired(true);
        options.addOption(amount);

        Option inputPath = new Option("i",
                "input",
                true,
                "input file path");
        inputPath.setRequired(true);
        options.addOption(inputPath);

        HelpFormatter formatter = new HelpFormatter();
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        try{
            cmd = parser.parse(options, args);
        } catch (ParseException e){
            System.out.println(e.getMessage());
            formatter.printHelp("Please enter correct argument",options);
            System.exit(1);
            return;
        }

        Path path = Paths.get(cmd.getOptionValue("input"));

        Currency from = Currency.valueOf(cmd.getOptionValue("f"));
        Currency to = Currency.valueOf(cmd.getOptionValue("t"));
        String input = cmd.getOptionValue("i");
        BigDecimal amountToChange = new BigDecimal(cmd.getOptionValue("a"));

        ExchangeRateExtractor exchangeRateExtractor = new ExchangeRateExtractor(input);
        ExchangeRateConverter exchangeRateConverter = new ExchangeRateConverter(from ,to , input);

        BigDecimal finalAmount = PrincipalCalculator.getResultingPrincipal(from, to, amountToChange, input);

        System.out.println(finalAmount);


//        for (Currency currency : Currency){
//
//        }


//        (Currency)cmd.getOptionValue("FromCurrency");










//        CurrencyConverter input = new CurrencyConverter("aa");
    }
}
