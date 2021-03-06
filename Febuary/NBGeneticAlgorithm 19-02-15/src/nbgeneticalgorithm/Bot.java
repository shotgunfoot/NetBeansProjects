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
//default grass object, used for food, prey and predator
public class Bot {

    private double _x, _y;
    private float _speed, _energy, _velocity;

    private double _turnSpeed, _rotation;
    private boolean _alive;

    public float getVelocity() {
        return _velocity;
    }

    public void setVelocity(float velocity) {
        this._velocity = velocity;
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

    public void setSpeed(float speed) {
        this._speed = speed;
    }

    public float getSpeed() {
        return _speed;
    }

    public void setEnergy(float energy) {
        this._energy = energy;
    }

    public float getEnergy() {
        return _energy;
    }

    public double getRotation() {
        return _rotation;
    }

    public void setRotation(double rotation) {
        this._rotation = rotation;
    }
}
