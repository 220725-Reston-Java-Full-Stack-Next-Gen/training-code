# How to Deploy your Angular App on a S3 Bucket
1. Create an Angular project build.
    - Create your Angular app as you desire. For demo, trainer will be using the DBZ-Angular-App from a separated repo.
    - Be sure to configure your backend app's URL in the ```environment.prod.ts``` file to point to your EC2 instance's public address like this:
    ```angular
    export const environment = {
        production: true,
        //this will be the url for the EC2 instance of the backend
        APP_URL: `https://20.98.180.248/api/`
    };
    ```
2. Run the following command in the terminal in VSCode:
    ```bash
    ng build
    ```
    - This should result in some files inside the folder named "dist/your-project-name".

3. Navigate to the AWS Console.
    - Go to S3 service
    - Go to Buckets
    - Click on Create Bucket
    - Fill the following info:
        - General Configuration
            - Bucket name: "dbz-api" (this name will be a part of the S3 instance URL)
        - Object Ownership
            - Select "ACLs disabled"
        - Block Public Access settings for this bucket
            - Uncheck the "Block all public access" box
        - Bucket Versioning
            - Enable this option
        - Tags (optional)
            - skip this section
        - Default encryption
            - Server-side encryption: disable
        - Advanced settings
            - skip this section
    - Click Create Bucket when done.

4. Now that you have your S3 bucket, go to the properties tab and click Edit on the static web hosting option below.
    - In the edit screen, provide the following info:
        - Static website hosting: Enable
        - Hosting type: Host a static website
        - Index document: index.html
        - Error document: index.html (or if you want a custom error page here, make sure to make the file at the same location as the index.html)
        - Redirection rules – skip this section
    - Click "Save Changes" when finished
    - Test your bucket's URL link that is available after the changes are saved. You should be getting a 403 error on the page.

5. Change the Bucket Policy for your S3 bucket and grant public access to all users.
    - Go to the Permissions tab under your S3 bucket settings.
    - Go to the Bucket Policy section.
    - Click Edit
    - Click on "Add New Statement"
    - Edit the JSON to have the following properties for the bucket policy:
    ```json
    {
	    "Version": "2012-10-17",
	    "Statement": [
            {
                "Sid": "AddPermission",
                "Effect": "Allow",
                "Principal": "*",
                "Action": ["s3:GetObject", "s3:GetObjectVersion"],
                "Resource": ["arn:aws:s3:::[Your-Bucket-Name]/*"]
            }
	    ]
    }
    ```
    - Click Save Changes.
    - If your static site does communicate to an external server (like your Spring Boot apps), you will need to configure CORS to work on the bucket like this:
        - Go to Cross-origin resource sharing (CORS)
        - Click Edit
        - Set the JSON like this (similar to the ones set in the HTTP_Interceptor service)
        ```json
        [
            {
                "AllowedHeaders": [
                    "*"
                ],
                "AllowedMethods": [
                    "HEAD",
                    "GET",
                    "POST",
                    "PUT",
                    "DELETE"
                ],
                "AllowedOrigins": [
                    "*"
                ],
                "ExposeHeaders": [
                    "Access-Control-Allow-Origin",
                    "X-Requested-With",
                    "Content-Type",
                    "Origin",
                    "Authorization",
                    "Accept",
                    "Client-Security-Token",
                    "Accept-Encoding",
                    "X-Auth-Token",
                    "content-type"
                ]
            }
        ]
        ```
        - Click Save Changes.
6. Upload your Angular dist folder to the S3 bucket.
    - Go the Objects tab under your S3 instance.
    - Click upload
    - Click add files 
    - Select everything inside of the dist/your-project-name folder of your Angular project
    - Click add folder
    - Select any folders that are also in the dist/your-project-name folder
    - Click Upload to finish

7. Test your S3 deployment by going back to the Properties tab for your S3 instance.
    - Go to Static website hosting and click on your endpoint link
    - Your Angular app should now be showing. Test it with the EC2 instance of your backend to see if app fully works.

8. Done

# Resources
- [Learn how to create and deploy the angular application to AWS Serverless S3](https://levelup.gitconnected.com/learn-how-to-create-and-deploy-the-angular-application-to-aws-serverless-s3-81f8a838b563)