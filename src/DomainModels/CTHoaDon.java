/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModels;

/**
 *
 * @author pc
 */
public class CTHoaDon {

    private String id;
    private int soLuong;
    private double donGia;

    public CTHoaDon() {
    }

    public CTHoaDon(String id, int soLuong, double donGia) {
        this.id = id;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
    public Object[] toRowData(){
        return new Object[]{id, soLuong, donGia};
    }

}
