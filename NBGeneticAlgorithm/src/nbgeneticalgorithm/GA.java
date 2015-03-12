/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbgeneticalgorithm;

/**
 *
 * @author Win7Sion
 */
public class GA {
    Prey prey[], oldPrey[];
    Predator predator[], oldPred[];
    
    int _PredGeneration = 0;
    int _PreyGeneration = 0;
    
    public Predator[] processPredatorPopulation(Predator[] population, int mutation){
        predator = new Predator[population.length];
        
        savePredatorPopulation(population);
        crossoverPredatorPopulation(predator);
        mutatePredatorPopulation(mutation);        
        return population;
    }
    
    public void savePredatorPopulation(Predator[] population) {
        for(int x = 0; x < population.length; x++){
            predator[x] = population[x];
            System.out.println(predator[x].getSpeed());
        }
    }
    
    public void crossoverPredatorPopulation(Predator[] population){
        
    }
    
    public void mutatePredatorPopulation(int rate){
        
    }
    
    public void createLog(){
        
    }
    
    public int getPredGeneration(){
        return _PredGeneration;
    }
    
    public int getPreyGeneration(){
        return _PreyGeneration;
    }
}
