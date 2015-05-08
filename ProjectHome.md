This library builds on the support for Functions in the Google guava library.  The library provides some nice new features such as multiple parameters (via tuples), memoization, relations (built on top of guava predicates with tuples) and a couple static functions (argmax and partitioning).

The library includes a Tuple implementation which uses generics and static methods with variable arguments.  Because there cannot be a variable number of type arguments, Tuples are implemented as several classes, each of a particular size, inheriting some useful features from the parent class. Names are shortened to T2, T3, etc for brevity's sake.

This library was built from the remainder of jmorwick-javalib, which has been retired, due to its overlap with Google Guava.  The remaining distinct and useful classes from jmorwick-javalib were mostly the function and tuple classes, which were re-built on top of Guava to reduce redundancy and assist interoperability.

Guava maintainers have indicated they do not wish to implement tuples or multi-parameter functions, so this library can serve the purposes of those who wish to use such abstractions on top of guava.