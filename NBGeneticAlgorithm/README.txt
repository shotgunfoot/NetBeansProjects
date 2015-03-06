Things that have changed :

No longer triangle vision, working field of view working with Arc2D which is moved around via the robots affine transform so it sticks to its front. See java docs on Arc2D and Shape.
It is done by assigning a new Arc2D in the loop, convert it to a Shape stored in the robot class, then use that shape for drawing and checking boundaries. 

Can switch between state eat and state search with relatively small problems.
Will need to draw a diagram explaining why it doesn't always head straight for the food its searching for. Its to do with when the angle between the prey current location vs the food location.
It doesnt take into consideration how long it takes to turn. The angle set might not be perfect for the full rotation. Meaning it will be off angle by a small %. Its not too bad if theres enough food
popping up between the prey. Otherwise it could be considered a problem if theres a sever lack of food. The prey could endlessly be searching for the same item. Also need to make a check on each loop 
whether or not the food its heading towards has been eaten by another prey.

Run down of the two states so far.

Search :

Loops through all prey and all food items. Checks if they already have a target or not and if the food is alive. If the prey doesnt have a target and the food is alive. It will set the angle to that
food item and then change the target status of that prey so that it won't constantly refresh its target. While it does this it will check if any food rects trigger the fov. If so, sets that food
as the target and switches to the eat behaviour.

Eat :

Loops through all prey, constantly refreshing the angle between the prey and food item. When its finally eaten, sets that food item to dead and resets the variables so the prey will search for another
random food bot.

Currently whole prey logic is done via Timers on a 100 millisecond loop. Going to want to use Threads now because they will be ultimately faster.

Current bugs :

->The whole go to the angle is a bit broken. The prey will bounce back and forth trying to get itself to the right angle untill fully looping around in a broken way. Also if it doesnt encounter a food
item it can shoot to a corner and get stuck.
->When the simulation is paused then reset and started again it breaks. Due to the drawing of the fov shape. Unsure why