# Spring Stereotype Annotations
Stereotype annotations for used for **Annotation based configuration**

Inside of a Spring-based project, if we have "component scanning" aka annotation scanning, we can make use of special annotations called **STEREOTYPE ANNOTATIONS**.

The purpose of stereotype annotations is to easily register Spring beans and store them into the IoC container (Inversion of control container) for future use in dependency injection.

1. `@Component`: Serves as a generic annotation for registering a class as a Spring bean 
2. `@Service`: Has the same behavior as `@Component`. The name of @Component and @Service is the only difference. @Service by convention is meant for classes that contain business logic
3. `@Repository`: Serves as an annotation for DAO classes. @Repository does add on additional behavior beyond what @Component and @Service do by introducing what is known as "exception translation". Exceptions that occur inside of the DAO methods will be "translated" into a Spring specific exception. (Such as DataAccessException)
4. `@Controller`: Used to register HTTP controllers. These beans will contain methods mapped to various endpoints