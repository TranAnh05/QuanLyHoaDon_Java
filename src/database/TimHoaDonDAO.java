package database;

import java.util.List;

import entity.HoaDonKH;

public class TimHoaDonDAO implements TimDAO{
    
    public TimHoaDonDAO(){}

    @Override
    public List<HoaDonKH> getDSHD_Tim() {
        return HoaDonCoSoDuLieu.getDanhSachHoaDon();
    }
}
