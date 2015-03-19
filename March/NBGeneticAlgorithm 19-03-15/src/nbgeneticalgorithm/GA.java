/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbgeneticalgorithm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author Win7Sion
 */
public class GA {

    Prey prey[], oldPrey[];
    Predator predator[], oldPred[];

    File file;
    Writer writer = null;
    Calendar date;

    int _PredGeneration = 0;
    int _PreyGeneration = 0;

    int _fittestPred = 0;
    int _fittestPrey = 0;
    int _mutate = 0;

    Random rNumber = new Random();

    GA() {
        try {
            date = Calendar.getInstance();
            String text = "Log file generated on " + date.getTime().toString() + "\n\n";
            file = new File("Log.txt");
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Prey[] processPreyPopulation(Prey[] population, int mutation) {
        prey = new Prey[population.length];
        _mutate = mutation;
        savePreyPopulation(population);
        evaluatePrey(prey);
        Prey[] newPrey = crossoverPreyPopulation(prey);
        //mutatePreyPopulation(mutation);
        _PreyGeneration++;
        return newPrey;
    }

    public Predator[] processPredatorPopulation(Predator[] population, int mutation) {
        predator = new Predator[population.length];
        _mutate = mutation;
        savePredatorPopulation(population);
        evaluatePredators(predator);
        Predator[] newPredator = crossoverPredatorPopulation(predator);
        //mutatePredatorPopulation(mutation);
        _PredGeneration++;
        return newPredator;
    }

    public void evaluatePredators(Predator[] predator) {
        double[] tFitness = new double[predator.length];
        for (int i = 0; i < predator.length; i++) {
            tFitness[i] = predator[i].getFitness();
        }

        double temp = 0;

        for (int i = 0; i < predator.length; i++) {
            if (tFitness[i] > temp) {
                temp = tFitness[i];
                _fittestPred = i;
            }
        }

    }

    public void evaluatePrey(Prey[] prey) {
        double[] tFitness = new double[prey.length];
        for (int i = 0; i < prey.length; i++) {
            tFitness[i] = prey[i].getFitness();
        }

        double temp = 0;

        for (int i = 0; i < prey.length; i++) {
            if (tFitness[i] > temp) {
                temp = tFitness[i];
                _fittestPrey = i;
            }
        }

    }

    public void savePredatorPopulation(Predator[] population) {
        for (int x = 0; x < population.length; x++) {
            predator[x] = population[x];
        }
    }

    public void savePreyPopulation(Prey[] population) {
        for (int x = 0; x < population.length; x++) {
            prey[x] = population[x];
        }
    }

    public Predator[] crossoverPredatorPopulation(Predator[] population) {
        Predator newPredator[] = new Predator[population.length];

        for (int p = 0; p < newPredator.length; p++) {
            int individual_1, individual_2;
            //step 1: select 2 individuals from current population
            individual_1 = rNumber.nextInt(1 + (population.length - 1));
            individual_2 = rNumber.nextInt(1 + (population.length - 1));

            //if the second selected individual happens to be the same as the first, re-pick until different individual is chosen
            while (individual_1 == individual_2) {
                individual_2 = rNumber.nextInt(1 + (population.length - 1));
            }

            double[] win1 = new double[4];

            double fitness1 = population[individual_1].getFitness(), fitness2 = population[individual_2].getFitness();

            //step 2: select 1 out of the 2 who has the highest fitness.
            if (fitness1 > fitness2) {
                win1[0] = population[individual_1].getSpeed();
                win1[1] = population[individual_1].getTurnSpeed();
                win1[2] = population[individual_1].getFov();
                win1[3] = population[individual_1].getFovLength();
            } else {
                win1[0] = population[individual_2].getSpeed();
                win1[1] = population[individual_2].getTurnSpeed();
                win1[2] = population[individual_2].getFov();
                win1[3] = population[individual_2].getFovLength();
            }

            //step 3: repeat step 1 and 2.
            //step 1: select 2 individuals from current population
            individual_1 = rNumber.nextInt(1 + (population.length - 1));
            individual_2 = rNumber.nextInt(1 + (population.length - 1));

            double[] win2 = new double[4];

            fitness1 = population[individual_1].getFitness();
            fitness2 = population[individual_2].getFitness();

            //step 2: select 1 out of the 2 who has the highest fitness.
            if (fitness1 > fitness2) {
                win2[0] = population[individual_1].getSpeed();
                win2[1] = population[individual_1].getTurnSpeed();
                win2[2] = population[individual_1].getFov();
                win2[3] = population[individual_1].getFovLength();
            } else {
                win2[0] = population[individual_2].getSpeed();
                win2[1] = population[individual_2].getTurnSpeed();
                win2[2] = population[individual_2].getFov();
                win2[3] = population[individual_2].getFovLength();
            }

            //step 4: assign a random point to use for crossing over the attributes
            int point = rNumber.nextInt(0 + (4 - 0));

            double[] offspring = new double[4];
            for (int i = 0; i < point; i++) {
                offspring[i] = win1[i];
            }

            for (int i = point; i < offspring.length; i++) {
                offspring[i] = win2[i];
            }

            /* Console output to show the crossover point working
             System.out.println("Crossover point: "+point+"\n");
             System.out.println("winner 1 Stats: " +win1[0]+", "+win1[1]+", "+win1[2]+", "+win1[3]+"\n");
             System.out.println("winner 2 Stats: " +win2[0]+", "+win2[1]+", "+win2[2]+", "+win2[3]+"\n");
             System.out.println("offspring "+p+" Stats: " +offspring[0]+", "+offspring[1]+", "+offspring[2]+", "+offspring[3]+"\n");
             */
            //step 5: create a new prey individual in a new Prey[] and set all the attributes to the custom array from step 4
            newPredator[p] = new Predator();
            newPredator[p].setSpeed(offspring[0]);
            newPredator[p].setTurnSpeed(offspring[1]);
            newPredator[p].setFov(offspring[2]);
            newPredator[p].setFovLength(offspring[3]);
        }

        return newPredator;
    }

    public void mutatePredatorPopulation(int rate) {

    }

    /*
     crossoverPreyPopulation
     What it does:
     Takes in the currently 
     */
    public Prey[] crossoverPreyPopulation(Prey[] population) {

        Prey newPrey[] = new Prey[population.length];

        for (int p = 0; p < newPrey.length; p++) {
            int individual_1, individual_2;
            //step 1: select 2 individuals from current population
            individual_1 = rNumber.nextInt(1 + (population.length - 1));
            individual_2 = rNumber.nextInt(1 + (population.length - 1));

            //if the second selected individual happens to be the same as the first, re-pick until different individual is chosen
            while (individual_1 == individual_2) {
                individual_2 = rNumber.nextInt(1 + (population.length - 1));
            }

            double[] win1 = new double[4];

            double fitness1 = population[individual_1].getFitness(), fitness2 = population[individual_2].getFitness();

            //step 2: select 1 out of the 2 who has the highest fitness.
            if (fitness1 > fitness2) {
                win1[0] = population[individual_1].getSpeed();
                win1[1] = population[individual_1].getTurnSpeed();
                win1[2] = population[individual_1].getFov();
                win1[3] = population[individual_1].getFovLength();
            } else {
                win1[0] = population[individual_2].getSpeed();
                win1[1] = population[individual_2].getTurnSpeed();
                win1[2] = population[individual_2].getFov();
                win1[3] = population[individual_2].getFovLength();
            }

            //step 3: repeat step 1 and 2.
            //step 1: select 2 individuals from current population
            individual_1 = rNumber.nextInt(1 + (population.length - 1));
            individual_2 = rNumber.nextInt(1 + (population.length - 1));

            double[] win2 = new double[4];

            fitness1 = population[individual_1].getFitness();
            fitness2 = population[individual_2].getFitness();

            //step 2: select 1 out of the 2 who has the highest fitness.
            if (fitness1 > fitness2) {
                win2[0] = population[individual_1].getSpeed();
                win2[1] = population[individual_1].getTurnSpeed();
                win2[2] = population[individual_1].getFov();
                win2[3] = population[individual_1].getFovLength();
            } else {
                win2[0] = population[individual_2].getSpeed();
                win2[1] = population[individual_2].getTurnSpeed();
                win2[2] = population[individual_2].getFov();
                win2[3] = population[individual_2].getFovLength();
            }

            //step 4: assign a random point to use for crossing over the attributes
            int point = rNumber.nextInt(0 + (4 - 0));

            double[] offspring = new double[4];
            for (int i = 0; i < point; i++) {
                offspring[i] = win1[i];
            }

            for (int i = point; i < offspring.length; i++) {
                offspring[i] = win2[i];
            }

            /* Console output to show the crossover point working
             System.out.println("Crossover point: "+point+"\n");
             System.out.println("winner 1 Stats: " +win1[0]+", "+win1[1]+", "+win1[2]+", "+win1[3]+"\n");
             System.out.println("winner 2 Stats: " +win2[0]+", "+win2[1]+", "+win2[2]+", "+win2[3]+"\n");
             System.out.println("offspring "+p+" Stats: " +offspring[0]+", "+offspring[1]+", "+offspring[2]+", "+offspring[3]+"\n");
             */
            //step 5: create a new prey individual in a new Prey[] and set all the attributes to the custom array from step 4
            newPrey[p] = new Prey();
            newPrey[p].setSpeed(offspring[0]);
            newPrey[p].setTurnSpeed(offspring[1]);
            newPrey[p].setFov(offspring[2]);
            newPrey[p].setFovLength(offspring[3]);
        }

        return newPrey;
    }

    public Prey[] mutatePreyPopulation(Prey[] population, int rate) {
        
        //take in offspring generation
        
        //apply mutation to % of population or apply mutataion to entire population
        
        return population;
    }

    public int getPredGeneration() {
        return _PredGeneration;
    }

    public int getPreyGeneration() {
        return _PreyGeneration;
    }

    public void updateLog() {

        double avgSpeed = 0, avgTurnSpeed = 0, avgFov = 0, avgFovLength = 0;

        try {
            date = Calendar.getInstance();
            String text = "\n";
            //open it in append mode so we don't overwrite previous logs
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.append(text);

            text = "Predator Generation " + (_PredGeneration - 1) + " Results.\n";
            writer.append(text);

            text = "Population size " + predator.length + "\t|\tMutation Rate " + _mutate + "\n\n";
            writer.append(text);

            //fittest individual            
            text = "Fittest predator was " + _fittestPred + " With fitness score of " + predator[_fittestPred].getFitness() + "\n";
            writer.append(text);
            text = "Fittest Predator Attributes : \n";
            writer.append(text);
            text = "Speed : " + predator[_fittestPred].getSpeed() + " | Turn Speed : " + predator[_fittestPred].getTurnSpeed()
                    + " | Field of View : " + predator[_fittestPred].getFov() + " | Fov Length : " + predator[_fittestPred].getFovLength() + "\n\n";
            writer.append(text);

            text = "Average of predator attributes :\n";
            writer.append(text);

            for (int i = 0; i < predator.length; i++) {
                avgSpeed += predator[i].getSpeed();
                avgTurnSpeed += predator[i].getTurnSpeed();
                avgFov += predator[i].getFov();
                avgFovLength += predator[i].getFovLength();
            }
            avgSpeed = avgSpeed / predator.length;
            avgTurnSpeed = avgTurnSpeed / predator.length;
            avgFov = avgFov / predator.length;
            avgFovLength = avgFovLength / predator.length;

            text = "Avg Speed : " + avgSpeed + " | Avg Turn Speed : " + avgTurnSpeed + " | Avg Fov : " + avgFov + " | Avg Fov Length : " + avgFovLength + "\n\n";
            writer.append(text);

            text = "Prey Generation " + (_PreyGeneration - 1) + " Results.\n";
            writer.append(text);

            text = "Population size " + prey.length + "\t|\tMutation Rate " + _mutate + "\n\n";
            writer.append(text);

            //fittest individual            
            text = "Fittest Prey was " + _fittestPrey + " With fitness score of " + prey[_fittestPrey].getFitness() + "\n";
            writer.append(text);
            text = "Fittest Prey Attributes : \n";
            writer.append(text);
            text = "Speed : " + prey[_fittestPrey].getSpeed() + " | Turn Speed : " + prey[_fittestPrey].getTurnSpeed()
                    + " | Field of View : " + prey[_fittestPrey].getFov() + " | Fov Length : " + prey[_fittestPrey].getFovLength() + "\n\n";
            writer.append(text);

            text = "Average of predator attributes :\n";
            writer.append(text);

            for (int i = 0; i < prey.length; i++) {
                avgSpeed += prey[i].getSpeed();
                avgTurnSpeed += prey[i].getTurnSpeed();
                avgFov += prey[i].getFov();
                avgFovLength += prey[i].getFovLength();
            }
            avgSpeed = avgSpeed / prey.length;
            avgTurnSpeed = avgTurnSpeed / prey.length;
            avgFov = avgFov / prey.length;
            avgFovLength = avgFovLength / prey.length;

            text = "Avg Speed : " + avgSpeed + " | Avg Turn Speed : " + avgTurnSpeed + " | Avg Fov : " + avgFov + " | Avg Fov Length : " + avgFovLength + "\n\n";
            writer.append(text);

            text = "||--------------------------------------------------------------------------------------||\n";
            writer.append(text);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
