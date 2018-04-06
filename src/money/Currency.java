package money;

import misc.Debug;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Currency
{
    private String[] currencyList = {"USD", "CAD", "AUD", "GBP", "RUB", "EUR"};

    private Map<String, String> currencySigns;

    private String currencyType;
    private float amount;

    public Currency(float amount, String currencyType)
    {
        if(Arrays.asList(currencyList).contains(currencyType))
        {
            this.currencyType = currencyType;
            this.amount = amount;

            currencySigns = new HashMap<>();

            currencySigns.put("USD", "$");
            currencySigns.put("CAD", "$");
            currencySigns.put("AUD", "$");
            currencySigns.put("GBP", "£");
            currencySigns.put("RUB", "\u20BD");
            currencySigns.put("EUR", "€");
        }

        else
        {
            Debug.Error("Unknown currency: " + currencyType);
        }
    }

    public String getCurrencyType()
    {
        return currencyType;
    }

    public float getAmount()
    {
        return amount;
    }

    public String getAmountString()
    {
        return String.valueOf(amount);
    }

    public void setAmount(float amount)
    {
        this.amount = amount;
    }

    public String getText()
    {
        return currencySigns.get(currencyType) + amount;
    }
}