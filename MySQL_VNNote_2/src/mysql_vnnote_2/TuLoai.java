/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_vnnote_2;

/**
 *
 * @author tangminhtin
 */
public class TuLoai {
    private int maTuLoai;
    private int maNgonNgu;
    private String tenTuLoai;

    /**
     * Constructor for TuLoai class
     * @param maTuLoai
     * @param maNgonNgu
     * @param tenTuLoai
     */
    public TuLoai(int maTuLoai, int maNgonNgu, String tenTuLoai) {
        this.maTuLoai = maTuLoai;
        this.maNgonNgu = maNgonNgu;
        this.tenTuLoai = tenTuLoai;
    }

    /**
     * Gets ma tu loai
     * @return
     */
    public int getMaTuLoai() {
        return maTuLoai;
    }

    /**
     *j Sets ma tu loai
     * @param maTuLoai
     */
    public void setMaTuLoai(int maTuLoai) {
        this.maTuLoai = maTuLoai;
    }

    /**
     * Gets ma ngon ngu
     * @return
     */
    public int getMaNgonNgu() {
        return maNgonNgu;
    }

    /**
     * Sets ma ngon ngu
     * @param maNgonNgu
     */
    public void setMaNgonNgu(int maNgonNgu) {
        this.maNgonNgu = maNgonNgu;
    }

    /**
     * Gets ten tu loai
     * @return
     */
    public String getTenTuLoai() {
        return tenTuLoai;
    }

    /**
     * Sets ten tu loai
     * @param tenTuLoai
     */
    public void setTenTuLoai(String tenTuLoai) {
        this.tenTuLoai = tenTuLoai;
    }

    @Override
    public String toString() {
        return "TuLoai{" + "maTuLoai=" + maTuLoai + ", maNgonNgu=" + maNgonNgu + ", tenTuLoai=" + tenTuLoai + '}';
    }
    
    
}
