package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import database.HDTT_DAO;
import entity.HoaDonKH;
import ui.HoaDonTrongThangCUI;

public class HoaDonTrongThangCTL {
    private HDTT_DAO hoaDonTrongThangDAO = null;
    private HoaDonTrongThangCUI hoaDonTrongThangCUI = null;

    public HoaDonTrongThangCTL(){}

    public HoaDonTrongThangCTL(HDTT_DAO hoaDonTrongThangDAO, HoaDonTrongThangCUI hoaDonTrongThangCUI){
        this.hoaDonTrongThangDAO = hoaDonTrongThangDAO;
        this.hoaDonTrongThangCUI = hoaDonTrongThangCUI;
    }

    public void getHoaDonTrongThangCTL(int thang, int nam){
        List<HoaDonKH> ds = hoaDonTrongThangDAO.getDSHD_Month();
        List<HoaDonKH> dsHoaDonTrongThang = new ArrayList<>();

        boolean mark = false;
        for(HoaDonKH hd : ds){
            LocalDate date = hd.getNgayHoaDon();
            if(date.getYear() == nam && date.getMonthValue() == thang){
                dsHoaDonTrongThang.add(hd);
                mark = true;
            }
        }

        if(mark == true){
            hoaDonTrongThangCUI.getHoaDonTrongThangCUI(dsHoaDonTrongThang);
        }
        else{
            hoaDonTrongThangCUI.getHoaDonTrongThangCUI("Khong co hoa don nao.");
        }
    }
}
