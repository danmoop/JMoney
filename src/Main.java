import misc.Debug;
import money.Currency;

public class Main
{
    public static void main(String[] args)
    {
        Currency myCurr = new Currency(500, "EUR");

        Debug.Log("Amount: " + myCurr.getAmount());
        Debug.Log("Currency: " + myCurr.getCurrencyType());
        Debug.Log("Currency Str: " + myCurr.getAmountString());
        Debug.Log("Text for display: " + myCurr.getText());
    }
}