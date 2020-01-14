package concurrency_ex5;

/**
 *
 * @author tangminhtin
 */
public class DemoRutTien {
    public static void main(String[] args) {
        // Create new object TaiKhoan with soTien is 1000
        TaiKhoan obj = new TaiKhoan(1000);
        
        // Create new object thread1 and setName is Vo
        RutTienThread thread1 = new RutTienThread(obj, 100);
        thread1.setName("Vo");
        
        // Create new object thread2 and setName is Chong
        RutTienThread thread2 = new RutTienThread(obj, 300);
        thread2.setName("Chong");
        
        // Create new object thread3 and setName is Con
        RutTienThread thread3 = new RutTienThread(obj, 500);
        thread3.setName("Con");
        
        // Start 3 threads
        thread1.start();
        thread2.start();
        thread3.start();
        
        try {
            // Thread will be sleep in 6s
            Thread.currentThread().sleep(6000);
        } catch (InterruptedException ex) {
            // Print out error
            ex.printStackTrace();
        }
        
        // Display the remaining amount
        System.out.println("So tien con lai trong tai khoan: " +
                obj.soTien);
    }
}
