# Exercises

## Monday
Time to review what you learned from last week!

In this exercise, you will be reviewing: classes/object creation in Java, Git project management basics, and local file navigation using Linux commands.

- Follow the instructions below:
    1. In a public repo called "Week1_Mini_Project_[your name here]", create a new Java project.
        - Create a new folder called "images". This folder will be used later to save key screenshots.

    2. In the new project, create a package called "com.[your first name].code".

    3. In that new package, create a Java class named "Thermometer". 
        - The class should have the following fields: 
            - a private integer variable called "degreesF" for Fahrenheit
            - a private integer variable called "degreesC" for Celsius
            - a private String variable called "name" for the Thermometer device name
            - a private integer array variable called "tempReadings". Initialized it as a new integer array of a fixed length of 3.
        - The class must have both an no-args constructor and an all-args constructor.
        - The class must have getters and setters for each class field.
        - The class must have a overridden toString() method that will print the contents of our objects.
        - The class must have the following custom methods:
            - ```public static int convertToFahrenheit(int c)``` = to convert any given Celsius value to Fahrenheit
            - ```public static int convertToCelsius(int f)``` = to convert any given Fahrenheit value to Celsius
            -```public static void calculateAvgTemp(int[] temps)``` = to calculate the average of any three given temperatures

    4. In the same package, create a new Java class called "MainDriver". Be sure to add a main method in this class.

    5. In the main method, do the following:
        - Prompt the user to name their Thermometer. Save the name to a new instance of your Thermometer class.
        - Print a greeting message to the user to indicate that the app has started running. An example message would look like this: ```Hi user, thanks for using [thermometer name here] today!```
        - Prompt the user to enter a Fahrenheit and Celsius value respectively.
        - Set the user's values into the Thermometer object.
        - Use the conversion methods in the Thermometer class to convert the given values to Celsius and Fahrenheit. Save the converted results into two new int variables.
        - Print the results to the console.
        - Now prompt the user to enter three integer values that represent recent temperature readings. Set this input as the Thermometer's tempReadings value.
        - Call the Thermometer's calculateAvgTemp() method to print the average temperature.
        - Print a goodbye message to the user to let the user know that the app is closing.
    
    6. Take a screenshot of your project running. Be sure to include the time on your computer at the time that you ran the app.
        - Attach the image to the images folder.
        - Be sure to commit your changes using Git & GitHub.

    7. Now you will be making a bash script that will automatically compile and run your Java code.
        - First, navigate to your project folder. Then use the Linux command that will make a new script.sh file.
        - Next, edit the contents of that new file to have the following:
            - ```javac MainDriver.java```
            - ```java MainDriver```
        - Run the bash script using the proper terminal command.
    
    8. Take a screenshot of your terminal after you run the script. Be sure to include the time on your computer at the time that you ran the app.
        - Attach the image to the images folder.
        - Be sure to commit your changes using Git & GitHub.

    9. Submit the link to your GitHub repo to your trainer via private message on GitHub.