package controller;

import java.util.List;

import database.XoaDAO;
import entity.HoaDonKH;
import ui.XoaHoaDonCUI;

public class XoaHoaDonCTL {
    private XoaDAO xoaDAO = null;
    private XoaHoaDonCUI xoaHoaDonCUI = null;

    public XoaHoaDonCTL(){}

    public XoaHoaDonCTL(XoaDAO xoaDAO, XoaHoaDonCUI xoaHoaDonCUI) {
        this.xoaHoaDonCUI = xoaHoaDonCUI;
        this.xoaDAO = xoaDAO;
    }

    public void xoaHDCTL(String maHD){
        List<HoaDonKH> ds = xoaDAO.getDSHD_Xoa();
        int size = xoaDAO.getEmptyList_Xoa();

        if(size == 0){
            xoaHoaDonCUI.inThongBao("Danh sach dang trong.");
        }
        else{
            boolean mark = false;
            for(HoaDonKH hd : ds) {
                if(hd.getMaHoaDonKH().equals(maHD)){
                    mark = true;
                    break;
                }
            }
            if(mark == true){
                xoaDAO.xoaHDDAO(maHD);
                xoaHoaDonCUI.inThongBao("Da xoa hoa don thanh cong.");
            }
            else{
                xoaHoaDonCUI.inThongBao("Khong ton tai ma hoa don trong danh sach.");
            }
        }
    }
}
