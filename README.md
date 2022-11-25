## L00T01G09 - Donkey Kong<PROJECT NAME>

> The project is based on an arcade game of 1981 the 'Donkey Kong'. This charather is the main monster that the jupman (Mario) needs to confront. An important charatheristic is the ability to jump, since it was the first arcade game to incorporate it. Therefore, the goal of the game is for Mario to reach the princess, in the highest floor. But he will have to face Donkey Kong that is on rampage throwing barrels, and climb some dangerous stairs.

>The authors of the project are (...), João Fernandes (202108867@fe.up.pt) and Sara Santos (202108675@fe.up.pt) for LDTS 2022/2023

### IMPLEMENTED FEATURES

**Features:**

- **Jumping** - Mario (or the char 'X') will jump when the space bar key is pressed.

- **Climbing stairs** - To move to the higher floor it's needed to climb the stairs. Therefore, if the charather is in the same position as the stairs (or char 'H'), it can climb. But if the stairs are broken, the action can't be completed.

- **Gravity** - Gravity is very important in Donkey Kong, and ithelped in some functions. For example, if Mario isn't on the top of the floor(or char '#'), he automatically falls.

- **Moving Barrels** - The barrels are an important feature in the original game. In this project, they move according to the floor and fall with the action of gravity. When they fall to the  lower floor, they change the tragetory. In other words, if they were moving to the right side, in the next floor, they will move to the left side. Sometimes, they can also come down to the stairs.

- **Winning when reach princess** - Usually, the game ends when  Mario is in the same level as the princess (or char 'P'). The way to win is the same. So, in the floor where the char is, the game ends, and the player can play again or exit.

- **Losing when a barrels hits** - When the barrels (or char 'O') are in the same place as Mario, the game automatically ends, and the player can try again.

- **Losing when is face to face with Donkey Kong** - This feature is similiar to the previous, when Mario touches Donkey Kong, the player looses.

**Mario running**

![img]((https://github.com/FEUP-LDTS-2022/project-l01gr09/blob/3f0ecc3c7dcb15440494e213e3df7b1eb28a300d/src/main/resources/img/floor_screenshot.png))

**Mario on the stairs**

![img]((https://github.com/FEUP-LDTS-2022/project-l01gr09/blob/310d5ff04cb54c08abd984266eff0f28f1774dc0/src/main/resources/img/stairs_screenshot.png))

**Mario jumping**

![img]((https://github.com/FEUP-LDTS-2022/project-l01gr09/blob/310d5ff04cb54c08abd984266eff0f28f1774dc0/src/main/resources/img/jump_screenshot.png))

### PLANNED FEATURES

**Future Features:**

- **Hammer** - Instead of only jumping to bypass the barrels, Mario has a tool (the hammer) to kill them, pressing 'X'.
- **Two Different Levels** - On the actual model, it has  just one level, will have two, with different rules and higher difficulty. 
- **Tilted Floor** - In the first level, the floor won't be straight, to add difficulty to the gameplay and the program itself. 
- **New Elements** - In the present level, to win is just to go to the higher floor. But will be added new elements, like different floor that need to jump to make Donkey Kong fall. 
- **Different Menus with More Options** - Currently, the menus are very similar and simple, and don't have options like instructions. In the future, they will be more appealing and easy to understand all the game.
- **Different Draw Methods** - The characters are base on just one char, and element like floor or stairs are longer and have spaces between them. The next delivery will have a more detailed graphic part.

>Level 1 - More similar to the original game with titled floor and hammer that needs to collect 


### DESIGN

> This section should be organized in different subsections, each describing a different design problem that you had to solve during the project. Each subsection should be organized in four different parts:

- **Problem in Context.** The description of the design context and the concrete problem that motivated the instantiation of the pattern. Someone else other than the original developer should be able to read and understand all the motivations for the decisions made. When refering to the implementation before the pattern was applied, don’t forget to [link to the relevant lines of code](https://help.github.com/en/articles/creating-a-permanent-link-to-a-code-snippet) in the appropriate version.
- **The Pattern.** Identify the design pattern to be applied, why it was selected and how it is a good fit considering the existing design context and the problem at hand.
- **Implementation.** Show how the pattern roles, operations and associations were mapped to the concrete design classes. Illustrate it with a UML class diagram, and refer to the corresponding source code with links to the relevant lines (these should be [relative links](https://help.github.com/en/articles/about-readmes#relative-links-and-image-paths-in-readme-files). When doing this, always point to the latest version of the code.
- **Consequences.** Benefits and liabilities of the design after the pattern instantiation, eventually comparing these consequences with those of alternative solutions.

**Example of one of such subsections**:

------

#### THE JUMP ACTION OF THE KANGAROOBOY SHOULD BEHAVE DIFFERENTLY DEPENDING ON ITS STATE

**Problem in Context**

There was a lot of scattered conditional logic when deciding how the KangarooBoy should behave when jumping, as the jumps should be different depending on the items that came to his possession during the game (an helix will alow him to fly, driking a potion will allow him to jump double the height, etc.). This is a violation of the **Single Responsability Principle**. We could concentrate all the conditional logic in the same method to circumscribe the issue to that one method but the **Single Responsability Principle** would still be violated.

**The Pattern**

We have applied the **State** pattern. This pattern allows you to represent different states with different subclasses. We can switch to a different state of the application by switching to another implementation (i.e., another subclass). This pattern allowed to address the identified problems because […].

**Implementation**

The following figure shows how the pattern’s roles were mapped to the application classes.

![img]((https://github.com/FEUP-LDTS-2022/project-l01gr09/blob/3f0ecc3c7dcb15440494e213e3df7b1eb28a300d/src/main/resources/img/floor_screenshot.png))

These classes can be found in the following files:

- [Character](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/Character.java)
- [JumpAbilityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/JumpAbilityState.java)
- [DoubleJumpState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/DoubleJumpState.java)
- [HelicopterState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/HelicopterState.java)
- [IncreasedGravityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/IncreasedGravityState.java)

**Consequences**

The use of the State Pattern in the current design allows the following benefits:

- The several states that represent the character’s hability to jump become explicit in the code, instead of relying on a series of flags.
- We don’t need to have a long set of conditional if or switch statements associated with the various states; instead, polimorphism is used to activate the right behavior.
- There are now more classes and instances to manage, but still in a reasonable number.

#### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

> This section should describe 3 to 5 different code smells that you have identified in your current implementation, and suggest ways in which the code could be refactored to eliminate them. Each smell and refactoring suggestions should be described in its own subsection.

**Example of such a subsection**:

------

#### DATA CLASS

The `PlatformSegment` class is a **Data Class**, as it contains only fields, and no behavior. This is problematic because […].

A way to improve the code would be to move the `isPlatformSegmentSolid()` method to the `PlatformSegment` class, as this logic is purely concerned with the `PlatformSegment` class.

### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.

**Example**:

- John Doe: 40%
- Jane Doe: 60%
