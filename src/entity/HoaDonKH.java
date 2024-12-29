package entity;

import java.time.LocalDate;

public abstract class HoaDonKH {
    protected String maHoaDonKH;
    protected String hoTen;
    protected LocalDate ngayHoaDon;
    protected int soLuong; 
    protected double donGia;

    public HoaDonKH(String maHoaDonKH, String hoTen, LocalDate ngayHoaDon, int soLuong, double donGia) {
        this.maHoaDonKH = maHoaDonKH;
        this.hoTen = hoTen;
        this.ngayHoaDon = ngayHoaDon;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
    
    public String getMaHoaDonKH() {
        return maHoaDonKH;
    }

    public String getHoten(){
        return hoTen;
    }

    public LocalDate getNgayHoaDon(){
        return ngayHoaDon;
    }

    public int getSoLuong(){
        return soLuong;
    }

    public double getDonGia(){
        return donGia;
    }
    
    public abstract double tinhThanhTien();
    
    public String toString(){
        return maHoaDonKH + ";" + hoTen + ";" + ngayHoaDon + ";" + soLuong + ";" + donGia;
    }    
}
