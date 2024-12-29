package ui;

import java.io.PrintWriter;

public class TongSoLuongCUI {
    private PrintWriter screenOut = null;

    public TongSoLuongCUI(){}

    public TongSoLuongCUI(PrintWriter screenOut){
        this.screenOut = screenOut;
    }

    public void inKetQua(int soLuongVietNam, int soLuongNuocNgoai){
        screenOut.println("Tong so luong cua khach hang Viet Nam: " + soLuongVietNam);
        screenOut.println("Tong so luong cua khach hang nuoc ngoai: " + soLuongNuocNgoai);
    }
}
