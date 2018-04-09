import bank.Bank;
import misc.Debug;
import money.Currency;

public class Main
{
    public static void main(String[] args)
    {
        Currency myMoney = new Currency(100000, "EUR");

        Debug.Log(myMoney.getFormattedAmount());

        Bank.setExchangeRate("EUR_GBP", 0.8);

        Currency myNewMoney = Bank.convert(myMoney, "GBP");

        Debug.Log(myNewMoney.getFormattedAmount());
    }
}