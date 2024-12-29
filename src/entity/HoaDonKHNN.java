package entity;

import java.time.LocalDate;

public class HoaDonKHNN extends HoaDonKH{
    private String quocTich; 

    public HoaDonKHNN(String maHoaDonKH, String hoTen, LocalDate ngayHoaDon, int soLuong, double donGia, String quocTich) {
        super(maHoaDonKH, hoTen, ngayHoaDon, soLuong, donGia);
        // setQuocTich(quocTich); 
        this.quocTich = quocTich;
    }

    public String getQuocTich(){
        return quocTich;
    }
    
    public double tinhThanhTien(){
        return soLuong * donGia;
    }

    public String toString(){
        return super.toString() + ";" + quocTich;
    }
}
