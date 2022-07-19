
# JAVA 8 Features

1. lambda Expressions
2. Functional Interfaces
3. Default methods in Interface
4. Static Methods in Interfaces.
5. Predicate
6. Function
7. Consumer
8. Supplier
9. Method refernce & constructor reference by Double colon(::) operator.
10 Stream API
11. Date & Time API ( Joda API)
12. NashHorn JavaScript Engine

# Lambda Expression
The main objective is to enable fucntional programing.

Anonymous Function : function which is nameless,without return type,without modifiers
```
(a,b) -> System.out.println("Hello);
```


# Functional Interface

Interface which contains only single abstract Method.If we want to invoke Lambda expression we need functional interface.

Optionally annotated with *@FunctionalInterface* annotation.

A interface can contain default method or static methods but should only contain 1 abstract method to be able to be a functional interface.

**Functional Interace WRT to Inheritance** 
```java
@FunctionalInterface
Interface interf {
    public void m1();
}

Interface B extends interf {

}
//Now interface b is also a functional interface
```
**Using Functional Interface to invoke lambda Expression**

```java
Interface Interf {
    public void m1();
}
Class Test {
    public static void main(String[] args){
        Interf i = () -> System.out.println(" Hello from lambda expression" );
        i.m1();   //Calling the method
    }
}
```

Eg:

```java
Interface Interf {
    public int squareIt(int n);
}
Class Test {
    public static void main(String[] args){
        Interf i = n -> n*n;
    }
}
```
### LamdaExpression for Multi Threading and Collections

**Defining A thread**

```
By implementing runnable interface.
By extending thread class.
```

```java
//OLD

class MyRunnable implements Runnable{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Child Thread");
        }
    }
}
class Test {
    public static void main(String[] args){
       MyRunnable r = new MyRunnable;
       Threadt t =  new Thread(r); 
       t.start();

       for(int i = 0 ; i<10 ;i++){
       System.out.println("Main Thread")
       }
    }
}

```
**Using lambda expression Runnable functional interface can be written below.Use this way from now on,Forget the old ways**
```java

//NEW
class Test {
    public static void main(String[] args){

       Runnable r = ()-> {
       for(int i = 0 ; i<10 ;i++){
       System.out.println("Child Thread");
       }
       };
       Threadt t =  new Thread(r); 
       t.start();

       for(int i = 0 ; i<10 ;i++){
       System.out.println("Main Thread")
       }
    }
}
```

**Lambda Expression on Collections**

```java
//OLD
class MyComparator implements Comparator<Integer>{
    public int compare(Integer I1,Integer I2){
            //Ternary operator
    return (I1<I2)?-1:(I1>I2)?1:0; 

    }
}

class Test {
    public static void main(String[] args){
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(20);
        l.add(10);
        l.add(100);
        System.out.println(l);
    
    Collections.sort(l,new MyComparator());
     System.out.println(l); //sorted output
    }
}
```

Dangerous Concept in collection: 

*Comparator contain only 1 method " compare() ". compare take 2 objects and return int value.* 

*It returns -ve iff object 1 has come before object 2*

*it returns +ve iff object 1 has come after object 2*

*it returns 0 iff object 1 is equal to object 2*

```JAVA
//NEW CODE USING LAMDA.Consice code
class Test {
    public static void main(String[] args){
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(20);
        l.add(10);
        l.add(100);
        System.out.println(l);
    Comparator<Integer> c = (I1,I2)->(I1<I2)?-1:(I1>I2)?1:0; 
    Collections.sort(l,c);
    l.stream().forEach(System.out::println) ;//prints each elements on new line,one by one
    List<Integer> l2 =l.stream().filter(i->i%2==0).collect(Collectors.toList());
    }
    }
```

```java
class Employee {
    String name;
    int eno;
    Employee(String name,int eno){
        this.name = name;
        this.eno = eno;
    }
    public String toString(){
        return eno ":" + name;
    }
}

class Test {
    public static void main(String[] args){
    
    Employee e = new Employee("Durga",100);
    System.out.println(e); //Overides toString method and prints name Durga

    ArrayList<Employee> l = new ArrayList<Employee>();
    l.add(new Employee("Akshay",1002));
    l.add(new Employee("Alans",1004));
    l.add(new Employee("Luna",1005));
    System.out.println(l); 
    
    }
```

