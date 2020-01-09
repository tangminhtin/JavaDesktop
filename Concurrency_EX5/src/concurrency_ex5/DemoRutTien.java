/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency_ex5;

/**
 *
 * @author tangminhtin
 */
public class DemoRutTien {
    public static void main(String[] args) {
        TaiKhoan obj = new TaiKhoan(1000);
        
        RutTienThread thread1 = new RutTienThread(obj, 100);
        thread1.setName("Vo");
        
        RutTienThread thread2 = new RutTienThread(obj, 300);
        thread2.setName("Chong");
        
        RutTienThread thread3 = new RutTienThread(obj, 500);
        thread3.setName("Con");
        
        thread1.start();
        thread2.start();
        thread3.start();
        
        try {
            Thread.currentThread().sleep(6000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
               
        System.out.println("So tien con lai trong tai khoan: " +
                obj.soTien);
    }
}
