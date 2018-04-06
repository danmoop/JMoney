package misc;

public class Debug
{
    public static void Log(Object msg)
    {
        System.out.println(msg);
    }

    public static void Error(String error)
    {
        throw new java.lang.Error(error);
    }
}
