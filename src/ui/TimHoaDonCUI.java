package ui;

import java.io.PrintWriter;

import entity.HoaDonKH;
import entity.HoaDonKHVN;

public class TimHoaDonCUI {
    private PrintWriter screenOut = null;

    public TimHoaDonCUI(){}

    public TimHoaDonCUI(PrintWriter screenOut){
        this.screenOut = screenOut;
    }

    public void inKetQua(String thongBao){
        screenOut.println(thongBao);
    }

    public void inKetQua(HoaDonKH kh){
         // dau line-through
        String lineThrough = "";
        for(int i = 1;i < 131;i++){
            lineThrough += "-";
        }
        
        // in ra nhu table (cot, hang)
        screenOut.println("Hoa don tim duoc theo ma la:\n");
        screenOut.printf("%-129s\n", lineThrough);
        screenOut.printf("%-15s | %-20s | %-20s | %-10s | %-10s | %-15s | %-20s |\n",
                        "Ma hoa don", "Ho va ten", "Ngay ra hoa don", "So luong", "Don gia", "Quoc tich", "Thanh tien");
        screenOut.printf("%-129s\n", lineThrough);

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
