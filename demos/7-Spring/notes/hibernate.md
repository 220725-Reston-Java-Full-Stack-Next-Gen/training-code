# Hibernate

# What is Hibernate?
- ORM (object relational mapper) solution introduced by Gavin King way back in 2001
- Can be used to query and persist objects from/to the database
- Maps Java classes to database tables (entities), including Java data types to SQL data types
- Simplifies the process of data persistence tasks

# Why ORM (Object relational mapping)
Object relational mappers such as Hibernate help us to solve issues associated with "converting" between objects in an OOP language and relational database tables. These issues are referred to as **impedence mismatches**.

There are 5 different issues that need to be addressed:
1. Granularity: there could mismatches in the number of classes that are mapped with a certain number of tables in the database
2. Inheritance: inheritance is natural in OOP, but you can't really expressed inheritance in a relational database very easily
3. Identity: Equality is different in OOP (.equals() logic enforces equality), while in a relational database, it is based on primary key
4. Associations: In OOP, we have the concept of HAS-A, in which objects have properties that could be pointing to other objects in a graph-like structure. IN a relational database, we have FKs pointing to PK
5. Navigation: We access data differently in Java v. a relational database. Ultimately, Hibernate helps us to grab all of the information that is required between different objects and their relations.

## Advantages
- Open source and lightweight
- You can implement "caching", which provides performance benefits in the sense that you don't need to query the database every time for a certain resource
- Database independent querying: we can utilize (HQL) (Hibernate Query language), which is basically an OOP version of SQL
- Simplifies joins since objects and their dependencies are mapped by Hibernate
    - Relationships:
        - One to one
        - One to many (many to one)
        - Many to many

# JPA
- JPA (Java Persistence API): The standard API for accessing, persisting, and managing data between Java objects and relational databases
    - JPQL to perform database operations
    - Uses the EntityManager interface to create, read, update, and delete instances of mapped "entity" classes
- Hibernate is an implementation of JPA, so it follows the standard laid out by the JPA specification
- Hibernate's Session interface is an extension of JPA's EntityManager interface

# Hibernate Hierarchy
- Configuration class
    - Provides us the ability to specify different configuration properties
    - We could provide a `hibernate.cfg.xml` file, which would contain our general hibernate configurations that would then be loaded up by this Configuration object
    - Used to build the `SessionFactory` object
- SessionFactory interface
    - Is used to create `Session` objects
    - Thread-safe
        - An application can therefore have a single SessionFactory shared by all threads
        - Therefore, we could use the Singleton design pattern for this SessionFactory object
- Session interface
    - The main way for Java applications to interact with Hibernate
    - Session is NOT thread safe, so we should only have a single session per thread
        - In the context of a back-end application, every request to the server spins up another thread
        - We should have a new Session per thread (aka per HTTP request)
- Transaction interface
    - Allows for transactions to be defined
    - We can commit and rollback, for example
        - Once we do either of these operations, the transaction is finished
    - A Session can have multiple transactions
        - But only 1 uncommitted transaction at a time

# JPA Annotations
When defining our entities within our model classes, we will be using JPA annotations to tell Hibernate how these should actually be mapped.

- @Entity
    - Defines a class that is to be mapped by Hibernate
- @Table
    - Allows the table name to be specified for the class we want to map to the database
    - Optional
- @Id
    - Defines which field acts as the primary key of our entity
- @Column
    - Allows us to define the column name in the database
    - Optional
    - Could also specify
        - The max column length
        - Whether the column should be unique
        - Whether it is nullable or not
- Mapping Annotations
    - @OneToOne
    - @OneToMany(@ManyToOne)
    - @ManyToMany
        - @JoinTable
            - @JoinColumn

# Object States
Objects are synchronized with the DB through Hibernate sessions, and can have different states depending on when/if they are synchronized

- Transient
    - An object that is newly created
        - Basically just a regular object that Hibernate is not keeping track of itself
    - Not synchronized with the DB
- Persistent
    - Object whose state is being managed and tracked by Hibernate
    - Synchronized through a Session object with the DB
- Detached
    - An object that was previously persistent, but the Session the object was associated with was closed
    - We could also specify manually to detached an object from a currently open Session
    - No longer synchronized with the DB

There is a term associated with Hibernate called "automatic dirty checking", which is a process whereby Hibernate automatically saves changes made (such as via setters) to a persistent object once the transaction has been committed or the session has been flushed.

Flushing
- The process of synchronizing the DB with objects that are currently persistent
- You can explicitly invoke this by calling `session.flush()`
- Flushing also occurs when a transaction has been committed

# Ways to Retrieve Data Using Hibernate
- HQL: Hibernate Query Language
    - You don't need to concern yourself with the table name in the database or the column names
    - HQL depends purely on the names of the classes in Java that are mapped to Hibernate as well as the variable names of the properties
