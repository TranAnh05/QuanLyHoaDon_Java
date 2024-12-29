package database;

import java.util.List;

import entity.HoaDonKH;


public class TongSoLuongDAOFile implements TSL_DAO {
    private GetListFromFile getListFromFile = null;
    
    public TongSoLuongDAOFile(){}

    public TongSoLuongDAOFile(GetListFromFile getListFromFile){
        this.getListFromFile = getListFromFile;
    }

    public List<HoaDonKH> getDSHD_Tong(){
        return getListFromFile.getListDAO();
    }
}
