# To convert int to String use the following methods.

```java
int i =10;

String s = Integer.toString(i);
String s = String.valueOf(i);
String s = String.format("%d",i);
```
# Using scanner

```
int i = scan.nextInt();
double d = scan.nextDouble();
String s = scan.nextLine();
```

# Static Initialization Blocks
A static initialization block is a normal block of code enclosed in braces, { }, and preceded by the static keyword.Static initialization blocks are executed when the class is loaded, and you can initialize static variables in those blocks.

```java
static {
    // whatever code is needed for initialization goes here
}
```

# find the day name from date using joda api

```java
...
import java.time.LocalDate;
...
//String month = in.next();
int mm = in.nextInt();
//String day = in.next();
int dd = in.nextInt();
//String year = in.next();
int yy = in.nextInt();
in.close();

 public static String findDay(int month, int day, int year) {
      
      LocalDate dt = LocalDate.of(year,month,day);
      String s = dt.getDayOfWeek().toString();
      return s;

    }
```

# Format currency using NumberFormat

```java
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class Solution {
    
    public static void main(String[] args) {
        /* Read input */
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        /* Create custom Locale for India. 
          I used the "IANA Language Subtag Registry" to find India's country code */
        Locale indiaLocale = new Locale("en", "IN");

        /* Create NumberFormats using Locales */
        NumberFormat us     = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat india  = NumberFormat.getCurrencyInstance(indiaLocale);
        NumberFormat china  = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        /* Print output */        
        System.out.println("US: "     + us.format(payment));
        System.out.println("India: "  + india.format(payment));
        System.out.println("China: "  + china.format(payment));
        System.out.println("France: " + france.format(payment));
    }
}
```

# JAVA Strings
## lexograohicalCheck
```
  public static String lexograohicalCheck(String a, String b){
        String result = "Yes";
        if(a.compareTo(b) > 0){
            return result;
        }else {
            result = "No";
            return result;
        }
    }
 ```
 ## Capitalise first letter of a String using substring method
 ```
    public static String capitalize(String str) {
    if(str == null || str.isEmpty()) {
        return str;
    }

    return str.substring(0, 1).toUpperCase() + str.substring(1);
}
```

# lexicographically smallest and largest substrings of length k,

