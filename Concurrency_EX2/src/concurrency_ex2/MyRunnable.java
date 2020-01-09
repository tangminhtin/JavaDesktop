/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency_ex2;


/**
 *
 * @author tangminhtin
 */
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        
        for (int i = 0; i <= 9; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
            
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException ex) {
                
            }
        }
        
    }
    
}
