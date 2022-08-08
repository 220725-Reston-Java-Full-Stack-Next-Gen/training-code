# How to Make an AWS RDS Instance and Setup Environment Variables for JDBC
## Part 1: AWS RDS Instance
1. Login into AWS Console
2. Go to RDS service
3. Select "Create Database"
4. In the settings page:
    - Choose a database creation method: "Standard Create"
    - Engine options:
        - Type: PostgreSQL
        - Version: 14.1 or greater
    - Templates: Free Tier
    - Skip "Availability and durability" section (keep default settings there)
    - Settings: 
        - Provide a DB Cluster identifer name
        - Credentials settings:
            - Provide master username
            - Provide master password
    - Skip "Instance configuration" and "Storage" sections (keep default settings there)
    - Connectivity:
        - Change "public access" to 'Yes'
        - Existing VPC security groups:
            - Change or create your own security group and select it here instead of default from dropdown list
        - Leave first "additional configuration" section alone (holds the port number for DB)
    - Skip "Database authentication" section (keep default settings there)
    - In second Additional Configuration section:
        - Provide an initial database name (if left blank, AWS will not create a database for you)
    - Click "Create Database" to finish.
5. Go to DBeaver.
6. Click the "New Database Connection" button (blue plug) in the top left corner.
    - Select database: PostgreSQL
    - Click 'Next'.
    - On Main tab:
        - Host: your AWS RDS endpoint (can be found on the Connectivity & security tab on your RDS instance page)
            - also check here that your inbound & outbound rules are set to public and your IP address
        - Port: 5432
        - Database: your AWS RDS database name (can be found on the Configuration tab on your RDS instance page)
        - Username: your AWS RDS master username
        - Password: your AWS RDS master password
        - Local Client: Postgres 14
    - Test your connection. If successful, hit "Finish"
7. You can now use your remote database locally to work with persisting data in your application as it runs.

## Part 2: Environment Variable Setup
For your Java application to be able to use JDBC, you will need the following:
1. The PostgreSQL driver dependency in your pom.xml file (Be sure to update your Maven project after you add any new dependencies)

### Windows:
1. Your environment variables:
    - db_url = ```jdbc:postgresql://[aws-endpoint]:[port]/[database-name]```
    - db_username = ```[your-aws-master-username]```
    - db_password = ```[your-aws-master-password]```
2. Restart your computer after you edit your env variables for the changes to apply.
2. Configure the rest of your Java application to use JDBC. See the "HelloJDBC" demo for more.

### MacOS:
1. Find out your macOS version.
2. Check which shell you are using (bash or zsh)
3. In shell terminal:
    a. For zsh shell, export $<VARIABLE_NAME> at ~/.zshenv or ~/.zshrc. (repeat for each variable)
    b. For bash shell, export $<VARIABLE_NAME> at ~/.bash_profile or ~/.bashrc. (repeat for each variable)
    c. Your environment variables:
        - $DB_URL = ```jdbc:postgresql://[aws-endpoint]:[port]/[database-name]```
    - $DB_USERNAME = ```[your-aws-master-username]```
    - $DB_PASSWORD = ```[your-aws-master-password]```
4. Restart your computer after you edit your env variables for the changes to apply
5. Test with ```echo $<VARIABLE_NAME>```
6. Configure the rest of your Java application to use JDBC. See the "HelloJDBC" demo for more.