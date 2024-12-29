package ui;

import java.io.PrintWriter;

public class SuaHoaDonCUI {
    private PrintWriter screenOut = null;

    public SuaHoaDonCUI(){}

    public SuaHoaDonCUI(PrintWriter screenOut){
        this.screenOut = screenOut;
    }

    public void inThongBao(String thongBao){
        screenOut.println(thongBao);
    }
}
