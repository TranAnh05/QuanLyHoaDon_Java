package database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import entity.HoaDonKH;

public class XoaHoaDonDAOFile implements XoaDAO {
    private GetListFromFile getListFromFile = null;
    private File fileData = null;

    // method
    // constructor
    public XoaHoaDonDAOFile(){}

    public XoaHoaDonDAOFile(String fileName){
        fileData = new File(fileName);
    }

    public XoaHoaDonDAOFile(GetListFromFile getListFromFile, String fileName){
        this(fileName);
        this.getListFromFile = getListFromFile;
    }

    public void xoaHDDAO(String maHD){
        // Lay danh sach tu file
        List<HoaDonKH> ds = getListFromFile.getListDAO();

        // xoa sinh vien trong List
        for(HoaDonKH hd : ds){
            if(hd.getMaHoaDonKH().equals(maHD)){
                ds.remove(hd);
                break;
            }    
        }

        // xu li ngoai le cua doi tuong File
        try {
            FileWriter fw = new FileWriter(fileData); // ghi đè lại các dữ liệu cũ
            BufferedWriter bw = new BufferedWriter(fw);

            // ghi cac sinh vien trong danh sach lai vao file
            for(HoaDonKH hd : ds){
                bw.write(hd.toString());
                bw.newLine();
            }

            
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<HoaDonKH> getDSHD_Xoa(){
        return getListFromFile.getListDAO();
    }

    public int getEmptyList_Xoa(){
        return getListFromFile.getEmptyList();
    }
}