- JPQL: Java Persistence Query Language
- Native SQL
- Criteria API
    - Type-safe way of querying for objects
    - Criteria use explicit methods and return types to fetch data

# JPA Cascade Types
By default, Hibernate does not cascade ANY operations from one object to another that it is forming a relationship with (one-to-one, one-to-many, many-to-many). We need to actually specify different operations that we want to be cascaded in order for that to occur.

Cascade Types:
- ALL
- PERSIST
- MERGE
- REMOVE
- REFRESH
- DETACH

So, we can specify these cascade types in our relationship annotations. Ex:\

`@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE })`

# Unidirectional v. Bidirectional Relationships
In Hibernate, we have this concept of unidirectional v. bidirectional.

Unidirectional:
- Only one side of relationship has a mapping
- Perfectly fine to use, you would just need to do additional work to get the associated relation on the other side (ex. getting all pirates belonging to a ship, if we only have the @ManyToOne on the Pirate side)
    - If I only have a single @ManyToOne on Pirate, and not a @OneToMany on Ship,
        - We would have to use something like HQL to help us out
            - ex. get Pirates belonging to ship 1
            - `List<Pirate> piratesOfShip1 = session.createQuery("SELECT p FROM Pirate p JOIN p.ship s WHERE s.id = 1").getResultList()`

Bidirectional:
- Both sides have a mapping to the other side of the relationship
- For example, @OneToMany in the Ship class and @ManyToOne in the Pirate class
- This could it easier to access the data that we need
    - However, we could run into "circular referencing" issues
    - This would result in infinite loops and our program crashing from `StackOverflowError`

Potential solutions for infinite looping:
- Remove the reference from one side inside of our `toString()` method
- For the purposes of JSON conversion, this issue would not be fixed by the above
    - We would need to have Jackson databind avoid including the JSON information on one side when serializing to JSON
    - This can be accomplished via the following annotations:
        - `@JsonManagedReference`
        - `@JsonBackReference`

In general, having functioning bidirectional relationships can be difficult, especially for beginers to Hibernate. But, it is perfectly ok to have unidirectional relationships.

# Caching
Hibernate can utilize caching to provide performance benefits. Instead of "hitting" the database for the same, unchanging data over and over, we can cache that in our Session / SessionFactory objects instead.

We have 2 different types of cache:
- L1 Cache
    - Built-in and provided automatically
    - Runs at the session level (scoped to a Session object)
    - Mandatory (you can't turn off L1 caching, you shouldn't anyways, it will always be active with the current session)
- L2 Cache
    - Not built in, but can be added
    - Scoped to SessionFactory, which means it will span across the entire duration of our application running

Including an L2 cache:

```xml
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-ehcache</artifactId>
    <version>5.5.6.Final</version>
</dependency>
```

Over in hibernate.cfg.xml:
```xml
<property name="cache.use_second_level_cache">true</property>
<property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.internal.EhcacheRegionFactory</property>
<property name="cache.provider_class">org.hibernate.cache.EhcacheProvider</property>
```

On our resources that we want to utilize L2 caching:

```java
@Entity
@Table(name = "pirate_ship")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Ship {
```

We have different CachceConcurrencyStrategy's:
- READ_ONLY: use this for entities that have data that never change
- NONSTRICT_READ_WRITE: Use this for entities where data is rarely changed
- READ_WRITE: Use this for entities where we read and update data
- TRANSACTIONAL: Use this for caching the full transactions made on an entity

# Lazy v. Eager Loading
Lazy Loading: Getting only the immediate data as necessary, in order to allow for optimization of memory usage. Only when we need the data for the associated relations, do we actually query for that information. For example, if we have lazy loading for a pirates property on Ship, it will only query the data for the pirates whenever we call the getter for the pirates.

Eager loading: Loads the data for our current object as well as the associated relations

- @OneToMany: LAZY by default
- @ManyToOne: EAGER by default
- @OneToOne: EAGER by default
- @ManyToMany: LAZY by default

The purpose of lazy loading is to provide optimizations in only retrieving data when it is necessary

## Proxy Object (associated w/ lazy loading)
A proxy object is essentially the epitome of lazy loading. The proxy object that you can retrieve from Hibernate does not contain any properties at the time of grabbing this object. Instead, the queries will only be made whenever you call the corresponding getters for the properties of that entity.

```java
Ship ship = session.load(Ship.class, 1) // load v. get: load will give you a proxy object, while get gives you a persistent object with the immediate data + any eagerly loaded relations

// At this moment, the ship object above has nothing actually stored for the properties. So it is really saving as much memory as possible and everything has to be lazily loaded.

ship.getName(); // This is the moment when Hibernate will actually ask the database for the name of this Ship
// Before calling the getter, the ship object here was actually totally devoid of values for the properties
```