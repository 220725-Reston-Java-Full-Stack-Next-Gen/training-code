## Create an EC2 Instance on AWS with a security group that consists of "Custom TCP" on port 8080

## If you're on Windows right click on your folder where you've stored your pem file, click Gitbash Here
## SSH into your EC2 instance by copy and paste the ssh command that allows you to connect to your Linux EC2 instance with your pem key, similar to this:
ssh -i "my-key-pair.pem" ec2-user@ec2-18-224-70-167.us-east-2.compute.amazonaws.com

# Setup your EC2 environment
sudo yum install java-1.8.0-openjdk-devel -y
sudo yum install maven -y
sudo yum install git -y
sudo amazon-linux-extras install tomcat8.5 -y

# Launch Tomcat Server and deploy your application
git clone <your repo>
cd <your repo>
cd <your app>
mvn package
## This is how we copy the .war file from our target foler to tomcaps webapps folder
sudo cp target/ServletDemoAndLogin-0.0.1-SNAPSHOT.war /var/lib/tomcat/webapps/

sudo service tomcat start

# Navigate to your EC2 endpoint on port 8080 to view your application hosted on Tomcat

Done!

# How to make your own CI/CD pipeline using AWS CodePipeline, AWS CodeBuild, & Elastic BeanStalk
1. Have a web application repository ready to use with this process.

2. Log into AWS Console.

3. Go to Elastic Beanstalk.
- Elastic Beanstalk in a nutshell is a way to deploy resources in AWS (i.e. EC2) fairly quickly.
- Click on 'Get Started' OR hit the dropdown on 'Create..' and select 'Web App'.
    - Provide the following info:
        - Application name: ex. "musician-app"
        - Application code:
            - Platform: ex. "Node JS" (for us, that will be java/tomcat)
            - Select sample application (the build pipeline will upload the code for us later)
            - Push Create to finish
- We have now created our environment for our application. EB is taking care of provisioning our resources for us in the background.

4. Test connection to EB instance by going to provided URL.

5. Go to CodePipeline service in AWS.
    - Give pipeline a name, and keep default settings after the name.
    - Source provider: select GitHub (must authorized).
        - Select repo and branch and detection options 'webhooks'
        - Build stage:
            - AWS CodeBuild is responsible for building aspects of your code and maintaining artifacts of your application within the S3 buckets.
            - In practice run, at the build stage in pipeline setup, select AWS CodeBuild so the app can then be deployed to an EC2 instance that the associates can SSH into.
        - Add deploy stage:
            - deployment provider = AWS Elastic Beanstalk
            - make sure that EB and CodePipeline is in same region
            - app name: same as EB name
            - environment name: same as the one in your EB instance
        - Review and create
        - NOTE: May need to create an IAM role during piepline setup (which looks pretty easy to do).

6. CodePipeline will start running. You should be able to view your web app from a EB URL now instead of the default watermark by AWS.

7. Test pipeline by making a small change in your source code. Push changes to GitHub and see if your AWS pipeline is running for that latest change.

8. DONE!! 

# CloudWatch is a way for monitor and manage the health of your application and other services that are within AWS.
1. Go to CloudWatch.
    - You can set alarms, logs
2. Create a dashboard
    - One-stop shop for everything about your app through graphs and analyze app performance
    - can also add widgets for latency
3. Create an alarm
    - Define metric to monitor
    - Define conditions to put in alarm state and trigger actions when in state
4. Log groups
    - Data dump of events that occur in your app
    - Insights give you a sql-like search through your log groups
5. Metrics
    - draw conclusions based on what is happening to your app system
6. Events
    - Rules = create for regularly occuring events to trigger automation on certain events
    - Buses = event delegation
7. ServiceLens
    - figure out what services are spenting most of that invokations
8. Container Insights
    - useful for container monitoring on techs like docker
9. Synthenics
    - monitor health of app through perioric pings to your app
    - check for certain apis are up & running
10. Contributor insights
    - allows time series analysis on your data & can do grouping of data into certain view

# AWS CloudFormation
## What is CloudFormation
Want to remember all the names of all your resources that you have created into your deployed application? NO!

You can upload a single file to configure your infrastructure for you through...AWS CloudFormation.
    - Just define template files and regions, and upload to CloudFormation!
## Key Concepts
- Create a .yaml or .json templates containing resources
    - highly recommending .yaml
    - resources can come from other AWS services like [this](https://user-images.githubusercontent.com/2091382/55330598-6be05100-545f-11e9-9bef-a1f9b6b89b86.png)
    - Stacks = logical grouping of templates and their resources
    - Changesets = diff what changes between previous commit and lastest commit
## Pros & Cons
### Pros:
- Makes your life easier
- introduce code review infrastucture changes to verify your changes as you develop
- integration easily with CI/CD pipeline
- large community support
Cons:
- steep learning curve at the start
- innocent looking changes can be dangerous (resources can be altered/removed by CF if renamed dangerously)
- drift can be painful 
    - Drift = persistent snapshot of your state of your app
    - out-of-sync issues can occur; be weary of manual changes to resouces
## Getting Started
- No planned demo available; can do a simple S3 bucket with CloudFormation(?)
## Resources
- [AWS CloudFormation Overview video](https://www.youtube.com/watch?v=0Sh9OySCyb4)