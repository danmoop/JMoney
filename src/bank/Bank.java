package bank;

import misc.Debug;
import money.Currency;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Bank
{
    private static String[] currencyList = Currency.currencyList;
    private static Map<String, String> currencySigns;
    private static Map<String, Double> exchangeRate = new HashMap<>();

    public static Currency convert(Currency firstCur, String secondCur)
    {
        if(Arrays.asList(currencyList).contains(secondCur))
        {
            createCurrencySigns();
            createCurrencyRates();

            if(firstCur.getCurrencyType().contains(secondCur))
                Debug.Error("You can't convert currency to the same one.");

            Double newBalance = firstCur.getAmount() * exchangeRate.get(firstCur.getCurrencyType()+"_"+secondCur);

            return new Currency(newBalance, secondCur);
        }

        else
        {
            Debug.Error("Unknown currency: " + secondCur);
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

    public static void createCurrencyRates()
    {
        exchangeRate.put("EUR_USD", 1.22817);
        exchangeRate.put("USD_EUR", 0.8143);

        exchangeRate.put("USD_RUB", 58.1605);
        exchangeRate.put("RUB_USD", 0.01719);

        exchangeRate.put("EUR_RUB", 71.4450);
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
        createCurrencyRates();

        getExchangeRate().put(currencyNames, rate);
    }
}
