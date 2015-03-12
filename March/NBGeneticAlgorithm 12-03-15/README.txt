Grass food for prey will replenish when half empty.

BUGS FOUND:

->All predators would chase prey number 0. This was because i was setting it so on line 574 "int prey = 0;". Now its "int prey = predPop[x].getPreyID();"
This change makes it so that once the predator has its target, it will only switch it out if the target dies in some way.

TO DO:
->Decide on what methods the simulation stops and performs the genetic algorithm loop.
 |-> On each death check if there are any prey / pred alive if not, stop and do GA.
 |-> Possibly time the simulation. After so long end it prematurely and do GA.

->Energy loss rate and gain for both agents. DONE!

->Design chromosome for both agents.

Genetic Algorithm to do list:
->Save both populations locally.

->Store population history.

->Work out fittest individuals and rank them.

->Perform crossover.
    ->This needs in depth to do list.

->Perform mutation at strength given.

->Return new population of both agents after crossover and mutation.

->Repeat above when called.


LASTLY:
Moving towards implementing the GA. There is some functionality there at the moment.
Because two timers will be at different times deciding when the simulation should end. I need to make the call for processing both agents in the GA once. I want to put it into the "main" section but
it is not having it. I need to make it so that when one Timer calls for the pause that it stops updating the agent in the other timer.
When either population is dead it sets Pause to false. This stops the updating. Good. But how to make it so that it can pass both populations once. Where should I put this section?

Sorted when to place it. If either population go extint it will set a boolean to true "newgen" and invoke the pause button as if its being pressed. This pause button when pressed checks if
newgen is true. If it is. It will send both populations to the GA class and then get them back and unpause the simulation.