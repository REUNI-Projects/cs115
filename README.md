## cs115 | Object Oriented Programming I

### Course Summary:

CS115 was the first real programming course I took in university. It covered the basics of object 
oriented programming, java, and common programming practices. This course left out recursion, 
exception handling, and I think File I/O.

### Original Project:

We had to make a dice game where you roll 2 die and try to eliminate all the numbers 1 to 12. The 
ui was just text in the terminal. 2 dies were rolled and you get 2 numbers, you can either 
eliminate the sum of the 2 numbers or eliminate the 2 individual numbers. You lose if neither 
option is availabe or you win after elimiating all the numbers. 

### Remake Project Idea:

I found what I believe was the actual game, *Shut the box*, and I want to make that. I will stick 
to just the terminal for the ui but it will look better then just text, maybe some ascii art. The 
rules will be based on the actual game. Maybe a score board but for data to be percistant, I would 
need to use File I/O which was not covered in cs115 but cs116.

---

### STB+ Terminal Edition

**Rules:**
1. Each turn, the player throws the dice and tries to shut the box.
2. Each throw of the dice are as follows.
    1. If and only if all tiles that require N number of dice to be thrown to shut are shut, 
    Player can opt to only throw N-1 dice.
    2. Player can only shut tiles that are not shut and whose values sum to exactly the sum of 
    the dice thrown.
        - Ex:<br>
            You threw 2 dice and got 3 and 6 which sums to 9. Assuming no tiles have been shut 
            yet, your available moves are:<br>
            - [ 9 ]
            - [ 1 & 8 ]
            - [ 2 & 7 ] 
            - [ 3 & 6 ]
            - [ 4 & 5 ]
            - [ 1 & 2 & 6 ] 
            - [ 1 & 3 & 5 ] 
            - [ 2 & 3 & 4 ]
3. The game ends when there are no available moves left
4. The final score would be the sum of the tiles left unshut, the lower the score the better!

Original Rules: 
[Source](https://www.mastersofgames.com/rules/shut-box-rules.htm?srsltid=AfmBOooYntoxPjQ7Kj2dkRyXA7wkTZ193iL9vYO8kz3o-y91YhSWKxjr)

**To Run:**

In the terminal:
1. `java -cp src/bin run` to play yourself, 
    1. `java -cp src/bin run -t` to run tests
    2. `java -cp src/bin run -ai _ #` to let an ai try
        - Replace _ with the bot (d: mine/default, g: gbt) 
            (You need to add your own key for gbt)
        - Replace # with the level (0-5)
3. If you need to compile first, run `javac -encoding UTF-8 -d src/bin src/*.java` from root 
    (same directory as the src folder)

**Sample:**