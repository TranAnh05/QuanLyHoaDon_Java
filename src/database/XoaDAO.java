package database;

import java.util.List;

import entity.HoaDonKH;

public interface XoaDAO {

    void xoaHDDAO(String maHD);
    List<HoaDonKH> getDSHD_Xoa();
    int getEmptyList_Xoa();
}
