# JMoney
JMoney is a library for dealing with money and currency conversations (For Spring app for example)

This is supposed to be Java version of [Ruby money library](https://github.com/RubyMoney/money)

***

Get started by creating your currency

``` java
Currency myMoney = new Currency(1500, "USD");
myMoney.getCurrencyType(); // USD
```

Get amount (instanceof double) or string

``` java
myMoney.getAmount(); // 1500.0 (double type)
myMoney.getAmountString(); // 1500.0 (string type)
```

There is sign for each currency and amount digits are divided by comas

``` java
myMoney.getFormattedString(); // $1,500.0
```

``` java
Currency myMoney = new Currency(12561200, "USD");
myMoney.getBriefAmount(); // 12.6M
```

Easy operations and conversations
``` java
myMoney.add(500); // 2000.0
myMoney.subtract(500); // 1000.0
```

Convert your currency to others
``` java
Currency myNewMoney = Bank.convert(myMoney, "RUB");
myNewMoney.getFormattedAmount(); // ₽135,032.93

or

Currency myNewMoney = Bank.convert(myMoney, "EUR");
myNewMoney.getFormattedAmount(); // €1,720.66
```

Set your custom exchange rate for any currencies
```java 
Currency myMoney = new Currency(1000, "EUR");
myMoney.getFormattedAmount(); // €1,000.0
Bank.setExchangeRate("EUR_GBP", 0.871);
Currency myNewMoney = Bank.convert(myMoney, "GBP");
myNewMoney.getFormattedAmount(); // £871.0 
```
