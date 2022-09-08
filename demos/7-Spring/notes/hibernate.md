# Hibernate
*This content is not a part of this Java curriculum; however, this should be useful for understanding how Spring framework (particularly Spring ORM) helps to abstract away Hibernate in later weeks and may also be useful for Project 2.*

The Hibernate framework is a ORM (Object-Relational Mapping) implementation which is built around JDBC.

ORM refers to the long-standing problem of setting up a relationship between a program's objects and rows in a SQL table.

```
class Customer {
    int id;
    String name;
    List<Account>;
}
```
```sql
Create Table Customer(
    id integer primary key,
    name varchar2(50),
    account_id foreign key references Account(id)
    --The above is an issue for mapping
);
```

Map our Java objects to database entities through Hibernate, built on top of JDBC, which will abstract for us all the persistence and transactions that we would normally do ourselves. Hibernate can use interfaces to abstract several different database connections, but can also generate SQL.

## Packages
- org.hibernate
- javax.persistence
    - JPA (Java Persistence API)
    - Generic annotations for ORMs

## Exceptions
- HibernateException
    - RuntimeException which wraps SQLException

## Dependencies
- hibernate-core
- hibernate-entityManager

## JDBC Interfaces vs Hibernate Interfaces
### JDBC
- DriverManager
- Connection
- Statement
- PreparedStatement
- CallableStatement
- ResultSet

### Hibernate
- **Configuration** creates session factories through a specified configuration file or class
- **SessionFactory** is a singleton which generates session objects using a factory design pattern.
    - >SessionFactory sf = new Configuration().configure("file").buildSessionFactory();
- **Session** represents the database connection
    - >Session s = sf.openSession();
    - >s.close();
- **Query** is used to write complex CRUD operations using HQL (Hibernate Query Language)
- **Criteria** is for programmatically writing Select queries
    ```java
    List<Animal> a = session.createCriteria(Animal.class)
        .addOrder(Order.asc("age"))
        .add(Restriction.between("age", 3, 7))
        .list();
    ```
- **Transaction** is an interface for managing ACID-complient transactions
    > Transaction tx = session.beginTransation();
    > //some inserts here
    > tx.commit();

## ACID
ACID is a set of rules to be respected whenever a transaction occures in a SQL database.

1. Atomicity
    - All or nothing approach, either every single line in a transaction succeeds without errors, or none do
1. Consistency
    - Every transaction must leave the database in a consistent state: respecting data, domain, and referential integrity
1. Isolation
    - All transactions that occur concurrently should create the same result in the database as if those transactions occured in series
1. Durability
    - All transactions must be permanent, leaving the database in a committed state that cannot be rolled back or lost

## Mapping with JPA Annotations
- @Entity: marks class for Hibernate
- @Table: maps entity to a table in database
- @Id: maps a property in an entity as a primary key in the database
- @Column: maps a property in an entity as a column in the database
- @JoinColumn: maps a property in an entity as a foreign key in the database

```java
//Student.java
import javax.persistence.*
@Entity
@Table(name=”student”)
public class Student(){
  @Id
  @column(name=”s_id”)
  private Integer studentId;
  
  @column(name=”s_name”)
  private String studentName;
}
```

- Multiplicity
  - @OneToOne
  - @OneToMany: used on parent relation
  - @ManyToOne: used on child relation
  - @ManyToMany

```java
@Entity
@Table(name=”dept”)
public class Department {
  @Id
  @Column(name=”d_id”)
  private Integer id;

  @Column(name=”d_name”)
  private String deptName
}

@Entity
@Table(name=”emp”)
public class Employee {
  @Id
  @Column(name=”e_id”)
  private Integer id;

  @Column(name=”e_name”)
  private String empName;
  
  @ManyToOne
  @JoinColumn(name=”dept_id”)
  private Department dept;
}
```

Alternatively, in Department.java:
```java
@OneToMany(mappedBy=”dept”)
private List<Employee> emps;
```

## Cascades
- By default, no transitive persistence or cascading of state in Hibernate objects with multiplicity relationships
- No default cascading of state or persistence by reachability
- Set up cascade types such as all, none, delete-orphan, etc, in mapping document or in annotation to establish parent/child lifecycle tables, where child lifespan is bounded by parent's lifespan

## Lazy/Eager Fetching
- Eager grabs all information, including associated objects, immediately
- Lazy grabs data only when needed, and creates a proxy in place of associated objects until then
- Proxies can be filled as long as session is open, otherwise a LazyInitializationException is thrown after session closes
- Ex: `@ManyToOne(fetch=FetchType.LAZY)`

## Object States
- Transient
  - Just Instantiated with 'new'
  - Not associated with a session
  - No database representation
- Persistent
  - Has database representation and an identifier
  - Within scope of a session
  - Any changes made in Java will be detected by Hibernate and reflected in database
- Detached
  - Was in a persistent state, but then the session ended
  - Automatic Dirty Checking
  - When connection closes, Hibernate checks for changes in persistent objects and puts all objects in Detached state
  
## Eager vs Lazy Hibernate session CRUD
- Get
  - Immediately (Eagerly) retrieve object from DB
  - Null if object does not exist
- Load
  - Retrieves a proxy (Lazily) which is filled only when used
  - Accessible while session is open

- Save
  - Returns generated PK
  - Immediately inserts regardless of transaction
- Persist
  - Void return type
  - Only inserts during a transaction

- Update
  - Updates object in DB
  - Brings transient object to persistent state
- Merge
  - Checks if object exists
  - Makes persistent object if it doesn't
  - Copies data into new persistent object

- SaveOrUpdate
  - Universal tool for persistent objects
  - If object exists, it will update
  - If not, it will create
  
## Caching
- Level 1
  - Session scope
  - Enabled by default (no config)
  - Session.evict() removes one object
  - Session.clear() removes entire cache
  - Session.contains() returns t/f if cached object is available
  
- Level 2
  - SessionFactory scope
  - Not default behavior (must configure w/ 3rd party library like Ehcache)
  - Strategies/Use cases:
    - Read_Only – good for app config, things that are never updated
    - Read_Write – for objects to be updated, only aware of changes through hibernate