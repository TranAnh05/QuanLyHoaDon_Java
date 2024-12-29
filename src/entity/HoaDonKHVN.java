package entity;

import java.time.LocalDate;

public class HoaDonKHVN extends HoaDonKH{ 
    private String doiTuong; 
    private int dinhMuc;

    public HoaDonKHVN(String maHoaDonKH, String hoTen, LocalDate ngayHoaDon, int soLuong, double donGia, String doiTuong, int dinhMuc) {
        super(maHoaDonKH, hoTen, ngayHoaDon, soLuong, donGia); 
        this.doiTuong = doiTuong;
        this.dinhMuc = dinhMuc;
    }
    
    public String getDoiTuong(){
        return doiTuong;
    }

    public int getDinhMuc(){
        return dinhMuc;
    }
    
    public double tinhThanhTien(){
        if(soLuong <= dinhMuc){
            return soLuong * dinhMuc;
        }
        else{
            int vuotDinhMuc = soLuong - dinhMuc;
            return (soLuong * dinhMuc * donGia) + (vuotDinhMuc * donGia * 2.5);
        }
    }

    public String toString(){
        return super.toString() + ";" + doiTuong + ";" + dinhMuc;
    }

    
}
