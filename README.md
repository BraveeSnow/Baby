# Baby Specification
**Revision #1**

The Baby language is an interpreted language made with ANTLR and java. Currently, it can do basic functions that are necessary for basic applications such as math.

One of the common problems with programming is readability, which baby is specifically made to combat. By turning a programming language into using only English words, this will allow even non-programmers to understand what's happening in the code.

This is highly beneficial to those specifically in human resources as they can finally be able to read something that they can understand, influencing their decisions for the greater good.

## Definitions

There are different terms used throughout the Baby Specification. Referring to the table below will ensure the reader will be able to fully comprehend the specification.

| Term        | Definition                                             |
| ----------- | ------------------------------------------------------ |
| Babysitter  | Refers to the programmer writing in the Baby language. |
| Interpreter | The program that runs a `.baby` file.                  |
| User        | The person running the program for its use case.       |

## Primitive Types

Types are implicitly defined in Baby, just like python. Here is a list of types supported in Baby that the babysitter can utilize:
- Integers
- Characters
- Strings
- Caps (a.k.a. booleans)
- Arrays

Currently, there is no way for the babysitter to create other composite types.

## Comments

Sometimes there are problems that cannot really be explained without a summary. For that case, we allow developers to add comments to their code. However, please note that babysitters shall adhere to the Baby Objective Styling Specification (known shorthand as BOSS). Please refer to the [[Baby Specification#BOSS|BOSS]] section for more information.

A comment can be started with `:)` and lasts for the entire line. You can add it to the end of statements if need be.

```
:) This is a comment.
```

## Writing a Program

To start writing a program with Baby, you must first create a file with the `.baby` extension. Inside this file, insert the following lines:

```
LESS GOOO

YEAH YEAH
```

All Baby files must have these two lines, both at the beginning and end, respectfully. All logic is contained within these two lines. If these lines aren't present, the interpreter will throw a fit until you fix it.

## Declaring Variables

Declaring variables is made simple. As many programming languages attempt view variable assignments as a form of mathematics, the Baby philosophy says otherwise: everything should be made in an easily readable English statement. An example of an assignment of a variable `x` to the value of `1` can be written like so:

```
ima turn a x into a 1        :) int x = 1;
ima turn a c into a 'c'      :) char c = 'c';
ima turn an elf into a "elf" :) String elf = "elf";
```

Notice how this is much more readable than `int x = 1;`, not to mention java's horrendous `private static final int x = 1;`. This is highly unreadable code with words meaning absolutely nothing to the average person.

>**WARNING**
>
>If the first letter in the variable name starts with a vowel and you use `a` instead of `an`, the interpreter will warn you of the mistake. Although some words such as "honest" require the use of `an` regardless of the beginning consonant, it will not mark this as a mistake.

### Arithmetic

As mentioned before, Baby disregards the mathematical perspective of variables. However, this does not mean that Baby is unable to do math. As math can be applied to a wide variety of problems, arithmetic is a must in programming. Simply use the operators you're familiar with: `+`, `-`, `*` and `/`.

```
:) multiply a variable called eleven by 2
ima turn an eleven into a 11
ima turn an eleven into a eleven * 2
```

### Declaring Arrays

Arrays are also very important in programming, and Baby makes an effort to make arrays as easy as possible to use. We can declare arrays like so:

```
ima turn a list_1 into a convertible
ima turn an iterable into a 0 to 10
ima turn an array into a (1, 2, 3)
```

As you can see, it is quite hard to create a highly readable syntax involving arrays. Changes are planned for this section, please refer to [[Baby Specification#BOPs|BOPs]] in order to learn how you could contribute to the DaBaby Specification.

Notice that we are introduced to three methods of array construction:
- `convertible` is an alias for an empty list.
- A range of values from `0 to 10`.
- An explicit array consisting of values `1, 2, 3`.

All three methods have their purposes for different problem solving scenarios, choose wisely.

## Using Arrays
Since arrays are an important part of the baby language they have a few helpful built in functions as well. Having these helpful functions arrays can contain a mixture of integers, doubles, strings, and chars all in one array.

### Pop 

The pop function is used to remove an element from an array, like so:

```
ima turn a list into a (1,2,3)
ima pop 0 from list
```

This removes the value from index 0 of the list. Pop also has another feature that can be quite useful, depending on the scenario:

```
ima turn a list into a (1,2,3)
tryna print with ima pop 0 from list rn
```

Since pop is able to return the value at the specified index, we can work with that data while also modifying the list itself, all in one line.

### Add

The add function is used to add values to the *end* of an array.

```
ima turn a list into a (1,2,3)
ima add 4 to list
```

This adds the value 4 to the end of list so it is now `(1, 2, 3, 4)`. One can make a simple queue with the utilization of the pop and add functions.

### Get

Get returns a value from an array without removing it from the array.

```
ima turn a list into a (1,2,3)
tryna print with ima get 0 from list rn
```

The above sample code prints out the value at index 0 from the list.

### Replace

The replace function takes an index and replaces it's value with the provided one.

```
ima turn a list into a (1,2,3)
ima replace 0 with 0 in list
```

This will replace 1 in list with 0 resulting in `(0, 2, 3)`.

## Conditional Branching

When programming, it is a must to be able to control the flow of logic in order to handle certain conditions. Thankfully, conditionals are easy to write:

```
ima turn a x into a 1

:) x > 1
if x more than 1 no cap
	:) conditional is false, do not run
	...
yeah

:) x <= 1
if x more than 1 cap
	:) conditional is true, proceed
	...
yeah
```

Notice how we can specify the same comparative operator (in this case, greater than) and adjust its behavior via the proceeding expression `cap`. Here are the following supported comparative operators supported by Baby:
- `x be y` - Variable `x` is equal to `y`.
- `x more thany ` - Variable `x` is greater than `y`.
- `x less than y` - Variable `x` is less than `y`.

If you need to check for equivalency along with a comparative operator, simply use the opposite comparative operator and use `cap` instead of `no cap` as shown in the second cap statement in the example.

## Repeating Loops

When a task needs to be done multiple times, a babysitter can use a loop to reduce the amount of required code. Before reading this section, it is encouraged that you have read the section on [[DaBaby Specification#Conditional Branching|conditional branching]] beforehand.

A do-while loop can be used if the babysitter knows for a fact that the repeated code must be ran at least once. We can write one like so:

```
ima do this rq
	:) your code here
while cap
```

While a do-while loop can work in some cases, in others it isn't sufficient as a condition may need to be checked at the beginning. In this case, use a while loop:

```
ima turn a n into a 1
ima turn a max into a 5

while n more than max cap
	tryna print with n rn
	ima turn a n into a n + 1
yeah
```

This is a loop that prints the numbers 1 through 5 to the console.

In cases where you want to iterate through a list of numbers, a for loop works best:

```
for every n in 0 to 10  
    tryna print with n * 2 rn  
yeah
```

## Reusing Code with Functions

Functions are an essential part of programming. Babysitters are allowed to define a set of instructions and use that set anywhere, so long as the function has been defined before invocation.

Creating a function is really simple. Similar to declaring a variable, declaring a function can be done like so:

```
ima turn a func into a function
with x, y, z
	tryna print with x, y, z rn
yeah
```

In this portion of baby code, we declare a function called `func` with the three parameters `x`, `y` and `z`. These parameters are placeholders for actual expressions passed to the function when invoked.

One can invoke a function using the syntax below. We'll invoke the same function we just declared, passing in numbers `1`, `2` and `3` for parameters `x`, `y` and `z`, respectively:

```
tryna func with 1, 2, 3 rn
```

This prints the number `123` to the terminal when run. Try experimenting with different numbers or, even better, different types.

## Importing External Sources

It's a great idea to split up your source code into different files to help with the organization of logic. The other files must also have a `.baby` extension and contain the start and end markers (refer to the [[Baby Specification#Writing a Program|Writing a Program]] section).

Say we have the files `main.baby` and `hello.baby`.

```
:) hello.baby

LESS GOOO

ima turn a hello into a function
with name
	tryna print with "Hello, " + name + "!" rn
yeah

YEAH YEAH
```

Notice how `hello.baby` has defined a function called `hello`. We can use this function inside `main.baby` like so:

```
:) main.baby

LESS GOOO

ima hit up hello
tryna hello with "Bob" rn

YEAH YEAH
```

> **NOTE**
> 
> It is important for the hit up to come before any references from it are made. This is because the interpreter will not know of the reference from an external file before a hit up. It is conventional to add all your hit-ups at the very top of the program file.

## BOSS

The **Baby Objective Style Specification**, or more widely known as BOSS, outlines how babysitters should format their document to improve readability.

1. White Space
	- Do not prepend spaces to any statement unless creating a conditional or function. Add four spaces per branch.
	- Tabs are not permitted as they do not preserve the same amount of indentation across machines.
	- An extra newline is permitted after a statement, but no more than two extras.
	- Everything shall be spaced evenly. Do not use more than 1 space at any time.
2. Comments
	- Do not overuse comments. They are there to present a complicated problem to a reader. Baby code is already in a highly readable format.
3. Hit Ups
	- All hit ups must be included at the very top of the file.

## BOPs

Also known as **Baby Objective Proposals**, BOPs are a document format to be followed and submitted to the Baby authors in order to improve upon readability and ease of use. A list of requirements are as follows:
1. A description of the problem. This must include:
	- The affected sections of the Baby Specification.
	- A sample of both original Baby code.
2. A solution to the problem with sample code provided.
3. Reasoning as to why this can improve readability and ease of use.

There is no specific BOP format to adhere to, so long as the submission is perfectly readable and understandable.