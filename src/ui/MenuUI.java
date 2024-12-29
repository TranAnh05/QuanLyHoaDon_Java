package ui;

import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.HoaDonTrongThangCTL;
import controller.InHoaDonCTL;
import controller.SuaHoaDonCTL;
import controller.TimHoaDonCTL;
import controller.TongSoLuongCTL;
import controller.TrungBinhThanhTienCTL;
import controller.XoaHoaDonCTL;



public class MenuUI {
    private Scanner keyBoardInput = null;
    private String promt = "->"; // loi nhac cho giao dien nay
    private String command = " ";
    private PrintWriter screenPromt = null;

    // cac doi tuong phu thuoc
    private InputHDUI inputHDUI = null;
    private XoaHoaDonCTL xoaHoaDonCTL = null;
    private SuaHoaDonCTL suaHoaDonCTL = null;
    private TongSoLuongCTL tongSoLuongCTL = null;
    private TrungBinhThanhTienCTL trungBinhThanhTienCTL = null;
    private HoaDonTrongThangCTL hoaDonTrongThangCTL = null;
    private TimHoaDonCTL timHoaDonCTL = null;
    private InHoaDonCTL inHoaDonCTL = null;
  
    
    // constructor
    public MenuUI(){

    }

    public MenuUI(PrintWriter screenPromt, Scanner keyBoardInput, InputHDUI inputHDUI,XoaHoaDonCTL xoaHoaDonCTL,
                  SuaHoaDonCTL suaHoaDonCTL, TongSoLuongCTL tongSoLuongCTL, TrungBinhThanhTienCTL trungBinhThanhTienCTL,
                  HoaDonTrongThangCTL hoaDonTrongThangCTL, TimHoaDonCTL timHoaDonCTL,InHoaDonCTL inHoaDonCTL)
    {
        this(screenPromt, keyBoardInput);
        this.inputHDUI = inputHDUI;
        this.xoaHoaDonCTL = xoaHoaDonCTL;
        this.suaHoaDonCTL = suaHoaDonCTL;
        this.tongSoLuongCTL = tongSoLuongCTL;
        this.trungBinhThanhTienCTL = trungBinhThanhTienCTL;
        this.hoaDonTrongThangCTL = hoaDonTrongThangCTL;
        this.timHoaDonCTL = timHoaDonCTL;
        this.inHoaDonCTL = inHoaDonCTL;
        
    }

    public MenuUI(PrintWriter _screenPrompt, Scanner _keyBoardInput){
        screenPromt = _screenPrompt;
        keyBoardInput = _keyBoardInput;
    }

    // method
    public void controlLoop(){
        // String command = " ";
        screenPromt.println("Go lenh \"help\" de duoc ho tro");

        while (true) {
            screenPromt.println(promt);
            screenPromt.flush(); // xóa bộ đệm (đảm bảo rằng dữ liệu được ghi từ bộ nhớ đệm ra đích thực tế)
            command = keyBoardInput.nextLine();
            command = command.trim(); // loai bo dau cach

            if(command.equalsIgnoreCase("help")){
                help();
                continue; // out if và quay lại while()
            }

            if(command.equalsIgnoreCase("add")){
                themHD();
                continue;
            }

            if(command.equalsIgnoreCase("remove")){
                xoaHD();
                continue;
            }

            if(command.equalsIgnoreCase("update")){
                suaHD();
                continue;
            }

            if(command.equalsIgnoreCase("get")){
                getSoLuongHoaDon();
                continue;
            }

            if(command.equalsIgnoreCase("calc")){
                getTBThanhTienKhachNuocNgoai();
                continue;
            }

            if(command.equalsIgnoreCase("month")){
                xuatHDTheoThang();
                continue;
            }

            if(command.equalsIgnoreCase("find")){
                timKiemHoaDon();
                continue; 
            }

            if(command.equalsIgnoreCase("print")){
                inDS();
                continue;
            }

            if(command.equalsIgnoreCase("quit")){
                break; // out while
            }
        }
    }

    private void help(){
        screenPromt.println("~~~~~~~~~~~~~~~CONSOLE HELP MENU~~~~~~~~~~~~~~~");
        screenPromt.println("[HELP] Ho tro su dung phan mem.");
        screenPromt.println("[ADD] Them hoa don.");
        screenPromt.println("[REMOVE] Xoa hoa don.");
        screenPromt.println("[UPDATE] Sua hon don.");
        screenPromt.println("[GET] Lay tong so luong theo loai.");
        screenPromt.println("[CALC] Tinh trung binh thanh tien cua khach hang nuoc ngoai.");
        screenPromt.println("[MONTH] Xuat tat cac cac hoa don trong thang nao do.");
        screenPromt.println("[FIND] Tim kiem hon don.");
        screenPromt.println("[PRINT] In danh sach hoa don.");
        screenPromt.println("[QUIT] Thoat phan mem.");
        screenPromt.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private void themHD(){
        inputHDUI.nhapThongTinHD();
    }

    private void xoaHD(){
        screenPromt.print("Nhap ma hoa don ban muon xoa: ");
        screenPromt.flush();
        String maKH = keyBoardInput.nextLine();
        xoaHoaDonCTL.xoaHDCTL(maKH);
    }

    private void suaHD(){
        screenPromt.print("Nhap ma hoa don ban muon thay doi thong tin: ");
        screenPromt.flush();
        String maKH = keyBoardInput.nextLine();
        suaHoaDonCTL.suaHDCTL(maKH);
    }

    private void getSoLuongHoaDon(){
        tongSoLuongCTL.getTongSoLuongCTL();
    }

    private void getTBThanhTienKhachNuocNgoai(){
        trungBinhThanhTienCTL.tinhTrungBinhThanhTienCTL();
    }

    private void xuatHDTheoThang(){
        while(true){
            try {
                screenPromt.print("Nhap vao nam cua thang: ");
                screenPromt.flush();
                int nam = keyBoardInput.nextInt();
                keyBoardInput.nextLine();
                screenPromt.print("Nhap vao thang ban muon truy xuat: ");
                screenPromt.flush();
                int thang = keyBoardInput.nextInt();
                keyBoardInput.nextLine();
                if(nam <= 0 || thang <= 0 || thang > 12){
                    screenPromt.println("Nam phai lon hon 0 va thang phai tu 1 -> 12.");
                    continue;
                }
                hoaDonTrongThangCTL.getHoaDonTrongThangCTL(thang, nam);
                break;
            }
            catch(InputMismatchException e){
                screenPromt.println("Ban phai nhap vao mot so nguyen.");
                keyBoardInput.next(); // xoa du lieu khoi bo nho dem.
            }
        }
        
    }

    private void timKiemHoaDon(){
        screenPromt.print("Nhap ma hoa don ban muon tim kiem: ");
        screenPromt.flush();
        String maKH = keyBoardInput.nextLine();
        timHoaDonCTL.timHoaDon_CTL(maKH);
    }

    private void inDS(){
        inHoaDonCTL.inHDCTL();
    }
}
