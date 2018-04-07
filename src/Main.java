import bank.Bank;
import misc.Debug;
import money.Currency;

public class Main
{
    public static void main(String[] args)
    {
        Currency myCurr = new Currency(101554.32, "USD");
        Debug.Log(myCurr.getFormattedAmount());
        Currency myCurr2 = Bank.convert(myCurr, "USD");
        Debug.Log(myCurr2.getFormattedAmount());
    }
}