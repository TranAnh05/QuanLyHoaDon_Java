package ui;

import java.io.PrintWriter;
import java.util.List;

import entity.HoaDonKH;
import entity.HoaDonKHVN;

public class InHoaDonCUI {
    private PrintWriter screenOut = null;

    // constructor
    public InHoaDonCUI(){
        
    }

    public InHoaDonCUI(PrintWriter screenOut){
        this.screenOut = screenOut;
    }

    // method
    public void inDSHD(String thongBao){
        screenOut.println(thongBao);
    }

    public void inDSHD(List<HoaDonKH> HoaDonKHs, int size){
        // line-through
        String lineThrough = "";
        for(int i = 1;i < 131;i++){
            lineThrough += "-";
        }

        // in nhu bang (cot, hang)
        screenOut.printf("%-129s\n", lineThrough);
        screenOut.printf("%-15s | %-20s | %-20s | %-10s | %-10s | %-15s | %-20s |\n",
                        "Ma hoa don", "Ho va ten", "Ngay ra hoa don", "So luong", "Don gia", "Quoc tich", "Thanh tien");
        screenOut.printf("%-129s\n", lineThrough);

        for(int i = 0;i < size;i++){
            HoaDonKH kh = HoaDonKHs.get(i);

            if(kh instanceof HoaDonKHVN){
                screenOut.printf("%-15s | %-20s | %-20s | %-10d | %-10.2f | %-15s | %-20.2f |\n",
                                kh.getMaHoaDonKH(), kh.getHoten(), kh.getNgayHoaDon(), kh.getSoLuong(), kh.getDonGia(), "Viet Nam", kh.tinhThanhTien());
            }
            else{
                screenOut.printf("%-15s | %-20s | %-20s | %-10d | %-10.2f | %-15s | %-20.2f |\n",
                                kh.getMaHoaDonKH(), kh.getHoten(), kh.getNgayHoaDon(), kh.getSoLuong(), kh.getDonGia(), "Nuoc Ngoai", kh.tinhThanhTien());
            }
            screenOut.printf("%-129s\n", lineThrough);                
        }  
    }
}
