Whats changed : 
Increases sizes of agents from 4 x 4 to 5 x 5

4 by 4 was that pixel too small, also the graphics are different. Brownish background and the agents are different colours.

Fitness is calculated by the same method as before (adding all attributes together) except now it will add 10% of the energy value to it.

Crossover points works properly. Selects a number between 0 and 4. Will swap attributes from 1st winner up until that crossover point. After that it will only swap over 2nd winners attributes. 
See picture (crossover.jpg) for details.

BUGS:

The rectangle bounds would default to 0 for any new generation individuals. They dont have access to the image data SO hard code them to 5 by 5. Poor solution but works. Better would be to get
the individuals to set based on the image used. Maybe.

