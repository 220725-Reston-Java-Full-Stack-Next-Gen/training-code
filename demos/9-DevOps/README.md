> *This document covers notes on Continuous Integration, Continuous Delivery, and Maven, plus some DevOps QC Qeustions (there is overlap from the qc-questions guide).*

<br>

# Continuous Integration

>"Continuous Integration is a software development practice where members of a team integrate their work frequently, usually each person integrates at least daily - leading to multiple integrations per day. Each integration is verified by an automated build (including test) to detect integration errors as quickly as possible. Many teams find that this approach leads to significantly reduced integration problems and allows a team to develop cohesive software more rapidly." 
<div style="text-align: right">~Martin Fowler</div>

DevOps culture aims to minimize the barriers between developers and operations as a whole, but it also streamlines the development process itself through Continuous Integration (CI). 

When working with several developers on a single code repository, safely integrating many changes from each developer is a challenge. Too few integrations and the code base may introduce bugs or become broken without any clear insight into when and how it happened. Each developer should not only be responsible for maintaining up-to-date code on their development environments, but also be responsible for regularly committing new code that passes local unit tests.

## Automated builds
As developers integrate new code, an automated build on a server separate from each of their development environments should trigger. After the build is pulled from the repository, compiled, and tested automatically, the developers should be notified of any and all issues or errors introduced by recent commits. This ensures any problems introduced into the repository are quickly highlighted before becoming buried by the next round of commits.

### Scripts
On a build server, the automated process may be as simple as a scheduled script which pulls the latest code from the repository, builds a new artifact from the changes, and logs and reports on the status of any compiling errors or test failures. The following is an example for a Linux server. This can be added as a `cron` job to periodically trigger your build.

#### `build.sh`
```bash
#!/bin/bash
git pull https://your-repository.git
cd your-repository/
mvn clean package
#Mail log output from build to developers
```

### CI/CD Tools
Advanced tools like Jenkins, Circle-CI, Travis-CI, and many more simplify the automation process. Whether hosted on your own build server or as a cloud service, they can coordinate SCM, build, deployment, and messaging tools through a user-friendly web interface and have access to a large community of plugins or excellent integration with repository services like GitHub.

# Continuous Delivery
>The essence of my philosophy to software delivery is to build software so that it is always in a state where it could be put into production. We call this Continuous Delivery because we are continuously running a deployment pipeline that tests if this software is in a state to be delivered.
<div style="text-align: right">~Martin Fowler</div>

Just as a team of developers use continuous, automated builds to integrate new changes to their code base rapidly, efficiently, and safely, an operations team benefits from automating a rapid delivery process of that build to the various teams and servers in preparation for deployment.

## Pipelines
The process of moving the build (or rebuilding from source) beyond the initial Continuous Integration build is called Continuous Delivery (CD), and the solution that implements this process is known as the deployment (or build) pipeline.

The first CI bulid, the build triggered by a commit or series of commits by developers, should be done quickly to satisfy CI requirements: quick unit tests and error-free compilations are enough. But afterwards the code base should be made available to other teams to run more extensive testing and performance monitoring.

An example two stage deployment pipeline would have the first stage do the CI compilation and unit testing while the second stage builds on a separate testing server to handle integration and end-to-end behavior testing. Further stages can be added at will, triggered at their own intervals.

Just like with CI, simple scripts can automate the process of building, testing, or deploying to staging servers. Tools such as Jenkins also simplify the process of building pipelines and can coordinate multiple servers with ease.

<br>
<hr>
<br>

# Maven :star:
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

<br>
<hr>
<br>

## :interrobang: DevOps and CI/CD QC Questions 
1. What is DevOps? What is the goal of various DevOps processes?
   > DevOps is a set of practices that combines software development and IT operations. It aims to shorten the systems development life cycle and provide continuous delivery with high software quality.

2. Explain CI/CD. (Continuous Integration/Continuous Delivery)

3. Jenkins is the automation server that we use for these 2 stages of development. Continuous Deployment comes after this.

4. What tools have you used to achieve CI/CD? Explain how you’ve setup and used them

5. What is a DevOps pipeline? Explain the steps to setting one up
   - A DevOps pipeline is a set of practices that the development (Dev) and operations (Ops) teams implement to build, test, and deploy software faster and easier. 
   - One of the primary purposes of a pipeline is to keep the software development process organized and focused.

   - **Steps in setting one up**:
      - A good pipeline consists of an automation tool to assist in integrating the teams code (**CI - Continuous Integration**) building the code and testing it (**CD - Continuous Delivery**), and deploying it to end users (**CD - Continuous Deployment**).  Hmmm can you think of a **build automation server** that we've set up before? *Think AWS CodePipeline using CodeBuild as its built automation server.*

6. What is a “build”? What is the end result of a build? What is the build tool you’ve used for Java projects?
   - * A **build** refers to the process that converts files and other assets under the developers' responsibility into a software product in its final or consumable form. The build may include: compiling source files. packaging compiled files into compressed formats (such as jar, zip, war).


7. What are the Maven lifecycles? List the steps in the build lifecycle:
   - The Maven build follows a specific life cycle to deploy and distribute the target project.
   - There are three built-in life cycles:
      - `default`: the main life cycle as it's responsible for project deployment
      - `clean`: to clean the project and remove all files generated by the previous build
      - `site`: to create the project's site documentation