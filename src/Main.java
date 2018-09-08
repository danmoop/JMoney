import misc.Debug;
import money.Currency;

public class Main
{
    public static void main(String[] args)
    {
        Currency myMoney = new Currency(12561200, "USD");

        Debug.Log(myMoney.getBriefAmount());
    }
}