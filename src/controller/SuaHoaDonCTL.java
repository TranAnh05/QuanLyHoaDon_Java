package controller;

import java.util.List;

import database.SuaDAO;
import entity.HoaDonKH;
import ui.InputHDUI;
import ui.SuaHoaDonCUI;

public class SuaHoaDonCTL {
    private SuaDAO suaDAO = null;
    private SuaHoaDonCUI suaHoaDonCUI = null;
    private InputHDUI inputHDUI = null;

    public SuaHoaDonCTL(){}

    public SuaHoaDonCTL(SuaDAO suaDAO, SuaHoaDonCUI suaHoaDonCUI, InputHDUI inputHDUI){
        this.suaDAO = suaDAO;
        this.suaHoaDonCUI = suaHoaDonCUI;
        this.inputHDUI = inputHDUI;
    }

    public void suaHDCTL(String maHD){
        List<HoaDonKH> ds = suaDAO.getDSHD_Sua();
        boolean mark = false;

        for(HoaDonKH hd : ds){
            if(hd.getMaHoaDonKH().equals(maHD)){
                mark = true;
                break;
            }
        }
        if(mark == true){
            suaHoaDonCUI.inThongBao("Nhap vao thong tin moi cua hoa don:");
            HoaDonKH hd = inputHDUI.nhapThongTinHDChinhSua(maHD);
            suaDAO.suaHDDAO(maHD, hd);
            suaHoaDonCUI.inThongBao("Da sua hoa don thanh cong.");
        }
        else{
            suaHoaDonCUI.inThongBao("Khong co hoa don nao co ma tren.");
        }
    }
}
