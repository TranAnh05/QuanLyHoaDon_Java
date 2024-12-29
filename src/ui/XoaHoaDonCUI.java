package ui;

import java.io.PrintWriter;

public class XoaHoaDonCUI {
    private PrintWriter screenOut = null;

    // method
    public XoaHoaDonCUI(){}

    public XoaHoaDonCUI(PrintWriter screenOut){
        this.screenOut = screenOut;
    }

    public void inThongBao(String thongBao){
        screenOut.println(thongBao);
    }

}
