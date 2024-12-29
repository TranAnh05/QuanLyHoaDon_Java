package database;

import java.util.List;

import entity.HoaDonKH;

public class TimHoaDonDAOFile implements TimDAO {
    private GetListFromFile getListFromFile = null;

    public TimHoaDonDAOFile(){}

    public TimHoaDonDAOFile(GetListFromFile getListFromFile){
        this.getListFromFile = getListFromFile;
    }

    public List<HoaDonKH> getDSHD_Tim(){
        return getListFromFile.getListDAO();
    }
}
