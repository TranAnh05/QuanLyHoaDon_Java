package database;

import java.util.List;

import entity.HoaDonKH;

public class TrungBinhThanhTienDAO implements TBTT_DAO{

    public TrungBinhThanhTienDAO(){}

    public List<HoaDonKH> getDSHD_TB() {
        return HoaDonCoSoDuLieu.getDanhSachHoaDon();
    }
    
}
