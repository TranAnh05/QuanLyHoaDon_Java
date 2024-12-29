package ui;

import java.io.PrintWriter;

public class TrungBinhThanhTienCUI {
    private PrintWriter screenOut = null;

    public TrungBinhThanhTienCUI(){}

    public TrungBinhThanhTienCUI(PrintWriter screenOut){
        this.screenOut = screenOut;
    }

    public void inKetQua(double tienTrungBinh){
        screenOut.println("Tong trung binh thanh tien cua khach hang nuoc ngoai la: " + tienTrungBinh);
    }
}
