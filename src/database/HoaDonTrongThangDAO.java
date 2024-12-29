package database;

import java.util.List;

import entity.HoaDonKH;

public class HoaDonTrongThangDAO implements HDTT_DAO{
    
    public HoaDonTrongThangDAO(){}

    public List<HoaDonKH> getDSHD_Month() {
        return HoaDonCoSoDuLieu.getDanhSachHoaDon();
    }
}
