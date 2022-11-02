# Next Generation JS Features

# let and const

var - used in old javascript but not encouraged to use in es6 actually.we use let in place of var

let - new var ..used for variable values

const - use const for constant values ..something we assign once and value never change


# Arrow Functions

```js
 //old way
function myFunc() {
cosole.log('akshay');
}

  //new way
const myFunc = (name) => {
console.log(name);
}

myFunc('akshay');
```

example 2

```js
//if its a return statement inside arrow function ,we can write like this
const multiply = number = >  2* number; 

```
# Export and Import

//person.js
```js
const person={
  name : 'Max'
}
export default person;
```

//utility.js
```js
export const clean=() => { }
export const baseData =10;
```

we can import default exports using any name like person.

Also to import  non default we use { baseData, clean } Similarly

```js
import person from './person.js. ..
import {baseData from './utility.js'
import {clean} from './utility.js'

```

# Classes

Actually blueprint of an object.

```js
class person {
  name = 'Max'
  call = () => { }
}

```
Constructor Functions

```js
const myPerson = new Person()
 myPerson.call()
 console.log(myPerson.name);

```

Supports Inheritance

```
class Person extends Master

```

Class has properties, constructors ,methods

```js
class Human{
  constructor(){
  this.gender = 'male'
   }
}

class Person extends Human {
 constructor(){
 super();          //MUST USE THIS KEYWORD TO INITIALISE PARENT CLASS HUMAN
 this.name = 'akshay'
 }
 printMyName(){
 console.log(this.name);
 }
}
```

# Classes ,Properties and Methods

properties are like variables attached to class / object.

property--- myProperty =value;
Methods----myMethod=() => { }

# The spread and Rest Operarator

...   this is the operator


Spread operator is use to spread up array of objects.

Rest operator is used to merge a list of function argument into an array

```
function sortArgs(...args) {
}
```

# Destructuring

Easily extract array elements or object properties and store them in variables

## Array Destructuring

```
[ a, b ] = [ 'Hello', ' Max ' ]
console.log(a) //Hello
console.log(b) //Max

```
## Object Destructuring

```
{name } = { name: 'Max' ,age :28 }
console.log(name) //MAX
console.log(age) //undefined
```


# Reference and Primitive types.

Objects and Arrays are reference types

Primitive tyoes you already know right ? duh :D.

# Array Functions

```
const number = [1,2,3];

const doubleArray = numbers.map(num) =>{
return num * 2;
};


```


