/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbgeneticalgorithm;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.Random;

/**
 *
 * @author Win7Sion
 */
//default grass object, used for food, prey and predator
public class Bot{

    private double _x, _y, _targetX, _targetY;
    private double _turnSpeed, _rotation, _speed, _angle;
    private boolean _alive, _target = false;
    private double _energy = 0;
    
    private AffineTransform _at;
    
    private Rectangle _bounds;
    
    private static final int _width = 9, _height = 9;
    
    Bot(){
        
    }
    
    public void setTarget(boolean target){
        this._target = target;
    }
    
    public Boolean hasTarget(){
        return _target;
    }
    
    public void setAffineTransform(AffineTransform at){
        this._at = at;
    }
    
    public AffineTransform getAffineTransform(){
        return _at;
    }

    public Rectangle getBounds(){
        return _bounds;
    }
    
    public void setBounds(Rectangle bounds){
        this._bounds = bounds;
    }
    
    public int getWidth(){
        return _width;
    }
    
    public int getHeight(){
        return _height;
    }
    
    public void setAngle(double angle){
        _angle = angle;
    }
    
    public double getAngle(){
        return _angle;
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
    
    public double getX() {
        return _x;
    }

    public double getY() {
        return _y;
    }

    public boolean isAlive() {
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

    public void addEnergy(double energy) {
        this._energy += energy;
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
        Rectangle rect;
        rect = new Rectangle();
        rect.setRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        this.setBounds(rect);
    }
}

class Predator extends Bot{
    private Random rNumber = new Random();
    private double r = 0;
    enum predatorStates {Search, Chase};
    predatorStates state;
    private double _fov, _fovWidth;
    private int _preyID;
    private Shape _fovShape;
    
    public Predator(){
        r = rNumber.nextInt(1 + (599 - 1));
        this.setX(r);
        
        r = rNumber.nextInt(1 + (599 - 1));
        this.setY(r);
        
        this.setAlive(true);
        
        this.addEnergy(500);
        
        r = 1.0 + (2.0 - 1.0) * rNumber.nextDouble();
        this.setSpeed(r);
        
        r = 2.0 + (4.0 - 2.0) * rNumber.nextDouble();
        this.setTurnSpeed(r);
        
        r = rNumber.nextInt(1 + (599 - 1));
        this.setTargetX(r);
        
        r = rNumber.nextInt(1 + (599 - 1));
        this.setTargetY(r);

        r = 150 + (180 - 150) * rNumber.nextDouble();
        this.setFovWidth(r);

        r = 90 + (100 - 90) * rNumber.nextDouble();
        this.setFov(45);
        
        this.setAngle(Math.toDegrees(Math.atan2(this.getTargetX() - this.getX(), this.getTargetY() - this.getY())));
        
        Rectangle rect;
        rect = new Rectangle();
        rect.setRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        this.setBounds(rect);
        
        this.stateSearch();
    }
    
    public void setFovShape(Shape shape){
        this._fovShape = shape;
    }
    
    public Shape getFovShape(){
        return _fovShape;
    }
    
    public void setFov(double fov){
        this._fov = fov;
    }
    
    public double getFov(){
        return _fov;
    }
    
    public void setFovWidth(double width){
        this._fovWidth = width;
    }
    
    public double getFovWidth(){
        return _fovWidth;
    }
    
    public void setPreyID(int id){
        this._preyID = id;
    }
    
    public int getPreyID(){
        return _preyID;
    }
    
    public void stateSearch(){
        state = predatorStates.Search;
    }
    
    public void stateChase(){
        state = predatorStates.Chase;
    }
   
    public predatorStates getState(){
        return state;
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
    private double _fovWidth, _fov;
    
    private Shape _fovShape;
    
    private int _foodID;
    
    /*
    Constructor generates the attributes for each Prey created
    */
    Prey(){
        r = rNumber.nextInt(1 + (599 - 1));
        this.setX(r);
        
        r = rNumber.nextInt(1 + (599 - 1));
        this.setY(r);
        
        this.setAlive(true);
        
        this.addEnergy(500);
        
        r = 1.0 + (2.0 - 1.0) * rNumber.nextDouble();
        this.setSpeed(r);
        
        r = 2.0 + (4.0 - 2.0) * rNumber.nextDouble();
        this.setTurnSpeed(r);
        
        r = rNumber.nextInt(1 + (599 - 1));
        this.setTargetX(r);
        
        r = rNumber.nextInt(1 + (599 - 1));
        this.setTargetY(r);
        
        r = 80 + (100 - 80) * rNumber.nextDouble();
        this.setFovWidth(r);

        r = 140 + (180 - 160) * rNumber.nextDouble();
        this.setFov(r);
        
        this.setAngle(Math.toDegrees(Math.atan2(this.getTargetX() - this.getX(), this.getTargetY() - this.getY())));
        
        Rectangle rect;
        rect = new Rectangle();
        rect.setRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        this.setBounds(rect);
        
        this.stateSearch();
    }
    
    public void setFovShape(Shape shape){
        this._fovShape = shape;
    }
    
    public Shape getFovShape(){
        return _fovShape;
    }
    
    public void setFov(double fov){
        this._fov = fov;
    }
    
    public double getFov(){
        return _fov;
    }
    
    public void setFovWidth(double width){
        this._fovWidth = width;
    }
    
    public double getFovWidth(){
        return _fovWidth;
    }
    
    public void setFoodID(int id){
        this._foodID = id;
    }
    
    public int getFoodID(){
        return _foodID;
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


