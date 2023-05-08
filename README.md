# LP5-Assignments

### Pre-requisites: Install JDK-8

    sudo apt-get remove openjdk*
    sudo apt update
    sudo apt install openjdk-8-jdk openjdk-8-jre


### Assignment 1:

Terminal 1:

    javac *.java
    rmic AddServerImpl

Terminal 2: 

    rmiregistry

Terminal 3: 

    java AddServer

Terminal 4: 

    java AddClient 127.0.0.1 5 8

### Assignment 2:

Terminal 1:

    idlj -fall ReverseModule.idl 
    javac *.java ReverseModule/*.java
    orbd -ORBInitialPort 1056&
    java ReverseServer -ORBInitialPort 1056& -ORB


Terminal 2:

    java ReverseClient -ORBInitialPort 1056 -ORBInitialHost localhost


### Assignment 3:

Terminal: 

    export MPJ_HOME=/home/ubuntu/Downloads/mpj-v0_44
    export PATH=$MPJ_HOME/bin:$PATH
    javac -cp $MPJ_HOME/lib/mpj.jar Assign3.java
    $MPJ_HOME/bin/mpjrun.sh -np 4 Assign3

### Assignment 4:

Terminal 1:

    python client.py
            
Terminal 2:
          
    python server.py


### Assignment 5:

Terminal 

    javac Tring.java
    java Tring

### Assignmnet 6:

Terminal

    javac Bully.java
    java Bully
    javac Ring.java
    java Ring


