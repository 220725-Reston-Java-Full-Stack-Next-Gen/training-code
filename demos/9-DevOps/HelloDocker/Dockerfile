# The Dockerfile is needed in order to build a Docker image that is then used to run a Docker container
# The first line in any Dockerfile uses the FROM keyword
# FROM = set the base image (aka pre-ready image from the DockerHub remote repository) to start this Dockerfile
# alphine = small base image = condensed version of the software associated with the alphine version
FROM node:alpine

# Now that we have our base, we will need to copy over all needed files to run my app from the container by using the copy keyword
# COPY = copy all files from source into the base image under a new directory called 'app'
COPY . /app

# Now I need to change my working directory for all of the commands in the rest of the Dockerfile to apply
# Here the working directory will now be our newly made 'app' folder
WORKDIR /app
# ^ here, now prefixing to this directory is now not needed for all of the following commands

# Now I should be ready to run my application through the docker container
# To execute commands through the docker container, we will need to use the CMD keyword
CMD node app.js