# Artificial Intelligence Project

**Student Name:** Christy Madden <br />
**Student ID:** G00214065 <br /><br />
**Student Name:** Gary McHugh <br />
**Student ID:** G00308668 <br /><br />
**Module:** Artificial Intelligence<br />
**Lecturer:** Dr John Healy <br />

___

# Introduction	

## Technologies Used:

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

## Deployment Details
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
  
## Features
The features of this application are listed below:
+ Re-written the maze as a 2D Node Array
+ Spartan can move using a search algorithm
+ Sprites are threaded using Executor Service
+ Different coloured Sprites use different Search Algorithms to move
+ Goal node can be reached when using the search algorithms
### Additional Features
An additional feature that we added to this project was to add a search algorithm to the Spartan. Initially the Spartan was being controlled by the user using input from the keyboard. In our project this has been changed so that the Spartan is now being controlled with a Search Algorithm. This search algorithm allows us to set a goal node such as a sword or a Sprite and have the Spartan traverse his way through the maze using the algorithm to the goal node. 

### AI Search Algorithms
The AI Search Algorithms are used to make the characters traverse the maze, there are various algorithms to do this. We first assigned the Brute Force Algorithm to the Spartan and manually set a goal node for him to reach. This was to ensure that we could successfully traverse the maze. Once we had this working we applied it to the Sprites. We used an Executor Service to thread the Sprites, allowing multiple Sprites to search for the goal node at the same time. We assigned different algorithms to different Sprites.

|Character|Search Algorithm|
|---|---|
|Spartan|DFS Brute Force Algorithm|
|Black Spider|BFS Brute Force Algorithm|
|Blue Spider|Iterative Deepening DFS|
|Green Spider|Depth Limited DFS|
|Yellow Spider|Recursive DFS|

### Fuzzy Logic
 We used fuzzy logic to output the risk that the Spartan has based on his health and whether or not he had a sword. The idea behind this was that we could evaluate the Spartans situation and change his goal node based on it. For Example, if the Spartan had moderate health and no weapon we would assign him a goal of getting a weapon. If the Spartan had high health and a weapon we would set the goal to be a spider to attack. This logic can clearly be seen in our fuzzy rules.
|Input Variables|Description|
|---|---|
|Health| The health is a value that is between 0 and 100 where a value of 0-30 is low health, a value of 30-70 is moderate health and 70-100 is high health. The character's health along with level of weapon they have contributes to the overall risk.|
|Weapon|The weapon value describes the value of the weapon that the character has where, 0 means the character does not have a weapon. 1 means that he character has picked up one sword and 2 means the character has picked up two swords which powers up his current weapon. |


|Output Variables|Description|
|---|---|
|Risk|This is evaluated through membership functions and fuzzy rules. It outputs a value between 0 and 2 that is based on the risk the character is at. We then check this output to see what the risk is and make decisions based on that output.|

Below is an example of a Fuzzy rule that is used to determine the risk:

```
RULE 1 : IF health is high AND weapon is two OR weapon is one THEN risk is low;
```

This means that if the Spartans health is high and he has a weapon of any kind, his risk is low as he can attack other spiders and is not in danger of dying

### Neural Network
We use the neural network to evaluate the current situation of the Spartan, we look at values such as Health and whether or not he has a sword and bombs. We pass the neural network the values that the Spartan currently has (his health, sword status and both bomb status's) We then output in the console what he should do in this situation such as fight, run and panic. This would then be used to determine what the Spartan should do in certain situations.

|Item|Values|
|---|---|
|Health|2 is Good Health, 1 is Okay Health, 0 is Needs Health|
|Sword|1 is Yes, 0 is No|
|Bomb|1 is Yes, 0 is No|
|Hydrogen Bomb|1 is Yes, 0 is No|


## Problems Encountered
We ran into many issues throughout the development of this application, here we will discuss these issues in detail. The first issue we ran into was assigning an algorithm to a 2D array of characters. The search algorithms that were provided to us were created to interact with a 2D array of Nodes rather than a 2D array of Characters. As there were many algorithms that we could use we made the decision that it would be easier for us to re-write the maze as an array of Nodes rather than re-write the algorithms to use arrays of characters. We ran into issues with the Game View, we found it difficult to update the game view without getting errors. Due to time constraints, we decided to output to the console instead as we didn't have time to fix the game view. We felt as though we would achieve more by printing to the console rather than updating the view. Another issue we faced was using the algorithms effectively, we found that each algorithm was different, meaning the configuring for one algorithm would not work for another. This limited our ability to use different algorithms in this application. Finally, the biggest issue that we faced was time to complete this project. We felt as though given more time with the knowledge we have gained, we could re-configure some of the code and get the application working as intended. 
