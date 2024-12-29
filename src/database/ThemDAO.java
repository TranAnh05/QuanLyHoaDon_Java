package database;

import java.util.List;

import entity.HoaDonKH;

public interface ThemDAO {

    void themHDDAO(HoaDonKH hd);
    List<HoaDonKH> getDSHD_Them();
}
