# JMoney
JMoney is a library for dealing with money and currency conversations (For Spring app for example)

This is supposed to be Java version of [Ruby money library](https://github.com/RubyMoney/money)

***

Get started by creating your currency

``` java
Currency myMoney = new Currency(255850, "USD");
myMoney.getCurrencyType(); // USD
```

Get amount (instanceof double) or string

``` java
myMoney.getAmount(); // 255850.0
myMoney.getAmountString(); // 255850.0
```

There is sign for each currency and amount digits are divided by comas

``` java
myMoney.getFormattedAmount(); // $255,850.0
```

Easy operations and conversations
``` java
myMoney.add(10000); // 265850.0
myMoney.subtract(10000); // 245850.0
```

Convert your currency to others
``` java
Currency myNewMoney = Bank.convert(myMoney, "RUB");
myNewMoney.getFormattedAmount(); // ₽14,880,363.93

or

Currency myNewMoney = Bank.convert(myMoney, "EUR");
myNewMoney.getFormattedAmount(); // €208,338.66
```

Set your custom exchange rate for any currencies
```java 
Currency myMoney = new Currency(1000, "EUR");
myMoney.getFormattedAmount(); // €1,000.0
Bank.setExchangeRate("EUR_GBP", 0.871);
Currency myNewMoney = Bank.convert(myMoney, "GBP");
myNewMoney.getFormattedAmount(); // £871.0 
```
