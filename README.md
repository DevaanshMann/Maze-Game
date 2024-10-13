Overview
This project is a simple Maze Solver implemented in Java as part of the COMP 282 course project at California State University, Northridge. The program uses a backtracking algorithm to navigate through a maze, starting at the top-left corner and aiming to reach the exit at the bottom-right corner. The user can observe the program as it explores different paths and backtracks when necessary until it finds the exit.

Features
Backtracking Algorithm: The program intelligently navigates the maze using a stack-based backtracking technique. It explores all possible moves and backtracks when a dead end is encountered.<br>
Maze Display: The maze is rendered on the console, showing walls, paths, and the current position of the mouse (represented by 'X').<br>
Automatic Maze Solving: The program automatically clears the maze and finds the exit point without any user input once started.

Maze Representation
The maze is represented as a 2D array where:<br>

91 represents a wall.<br>
0 represents an empty path that can be traversed.<br>
25 represents key points of interest or goals within the maze (used as exit points).
How It Works
Initialization:
The program begins with an introductory countdown before displaying the maze.<br>
The player's starting point is (0, 2) and the goal is to navigate to the exit at (49, 24).

Movement:
The mouse (X) moves step by step, trying to go right, down, left, or up in that order.<br>
If no valid moves are available, the program backtracks to a previous position using a stack to store the path history.

End Condition:
The program stops once the mouse reaches the bottom-right corner of the maze, displaying a success message.

Files
Maze.java: This is the main file that contains the logic for rendering the maze, moving the mouse, and the backtracking algorithm.
Requirements
Java Development Kit (JDK): The program requires JDK 8 or higher to compile and run.
How to Run
Clone the repository from GitHub. <br>
Compile the Maze.java file using a Java compiler. <br>
Run the compiled program to watch the Maze Solver in action.
