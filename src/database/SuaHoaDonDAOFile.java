package database;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import entity.HoaDonKH;

public class SuaHoaDonDAOFile implements SuaDAO {
    private GetListFromFile getListFromFile = null;
    private File fileDate = null;

    // method
    public SuaHoaDonDAOFile(){}

    public SuaHoaDonDAOFile(GetListFromFile getListFromFile, String fileName){
        this.getListFromFile = getListFromFile;
        this.fileDate = new File(fileName);
    }

    public void suaHDDAO(String maHD, HoaDonKH hoaDon){
        // lay danh sach tu file
        List<HoaDonKH> ds = getListFromFile.getListDAO();

        // sua hoa don
        for(int i = 0;i < ds.size();i++){
            if(ds.get(i).getMaHoaDonKH().equals(maHD)){
                ds.set(i, hoaDon);
                break;
            }
        }

        // update vao file
        try {
            FileWriter fw = new FileWriter(fileDate);
            BufferedWriter bw = new BufferedWriter(fw);

            for(HoaDonKH hd : ds){
                bw.write(hd.toString());
                bw.newLine();
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<HoaDonKH> getDSHD_Sua(){
        return getListFromFile.getListDAO();
    }

}
