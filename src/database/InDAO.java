package database;

import java.util.List;

import entity.HoaDonKH;

public interface InDAO {
    
    List<HoaDonKH> getDSHD_In();
    int getEmptyList_In();
}
