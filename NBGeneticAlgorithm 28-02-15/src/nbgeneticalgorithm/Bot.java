/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbgeneticalgorithm;

import java.util.Random;

/**
 *
 * @author Win7Sion
 */
//default grass object, used for food, prey and predator
public class Bot{

    private double _x, _y, _targetX, _targetY;
    private double _turnSpeed, _rotation, _speed, _energy, _angle;
    private boolean _alive, _goal;
    
    Bot(){
        
    }
    
    public void setAngle(double angle){
        _angle = angle;
    }
    
    public double getAngle(){
        return _angle;
    }
    
    public void sort(){
        System.out.println("Generic Bot sort");
    }
    
    public void setTargetX(double targetX){
        _targetX = targetX;
    }
    public void setTargetY(double targetY){
        _targetY = targetY;
    }
    
    public double getTargetX(){
        return _targetX;
    }
    
    public double getTargetY(){
        return _targetY;
    }
    
    public boolean getGoal(){
        return _goal;
    }
    
    public void setGoal(boolean goal){
        _goal = goal;
    }
    
    public double getX() {
        return _x;
    }

    public double getY() {
        return _y;
    }

    public boolean getAlive() {
        return _alive;
    }

    public void setAlive(boolean alive) {
        this._alive = alive;
    }

    public void setX(double x) {
        this._x = x;
    }

    public void setY(double y) {
        this._y = y;
    }

    public void setTurnSpeed(double turnSpeed) {
        this._turnSpeed = turnSpeed;
    }

    public double getTurnSpeed() {
        return _turnSpeed;
    }

    public void setSpeed(double speed) {
        this._speed = speed;
    }

    public double getSpeed() {
        return _speed;
    }

    public void setEnergy(double energy) {
        this._energy = energy;
    }

    public double getEnergy() {
        return _energy;
    }

    public double getRotation() {
        return _rotation;
    }

    public void setRotation(double rotation) {
        this._rotation = rotation;
    }
}

class Food extends Bot{
    private Random rNumber = new Random();
    private double r = 0;
    Food(){
        this.setAlive(true);
        r = 1 + (599 - 1) * rNumber.nextDouble();
        this.setX(r);
        r = 1 + (599 - 1) * rNumber.nextDouble();
        this.setY(r);
    }
}
 
/*
Class Prey extends Bot
Generates the chromosomes for each prey through the constructor and starts
the thread that gets the prey in one of three states, Search, Eat and Escape
*/
class Prey extends Bot{
    
    private Random rNumber = new Random();
    private double r = 0;
    enum preyStates {Search, Eat, Escape};
    preyStates state;
    /*
    Constructor generates the attributes for each Prey created
    */
    Prey(){
        r = 1 + (599 - 1) * rNumber.nextDouble();
        this.setX(r);
        
        r = 1 + (599 - 1) * rNumber.nextDouble();
        this.setY(r);
        
        this.setAlive(true);
        
        this.setEnergy(500);
        
        r = 1.0 + (2.0 - 1.0) * rNumber.nextDouble();
        this.setSpeed(r);
        
        r = 2.0 + (4.0 - 2.0) * rNumber.nextDouble();
        this.setTurnSpeed(r);
        
        this.stateSearch();
    }
    
    public void stateSearch(){
        state = preyStates.Search;
    }
    
    public void stateEat(){
        state = preyStates.Eat;
    }
    
    public void stateEscape(){
        state = preyStates.Escape;
    }
    
    public preyStates getState(){
        return state;
    }
}