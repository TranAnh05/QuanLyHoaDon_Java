package controller;

import java.util.List;

import database.TimDAO;
import entity.HoaDonKH;
import ui.TimHoaDonCUI;

public class TimHoaDonCTL {
    private TimDAO timHoaDonDAO = null;
    private TimHoaDonCUI timHoaDonCUI = null;

    // method
    public TimHoaDonCTL(){}

    public TimHoaDonCTL(TimDAO timHoaDonDAO, TimHoaDonCUI timHoaDonCUI){
        this.timHoaDonDAO = timHoaDonDAO;
        this.timHoaDonCUI = timHoaDonCUI;
    }

    public void timHoaDon_CTL(String maHD){
        List<HoaDonKH> ds = timHoaDonDAO.getDSHD_Tim();

        boolean mark = false;
        for(HoaDonKH hd : ds){
            if(hd.getMaHoaDonKH().equals(maHD)){
                timHoaDonCUI.inKetQua(hd);
                mark = true;
                return;
            }
        }
        if(mark == false){
            timHoaDonCUI.inKetQua("Khong tim thay hoa don voi ma tren.");
        }
    }
}
