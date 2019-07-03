import money.Currency;

public class Main
{
    public static void main(String[] args)
    {
        Currency money = new Currency(1234567, "USD");

        // $1,234,567
        System.out.println(money.getFormattedString());


        // $1.2M
        System.out.println(money.getBriefAmount());
    }
}