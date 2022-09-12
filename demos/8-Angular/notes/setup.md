# Set up

1. Install node.js
2. Install the angular cli with the command `npm i -g @angular/cli`

## Creating an angular app

1. Run the cli command `ng new <app-name>` to scaffold an angular project
2. Navigate to your scaffolded project and run the commmand `ng serve --open` or `ng serve -o` to run your scaffolded app.

## Scaffolded app

The command to scaffold a new project gives you a couple of stuff. Let's talk about the important ones:

1. package.json
   - the file that tells node.js how to manage and handle your js project. metadata about the project.
   - So if you don't have the node modules folder, you can run `npm i` and that looks into your package.json and installs all the dependencies you'll need for you. Like a .csproj file.
2. tsconfig.json
   - compiler options for your ts files
3. node_modules folder
   - libs and deps that you'll be working with
4. e2e folder
   - for e2e testing
5. src
   - your src code