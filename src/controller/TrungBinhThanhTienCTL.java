package controller;

import java.util.List;

import database.TBTT_DAO;
import entity.HoaDonKH;
import entity.HoaDonKHNN;
import ui.TrungBinhThanhTienCUI;

public class TrungBinhThanhTienCTL {
    private TBTT_DAO trungBinhThanhTienDAO = null;
    private TrungBinhThanhTienCUI trungBinhThanhTienCUI = null;

    public TrungBinhThanhTienCTL(){}

    public TrungBinhThanhTienCTL(TBTT_DAO trungBinhThanhTienDAO, TrungBinhThanhTienCUI trungBinhThanhTienCUI){
        this.trungBinhThanhTienCUI = trungBinhThanhTienCUI;
        this.trungBinhThanhTienDAO = trungBinhThanhTienDAO;
    }

    public void tinhTrungBinhThanhTienCTL(){
        List<HoaDonKH> ds = trungBinhThanhTienDAO.getDSHD_TB();
        double tienTrungBinh = 0;
        int count = 0;

        double thanhTien = 0;
        for(HoaDonKH hd : ds){
            
            if(hd instanceof HoaDonKHNN){
                count++;
                thanhTien += hd.tinhThanhTien();
            }
        }

        if(count == 0){
            tienTrungBinh = 0;
        }
        else{
            tienTrungBinh = thanhTien / count;
        }
        trungBinhThanhTienCUI.inKetQua(tienTrungBinh);
    }
}
