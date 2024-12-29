package ui;

import java.io.PrintWriter;

public class ThemHoaDonCUI {
    private PrintWriter screenPromt = null;

    // constructor
    public ThemHoaDonCUI(){
        
    }

    public ThemHoaDonCUI(PrintWriter screenPromt){
        this.screenPromt = screenPromt;
    }
    
    // method
    public void inThongBao(String thongBao){
        screenPromt.println(thongBao);
    }
}
