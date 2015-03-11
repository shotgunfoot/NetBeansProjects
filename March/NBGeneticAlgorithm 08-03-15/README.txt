Lots of progress. Lots of bugs.

Most note worthy bugs : 

->All agents at some point get stuck running into walls or corners.

->Predator agents get confused trying to switch targets. Currently it constantly swaps out the target. Need to make it focus on only one target until vision finds another.

->Because they keep switching targets they eventually get stuck, usually heading to the right.

->Not a bug as such but a possible problem is when looping through potential targets it will count the targets that are not alive. It might not be a problem. But just in case it's something that
should be looked at and possibly changed.

Things that are not completed : 

->Escape behaviour is not implemented for the prey bots.

->Not expending energy when running around (maybe) Might want to make it an additive only thing and have it count towards fitness value in the GA

->Refresh food population

->The genetic algorithm

To do list :
->Fix all bugs so far.
->Implement final behaviour for prey (escape).
->New class called Genetic Algorithm that handles all of that stuff. (side note) Create a string based chromosome ready for the GA.