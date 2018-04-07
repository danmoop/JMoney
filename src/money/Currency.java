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
    private double amount;

    public Currency(double amount, String currencyType)
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

    public double getAmount()
    {
        return Math.round(amount * 100.0) / 100.0;
    }

    public String getAmountString()
    {
        return String.valueOf(Math.round(amount * 100.0) / 100.0);
    }

    public String getFormattedAmount()
    {
        String str_amount = getAmountString();

        String nums = str_amount.split("\\.")[0];
        String decimals = str_amount.split("\\.")[1];

        StringBuffer st = new StringBuffer(nums);

        for(int i = nums.length(); i > 0; i--)
        {
            if((nums.length() - i) % 3 == 0)
            {
                st.insert(i, ",");
            }
        }

        String result = String.valueOf(st.deleteCharAt(st.length() - 1));

        return currencySigns.get(currencyType) + result + "." + decimals;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public void add(double amount)
    {
        setAmount(getAmount() + amount);
    }

    public void subtract(double amount)
    {
        setAmount(getAmount() - amount);
    }

    public String getText()
    {
        return currencySigns.get(currencyType) + amount;
    }
}