package database;

import java.util.List;

import entity.HoaDonKH;

public class TongSoLuongDAO implements TSL_DAO {
    
    public TongSoLuongDAO(){}

    public List<HoaDonKH> getDSHD_Tong() {
        return HoaDonCoSoDuLieu.getDanhSachHoaDon();
    }
}
