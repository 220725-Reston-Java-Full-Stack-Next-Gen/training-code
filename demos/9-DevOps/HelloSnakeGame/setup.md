# How to set up the Snake Game on a EC2 instance
1. SSH into a EC2 instance.
    - You will need only 1 security rule (SSH port 20), which is supplied to your instance by default.

2. Once connected to your EC2 instance, run the following commands from the EC2 terminal:
```bash
# a. Get all packages needed for EC2 to run properly
sudo yum update

# b. Install Docker
sudo yum install docker

# c. create a group of users within your EC2 instance with Docker permissions
sudo groupadd docker
sudo usermod -a -G docker ec2-user

# d. start docker in container
sudo service docker start

# e. Now with Docker installed, make a folder in the EC2 instance root directory that will contain your Dockerfile
mkdir snakedocker
cd snakedocker
```

3. Now inside the new snakedocker directory, run the following commands:
```bash
# Open a text editor to apply your Dockerfile changes
nano Dockerfile
# The following command will open up the nano text editor from here
```

4. Inside the text editor, edit Dockerfile to contain this:
```docker
# FROM speifies the base image, running an ubuntu OS
FROM ubuntu:18.04

# RUN specifies the duty of the container.  It should install this software
RUN apt-get update && apt-get install -y libncurses5-dev && apt-get install -y nsnake

# CMD specifies the instruction that is to be executed when a Docker container starts
# In this case, we are running the executable located at /usr/games/nsnake within the nginx container
CMD ["/usr/games/nsnake"]
```
- Exit the nano text editor with the keyboard commands ```ctrl + X```, then press ```Y``` to save.

5. Build the image from the Dockerfile with the following command:
```bash
sudo docker build -t snake:auto .
```

6. Finally, run the image with the following command and you'll load up the game thanks to the CMD command.
```bash
sudo docker run -it snake:auto
# the -it flag allows you to interact with the executable file, which, in this case, is the game itself.
```

7. Enjoy the game!