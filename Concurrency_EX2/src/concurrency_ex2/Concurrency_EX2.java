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
public class Concurrency_EX2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        MyRunnable runnable1 = new MyRunnable();
        MyRunnable runnable2 = new MyRunnable();
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);      
        
        thread1.start();
        thread2.start();
        
    }
    
}
