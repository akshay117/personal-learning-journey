# Programs in java 8

# Q1 Given a list of integers, find out all the even numbers exist in the list using Stream functions?

```java

import java.util.*;
import java.util.stream.*;
public class MyClass {
    public static void main(String args[]) {
     List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
     list.stream()
         .filter(n -> n%2 == 0)
         .forEach(System.out::println);
    }
}
```

# Q2 Given a list of integers, find out all the numbers starting with 1 using Stream functions?

```java
import java.util.*;
import java.util.stream.*;
public class MyClass {
    public static void main(String args[]) {
     List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
     list.stream()
         .map( s -> s + "") //convert integer to string
         .filter(s-> s.startsWith("1"))
         .forEach(System.out::println);
    }
}
```

# Q3 How to find duplicate elements in a given integers list in java using Stream functions?

```java
import java.util.*;
import java.util.stream.*;
public class MyClass {
    public static void main(String args[]) {
     List<Integer> list = Arrays.asList(10,15,8,49,25,98,32,32);
     Set<Integer> set = new HashSet();
     
     list.stream()
         .filter(n -> !set.add(n))
         .forEach(System.out::println);
    }
}
```

# Q4 Given the list of integers, find the first element of the list using Stream functions?

```java

import java.util.*;
import java.util.stream.*;
public class MyClass {
    public static void main(String args[]) {
     List<Integer> list = Arrays.asList(10,15,8,49,25,98,32,32);
     
     list.stream()
         .findFirst()
         .ifPresent(System.out::println);
    }
}
```

# Q5 Given a list of integers, find the total number of elements present in the list using Stream functions?

```java
import java.util.*;
import java.util.stream.*;
public class MyClass {
    public static void main(String args[]) {
     List<Integer> list = Arrays.asList(10,15,8,49,25,98,32,32);
     
    long count =  list.stream()
         .count();
        System.out.println(count);
         
    }
}
```

# Q6 Given a list of integers, find the maximum value element present in it using Stream functions?

```java

import java.util.*;
import java.util.stream.*;
public class MyClass {
    public static void main(String args[]) {
     List<Integer> list = Arrays.asList(10,15,8,49,25,98,32,32);
     
    int  max  =  list.stream()
         .max(Integer::compare)
         .get();
        System.out.println(max);
         
    }
}
```


# Q7 Given a String, find the first non-repeated character in it using Stream functions?


```java

import java.util.*;
import java.util.stream.*;
import java.util.function.Function;
public class MyClass {
    public static void main(String args[]) {
   String input = "Java Hungry Blog Alive is Awesome";
     
      Character result = input.chars() // Stream of String       
                                    .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
                                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
                                    .entrySet()
                                    .stream()
                                    .filter(entry -> entry.getValue() == 1L)
                                    .map(entry -> entry.getKey())
                                    .findFirst()
                                    .get();
            System.out.println(result);                    
    }
}

```

# Q8 Given a String, find the first repeated character in it using Stream functions?

```java
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

public class JavaHungry {
    public static void main(String args[]) {
            String input = "Java Hungry Blog Alive is Awesome";

            Character result = input.chars() // Stream of String       
                                    .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
                                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
                                    .entrySet()
                                    .stream()
                                    .filter(entry -> entry.getValue() > 1L)
                                    .map(entry -> entry.getKey())
                                    .findFirst()
                                    .get();
            System.out.println(result);                    
    }
```

# Q9 Given a list of integers, sort all the values present in it using Stream functions?

```java

import java.util.*;
import java.util.stream.*;
import java.util.function.Function;
public class MyClass {
    public static void main(String args[]) {
  List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15); 
  myList.stream().sorted()
  .forEach(System.out::println);
    }
}
```

# Q10 Given a list of integers, sort all the values present in it in descending order using Stream functions?

  ```java

import java.util.*;
import java.util.stream.*;
import java.util.function.Function;
public class MyClass {
    public static void main(String args[]) {
  List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15); 
  myList.stream().sorted(Collections.reverseOrder())
  .forEach(System.out::println);
    }
}
 ```


