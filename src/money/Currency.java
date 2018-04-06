package money;

import misc.Debug;

import java.util.Arrays;

public class Currency
{
    private String[] currencyList = {"USD", "CAD", "AUD", "GBP", "RUB", "EUR"};

    public Currency(float amount, String currencyType)
    {
        if(Arrays.asList(currencyList).contains(currencyType))
        {
            
        }

        else
        {
            Debug.Error("Unknown currency: " + currencyType);
        }
    }
}