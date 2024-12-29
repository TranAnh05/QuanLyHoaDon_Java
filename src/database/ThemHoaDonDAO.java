package database;

import java.util.List;

import entity.HoaDonKH;

public class ThemHoaDonDAO implements ThemDAO {
    
    public ThemHoaDonDAO(){}

    public void themHDDAO(HoaDonKH hd) {
        HoaDonCoSoDuLieu.themHoaDon(hd);
    }

    public List<HoaDonKH> getDSHD_Them() {
        return HoaDonCoSoDuLieu.getDanhSachHoaDon();
    }
    
}
