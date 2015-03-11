Screw angle2D. Just screw it so much.

if under 180. Find difference and minus the rotation by that difference for the fovshape

Heres the complicated mess that is setting the FOV for each agent.

Step 1:
Create an Arc2D var = new Arc2D.Double(x, y, width, start, height, extent, pie);
x,y width, height and start are there to set the location and size of the arc.
extent is the angle slice. For example, 90 makes a 90 degree slice.
The last parameter is one of three. PIE, CHORD and OPEN. PIE is used because it makes a full pie slice.

Using an agent example the line looks like this :

Arc2D fov = new Arc2D.Double(0, 0, predPop[x].getFovWidth(), predPop[x].getFovWidth(), 0, predPop[x].getFov(), Arc2D.PIE);

It grabs the needed variables from that agent.

Step 2:
Create an AffinTransform seperate to the one controlling the rotation and position of the agent body.
The translate looks like this:

k.translate(predPop[x].getX() - predPop[x].getFovWidth() / 2 + predPop[x].getWidth() / 2, predPop[x].getY() - predPop[x].getFovWidth() / 2 + predPop[x].getHeight() / 2);

Takes the x location minus half the fovwidth and finally adds half the width of the agent. Same for y location and height. This is because
the arc is painted inside a rectangle. This rectangle is the size of the fovwidth. Halfing it makes the new center the center of the agent.

Step 3:
Work out the difference between 180 and the fov specified. Then half it.

	double fovd = predPop[x].getFov();
    double difference = 180 - fovd;
    difference = difference / 2;
	
Step 4:
Using the difference found, offset the rotation by that much and offset by width and height. This is so it rotates around the center of the arc2D using 
the same rotation set by the agent body.

k.rotate(Math.toRadians(predPop[x].getRotation() - difference), predPop[x].getFovWidth() / 2, predPop[x].getFovWidth() / 2);

Step 5:
Store this newly created shape with the agent.



OTHER NOTES
Implemented the clicking ability. Doesnt show the attributes in the GUI yet. Shouldn't be too hard to do however.

Need to go over the entire program for spelling errors, clarity sake, naming methods and to make sure there are no hardcoded things. i.e 9 / 2 instead of getwidth / 2.