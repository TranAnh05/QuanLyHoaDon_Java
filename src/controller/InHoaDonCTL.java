package controller;

import java.util.List;

import database.InDAO;
import entity.HoaDonKH;
import ui.InHoaDonCUI;

public class InHoaDonCTL {
    private InDAO inHoaDonDAO = null;
    private InHoaDonCUI inHDCUI = null;

    public InHoaDonCTL(){}

    public InHoaDonCTL(InDAO inHoaDonDAO, InHoaDonCUI inHDCUI) {
        this.inHoaDonDAO = inHoaDonDAO;
        this.inHDCUI = inHDCUI;
    }

    public void inHDCTL(){
        List<HoaDonKH> ds = inHoaDonDAO.getDSHD_In();
        int size = inHoaDonDAO.getEmptyList_In();

        if(size == 0){
            inHDCUI.inDSHD("Danh sach dang trong");
        }
        else{
            inHDCUI.inDSHD(ds, size);
        }
        
    }
}
