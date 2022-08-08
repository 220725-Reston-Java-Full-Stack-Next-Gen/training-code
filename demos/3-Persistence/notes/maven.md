> Scroll to the bottom of this page for a guide on how to create a Maven project

# Maven :star:
Maven is a **build automation tool** used primarily for Java projects. Maven can also be used to build and manage projects written in C#, Ruby, Scala, and other languages. 

- Maven's functionality is centered around the **`POM` (Project Object Model)** which specifies plugins, dependencies and more meta data about what your project needs to build.

There are three built-in build lifecycles: `default`, `clean` and `site`. 

- The `default` lifecycle handles your project deployment
- The `clean` lifecycle handles project cleaning
- The `site` lifecycle handles the creation of your project's site documentation.

## Each Build Lifecycle is Made Up of Phases
Each of these build lifecycles is defined by a different list of build phases, wherein a build phase represents a stage in the lifecycle.

For example, the `default` lifecycle comprises of the following phases:

   - `validate` - validate the project is correct and all necessary information is available
   - `compile` - compile the source code of the project
   - `test` - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
   - `package` - take the compiled code and package it in its distributable format, such as a JAR.
   - `verify` - run any checks on results of integration tests to ensure quality criteria are met
   - `install` - install the package into the local repository, for use as a dependency in other projects locally
   - `deploy` - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects.

These lifecycle phases (plus the other lifecycle phases not shown here) are executed sequentially to complete the default lifecycle. Given the lifecycle phases above, this means that when the default lifecycle is used, Maven will first validate the project, then will try to compile the sources, run those against the tests, package the binaries (e.g. jar), run integration tests against that package, verify the integration tests, install the verified package to the local repository, then deploy the installed package to a remote repository.

<hr>

# Demo
1. Create Maven Project:

	- In the left hand upper corner of Eclipse click File > New > Other > Search for "Maven" > Click Maven Project > Click Create Simple Project > > group Id = com.revature > Artifact ID = > MyProject > click Finish.

2. Within the `src/main/java` folder add a base package (like `com.revature`).

3. Within that package, create your first public class like `Driver.java`.  Your `main()` method will reside here.

    - Don't forget to add the following plugin to tell Maven where your `main()` method is (which class file to execute).  Add the following to your `POM.xml`:
    
    ```xml
	<build>
		<plugins>
			<plugin>
				<!-- Build an executable JAR -->
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-jar-plugin</artifactId>
				<version>3.1.0</version>
				<configuration>
					<archive>
						<manifest>
							<addClasspath>true</addClasspath>
							<classpathPrefix>lib/</classpathPrefix>
							<mainClass>com.revature.Driver</mainClass>
						</manifest>
					</archive>
				</configuration>
			</plugin>
		</plugins>
	</build>

    ```


4. Right click on your project > `Open in Local Termainl` > run `mvn clean`. 

    > Notice that this command deletes your `target` folder.  This is where all of your `jar` files and compiled classes live. Now we are ready to compile our app.

Instead of using the CLI, you can also right click on your project and run these commands.

5. Second step is to compile our source code.  Right click on your project > click on `Maven build...`.

    > `build` is the command that compiles your source code.  We need to specify that we want to compile.

6. In the box that pops up, within `Goals:` type **`compile`** > `Run`.

:exclamation: In the case that you get this error message:

```
[ERROR] No compiler is provided in this environment. Perhaps you are running on a JRE rather than a JDK?
```
Follow these steps

a. On your Eclipse IDE, go into **Window** > **Preferences** > **Java** > **Installed JREs** > and check your installed JREs. You should have an entry with a JDK there. <br>

> If you don't, click add > Standard VM > Next > and in JRE home: click on Directory... then go to > Local Disk (C:) > Program Files > Java > click on the jdk folder. <br>

b. Click OK
Then Right-Click on your Project -> Maven -> Update Project.  Now you can try again and it should pass.

> Alternatively check [this StackOverflow post](https://stackoverflow.com/questions/19655184/no-compiler-is-provided-in-this-environment-perhaps-you-are-running-on-a-jre-ra) for help.

7. Now, if you go back and check your **target** file, you'll see all the compiled classes.

8. Next step is to compile your test classes: Right click again and run `Maven build...`.

9. This time in goald write: `test-compile`. This will compile all of our Test files.  You can see these in a `test-class` folder in `target.`

Now we have compiled our source code and we have compiled our test classes. Now let's **RUN the tests**.

10. You can either run it by right clicking > Run as `Maven build...` > write `test` in goals, OR **you can open it in your local terminal and run `mvn test`**

> All of these test results will be sotred in a new folder within `target\surefire-reports`.

## Create a JAR file with `mvn install`.

11.  You could either right click > Run as `Maven build...` and enter `install` in goals, OR *open the project in your Local Terminal and run `mvn install`*.

    > Now you will see your `JAR` file called `<your-project-name>-0.0.1-SNAPSHOT.jar`.


## CLI commands

1. mvn clean
2. mvn compile
3. mvn test-compile
4. mvn test
5. mvn install (create JAR file)


## Run the JAR file.
1. Now that the JAR file is created in your `target\` folder, `cd` into it.

2. Inside this folder run the following command:

```
java -jar <Your-Project-Name>-0.0.1-SNAPSHOT.jar
```

3. Your program should now execute in the terminal.


### Resources:
- [Intro to Maven](https://www.studytonight.com/maven/introduction-to-maven)
- [The difference between `package` and `install`](https://stackoverflow.com/questions/16602017/how-are-mvn-clean-package-and-mvn-clean-install-different)
- [Why did we include that executable jar plugin in the `pom.xml`?](https://maven.apache.org/shared/maven-archiver/examples/classpath.html) 