package database;

import java.util.List;

import entity.HoaDonKH;

public class InHoaDonDAOFile implements InDAO {
    private GetListFromFile getList = null;

    public InHoaDonDAOFile(){}
    
    public InHoaDonDAOFile(GetListFromFile getList){
        this.getList = getList;
    }

    public List<HoaDonKH> getDSHD_In(){
        return getList.getListDAO();
    }

    public int getEmptyList_In() {
        return getList.getEmptyList();
    }
}
