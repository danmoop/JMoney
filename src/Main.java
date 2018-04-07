import misc.Debug;
import money.Currency;

public class Main
{
    public static void main(String[] args)
    {
        Currency myCurr = new Currency(63366.34, "USD");

        Debug.Log("BEFORE: " + myCurr.getFormattedAmount());

        myCurr.subtract(31212.13);

        Debug.Log("AFTER: " + myCurr.getFormattedAmount());

    }
}