/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency_ex1;

/**
 *
 * @author tangminhtin
 */
public class Concurrency_EX1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        
        thread1.start();
        thread2.start();
            
    }
    
}
