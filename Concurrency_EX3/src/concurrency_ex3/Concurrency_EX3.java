/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency_ex3;

/**
 *
 * @author tangminhtin
 */
public class Concurrency_EX3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        
        thread1.setName("jojo");
        thread2.setName("mimi");
        
        thread1.start();
        thread2.start();
    }
    
}
