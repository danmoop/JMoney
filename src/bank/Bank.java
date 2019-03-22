package bank;

import misc.Debug;
import money.Currency;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank
{
    private static List<String> currencyList = Currency.getCurrencyList();
    private static Map<String, String> currencySigns;
    private static Map<String, Double> exchangeRate = new HashMap<>();

    public static Currency convert(Currency firstCurrency, String secondCurrency)
    {
        if(currencyList.contains(secondCurrency))
        {
            createCurrencySigns();

            if(exchangeRate.size() == 0)
                createCurrencyRates();

            if(firstCurrency.getCurrencyType().contains(secondCurrency))
                return firstCurrency;

            if(exchangeRate.get(firstCurrency.getCurrencyType()+"_"+secondCurrency) != null)
            {
                double newBalance = firstCurrency.getAmount() * exchangeRate.get(firstCurrency.getCurrencyType() + "_" + secondCurrency);
                return new Currency(newBalance, secondCurrency);
            }

            else
            {
                Debug.Log("Exchange rate " + firstCurrency.getCurrencyType() + "_" + secondCurrency + " is not found. \n Add it manually using Bank.setExchangeRate('" + firstCurrency.getCurrencyType()+"_"+secondCurrency+"', rate);");
                return null;
            }
        }

        else
        {
            Debug.Error("Unknown currency: " + secondCurrency);
            return null;
        }
    }

    private static void createCurrencySigns()
    {
        currencySigns = new HashMap<>();

        currencySigns.put("USD", "$");
        currencySigns.put("CAD", "$");
        currencySigns.put("AUD", "$");
        currencySigns.put("GBP", "£");
        currencySigns.put("RUB", "\u20BD");
        currencySigns.put("EUR", "€");
    }

    private static void createCurrencyRates()
    {
        exchangeRate.put("EUR_USD", 1.22817);
        exchangeRate.put("USD_EUR", 0.8143);

        exchangeRate.put("USD_RUB", 69.91); // :(
        exchangeRate.put("RUB_USD", 0.01719);

        exchangeRate.put("EUR_RUB", 80.9);
        exchangeRate.put("RUB_EUR", 0.014);
    }

    public static Map<String, Double> getExchangeRate()
    {
        if(exchangeRate.size() != 0)
            return exchangeRate;
        else
        {
            createCurrencyRates();
            return exchangeRate;
        }
    }

    public static void setExchangeRate(String currencyNames, double rate)
    {
        if(exchangeRate.size() == 0)
            createCurrencyRates();

        getExchangeRate().put(currencyNames, rate);
    }
}
