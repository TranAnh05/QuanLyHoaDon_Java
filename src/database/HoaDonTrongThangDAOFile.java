package database;

import java.util.List;

import entity.HoaDonKH;

public class HoaDonTrongThangDAOFile implements HDTT_DAO{
    private GetListFromFile getListFromFile = null;

    public HoaDonTrongThangDAOFile(){}

    public HoaDonTrongThangDAOFile(GetListFromFile getListFromFile){
        this.getListFromFile = getListFromFile;
    }

    public List<HoaDonKH> getDSHD_Month(){
        return getListFromFile.getListDAO();
    }
}
