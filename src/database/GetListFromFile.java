package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entity.HoaDonKH;
import entity.HoaDonKHNN;
import entity.HoaDonKHVN;

public class GetListFromFile {
    private File fileData = null;

    public GetListFromFile(String fileName) {
        fileData = new File(fileName);
    }

    public List<HoaDonKH> getListDAO(){
        // tao mot danh sach de luu cac doi hoa don tu file
        List<HoaDonKH> ds = new ArrayList<>();

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(fileData);
            br = new BufferedReader(fr);
            String line = "";

            while(true){
                try {
                    line = br.readLine();
                    if(line == null){
                        break;
                    }
                    String txt[] = line.split(";"); // chuyen doi cac chuỗi thành mảng bằng dấu;
                    for(String s : txt){
                        // doc hoa don viet nam va them vao danh sach
                        if(s.equalsIgnoreCase("sinh hoat") || s.equalsIgnoreCase("kinh doanh") || s.equalsIgnoreCase("san xuat")){
                            String maHD = txt[0];
                            String hoTen = txt[1];
                            LocalDate ngayHoaDon = LocalDate.parse(txt[2]);
                            int soLuong = Integer.parseInt(txt[3]);
                            Double donGia = Double.parseDouble(txt[4]);
                            String doiTuong = txt[5];
                            int dinhMuc = Integer.parseInt(txt[6]);

                            HoaDonKHVN hd = new HoaDonKHVN(maHD, hoTen, ngayHoaDon, soLuong, donGia, doiTuong, dinhMuc);
                            ds.add(hd);
                        }

                        // doc hoa don nuoc ngoai va them vao danh sach
                        if (s.equalsIgnoreCase("nuoc ngoai")){
                            String maHD = txt[0];
                            String hoTen = txt[1];
                            LocalDate ngayHoaDon = LocalDate.parse(txt[2]);
                            int soLuong = Integer.parseInt(txt[3]);
                            Double donGia = Double.parseDouble(txt[4]);
                            String quocTich = txt[5];

                            HoaDonKHNN hd = new HoaDonKHNN(maHD, hoTen, ngayHoaDon, soLuong, donGia, quocTich);
                            ds.add(hd);
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return ds;
    }

    public int getEmptyList(){
        List<HoaDonKH> ds = getListDAO();
        return ds.size();
    }
}
