package controller;

import java.util.List;

import database.TSL_DAO;
import entity.HoaDonKH;
import entity.HoaDonKHNN;
import entity.HoaDonKHVN;
import ui.TongSoLuongCUI;

public class TongSoLuongCTL {
    private TSL_DAO tongSoLuongDAO = null;
    private TongSoLuongCUI tongSoLuongCUI = null;

    public TongSoLuongCTL(){}

    public TongSoLuongCTL(TSL_DAO tongSoLuongDAO, TongSoLuongCUI tongSoLuongCUI){
        this.tongSoLuongCUI = tongSoLuongCUI;
        this.tongSoLuongDAO = tongSoLuongDAO;
    }

    public void getTongSoLuongCTL(){
        List<HoaDonKH> ds = tongSoLuongDAO.getDSHD_Tong();
        int soLuongVN = 0, soLuongNN = 0;
        for(HoaDonKH hd : ds){
            if(hd instanceof HoaDonKHVN){
                soLuongVN += hd.getSoLuong();
            }

            if(hd instanceof HoaDonKHNN){
                soLuongNN += hd.getSoLuong();
            }
        }
        tongSoLuongCUI.inKetQua(soLuongVN, soLuongNN);
    }
}
