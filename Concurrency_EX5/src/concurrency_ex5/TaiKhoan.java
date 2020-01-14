package concurrency_ex5;

/**
 *
 * @author tangminhtin
 */
public class TaiKhoan {
    // Create variable soTien 
    int soTien;

    /**
     * Create new instance for TaiKhoan
     * @param soTien 
     */
    public TaiKhoan(int soTien) {
        this.soTien = soTien;
    }

    /**
     * Function to perform process of withdraw money
     * @param soTienRut 
     */
    synchronized void rutTien(int soTienRut) {
        // Display soTien before withdraw money in bank accounts
        System.out.println("So tien tai khoan hien thi cho "
                + Thread.currentThread().getName()
                + " truoc khi rut: " + soTien);
        try {
            // Thread will be sleep in 3s
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            // Print outs error
            ex.printStackTrace();
        }
        // Calculate money when user withdraw money
        soTien = soTien - soTienRut;
        // Display soTien after withdraw money in bank accounts
        System.out.println("So tien tai khoan hien thi cho "
                + Thread.currentThread().getName()
                + " sau khi rut: " + soTienRut + ": " + soTien);
    }
}
