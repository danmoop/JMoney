import bank.Bank;
import misc.Debug;
import money.Currency;

public class Main
{
    public static void main(String[] args)
    {
        Currency myMoney = new Currency(100000, "RUB");

        Debug.Log(myMoney.getFormattedAmount());

        Bank.setExchangeRate("RUB_CAD", 0.022);

        Currency myNewMoney = Bank.convert(myMoney, "CAD");

        Debug.Log(myNewMoney.getFormattedAmount());
    }
}