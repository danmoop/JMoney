import bank.Bank;
import misc.Debug;
import money.Currency;

public class Main
{
    public static void main(String[] args)
    {
        Currency myMoney = new Currency(1000, "CHF");

        myMoney.setCurrencySign("CHF");

        Bank.setExchangeRate("CHF_RUB", 64.32);

        Currency myRubs = Bank.convert(myMoney, "RUB");

        Debug.Log(myRubs.getFormattedAmount());
    }
}