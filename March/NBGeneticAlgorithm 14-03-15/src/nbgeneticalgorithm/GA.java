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
    
    int _fittest = 0;
    int _mutate = 0;
    
    public Predator[] processPredatorPopulation(Predator[] population, int mutation){
        predator = new Predator[population.length];
        _mutate = mutation;
        savePredatorPopulation(population);
        evaluatePredators(predator);
        //crossoverPredatorPopulation(predator);
        //mutatePredatorPopulation(mutation);
        createLog();
        _PredGeneration++;
        _PreyGeneration++;
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
                    _fittest = i;
                }
            }
        
    }
    
    public void createLog() {
        try {
            date = Calendar.getInstance();
            String text = "Log file generated on " + date.getTime().toString() + "\n";                                    
            file = new File("Generation " + _PredGeneration + " Log.txt");
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(text);

            text = "Predator Generation " + _PredGeneration + " Results.\n";
            writer.write(text);
            
            text = "Population size " + predator.length + "\t|\tMutation Rate " + _mutate + "\n";
            writer.write(text);
            
            //possible things to note, average rates of attributes
            
            
            //fittest individual            
            text = "Fittest predator was " + _fittest + " With fitness score of " + predator[_fittest].getFitness() + "\n";
            writer.write(text);
            
            text = "Prey Generation " + (_PredGeneration - 1) + " Results.\n";

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

    public void savePredatorPopulation(Predator[] population) {
        for(int x = 0; x < population.length; x++){
            predator[x] = population[x];            
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
}
