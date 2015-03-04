/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbgeneticalgorithm;
import java.awt.Point;
/**
 *
 * @author Win7Sion
 */
//default grass object, used for food, prey and predator
public class Bot {

    private double _x, _y, _targetX, _targetY;
    private double _turnSpeed, _rotation, _speed, _energy;;
    private boolean _alive, _goal;

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