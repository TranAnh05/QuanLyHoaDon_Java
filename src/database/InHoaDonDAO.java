package database;

import java.util.List;

import entity.HoaDonKH;

public class InHoaDonDAO implements InDAO{

    public InHoaDonDAO() {}

    public List<HoaDonKH> getDSHD_In() {
        return HoaDonCoSoDuLieu.getDanhSachHoaDon();
    }

    public int getEmptyList_In() {
        return HoaDonCoSoDuLieu.getSoLuongHoaDon();
    }
    
}
