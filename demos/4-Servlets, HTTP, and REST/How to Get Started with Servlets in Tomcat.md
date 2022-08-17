# How to Get Started with Servlets in Tomcat
1. Install Apache Tomcat
2. Open Spring Tools Suite (or preferred IDE).
3. Open your `Servers` window.
    - Go to `Windows > Show View > Other > Search "Servers"`
4. Right-click in window. Go to `New > Server...`
5. In wizard, select Apache > Tomcat v8.5 Server (or whichever version number that you installed)
    - Click Next
    - You will be asked to specify the installation directory.
        - In `Tomcat Installation Directory`, hit `Browse` and navigate to your Tomcat install folder (commonly in your C://ProgramFiles/Apache Software Foundations on Windows computers).
    - Hit `Finish` to complete.
6. To test that Tomcat is working, double-check your new server and check ports.
    - Default port for Tomcat is on port 8080, but you can change it if you have another application running on that port.
    - For testing Tomcat, make sure to for "Server Location" setting, select "Use Tomcat installation" to get Tomcat's homepage when server starts.
    - Right-click your server, and hit 'Start'. Should see Tomcat homepage if successful.
    - Now change "Server Location" setting, select "Use workspace". That will show any UI that the developer makes instead of Tomcat's homepage.
7. Create your web applciation.
    a. create WAR Maven project
    b. update pom.xml file
    c. add the deployment descriptor (WEB-INF/web.xml)
    d. make servlets
    e. done

8. Add project to server list by right-click > Add & Remove > move project over to the right > apply changes.

9. Run server
    - Right-click server > select 'Start'
    - URL: http://localhost:8080/<project-name>/<uri-endpoint>
    - NOTE: If you don't know your endpoint that your project is running on, go to http://localhost:8080/manager/html or http://localhost:8081/