# Anonymous inner class vs Lambda Empressions

*Anonymous Inner Class*

Class which does not have a name.It can extend a class or implement an interface.
For instant use we use this class

```java
//Anonymous inner class
Runnable r = new Runnable()
{
      ...
};

```

```java
class Test{
    public static void main(String[] args){
        Runnable r = new Runnable(){
            public void run(){
                for(inr i=0;i<10;i++){
                    System.out.println("Child Thread)
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
   
        for(inti=0;i<10;i++){
            System.out.println("Main Thread) 
        }
    }
}

```

**Anonymous InnerClass is more powerfull than Lamda Expression**

If anonymous inner class implements an interface that contains single abstract method then only we can replace that anonymous inner class with lambda expressions.

```java
Interface interf{
    public void m1();
    public void m2();
}

Interf a = new Interf() ;
{
    public void m1(){

    }
    public void m2(){

    }
};

```
# Default Methods
```
Until version 1.7 every method inside interface is always : public and abstract 
In version 1.8 version Default + static methods
In version 1.9 version private methods also allowed.
Every variable present in interface is public static final.
 ```

 **Default Methods | Virtual Extension Method | Defender Method**

Without effecting implementation classes if we want to add new method to interface..we can go for default method.

Only used inside interface class.

```java
interface Interf{
    default void m1(){
        System.out.println("Default Method");
    }
}
```
**Java Doesnt Support Multiple Inheritance**

# Static Methods
To define general utility method inside interface with static .
Not related to objects.
From 1.8 vresion interface can use static methods.

```java
//Interface static method can be called with interface name only
interface Interf{
    public static void m1(){
        System.out.println("Interface static method");
    }
class Test implements Interf{
    public static void main(String[] args){
        Interf.m1();
      
    }
}
}
```
# Predefined Functional Interfaces.

**Predicate,Function,Consumer,Supplier**

## Two argument predefined functional interfaces

**BiPredicate,BiFunction,BiConsumer**


## Primitive Functional Interfaces

**IntPredicate,IntFunction,IntConsumer**

# Predicate

Predicate Functional interface contain only one abstract method.

For Conditional checks


```java
//Example
import java.util.function.*;

class Test implements Interf{
    public static void main(String[] args){
        Predicate<Integer> p1 = i-> i%2 ==0;
        System.out.println(p1.test(10));

        Predicate<Employee> p1 = e -> e.salary >10000 ;
        p1.test(e);
    }
}
```
**Write a predicate to check wheather the length of String is > 5 or not ?**

```java
//predicate contains only one method test and use to check a lambda expression
Predicate<String> string = s -> s.length()>5; 
string.test();
```
## Predicate Joining

p1.and(p2).test(30);

p1.or(p2);

p1.negate()


```java
import java.util.function.*;
class Test
{
    public static void main(String[] args){
        int[] x = {0,5,10,15,20,25,30,35};
        Predicate<Integer> p1 = i -> i%2 == 0;
        Predicate<Integer> p2 = i -> i>10;
        // and() , or() , negate()
        System.out.println(" The numbers which are even __and > 10 are:"  );
        for(int x1: x){
            if(p1.and(p2).test(x1)){
                System.out.println(x1);
            }
        }
         System.out.println(" The numbers which are even ___or > 10 are:"  );
        for(int x1: x){
            if(p1.or(p2).test(x1)){
                System.out.println(x1);
            }
        }
          System.out.println(" The numbers which are not even are:"  );
        for(int x1: x){
            if(p1.negate().test(x1)){
                System.out.println(x1);
            }
        }
    }
}

```

# Function

Input-->perform some operation and produce result

```java
//Function has method apply
interface Function<T,R>{
    public void apply();
}
```

```java
import java.util.function.*;
class Test
{
    public static void main(String[] args){
        Function<Integer,Integer> f = i->i*i;
        f.apply(10);
    }
}
```
```java
import java.util.function.*;
class Test
{
    public static void main(String[] args){
        Function<String,Integer> f = s->s.length();
        f.apply("akshay");
    }
}
```

## Function Chaining
2 functions can be joined .

