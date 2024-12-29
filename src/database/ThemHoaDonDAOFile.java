package database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import entity.HoaDonKH;

public class ThemHoaDonDAOFile implements ThemDAO {
    private GetListFromFile getListFromFile = null;
    private File fileData = null;

    // method
    public ThemHoaDonDAOFile(){}

    public ThemHoaDonDAOFile(String fileName){
        fileData = new File(fileName);
    }

    public ThemHoaDonDAOFile(GetListFromFile getListFromFile, String fileName){
        this(fileName);
        this.getListFromFile = getListFromFile;
    }

    public void themHDDAO(HoaDonKH hd){
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(fileData, true); // không ghi đè dữ liệu cũ, nối tiếp nhau
            bw = new BufferedWriter(fw);
            bw.write(hd.toString());
            bw.newLine();

            bw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }    
    }

    public List<HoaDonKH> getDSHD_Them(){
        return getListFromFile.getListDAO();
    }
}
