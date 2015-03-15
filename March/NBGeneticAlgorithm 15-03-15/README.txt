Whats new :

->Got it to pause when all bots are dead on either side. That is my end clause for the simulation at the moment.
->Generally no predators die and this might be a problem.
->Now creates text file log of the predator population stuff. Only the fitness value so far but its a work in progress.
->Fitness evaluation works.

->FITNESS EVALUATION
    ->Works by adding all the attributes together and adding an extra 10 points for every 100 the energy value is over. I.e Energy score of 350 gives 30 points extra.

->WHAT TO DO
    ->Need to separate the 5 steps in the GA. 
        ->Evaluate Fitness by storing the fitness value of each individual (done)
        ->Selection by choosing two random individuals by % based on their fitness score i.e higher fitness = higher chosen %. Winner is highest fitness score. Mark him and repeat.
        ->Crossover the two winners to create new individual for next generation.
        ->Mutate new individuals crossover point with Mutation strength set by user.
        ->Repeat Selection + Crossover + Mutation for the amount of times equal to the original population length. This gets you the same population size.
        ->Send new generation back to simulation, unpause and continue. Repeat above steps from beginning.

        