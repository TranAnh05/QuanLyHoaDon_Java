package database;


import java.util.ArrayList;
import java.util.List;

import entity.HoaDonKH;

public class HoaDonCoSoDuLieu {
    private static List<HoaDonKH> dsHoaDon = null; 

    public static void initDatabase(){
        // ArrayList(là một lớp cụ thể) được sử dụng như một lớp thức hiện interface List. Điều này có nghĩa là mình có thể sử dụng
        // bất kì phương thức nào được định nghĩa trong giao diện list với đối tượng arrayList
        dsHoaDon = new ArrayList<>();
    }

    public static void themHoaDon(HoaDonKH hoaDonKH){
        dsHoaDon.add(hoaDonKH); 
    }

    public static void xoaHoaDon(String maKH){
        // dsHoaDon.removeIf(kh -> kh.getMaHoaDonKH().equals(maKH));
        for(HoaDonKH kh : dsHoaDon){
            if(kh.getMaHoaDonKH().equals(maKH)){
                dsHoaDon.remove(kh);
                return;     
            }
        }
    }

    public static void suaHoaDon(String maKH, HoaDonKH hoaDon) {
        for (int i = 0; i < dsHoaDon.size(); i++) {
            if (dsHoaDon.get(i).getMaHoaDonKH().equals(maKH)) {
                dsHoaDon.set(i, hoaDon);
                return;
            }
        }
    }

    public static List<HoaDonKH> getDanhSachHoaDon(){
        return dsHoaDon; 
    }

    public static int getSoLuongHoaDon(){
        return dsHoaDon.size();
    }
    
}
