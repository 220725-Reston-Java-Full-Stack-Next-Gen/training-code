## Collections / Generics
1. What are collections in Java?
  + A general data structure that contains Objects. Also the name of the API
2. What are the interfaces in the Collections API?
  + Iterable, Collection, List, Queue, Set, Map, SortedSet, SortedMap
3. What is the difference between a `Set` and a `List`?
  + `Set` does not allow duplicates (its members are unique)
4. What is the difference between a `Array` and an `ArrayList`?
  + An array is static and its size cannot be changed, but an ArrayList can grow/shrink
5. What is the difference between `ArrayList` and `Vector`?
  + `Vector` is synchronized whereas `ArrayList` is not.
6. What is the difference between `TreeSet` and `HashSet`?
  + The two general purpose `Set` implementations are `HashSet` and `TreeSet`. `HashSet` is much faster (constant time versus log time for most operations) but offers no ordering guarantees.
7. What is the difference between HashTable and HashMap?
  + a. `Hashtable` is synchronized whereas `Hashmap` is not.

  + b. `Hashmap` permits `null` values and the `null` key.
8. Are Maps in the Collections API?
  + Yes, but they do not implement `Collection` or `Iterable` interfaces
9. What are generics? What is the diamond operator (`<>`)?
  + A way of specifying a type within a data structure - they enforce type safety. `<>` operator lets you infer generic types from the LHS of assignment operation

- To learn more about Collecions, be sure to review the `HelloCollections` demo.