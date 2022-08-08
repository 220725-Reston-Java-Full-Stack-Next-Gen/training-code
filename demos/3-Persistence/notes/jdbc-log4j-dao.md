# JDBC
- What is `JDBC`? Where does this API come from?
  - JDBC (Java Database Connectivity) is a Java API to connect and execute the query with the database.

  - To find out more about JDBC, please visit these resources:
    1. [GeekForGeeks - JDBC](https://www.geeksforgeeks.org/introduction-to-jdbc/)
    2. [JDBC Theory](https://www.youtube.com/watch?v=y_YxwyYRJek)
    3. [JDBC Tutorial](https://www.youtube.com/watch?v=5vzCjvUwMXg)

- What are the 5 main classes and interfaces included in the JDBC API?
  - `DriverManager` Class
  - `Connection` Interface
  - `Statement` Interface
  - `ResultSet` Interface
  - `CallableStatement` Interface

- How do we protect against **SQL Injection**?
  - This is very important for interviews.  Take a look at [OWASP top 10](https://owasp.org/www-project-top-ten/)

# DAO Design Pattern
- Explain the `DAO` Design Pattern.  What is it's purpose? Great resource [here](https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm) 👈
  - **Data Access Object Interface** - (*i.e `IUserDao.java`*) This interface defines the standard operations to be performed on a model object(s).
  
  - **Data Access Object concrete Class** - (*i.e `UseroDao.java`*) This class implements above interface. This class is responsible to get data from a data source which can be database / xml or any other storage mechanism.
  
  - **Model Object or Value Object** - (*i.e `User.java`*) This object is simple POJO containing get/set methods to store data retrieved using DAO class.

# Log4j
> Be able to answer the following questions:
  - What is logging?
  - Why is **Logging** important?
  - Name some logging levels.
  - What is Log4j?
  - What is the purpose of the log4j.properties file?

- To learn more about logging & log4j:
  1. [Intro to Logging - freeCodeCamp](https://www.freecodecamp.org/news/you-should-have-better-logging-now-fbab2f667fac/)
  2. [Log4j Overview & Tutorial - Tutorialspoint](https://www.tutorialspoint.com/log4j/index.htm)