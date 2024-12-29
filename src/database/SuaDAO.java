package database;

import java.util.List;

import entity.HoaDonKH;

public interface SuaDAO {

    void suaHDDAO(String maHD, HoaDonKH hd);
    List<HoaDonKH> getDSHD_Sua();
}
