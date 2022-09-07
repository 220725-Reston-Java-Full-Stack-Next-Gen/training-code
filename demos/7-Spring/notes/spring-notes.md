# Spring Framework Overview

# Goals
- Lightweight Development with POJOs (Plain Java Objects)
- Dependency Injection
    - Promotes loose coupling
    - Loose coupling: Basically, when you're developing, you might use a bunch of different dependencies within a certain class, and you might want to be able to switch out different implementations, so we can utilize DI to achieve this to inject objects that we want to have our IoC container manage
        - "Switching out dependencies"
        - Not having to hardcode the instantiation of objects
- Minimization of boiler code

# IoC
- Inversion of Control
    - Inverts control of object creation and application flow to a framework
        - Dependency Injection (DI) is a pattern to implement IoC
            - "behavior is injected into your classes"
            - Achieves "Loose Coupling"

![dependency injection](https://docs.spring.io/spring-framework/docs/current/reference/html/images/container-magic.png)

# Dependency Injection
- Implementation of inversion of control
    - Dependency: some object another object needs in order to function properly
    - Injection: passing dependency to a dependent object
    - When a Spring bean is instantiated, any dependencies that it requires will be provided (given that those dependencies are also configured as Spring beans)
    - Decouples configuration from implementation

# Spring Bean
- Any object whose lifecycle is managed by Spring (the IoC container)
- We specify through configuration what should be a Spring Bean

# Modules
- Core container: The core of Spring for creating beans, and also for managing bean dependencies
    - Beans: spring-beans module
    - Core: spring-core module
    - Context: spring-context module
    - SpEL: Spring Expression Language module

The `Core` and `Beans` modules provide the fundamental parts of the Spring framework, such as IoC (inversion of control) and DI (dependency injection). **BeanFactory** is an implementation of the factory design pattern, which removes the need to create programmatic singletons and enables the decoupling of configuration and specification of dependencies from the program logic itself.

The `Context` builds on top of the Core and Beans modules and allows access to objects in a framework-style manner. Context is what provides us with `ApplicationContext`, which extends BeanFactory.

- Additional modules:
    - Web module
    - AOP module
    - ORM module
    - Test module
    - JDBC module
    - etc

# Spring Projects
Spring projects are built on top of different modules that make up Spring framework. These are "boiler-plate" projects that help us to easily build Spring applications.

- Spring Boot
- Spring Data
- Spring Security
- Etc

# BeanFactory vs. ApplicationContext
- Both represent an IoC container, which manages the lifecycle of Spring beans

## BeanFactory
- Older
- It lazily instantiates Spring Beans
- Must provide a resource object configured for our `beans.xml`

Example implementation: `XmlBeanFactory`

```java
XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
```

## ApplicationContext
- Newer
- It eagerly instantiates Spring Beans
- **Provides support for annotations**
- Naming convention changed from `beans.xml` to `applicationContext.xml`
- Sub-interface of BeanFactory (meaning this interface extends the BeanFactory interface)
- Easier integration with Spring AOP
- Event publication
- Internationalization features
- Support for application-layer specific contexts such as `WebApplicationContext`

Example implementations:
- ClassPathXmlApplicationContext
- FileSystemXmlApplicationContext
- XmlWebApplicationContext
- Etc.

# Configuration
- XML Config
    - Our configuration is defined in `applicationContext.xml`
    - We can specify our beans inside of this file, whether we want component scanning (annotation scanning), etc.

- Annotation Config
1. Enable "Component Scanning" in our `applicationContext.xml`
2. Annotate classes w/ "stereotype annotations"
    - @Component: general Spring bean
    - @Repository: for our DAOs
    - @Controller: for our HTTP controllers
    - @Service: for various services in our service layer

- Java Config
    - We can specify beans that we would like for Spring to instantiate and populate inside of a special configuration bean
    - We can utilize the @Configuration annotation in order to designate this class as our configuration class
    - We then would use `@Bean` on each method inside of this class that should be instantiating a bean
        - the method name is the bean name itself
        - `@Bean` is a special annotation that will actually intercept this method call, check to see if the bean already exists or not inside of the container, and if not, actually instantiate the object inside the method and return that new object. Otherwise, the `new SomeObject()` logic inside the method will not even run at all, and the already existing bean will simply be returned to us.

# Bean Scopes
Scopes determine how many instances of a particular Spring bean we should create and have at any particular time. This depends on the context in which they are used, which is why this is referred to as "scope".

## Universal Scopes
- Singleton (default): There is only 1 instance of the Bean
- Prototype: There will be a new Bean instantiated each time it is called for

## Web-Aware Scopes
- Request: One Per HTTP request
- Session: One Per HTTP session
- New as of Spring 5
    - Application: One per ServletContext (Per Web Container)
    - WebSocket: One per websocket
- Now deprecated as of Spring 5
    - Global session: was used for Portlets for global session

# Dependency Injection Types
- There are many different ways we can wire dependencies together, just like there are many different ways to configure beans with our IoC container
- Bean wiring is the process of connecting our beans using dependency injection (DI)

## Setter Injection
- Uses setter methods to provide dependencies
- Does not ensure DI because an instance could be created without configuring a particular field
    - no issue would be raised if we did not successfully provide a dependency to this object, because in order to make use of the setter, you would have already had to have instantitated this bean
    - one way around this issue could be to use the @Required annotation to make sure that there is actually a dependency provided
        - Would prevent `NullPointerException` issues down the road

## Constructor Injection
- Uses a constructor (this is what we saw already with Angular)
- We provide to the constructor the necessary dependencies as parameters
- The bean cannot be instantiated without the proper dependencies being injected

## Field Injection
- `@Autowired` directly on top of the field itself (property)
- example:
```java
@Autowired
private IMyService myService;
```
- Utilizes reflection under the hood, not constructors or setters

# Autowiring
Autowiring in general uses the `@Autowired` annotation. You can place this on fields directly, in which case we would be utilizing `field injection`, or on constructors, setters for constructor/setter injection.