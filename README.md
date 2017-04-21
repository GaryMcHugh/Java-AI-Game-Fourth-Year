# Artificial Intelligence Project

**Student Name:** Christy Madden <br />
**Student ID:** G00214065 <br /><br />
**Student Name:** Gary McHugh <br />
**Student ID:** G00308668 <br /><br />
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

This application uses Artificial Intelligence Search Algorithms such as a Brute Force Algorithm and a Depth Limited Depth First Search to allow a game character to find a goal node within a maze. The main Spartan characters movement is controlled by a single search algorithm, the Sprites (Spiders) are controlled by different search algorithms. The Sprites are also threaded using an Executor Service allowing them to execute in parallel along with the main Spartan character. Fuzzy Logic and Neural Networks are also used in this application. The Fuzzy Logic is responsible for determining the level of risk the Spartan character has, this is done by using the value for the Spartans health along with its weapon level. The risk level is determined through Fuzzy rules we created coupled with various membership functions. With this risk, we will decide on what the goal node for the Spartan should be, i.e. if risk is high the Spartan should look for a weapon. The Neural Network is responsible for determining what the Spartan should do based on the situation. For Example, if the Spartan has low health and no weapon and encounters a sprite, he needs to run. If he encounters a sprite with high health and a weapon he should fight.

### What does the application run on?

This application is built using Java and will run on any machine or OS once it has Java installed. It is recommended that your computer has Java 8 installed. 

### Deployment Details
The application can be downloaded from GitHub using the above link. You will be need to run it from the command line. It is recommended that you navigate to the root directory of the project. Here you can run the command that will start the application.

**Note** _you will need to have a jar file if you want the application to run and you will need to be add it to the classpath_

**Example command to run** 

 ```
    java –cp ./game.jar ie.gmit.sw.ai.maze.GameRunner
 ```

 * __java__ is the command needed to run a java application
 * __-cp__ is an argument that will add the required jar files to the classpath. 
 * The class to run is GameRunner.java and is found in the __ie.gmit.sw.ai.maze package__

__if you want to run this in your own IDE follow these steps:__
1. Download a zip file of this project using the 'Clone or download' button above and unzip it __or__ download [Git](https://git-scm.com/downloads) and execute the following command in the Git Bash Console:

 ```
    git clone https://github.com/chris2020/Java-AI-Game-Fourth-Year.git
 ```
  
  2. Open the downloaded file in your preferred IDE or import the project into your IDE.
  3. Go to the GameRunner.Java file in the __ie.gmit.sw.ai.maze__ package.
  4. Run the project as a Java Application from this class.

### AI Search Algorithms
The AI Search Algorithms are used to make the characters traverse the maze, there are various algorithms to do this. We first assigned the Brute Force Algorithm to the Spartan and manually set a goal node for him to reach. This was to ensure that we could successfully traverse the maze. Once we had this working we applied it to the Sprites. We used an Executor Service to thread the Sprites, allowing multiple Sprites to search for the goal node at the same time. We assigned different algorithms to different Sprites.

|Character|Search Algorithm|
|---|---|
|Spartan|<search algorithm here>|
|Black Spider|<search algorithm here>|
|Blue Spider|<search algorithm here>|
|Brown Spider|<search algorithm here>|
|Green Spider|<search algorithm here>|
|Grey Spider|<search algorithm here>|
|Orange Spider|<search algorithm here>|
|Red Spider|<search algorithm here>|
|Yellow Spider|<search algorithm here>|

### Fuzzy Logic
|Input Variables|Description|
|---|---|
|Health| The health is a value that is between 0 and 100 where a value of 0-30 is low health,  a value of 30-70 is moderate health and 70-100 is high health. The characters health along with level of weapon they have contributes to the overall risk.|
|Weapon|The weapon value describes the value of the weapon that the character has where, 0 means the character does not have a weapon. 1 means that he character has picked up one sword and 2 means the character has picked up two swords which powers up his current weapon. |


|Output Variables|Description|
|---|---|
|Risk|This is evaluated through membership functions and fuzzy rules. It outputs a value between 0 and 2 that is based on the risk the character is at. We then check this output to see what the risk is and make decisions based on that output.|

Below is an example of a Fuzzy rule that is used to determine the risk:

```
RULE 1 : IF health is high AND weapon is two OR weapon is one THEN risk is low;
```

This means that if the Spartans health is high and he has a weapon of any kind, his risk is low as he can attack other spiders and is not in danger of dieing
### Neural Network