```java
f1.andThen(f2).apply(i);
///f1 followed by f2
f1.compose(f2).apply(i);
//first f2 then f1

```

```java
import java.util.function.*;
class Test
{
    public static void main(String[] args){
  Function<Integer,Integer> f1 = i->2*i;
  Function<Integer,Integer> f2 = i -> i*i*i; //i becomes 4 
  System.out.println(f1.andThen(f2).apply(2));
  ///Output 64
  System.out.println(f1.compose(f2).apply(2));
  //OUTPUT 16
    }
}
```

# Consumer
Consumer always take a input and never returns anything, ie it consumes.

Consumer has accept method ,LIKE Function has apply,predicate has test().

```java
import java.util.function.*;
class Test
{
    public static void main(String[] args){
  Consumer<String> c = s-> System.out.println(s);
  c.accept("akshay)


    }
}
```

# Consumer  Chaining
Consumer can be also chained, using andThen

```java
Consumer<Movie> c1 = m-> System.out.println(m.name + "NAME OF MOVIE);
Consumer<Movie> c2 = m-> System.out.println(m.name + " READY TO RELEASE");

Movie m = new Movie("Spider");
c1.accept(m);

Consumer<Movie cc = c1.andThen(c2);
```

# Supplier

Just supply my required objects and it wont take any input
it has method get()
```java
class Test
{
    public static void main(String[] args){
        Supplier<String> s = ()->{
            String otp= "";
            for(int i=0;i<6;i++){
                otp=otp+(int)Math.random()*10);
            }
            return otp;
        }
        s.get();
        s.get();
    }
    
}
```

# Summary

Predicate---> test()

Function----> apply()

Consumer----->accept()

Supplier------>get()


# Two Input Arguments

1.Check the sum of 2 given numbers is even or not?

BiPredicate

BiConsumer

BiFunction

**AutoBoxing & AutoUnboxing**
:Conversion of primitive to wraper objects and wise versa.may cause performance issues.

# **Primitive version of Functional Interfaces**

```
IntPredicate p = i->i%2==0;
```
Similary other datatypes are also present

**Primitive Version for Function**

IntFunction

DoubleFunction 

# Additional Functional Interfaces

BinaryOperator

UnaryOperator

Search for more and learn about them in java docs.

# Method and Constructor Reference.

**Lambda Expression alternate**
 Using Method and Constructor reference we can reuse code.

 Advantage : Code Reuseability

 ```JAVA
class Test {
  public static void m1(){
     for(int i = 0 ; i<10 ;i++){
       System.out.println("Child Thread")
       }
  }

    public static void main(String[] args){
       Runnable r = Test::m1;  //Functional interface internelly reference Test class method.
       //using  :: operator
       Threadt t =  new Thread(r); 
       t.start();

       for(int i = 0 ; i<10 ;i++){
       System.out.println("Main Thread")
       }
    }
}

 ```

 # Streams

 # Collections and Stream

 If we want to represent a group of objects as a single entity then we go for **Collections**

 If we want to process objects from the Collection use **Stream**

```
Stream s = c.stream();
stream is an interface present in java.util.stream pkg
 ```
 Filter elements based on condition : the numbers are even or not.
**Use Filter method**
```
ArrayList<Integer> l = new Arrayist<Integer>();
List<Integer> l2 = l.stream().filter(i->i%2==0).collect(Collectors.toList());
 ```

 For a Student Add 5 grace marks . We use **Map** method

 ```java
 List<Integer> l2 = l.stream().map(i->i+5).collect(Collectors.toList());

 ```   


# filter ()

Filter(Predicate)

Predicate return boolean

# map()

Map(result)

Do some operations and return result.

# collect()

# count()

# sorted() - normal  / natural sorting
Comparable interface is used

Contain compareTo() method.

i1.compareTo(i2)

# sorted(Comparator) - for customised sorting

Comparator  has compare() method;
use lamda expression'

# min(Comparator) & max(Comparator)
  use .get() at the end of stream pipe.

# forEach()

forEach(System.out::println);

# toArray()

to convert stream of objects to Array.

l.stream().toArray(Integer[]::new);

# Stream.of();

Streams applicable for whereever group of values are there.Happily we can go for streams concept.
This is not just for collections.
```java
Stream s = Stream.of(9,99,999,999);
```