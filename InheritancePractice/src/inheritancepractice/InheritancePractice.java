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
public class InheritancePractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Toast toast = new Toast();
        Butter[] butter;
            
        butter = new Butter[5];
        for(int x = 0; x < 5; x++){
            butter[x] = new Butter();
        }
    }
    
}

