package database;

import java.util.List;

import entity.HoaDonKH;

public class SuaHoaDonDAO implements SuaDAO {

    public SuaHoaDonDAO(){}
    
    public void suaHDDAO(String maHD, HoaDonKH hd) {
        HoaDonCoSoDuLieu.suaHoaDon(maHD, hd);
    }

    public List<HoaDonKH> getDSHD_Sua() {
        return HoaDonCoSoDuLieu.getDanhSachHoaDon();
    }
    
}
