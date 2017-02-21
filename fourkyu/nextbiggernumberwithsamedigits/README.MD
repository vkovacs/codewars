Next bigger number with the same digits
---

You have to create a function that takes a positive integer number and returns the next bigger number formed by the same digits:

~~~
Kata.nextBiggerNumber(12)==21
Kata.nextBiggerNumber(513)==531
Kata.nextBiggerNumber(2017)==2071
~~~

If no bigger number can be composed using those digits, return -1:

~~~
Kata.nextBiggerNumber(9)==-1
Kata.nextBiggerNumber(111)==-1
Kata.nextBiggerNumber(531)==-1
~~~

https://www.codewars.com/kata/55983863da40caa2c900004e/train/java