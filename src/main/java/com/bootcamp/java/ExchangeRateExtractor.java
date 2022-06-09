package com.bootcamp.java;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ExchangeRateExtractor {

    public static CurrencyConverter input;

    public Currency currency;

    public Map<Currency , BigDecimal> dailyExchangeRate;

    public static Map<Currency , BigDecimal> extractXML(String inputPath){
//        CommonCli_For_Input input = new CommonCli_For_Input("aa");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Map<Currency , BigDecimal> dailyExchangeRate = new HashMap<>();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputPath);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Cube");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getAttributes().getNamedItem("currency")!=null){
                    dailyExchangeRate.put(Currency.valueOf(nNode.getAttributes().getNamedItem("currency").getNodeValue())
                            , new BigDecimal(nNode.getAttributes().getNamedItem("rate").getNodeValue()));
                }
//                System.out.println(dailyExchangeRate);
                //.getNodeValue());
//                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//                    Element eElement = (Element) nNode;
//                    if (eElement.getAttribute() == "currency"){
//
//                    }
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dailyExchangeRate;



    }

//    public static void main(String[] args) {
//        extractXML("fx-rates.xml");
//    }

    public ExchangeRateExtractor(String inputPath) {
        this.dailyExchangeRate = extractXML(inputPath);
    }



    public Map<Currency, BigDecimal> getDailyExchangeRate() {
        return dailyExchangeRate;
    }
}
