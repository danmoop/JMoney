import misc.Debug;
import money.Currency;

public class Main
{
    public static void main(String[] args)
    {
        Currency myMoney = new Currency(15000, "BTC");

        myMoney.hideCurrencySign();

        Debug.Log(myMoney.getFormattedAmount());
    }
}