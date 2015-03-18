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
    
    public Prey[] processPreyPopulation(Prey[] population, int mutation){
        prey = new Prey[population.length];
        _mutate = mutation;
        savePreyPopulation(population);
        evaluatePrey(prey);
        //crossoverPredatorPopulation(predator);
        //mutatePredatorPopulation(mutation);
        _PreyGeneration++;
        return population;
    }
    
    public Predator[] processPredatorPopulation(Predator[] population, int mutation){
        predator = new Predator[population.length];
        _mutate = mutation;
        savePredatorPopulation(population);
        evaluatePredators(predator);
        //crossoverPredatorPopulation(predator);
        //mutatePredatorPopulation(mutation);
        _PredGeneration++;
        return population;
    }
    
    public void evaluatePredators(Predator[] predator){
        double[] tFitness = new double[predator.length];        
        for(int i = 0; i < predator.length; i++){
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
    
    public void evaluatePrey(Prey[] prey){
        double[] tFitness = new double[prey.length];        
        for(int i = 0; i < prey.length; i++){
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
        for(int x = 0; x < population.length; x++){
            predator[x] = population[x];            
        }
    }
    
    public void savePreyPopulation(Prey[] population) {
        for(int x = 0; x < population.length; x++){
            prey[x] = population[x];            
        }
    }
    
    public void crossoverPredatorPopulation(Predator[] population){
        
    }
    
    public void mutatePredatorPopulation(int rate){
        
    }
    
    public int getPredGeneration(){
        return _PredGeneration;
    }
    
    public int getPreyGeneration(){
        return _PreyGeneration;
    }
    
    public void createLog() {
        
        double avgSpeed = 0, avgTurnSpeed = 0, avgFov = 0, avgFovLength = 0;
        
        try {
            date = Calendar.getInstance();
            String text = "Log file generated on " + date.getTime().toString() + "\n\n";                                    
            file = new File("Generation " + (_PredGeneration - 1) + " Log.txt");
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(text);

            text = "Predator Generation " + (_PredGeneration - 1) + " Results.\n";
            writer.write(text);
            
            text = "Population size " + predator.length + "\t|\tMutation Rate " + _mutate + "\n\n";
            writer.write(text);                       
            
            //fittest individual            
            text = "Fittest predator was " + _fittestPred + " With fitness score of " + predator[_fittestPred].getFitness() + "\n";
            writer.write(text);
            text = "Fittest Predator Attributes : \n";
            writer.write(text);
            text = "Speed : " + predator[_fittestPred].getSpeed() + " | Turn Speed : " + predator[_fittestPred].getTurnSpeed() 
                    + " | Field of View : " + predator[_fittestPred].getFov() + " | Fov Length : " + predator[_fittestPred].getFovLength() + "\n\n";
            writer.write(text);
            
            text = "Average of predator attributes :\n";
            writer.write(text);
            
            for(int i = 0; i < predator.length; i++){
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
            writer.write(text);
            
            text = "Prey Generation " + (_PreyGeneration  - 1) + " Results.\n";
            writer.write(text);
            
            text = "Population size " + prey.length + "\t|\tMutation Rate " + _mutate + "\n\n";
            writer.write(text);                       
            
            //fittest individual            
            text = "Fittest Prey was " + _fittestPrey + " With fitness score of " + prey[_fittestPrey].getFitness() + "\n";
            writer.write(text);
            text = "Fittest Prey Attributes : \n";
            writer.write(text);
            text = "Speed : " + prey[_fittestPrey].getSpeed() + " | Turn Speed : " + prey[_fittestPrey].getTurnSpeed() 
                    + " | Field of View : " + prey[_fittestPrey].getFov() + " | Fov Length : " + prey[_fittestPrey].getFovLength() + "\n\n";
            writer.write(text);
            
            text = "Average of predator attributes :\n";
            writer.write(text);
            
            for(int i = 0; i < prey.length; i++){
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
            writer.write(text);
            
            text = "End of Line\n";
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
    
}
