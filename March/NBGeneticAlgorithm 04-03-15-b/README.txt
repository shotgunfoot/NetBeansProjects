One hell of a potch getting vision to work. Got it working to some degree but its not a proper cone of vision.

Heres a break down of the process:

Get a cone of vision in there. 
Attach it to the bot and make it rotate with it.
Basic collision detection so that when food is in the cone it does something.

Quick google for anything related to field of vision in games turned up with 3D games and or involving vector. There had to be a simpler way however.
SO Polygons were used. Polygons can be created several ways. How I chose to make them was with two int[3] arrays. So naturally I start playing with Polygons globally and end up with random 
polygons in the simulation. Step one complete.

Attaching it to the bot was quite difficult. I got it to rotate with it, but never in the right place. It was always offset by a huge amount or by a small amount. Turns out im not so good with
geometry and what not. 

int dxpoly[] = {5, 30, -30};
int dypoly[] = {5, -50, -50};

These are generic int arrays that represent data for the polygon. A triangle polygon. Each index for both of them represent 1 point of the triangle. The polygon doesn't need the position data of
its bot owner at all. And it rotates with the value that the bot body uses.

Here is the global crap version so that I can explain better.

if (preyPop[x].isAlive()) {
                        AffineTransform t = new AffineTransform();
                        t.translate(preyPop[x].getX(), preyPop[x].getY());
                        //convert the angle to radians so the displayed image is correct to direction of agent
                        t.rotate(Math.toRadians(preyPop[x].getRotation()), 9 / 2, 9 / 2);
                        t.scale(1, 1);
                         
                        g2d.drawImage(prey, t, this);
                        
                         /*
                         Messing with polygons for field of view
                         */
                        
                        //if want vision to begin from inside bot, offset everything by 5
                         
                         int dxpoly[] = {5, 30, -30};
                         int dypoly[] = {5, -50, -50};
                         
                         Polygon po = new Polygon(dxpoly, dypoly, dxpoly.length);
                         
                         Shape s = t.createTransformedShape(po);
                         
                         g2d.fill(s);

                         .......

First checks if prey is alive, if so, draw it. An affine transform is made for it. Which is translated by the x and y coords of the currently indexed preybot. 
t.rotate simply takes the rotation value set earlier in the prey logic timer loop and applies it with 9 / 2, 9 / 2 offset. This is so that it rotates around its center rather than the 0, 0 of the
image used.
t.scale keeps it to its original size.

-->g2d.drawImage(prey, t, this);

This line draws the image prey, with transform and rotate of the affine transform. 

Then two int[3] arrays are created to specify the dimensions of the triangle. Offset of 5 in x and y so its closer to the center of the prey image. 30 to -30 on x so thats 60 in total.
Same goes for the y side of things. A polygon is created with these arrays. Then a Shape is created using the data from the AffineTransform t so it has the bots x and y coords and places a triangle
over it.
g2d.fill(s); Simply draws it.

This was the crappy version to test that it could work. Afterwards I separated it all to follow Object Oriented guidelines.

The next part was making it so that it could be modifiable when it came to the genetic algorithm. the 5, 30, -30 had to be dynamic. For the GA to work.


ANOTHER PROBLEM
The draw method in paint obviously runs much, much...much faster than my 100 millisecond Timer that is preyLogic. Which means certain things might try to be drawn before it can actually be drawn.
Resulting in out of bounds exceptions. Quick fix. Change it so that the Boolean controlling wether to draw or not is set to true at the end of the first iteration of a timer.
Future problems with this is that multiple timers (which i'll have due to predator having one themselves) will need to wait at least once for both of them to finish looping before letting them draw.
This will cause concurrency problems in the future.

ON THE GOOD SIDE
I implemented a cheap and simple pause feature. Big fat pause boolean that allows the timers to actually loop through the logic

Also. State stuff is starting to work. Currently the bot will spot food, switch to eat state and then back to search state. Causing them to essentially freeze on the spot.
Need to make it so that it continues forward, ignores all other food, when eaten that food bot THEN switch back to search. The eat states target will be the one it finds. 
I could do this by having it actually choose a random location to begin with. When vision finds food. switch to eat, go to food, when on location make a new random target and switch to search.
Could either have Search have a function on enter which is to assign a random target. Or have Eat have an exit function to makes the random target. or whatever...
                      