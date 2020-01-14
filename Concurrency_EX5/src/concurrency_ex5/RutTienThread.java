package concurrency_ex5;

/**
 *
 * @author tangminhtin
 */
public class RutTienThread extends Thread {
    // Create new object of TaiKhoan and variable of soTienRut
    TaiKhoan obj;
    int soTienRut;

    // Create new instance for RutTienThread
    public RutTienThread(TaiKhoan obj, int soTienRut) {
        this.obj = obj;
        this.soTienRut = soTienRut;
    }

    // Function run to withdraw money
    public void run() {
        obj.rutTien(soTienRut);
    }    
}
