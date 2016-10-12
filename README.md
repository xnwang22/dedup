# Dedup
The goal of this application is to remove duplications in a array.


## Description
I implemented 4 methods to remove duplications for an array.

1. Use Java 8 stream and distinct
2. Use Hashset
3. Use LinkedHashset
4. Use Java map

The first one uses one line of code. It is succinct and reserves the order of the array. The down side is, it may be not easy to debug. Well, there is not too much to debug for one line of code.

The second method just takes the advantages of Java Set collection. However, a set does not preserve the order of the array. To improve this, I came up with number 3, i.e. use an LinkedHashset instead.

The fourth method uses a map. It is similar to using Hashset. However, it has a potential, if you need the counts of duplications, it is very easy to get it from the map.

Unit tests is also pushed.




