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
public class TaiKhoan {

    int soTien;

    public TaiKhoan(int soTien) {
        this.soTien = soTien;
    }

    synchronized void rutTien(int soTienRut) {
        System.out.println("So tien tai khoan hien thi cho "
                + Thread.currentThread().getName()
                + " truoc khi rut: " + soTien);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        soTien = soTien - soTienRut;
        System.out.println("So tien tai khoan hien thi cho "
                + Thread.currentThread().getName()
                + " sau khi rut: " + soTien);
    }
}
