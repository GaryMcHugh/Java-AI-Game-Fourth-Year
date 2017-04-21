# Artificial Intelligence

**Student Name:** Christy Madden <br />
**Student ID:** G00214065 <br />
**Student Name:** Gary McHugh <br />
**Student ID:** G00308668 <br />
**Module:** Artificial Intelligence<br />
**Lecturer:** Dr John Healy <br />

___

# Introduction	

### Technologies Used:

+ **Operating System:** Linux Mint 18.1 "Serena", Windows 10
+ **IDE:** Eclipse, Visual Studio Code
+ **Programming Language:** Java
+ **Hosting Site:** GitHub
+ **Documentation:** ReadMe.md
+ **GitHub Link:** https://github.com/chris2020/Java-AI-Game-Fourth-Year

### What is the application?

This application uses Artificial Intelligence Search Algorithms such as a Brute Force Algorithm and a Depth Limited Depth First Search to allow a game character to find a goal node within a maze. The main spartan characters movement is controlled by a single search algorithm, the Sprites (Spiders) are controlled by different search alorithms. The Sprites are also threaded using an Executor Service allowing them to execute in parallel along with the main spartan character. Fuzzy Logic and Neural Networks are also used in this application. The Fuzzy Logic is responsible for determining the level of risk the spartan character has, this is done by using the value for the spartans health along with its weapon level. The risk level is determined through Fuzzy rules we created coupled with various membership functions. With this risk we will decide on what the goal node for the spartan should be, i.e. if risk is high the spartan should look for a weapon. The Neural Network is responsible for determining what the spartan should do based on the situation. For Example, if the spartan has low health and no weapon and encounters a sprite, he needs to run. If he encounters a sprite with high health and a weapon he should fight.

### What does the appication run on?

This application is built using Java and will run on any machine or OS once it has Java installed. It is recommended that your computer has Java 8 installed. 

### Deployment Details
The application can be downloaded from GitHub using the above link. You will be need to run it from the command line. It is recommended that you navigate to the root directory of the project. Here you can run the command that will start the application.

**Note** _you will need to have a jar file if you want the application to run and you will need to be add it to the classpath_

**Example command to run** 

 ```
    java –cp ./game.jar ie.gmit.sw.ai.GameRunner
 ```

 * __java__ is the command needed to run a java application
 * __-cp__ is an argument that will add the required jar files to the classpath. 
 * The class to run is GameRunner.java and is found in the __ie.gmit.sw.ai.maze package__

__if you want to run this in your own IDE follow these steps:__
1. Download a zip file of this project using the 'Clone or download' button above and unzip it __or__ download [Git](https://git-scm.com/downloads) and execute the following command in the Git Bash Console:
	```
	git clone https://github.com/chris2020/Java-AI-Game-Fourth-Year.git
	```
  
  2. Open the downloaded file in your perferred IDE or import the project into your IDE.
  3. Go to the GameRunner.Java file in the __ie.gmit.sw.ai.maze__ package.
  4. Run the project as a Java Application from this class.
