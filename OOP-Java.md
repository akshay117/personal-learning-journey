
## Class - Named group of properties and functions
## Objects - Instance of a Class
Class is logical construct and objects are Physical reality

Objecta are categorised by state,identity,behaviour.

Object are created in heap memory and variables in stack .

## Dynamic memory allocation (new)

```
    Student student = new Student();
-------------------   ---------------
     Complile time.      Runtime
```     

## Java Constructor

A special function that runs when we create a object and it allocates some variables.
Allocate values that we need when creation of objects.

####  " this " keyword

access the reference variable of object 

cannot use inside static blocks.

## By Default Constructor

a constructor without argument is acually a default constructor.

## Constructor Overloading

Same as function overloading

We can call a constructor inside another constructor using the this keyword.

## In java primitives are not implemented as objects so we dont use new keyword to initialise them.

## Wrapper Class

`Integer num =45` it is now created as object

When we pass objects reference values are passed.

## Final Keyword

`final int INCREASE = 2;`
always initialise when using final keyword

`final Student akshay = new Student();
 
 when a non primitive is final we cannot reassign it but we can change the values.
 
 ## Garbage Collection
 
 *finalise method*
 
 Distructing ..java executes this method before garbage collection.sort of like a clean up method.
 
 ```java
 @Override
 protected void finalise() throws Throwable {
 System.out.println(" Object is distroyed ");
 }
 
 ```

## Static in java

properties common to all the object of a class

To acess static variable inside constructor we use Class name


## Inner class

Outside class cannot be static

inner class can be static
 
## Singleton Class

Just a class that we can create only one object of

```java
public class Singleton{
private Singleton(){
private Singleton instance;

public static Singleton getInstance(){
if(instance == null){
instance = new Singleton():
}
}

}
```

# Inheritance

## extends keyword

super () used to initialise values in parent class.

Types of Inheritance

Single Inhertance : one class extends another class.

Multilevel Inheritance : java doesnt support

Hierachical Inhertance

Hibrid Inheritance - Combination of single and multiple inheritance

# Polimorphism

Compile Time or static polymorphishm --- bY METHOD OVERLOADING


Runtime or Dynamic polymorphism ----by  method overiding. @Override keyword

`CHILD CLASS OVERRIDES PARENT METHOD`

Interfaces

You can inherit but you cant override static methods

# Encapsulation

wrapping up implemention of data members & methods in a class

# Abstraction

Hiding unnessasary details and showing valuable information.

Data Hiding







