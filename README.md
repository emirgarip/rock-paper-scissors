# Rock-Paper-Scissors Game

Welcome to the Rock-Paper-Scissors game! This is a simple text-based game where you can play against the computer. Choose your moves wisely and see if you can beat the computer!

## Game Rules

- Rock beats Scissors
- Scissors beats Paper
- Paper beats Rock

## How to Play

1. Clone or download the project to your local machine.

2. Open your preferred Java IDE (Integrated Development Environment), such as Eclipse, IntelliJ IDEA, or Visual Studio Code.

3. Import the project into your IDE as a Java project.

4. Open terminal and run `mvn clean install`

5. Once the project is imported, navigate to the Main class located at `org.abas.main.Main`.

6. Run the `main` method in the Main class to start the game.

7. The game will prompt you to enter your username.

8. Follow the instructions to enter your move: R for Rock, P for Paper, S for Scissors, or Q to quit the game.

9. After each round, the game will display your move and the computer's move, along with the outcome.

10. Keep playing until you decide to quit by entering 'Q'.

## app.properties Structure

The `app.properties` file is used to specify the behavior of the computer opponent. It should be placed in the root directory of the project. The file should have the following structure:

`computerBehaviour=<value>`

- `<value>` can be one of the following options:
    - `R` (Rock)
    - `P` (Paper)
    - `S` (Scissors)
    - `Random` (Computer randomly selects a move)

Example `app.properties` file:

`computerBehaviour=Random`

In this example, the computer opponent will randomly select its moves.

Feel free to experiment with different values for `computerBehaviour` to change the computer's behavior during the game.

Enjoy the game and have fun playing Rock-Paper-Scissors! 🎮👊✋✌️