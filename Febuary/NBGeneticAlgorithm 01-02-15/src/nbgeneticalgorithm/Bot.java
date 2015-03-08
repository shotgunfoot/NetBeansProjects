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
        private float _turnSpeed, _speed;
        private boolean _alive;
        
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
        
        public void setTurnSpeed(float turnSpeed){
            this._turnSpeed = turnSpeed;
        }
        
        public float getTurnSpeed(){
            return _turnSpeed;
        }
        
        public void setSpeed(float speed){
            this._speed = speed;
        }
        
        public float getSpeed(){
            return _speed;
        }
    }
