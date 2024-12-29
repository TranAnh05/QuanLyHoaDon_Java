package controller;

import java.time.LocalDate;
import java.util.List;

import database.ThemDAO;
import entity.HoaDonKHNN;
import entity.HoaDonKHVN;
import entity.HoaDonKH;
import ui.ThemHoaDonCUI;

public class ThemHoaDonCTL {
    private ThemHoaDonCUI themHoaDonCUI = null; 
    private ThemDAO  themDAO = null; 

    // constructor
    public ThemHoaDonCTL(){

    }

    public ThemHoaDonCTL(ThemDAO _themDAO, ThemHoaDonCUI _themHDOut){
        themDAO = _themDAO;
        themHoaDonCUI = _themHDOut;
    }

    // method
    public void addHD(String maHoaDonKH, String hoTen, LocalDate ngayHoaDon, int soLuong, double donGia, String doiTuong, int dinhMuc ){
        HoaDonKHVN hoaDonKHVN = new HoaDonKHVN(maHoaDonKH, hoTen, ngayHoaDon, soLuong, donGia, doiTuong, dinhMuc);
        addHD(hoaDonKHVN);
    }

    public void addHD(String maHoaDonKH, String hoTen, LocalDate ngayHoaDon, int soLuong, double donGia, String quocTich){
        HoaDonKHNN hoaDonKHNN = new HoaDonKHNN(maHoaDonKH, hoTen, ngayHoaDon, soLuong, donGia, quocTich);
        addHD(hoaDonKHNN);
    }

    public void addHD(HoaDonKH kh){
        List<HoaDonKH> ds = themDAO.getDSHD_Them();
        boolean mark = false;

        for(HoaDonKH hoaDon : ds){
            if(hoaDon.getMaHoaDonKH().equals(kh.getMaHoaDonKH())){
                mark = true;
            }
        }

        if(mark == true){
            themHoaDonCUI.inThongBao("Da ton tai ma hoa don tren. Them hoa don that bai.");
        }
        else{
            themDAO.themHDDAO(kh);
            themHoaDonCUI.inThongBao("Da them hoa don thanh cong");
        } 
    }         
}




