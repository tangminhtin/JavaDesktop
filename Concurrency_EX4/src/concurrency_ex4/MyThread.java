/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency_ex4;


/**
 *
 * @author tangminhtin
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
    
        for (int i=0; i<=9; i++) {
            System.out.println(getName() + " - " + i);
        
            try {
                sleep(1000);
            } catch (InterruptedException ex) {

            }
        } 
    }
    
    
}
