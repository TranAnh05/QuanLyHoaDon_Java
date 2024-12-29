package database;

import java.util.List;

import entity.HoaDonKH;

public class XoaHoaDonDAO implements XoaDAO {
    
    public XoaHoaDonDAO(){}

    public void xoaHDDAO(String maHD) {
        HoaDonCoSoDuLieu.xoaHoaDon(maHD);
    }

    public List<HoaDonKH> getDSHD_Xoa() {
        return HoaDonCoSoDuLieu.getDanhSachHoaDon();
    }

    public int getEmptyList_Xoa() {
        return HoaDonCoSoDuLieu.getSoLuongHoaDon();
    }

    
}
