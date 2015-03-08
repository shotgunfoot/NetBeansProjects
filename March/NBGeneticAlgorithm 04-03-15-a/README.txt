This version changed the way the prey logic Timer handled Rectangles. Instead of a globally used rect it now uses the private one belonging to the agent via getters and setters.
Also it updated the food rectangles. They never move so it was redundant to update them constantly. That and it was only updated as many food items as there were prey agents. Thats fixed.

Lastly, implemented basic third class that is Predator and its constructor is the same as a prey. Only difference so far is the types of states. It has 2. Search and Hunt. Self explanatory.

WHAT NEEDS TO BE DONE : 
Some sort of vision based search that the prey can use. After its done I can move onto getting Predator behaviour.