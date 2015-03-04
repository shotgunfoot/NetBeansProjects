/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritancepractice;

/**
 *
 * @author Win7Sion
 */
public class Toast {

    Toast(){
        System.out.println("Toast class");
    }
}

class Butter extends Toast{
    Butter(){
        System.out.println("Butter class");
    }
}