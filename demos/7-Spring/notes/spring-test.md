# Spring Test
Testing is an extremely important part of any software development. Spring provides a module called `spring-test`, which is also included with Spring Boot projects by default, which makes doing tests such as integration tests and dao layer tests easy. 

In particular, Spring test gives features such as allowing us to test a fully integrated system as a whole using features such as providing an **application context** and dependency injection.

Application Context: responsible for instantiating, storing, and configuring (wiring) all of our beans together.
- 3 tier application:
    - Controller
    - Service
    - Dao
- We want to have these layers wired together through the application context (IoC container), so that we can perform integration testing

# Annotations that go on top of Test classes
- `@SpringBootTest`: Loads an entire application context (the entire app, just like when you run the Spring Boot application normally)
- `@AutoConfigureMockMvc`: Configures a MockMvc bean that can be injected into the test class in order to send mock HTTP requests to our fully configured WebApplicationContext
- `@DirtiesContext`: Allows us to indicate that the application context needs to be reloaded (for example, so that we can start with a brand new database for each test)

# MockMvc
MockMvc provides support for testing Spring MVC applications. It gives testers the ability to perform request handling through mock request objects and mock response objects rather than running an actual HTTP server (such as Tomcat).

We can utilize MockMvc to perform requests and check if the responses are what we should be expecting.

## Integration Test Example
```java
@Test
public void testLogin_trainer() throws Exception {
    /*
     * Arrange
     */
    LoginDTO dto = new LoginDTO("bach_tran", "password123");
    String jsonToSend = mapper.writeValueAsString(dto);

    /*
     * Act and Assert
     */
    // We want to send a fake http request to /login
    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/login").content(jsonToSend)
        .contentType(MediaType.APPLICATION_JSON);

    UserRole expectedUserRole = new UserRole("trainer");
    expectedUserRole.setId(1);
    User expectedObject = new User("Bach", "Tran", "bach_tran", "password123", expectedUserRole);
    expectedObject.setId(1);

    String expectedJson = mapper.writeValueAsString(expectedObject);

    this.mvc.perform(builder)
        .andExpect(MockMvcResultMatchers.status().is(200))
        .andExpect(MockMvcResultMatchers.content().json(expectedJson));
}
```

Since these integration tests utilize the actual controllers, services, daos, and database, data often needs to be populated ahead of time

```java
@BeforeEach
public void setUp() {

    EntityManager em = emf.createEntityManager();
    Session session = em.unwrap(Session.class);
    Transaction tx = session.beginTransaction();

    UserRole trainer = new UserRole("trainer"); // userRole id 1
    session.persist(trainer);

    UserRole associate = new UserRole("associate"); // userRole id 2
    session.persist(associate);

    User bach = new User("Bach", "Tran", "bach_tran", "password123", trainer); // User id 1
    session.persist(bach);

    User jane = new User("Jane", "Doe", "jane_doe", "pass", associate); // User id 2
    session.persist(jane);

    tx.commit();

    session.close();
}
```

## Using a Mock HttpSession
It is even possible to mock an HttpSession in order to test endpoints that require a user to be logged in

```java
@Test
public void testLoginStatus_loggedIn() throws Exception {
    /*
     * Arrange
     */
    UserRole fakeUserRole = new UserRole("trainer");
    fakeUserRole.setId(1);

    User fakeUser = new User("Bach", "Tran", "bach_tran", "password", fakeUserRole);
    fakeUser.setId(1);

    MockHttpSession session = new MockHttpSession();
    session.setAttribute("currentuser", fakeUser);

    /*
     * ACT
     */
    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/loginstatus").session(session);

    String expectedJsonUser = mapper.writeValueAsString(fakeUser);

    this.mvc.perform(builder)
        .andExpect(MockMvcResultMatchers.status().is(200))
        .andExpect(MockMvcResultMatchers.content().json(expectedJsonUser));

}
```
