# AWS
AWS (Amazon Web Services) is a PaaS (Platform as a Service) which offers many SaaS (Software as a Service) and IaaS (Infrastructure as a Service) IT solutions on the cloud (i.e. hosted remotely on their many server farms). Amazon offers many services at various price points and dominates the cloud IT market today.

## EC2
EC2, Elastic Cloud Compute, is a web service providing flexible computing power in the form of a server running a headless operating system on virtual hardware.An instance is a single EC2 machine with predefined hardware resources (CPU, RAM, Network I/O), and can be configured individually or as part of a group of instances in a VPC (Virtual Private Cloud). Security Group settings, Auto-Scaling groups, Load Balancers, and EBS (Elastic Block Storage) drives can be attached to each instance. When creating a new instance, users must choose an AMI from Amazon or the Amazon marketplace, attach an EBS drive, and create or assign existing key pairs for secure SSH connections to the instance in the future.

### AMI
An AMI (Amazon Machine Image) is a snapshot of a preconfigured operating system ready to be flashed onto a new EC2 instance. Amazon offers many Linux and Windows AMIs, including its own Linux distribution 'Amazon Linux', all of which come with pre-installed tools and services as well as proper security settings and user account configurations.

### Security Group
EC2 instances have strict firewall settings by default and must be configured through security group settings to allow specific kinds of traffic through specific ports or port ranges. By default a security group allows incoming SSH protocol connections on port 22.

### Auto Scaling and Elastic Load Balancing
An EC2 instance can be horizontally scaled, i.e. multiple instances sharing the same configuration can be deployed or removed to provide a small army of servers hosting multiple instances of your EC2 machine. Auto Scaling groups provide users control over hardware or network thresholds that trigger automatic scaling of the number of instances, while an ELB (Elastic Load Balancer) manages efficient routing of traffic to these instances to evenly spread traffic to available resources.

### Connecting to an EC2 Instance
The standard protocol for connections to an EC2 instance is SSH (Secure Shell). Using the Unix `ssh` command or a Windows tool like `PuTTY` a user can establish a connection using a `.pem` key file which contains a private/public key pair. When an EC2 instance is created, the complimentary key value is stored on the instance as well and all connections must use this file to authenticate.

Using `ssh` to connect:
```bash
ssh -i 'path/to/your.pem' ec2UserName@ec2-IP-or-DNS
```

For Amazon Linux AMIs, the username is `ec2-user`. For an Ubuntu AMI, it would be `ubuntu`. The server can be reached via its short IPv4 address or the generated DNS name, both of which are generated for your EC2 instance. Be wary of any address changes after instances are shut down.

When first connecting, answer `yes` to the prompt asking to register the new server. Afterwards your shell prompt will now reflect a session on your EC2.

### EBS
Elastic Block Store (EBS) provides hard storage for EC2 instances, with various hardware options for desired performance and capacity. EC2 memory is volatile, so EBS offers a file storage option to back up any data on an EC2 instance. Furthermore, EBS volumes can be detached and reattached at will, and even cloned or attached to completely new instances.

EBS volumes are formatted with a file system for compatibility with an EC2 instance's operating system.

## S3
Amazon S3 (Simple Storage Service) offers an object storage service commonly used for hosting media or application files, backup storage, static website files, and software artifacts and binaries. As opposed to a block storage like EBS which includes a filesystem overhead for compatibility with Linux or Windows, an S3 simply stores objects in a bucket. An object is composed of a file and metadata while a bucket is a container hosting objects.

### Bucket Policy
An S3 bucket not only stores objects, but also provides url links to each object. The Bucket Policy for the bucket configures access permissions to these links, which are restricted by default. In the Permissions/Bucket Policy page, a JSON configuration file can be added to change it.

### Example Bucket Policy
```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "PublicReadGetObject",
      "Effect": "Allow",
      "Principal": "*",
      "Action": "s3:GetObject",
      "Resource": "arn:aws:s3:::your-bucket-name/*"
    }
  ]
}
```
This policy allows access to all files in the bucket named 'your-bucket-name'.