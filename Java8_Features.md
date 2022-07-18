
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