import bank.Bank;
import money.Currency;

public class Main
{
    public static void main(String[] args)
    {
        Currency money = new Currency(1071231491, "USD");

        Bank.setExchangeRate("USD_RUB", 132);

        System.out.println(money.getFormattedString());
    }
}