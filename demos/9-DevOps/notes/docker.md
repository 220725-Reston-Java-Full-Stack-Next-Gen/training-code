# Basic Docker Workflow
1. Make your Dockerfile
    - Insert the instructions inside this file
    - For this example:
        a. Start with an OS
        b. Install node
        c. Copy app files
        d. Run node app.js
    - Dockerfile commands:
        - FROM (for base image)
        - RUN (can execute any Linux commands in the container)
        - ENV (sets environment vars in container)
        - COPY (executes on HOST machine to copy app files and put copies in container)
        - WORKDIR (set default dir so that next commands executes in marked dir)
        - CMD (execute entrypoint Linux commands)
        - NOTE: You can multiple RUN commands but only one CMD command in Dockerfile
2. Build your Docker image from the Dockerfile
    - Run command: ```docker build -t[tag] [name:tagname] [folder-location-to-find-dockerfile]```
        - ```.``` for current directory
        - ex. ```docker build -t hello-docker .```
    - Check for your images with ```docker images``` or ```docker image ls```
3. Run your image to start container!
    - Command: ```docker run [image-name]```
4. Save your Docker image to DockerHub
    - Retag your image to this format:
    ```docker tag firstimagename YOUR_DOCKERHUB_NAME/firstimagename```
    - Then use command: ```docker push YOUR_DOCKERHUB_NAME/firstimagename```
5. Pull image from remote repo
    - Command: ```docker pull image-name```
    - SPECIAL NOTE: ```docker run image-name``` will also pull an image from the remote repo if it is not already on your local machine
    - You can check your local processes (aka your actively running containers) with the command, ```docker ps```, and Docker will list them out for you.
        - The ```-a``` tag will show all stopped and active containers. Full command: ```docker ps -a```
    - You can run the container in a interactive mode with the ```-it``` tag, so: ```docker run -it image-name```
    - ```-d ``` = detached mode
    - Interactive mode typically opens up in a shell for users to interact in; use Linux command when in Ubuntu shells
    - ```docker start | stop [container-id-num]``` to start or stop a specific container by id number (which can be found with the ```docker ps``` command)

# Basic Linux commands:
- echo = print to console
    - ```echo $0``` to show you the name of the currently running process
- whoami = shows user name to console
- history = shows history of commands used
- ![number] = to execute a command from history list
- exit = to close shell
- nano = text editor
- apt = ubuntu package manager
- Before installing a package, make sure you have an updated list of packages:
    a. run ```apt update``` to get current list
    b. ```apt list``` to check list
    c. run ```apt install [package-name]``` to install desired package
    d. ```apt remove [package-name]``` to remove package if needed

# Handling Multiple Containers with Port Binding
- Always check to see if you have binded your container's port to a host port. Remember: the host port must be unique but not the container port (meaning that two container can be listened on the same port number but cannot be interacted with until you bind it to a unique port on your host computer).
- ```docker run -p[hostport:containerport] -d [image-name]```
- ex. docker run -p6001:6379 -d redis:4.0
- the -e flag allows you to set an environment variable to go in your container

# Don't want to deal with ports? Easy...let's make a Docker network
- To make a new network, run ```docker network create [desired-network-name]```
- Then just start your containers in that network like in this example:
```docker run -d -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=password --name mongodb --net mongo-network mongo```
- Use the ```--net``` flag to assign the network that the container will be in
- FUN FACT: Use ```\``` after a flag to go to the next line in the terminal to complete a command
- The containers within a network are able to communicate with each other easily because they are in their own isolated cloud away from the host server.

# But you don't want to deal with the network either? Solution: Docker Compose
- Allows you run multiple containers by centralizing them into a YAML file
- Makes it easier to automate orchestration of our containers (just like in Kubernetes)
- To start Docker Compose, run ```docker-compose -f [yaml-file-name] up``` (can also run in detached mode)
- And you can bring everything down with ease with ```docker-compose -f [yaml-file-name] down``` 
    - brings down containers + network automatically
- Docker Compose takes care of creating a common network for your containers so no need to worry about making your own!
- But what if one container depends on another to operate? 
    - No worries, just add a `depends_on` label on the needy party and a `healthcheck` label on the dominant one. 
    - Once the heathcheck meets the desired condition, it will start the other container in the process.
    - The end result should look like this:
    ```
        CONTAINER ID   IMAGE           COMMAND                  CREATED          STATUS                    PORTS                                           NAMES    
    e2c2df473336   mongo-express   "tini -- /docker-ent…"   37 seconds ago   Up 36 seconds             0.0.0.0:8081->8081/tcp, :::8081->8081/tcp       techworld-js-docker-demo-app_mongo-express_1
    68207549690a   mongo           "docker-entrypoint.s…"   47 seconds ago   Up 46 seconds (healthy)   0.0.0.0:27017->27017/tcp, :::27017->27017/tcp   techworld-js-docker-demo-app_mongodb_1
    ```
# Data Persistence in Docker
- Any time you restart a container, any data configured inside the container is lost (uh oh).
- This can be resolved using volumes to persist our data between spin-ups and spin-downs.

# Debugging Containers
- Whenever you adjust a Dockerfile, you have to rebuild the image!
- To delete an image, you must first delete the container
    ```shell
        # List all containers (only IDs)
        docker ps -aq
        # Stop all running containers
        docker stop $(docker ps -aq)
        # Remove all containers
        docker rm $(docker ps -aq)
        # Remove all images
        docker rmi $(docker images -q)
    ```
- You check the activity logs of a container using ```docker logs [container-id | container-name]```
    - To see just the last activity, do ```docker logs [container-id | name] | tail```
    - To stream your logs (update via live feed), use ```docker logs [container-id/name] -f```
- To override the default container name at runtime, use ```docker run -p[hostport]:[container-port] -d --name [your-desired-container-name] [image-name]```
- To get the terminal of the container, use ```docker exec -it [container-id | container-name] [path-of-container]```
    - ex. docker exec -it 918c22e65a59 /bin/bash
- pwd (prints the path of the working directory, starting from the root)
- env (to check environment variables within container)
- Other troubleshooting tips:
    - If npm commands start not working in terminal (aka getting the ```/bin/sh^M: bad interpreter: No such file or directory``` error), follow these steps:
        1. cd ~
        2. nano .bashrc
        3. Inside .bashrc, append this to the end of the file:
        ```shell
            # strip out problematic Windows %PATH%
            export PATH=$(echo "$PATH" | sed -e 's/:\/mnt[^:]*//g')
        ```
        4. save & exit from nano
        5. close and reopen all terminals to see if issue has been resolved
# Creating Private Repos on Amazon ECR (Elastic Container Registry)
- Create your registry
    - Only settings to worry about are:
        1. Public/Private visibility
        2. Set the registry name (typically [domain-name-that-aws-provides]/[your-image-name])
    - NOTE: you create a docker repository `per image`, meaning each image gets its own repo. But you can save different tags (versions) of the same image in the same repo.
- How to Push to your new repo on AWS:
    1. Pre-requisites:
        a. AWS CLI needs to be installed
        b. Credentials need to be configured

# Video Resources
- [Mosh - Docker for Beginners](https://www.youtube.com/watch?v=pTFZFxd4hOI)
- [TechWorld With Nana - Docker Tutorial for Beginners](https://www.youtube.com/watch?v=3c-iBn73dDE)