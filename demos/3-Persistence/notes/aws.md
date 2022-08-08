# AWS: Amazon Web Services
Amazon provides many technical services available in the cloud. 
They follow a **"pay as you go" model, which means you are only charged for the exact uptime of the services that you are leveraging**.
They also have a series of services that are labelled as "free-tier", which will not cost money if used under certain limitations, such as 20 GB storage maximum, etc.
Some other services are under "free-tier" only for the first 12 months after making an AWS account.

<br>

There are MANY different services, but we'll just focus on RDS:
- **RDS: Relational Database Service**
    - Amazon Relational Database Service is a distributed relational database service by Amazon Web Services. 
    - It is a web service running "in the cloud" designed to simplify the setup, operation, and scaling of a relational database for use in applications.


Some other services we'll get into later:  (I'm listing them here for now)
- EC2 (Elastic Compute Cloud)
- S3 (Simple Storage Service)

<br>

## Cloud Models
Different Cloud Models that offer different portions of the Software Infrastructure Components as a Service

<br>

- **Software as a Service (SaaS)**
    - Provides everything from 1 - 9
    - Ex: Google Docs, Microsoft Office 365, SonarCloud
    - Consumers: End Users
<br>

- **Platform as a Service (PaaS)**
    - Provides everything from 3 - 9
    - Allows hosting of application/data while bypassing all of the runtime environments and middleware that is handled for you
    - Ex: AWS Elastic Beanstalk, Heroku, "Microsoft Azure App Service"
    - Consumers: Developers

<br>

- **Infrastructure as a Service (IaaS)**
    - Provides everything from 5 - 9
    - Ex: AWS EC2
    - Consumers: SREs, System Administrators, (Sometimes regular developers)