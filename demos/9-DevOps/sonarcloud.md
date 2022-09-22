# SonarCloud
* What is SonarCloud used for?
SonarCloud is the leading online service to catch Bugs and Security Vulnerabilities in your Pull Requests and throughout your code repositories.

* What are some of the features of SonarCloud?
The main features of SonarCloud are:
- 23 languages: Java, JS, C#, C/C++, Objective-C, TypeScript, Python, ABAP, PLSQL, T-SQL and more.
- Thousands of rules to track down hard-to-find bugs and quality issues thanks to powerful static code analyzers.
- Cloud CI Integrations, with Travis, Azure DevOps, BitBucket, AppVeyor and more.
- Deep code analysis, to explore all source files, whether in branches or pull requests, to reach a green Quality Gate and promote the build.
- Fast and Scalable

* So what is the difference between a bug, a vunerabilitity, and a code smell?
## Bug
- A coding mistake that can lead to an error or unexpected behavior at runtime.

## Vunerability
- A point in your code that's open to attack

## Code Smell
- A maintainability issue that makes your code confusing and difficult to maintain
- Code smells are usually not bugs; they are not technically incorrect and do not prevent the program from functioning. Instead, they indicate weaknesses in design that may slow down development or increase the risk of bugs or failures in the future.
- Here are 2 easy ways to reduce the number of code smells in your projects:
    - Refactor the smelling code as long as there's time on a project
    - Go heavy on unit testing and documentation to reduce the chances of code smelling

* What is a quality gate?
- A quality gate is an indicator that tells you whether your code meets the minimum level of quality required for your project. It consists of a set of conditions that are applied to the results of each analysis.
- With the Quality Gate, you can enforce ratings (reliability, security, security review, and maintainability) based on metrics on overall code and new code. These metrics are part of the default quality gate.
- How do I change the quality of gate in Sonarcloud?
    1. You cannot edit the Sonar Way, it's built-in. You have to create a new Quality Gate after your initial analysis by clicking "Set Up New Code Definition".
    2. Once assigning the Quality Gate to a project, you will need to reanalyze the project.

## How to Set up SonarCloud

### Step 1: Link your Source code to a GitHub Repository
1. Have your source code open in your editor.  You will connect it to a remote repository.

2. Go to github.com. Generate a new repository. Just give it a name and description.  You can make it public
> *Do **NOT** check the boxes to generate a README.md file, .gitignore, or license.* <br>
> *You should see the following*

<br>

<img src="imgs/git-1.png">

<br>

4. Copy the commands underneath where it says `...or create a new repository on the command line`.

3. Switch back to your editor where you have your code.  Open the **root directory** in GitBash Terminal. Paste the code that you copied into the terminal.

4. Press `enter` to push up the link from your local to remote repo.

5. run `git add .`, `git commit -m"push src code"`, `git push origin main` to push up your source code.

*Now your Github Repo is fully configured.*

<br>

### Step 2: Configure SonarCloud 

1. Open your web browser again.  Go to [www.sonarcloud.io](https://sonarcloud.io/).

2. If you haven't connected your GitHub account already, under **"Go Ahead! Analyze your repo"** click the GitHub icon and sign in with your GitHub account to connect SonarCloud.

3. Click `Import another organization`, and you will be prompted to select the organization where your repository is stored. 

4. After you've selected your organization, click **"Don't see your repo? Check your GitHub app configuration."**

5. You will be redirected to Github.  Next to the SonarCloudicon, click **`Configure`**.

6. Scroll down on the installation page and click `Only select repositories` -> select your repository from the drop down menu.

<br>

<img src="imgs/install.png">

<br>


*After you click save, you'll be redirected to SonarCloud.*

7. In the top nav bar, click the white :plus: > Click **Analyze New Project** > You shoudl see your repository pop up now.

8. Click the check box next to your repo and click **"Set Up"**.

<br>

<img src="imgs/setup.png">

<br>

### Step 3: Setup GitHub Actions

1. When prompted to0 **Choose your Analysis Method:** Choose **"With GitHub Actions"**

2. Follow the instructions on the screen to set up the GitHub Action

<br>

<img src="imgs/action.png">

<br>

3. After you've pasted the `SONAR_TOKEN` & Value in your GitRepo under the repo Settings > Secrets, Click Continue and select `Maven` as the option that best describes your build.

4. Go back to the code in your editor again. In your `pom.xml` paste in the suggested `properties` 

<br>

```xml
<properties>
  <sonar.organization>your-organization-or-username</sonar.organization>
  <sonar.host.url>https://sonarcloud.io</sonar.host.url>
</properties>
```

<br>


5. Right click in the root directory and create a new folder named `.github/workflows`

5. Right click on your project again > new file > make it inside of `workflows` > name it `build.yml`

Paste this code in it: (*This is from the SonarCLoud setup guides but please note I've changed the branch to main instead of master!*)

<br>

```yml
name: Build
on:
  push:
    branches:
      - main
  pull_request:
    types: [opened, synchronize, reopened]
jobs:
  build:
    name: Build
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
        with:
          fetch-depth: 0  # Shallow clones should be disabled for a better relevancy of analysis
      - name: Set up JDK 11
        uses: actions/setup-java@v1
        with:
          java-version: 11
      - name: Cache SonarCloud packages
        uses: actions/cache@v1
        with:
          path: ~/.sonar/cache
          key: ${{ runner.os }}-sonar
          restore-keys: ${{ runner.os }}-sonar
      - name: Cache Maven packages
        uses: actions/cache@v1
        with:
          path: ~/.m2
          key: ${{ runner.os }}-m2-${{ hashFiles('**/pom.xml') }}
          restore-keys: ${{ runner.os }}-m2
      - name: Build and analyze
        env:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}  # Needed to get PR information, if any
          SONAR_TOKEN: ${{ secrets.SONAR_TOKEN }}
        # be sure to run this command in the same location as your pom.xml file
        # Sonarcloud will by default run commands at the root directory of your repo unless instructed to go into another folder
        run: mvn -B verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=sophiagavrila_pipeline-demo
```

<br>

6. Save your code and push everything up to your repo.  The Sonar Cloud Quality Analysis will begin immediately on your `main` branch.

<br>

<img src="imgs/check.png">

<br>

### Finished! :tada:

* References:
- [SonarCloud Documentation](https://docs.sonarcloud.io/)
- [What is a Code Smell & Common Mistakes](https://www.bitegarden.com/what-is-code-smell-and-common-mistakes)