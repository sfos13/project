# L00T01G09 - Donkey Kong<PROJECT NAME>


> The project is based on an arcade game of 1981 the 'Donkey Kong'. This charather is the main monster that the jupman (Mario) needs to confront. An important charatheristic is the ability to jump, since it was the first arcade game to incorporate it. Therefore, the goal of the game is for Mario to reach the princess, in the highest floor. But he will have to face Donkey Kong that is on rampage throwing barrels, and climb some dangerous stairs.

>The authors of the project are Nils Rothamel (202203004@fe.up.pt), João Fernandes (202108867@fe.up.pt) and Sara Santos (202108675@fe.up.pt) for LDTS 2022/2023

## IMPLEMENTED FEATURES

**Features:**

- **Mario Movement** - The player can controll the directions that Mario moves. But there are restrictions, you only move to right and left in the floor, and the stairs are the only way to move in the axis of y.

- **Jumping** - Mario (or the char 'X') will jump when the space bar key is pressed.

- **Climbing stairs** - To move to the higher floor it's needed to climb the stairs. Therefore, if the character is in the same position as the stairs (or char 'H'), it can climb. But if the stairs are broken, the action can't be completed.

- **Gravity** - Gravity is very important in Donkey Kong, and it helped in some functions. For example, if Mario isn't on the top of the floor(or char '#'), he automatically falls.

- **Moving Barrels** - The barrels are an important feature in the original game. In this project, they move according to the floor and fall with the action of gravity. When they fall to the  lower floor, they change the tragetory. In other words, if they were moving to the right side, in the next floor, they will move to the left side. Sometimes, they can also come down to the stairs.

- **Winning when reach princess** - Usually, the game ends when  Mario is in the same level as the princess (or char 'P'). The way to win is the same. So, in the floor where the char is, the game ends, and the player can play again or exit.

- **Losing when a barrels hits** - When the barrels (or char 'O') are in the same place as Mario, the game automatically ends, and the player can try again.

- **Losing when is face to face with Donkey Kong** - This feature is similar to the previous, when Mario touches Donkey Kong, the player looses.

**Screenshots of the Game**

![img](src/main/resources/img/floor_screenshot.png)

![img](src/main/resources/img/stairs_screenshot.png)

![img](src/main/resources/img/jump_screenshot.png)

## PLANNED FEATURES

**Future Features:**

- **Hammer** - Instead of only jumping to bypass the barrels, Mario has a tool (the hammer) to destroy them, pressing 'X'.

- **Two Different Levels** - On the actual model, it has just one level, but it will have two, with higher difficulty, different rules, and goals. Because of the new elements added and more complex design.

- **Tilted Floor** - In the first level, the floor won't be straight, to add difficulty to the gameplay and the program itself.

- **New Elements** - In the present level, to win, Mario needs to go to the highest floor. But new elements will be added, like a different floor where Mario needs to jump to make Donkey Kong fall or new types of barrels.

- **Different Menus with More Options** - Currently, the menus are very similar and simple, and don't have options like instructions. In the future, they will be more appealing and easy to understand.

- **Different Draw Methods** - The characters are based on just one char, and elements like floors or stairs are longer and have spaces between them. The next delivery will have more detail and better graphics.

**Mocks**

>**Level 1** - More similar to the original game with titled floor and a hammer that needs to be collected.

![img](src/main/resources/img/originalgame_nivel1.png)

>**Level 2** - Instead of a titled floor, the levels of floor are proportional to each other. The goal also change: Mario need to jump all 8 yellow blocks in the floor to Donkey Kong fall and end the game.

![img](src/main/resources/img/originalgame_nivel2.png)

![img](src/main/resources/img/originalgame_nivel2_lastfloor.png)

![img](src/main/resources/img/originalgame_nivel2_end.png)

