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
public class RutTienThread extends Thread {
    TaiKhoan obj;
    int soTienRut;

    public RutTienThread(TaiKhoan obj, int soTienRut) {
        this.obj = obj;
        this.soTienRut = soTienRut;
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
