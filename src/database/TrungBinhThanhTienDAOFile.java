package database;

import java.util.List;

import entity.HoaDonKH;

public class TrungBinhThanhTienDAOFile implements TBTT_DAO{
    private GetListFromFile getListFromFile = null;

    public TrungBinhThanhTienDAOFile(){}

    public TrungBinhThanhTienDAOFile(GetListFromFile getListFromFile){
        this.getListFromFile = getListFromFile;
    }

    public List<HoaDonKH> getDSHD_TB(){
        return getListFromFile.getListDAO();
    }
}
