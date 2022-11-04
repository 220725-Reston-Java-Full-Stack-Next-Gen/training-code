In-Class Activity: 

Given this 1-hour period, create three components and establish the routing & testing to those components:
1) Login component - for users to log into app
User Stories:
- A user can go to the login page and enter their username and password in the form.
- A user with correct credentials can then be navigated to the welcome page.
- A user can submit their credentials by either pressing 'Enter' after fillling out the form or clicking the submit button below the form.
- A user will be prompted with a message of 'Invalid username and/or password' if credentials do not make your hard-coded user here:
```
username: bob
password: passw0rd123
first name: Bob
last name: Jones
course: art
attendance days: M, T, TH, F
```

Test Cases:
- If component and important form elements exist on webpage
- If each HTML input element in the form is able to get the correct values
- If user enters correct credentials
- If user enters incorrect credentials
- Check if renavigation to homepage is successful for routing

2) Welcome component - homepage 
User Stories:
- A user can view their personal information.
- A user can click on a link to be redirected to view-all-students webpage.
- A user can click a button to logout

Test Cases:
- If component and important HTML elements exist on webpage
- Check if user clicks link then they are sent to view-all page
- Check if user clicks button then they are sent back to login page
- Check if render for user information is showing on page correctly

3) View All Students component
User Stories:
- A user can view all students (student data can be hardcoded or retrieved from an external API that sends JSON)
- If no table data available, the page should show a message of "No information available."
- A user can click on a link to be redirected to welcome webpage.

Test Cases:
- If component and important HTML elements exist on webpage
- Check if table renders student data correctly if data is not present
- Check if table renders student data correctly if data is present
- Check if user clicks link then they are sent back to welcome page
- Check if render for user information is showing on page correctly

Note: no CSS styling is required - MVP is functionality.

Instructions:
- Discuss algorithm (aka approach of how you want to achieve MVP)
- Work together as a cohort (everybody does have to participate for attendance) to solve this prompt.