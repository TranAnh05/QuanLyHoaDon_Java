package ui;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.ThemHoaDonCTL;
import entity.HoaDonKHNN;
import entity.HoaDonKHVN;
import entity.HoaDonKH;

public class InputHDUI {
    private Scanner keyBoardInput = null;
    private PrintWriter screenPromt = null;
    private String maKhPromt, maKhPromtUpdate, hoTenPromt, ngayHoaDonPromt, soLuongPromt, donGiaPromt,doiTuongPromt, dinhMucPromt, quocTichPromt; 
    private ThemHoaDonCTL  themHoaDonCTL = null;


    // constructor
    public InputHDUI(){
        
    }

    public InputHDUI(PrintWriter screenPromt, Scanner keyBoardInput, ThemHoaDonCTL themHoaDonCTL){
        this(screenPromt, keyBoardInput);
        this.themHoaDonCTL = themHoaDonCTL;
    }

    public InputHDUI(PrintWriter screenPromt, Scanner keyBoardInput){
        this.screenPromt = screenPromt;
        this.keyBoardInput = keyBoardInput;

        maKhPromt = "MA HOA DON (THEO DINH DANG hd#): ";
        maKhPromtUpdate = "MA HOA DON VUA NHAP: ";
        hoTenPromt = "TEN KHACH HANG: ";
        ngayHoaDonPromt = "NGAY RA HOA DON THEO DINH DANG(dd/MM/yyyy): ";
        soLuongPromt = "SO LUONG: ";
        donGiaPromt = "DON GIA: ";
        dinhMucPromt = "DINH MUC: ";
        doiTuongPromt = "DOI TUONG: [\"SINH HOAT\" / \" KINH DOANH\" / \"SAN XUAT\"]: ";
        quocTichPromt = "QUOC TICH: [\"VIET NAM\" / \"NUOC NGOAI\"]: ";
    }

    // method

    public void nhapThongTinHD(){
        screenPromt.print(maKhPromt);
        screenPromt.flush();
        String maKh = keyBoardInput.nextLine();
        screenPromt.print(hoTenPromt);
        screenPromt.flush();
        String hoTen = keyBoardInput.nextLine();

        // xu li dinh dang ngay
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ngayHoaDon = null;
        boolean validDate = false;

        while (!validDate) {
            screenPromt.print(ngayHoaDonPromt);
            screenPromt.flush();
            String ngayRaHoaDon = keyBoardInput.nextLine(); // 29/02/2023
    
            try{
                ngayHoaDon = LocalDate.parse(ngayRaHoaDon, formatter); // 28/02/2023

                // kiem tra xem ngay da nhap co dung voi dau vao khong
                // xu li truong hop ngay 30/2/,....
                String formattedDate = ngayHoaDon.format(formatter); // 28/02/2023 
                if(!formattedDate.equals(ngayRaHoaDon)){
                    throw new DateTimeParseException("Ngay khong hop le", ngayRaHoaDon, 0);
                }
                validDate = true;
            }
            catch(DateTimeParseException e){
                screenPromt.println("Dinh dang ngay khong hop le! Vui long nhap lai.");
            }
        }
        
        // xu li ngoai le neu nguoi dung nhap khong dung voi kieu du lieu int
        int soLuong = 0;
        while(true){
            screenPromt.print(soLuongPromt);
            screenPromt.flush();

            try {
                soLuong = keyBoardInput.nextInt();

                if(soLuong <= 0){
                    screenPromt.println("So luong phai lon hon 0.");
                    continue;
                }
                break;
            }
            catch(InputMismatchException e){
                screenPromt.println("Loi. Ban phai nhap vao mot so nguyen.");
                keyBoardInput.next(); // xoa du lieu nhap sai khoi bo dem
            }
        }
        
        // xu li phan nhap so
        double donGia = 0.0;
        while(true){
            screenPromt.print(donGiaPromt);
            screenPromt.flush();
            try {
                donGia = keyBoardInput.nextDouble();
                if (donGia <= 0) {
                    screenPromt.println("Don gia phai lon hon 0.");
                    continue;
                }
                break;
            }
            catch(InputMismatchException e){
                screenPromt.println("Loi. Ban phai nhap vao mot so thuc.");
                keyBoardInput.next(); // xoa du lieu nhap sai khoi bo dem
            }
        }
        keyBoardInput.nextLine();

        // xu li phan nhap quoc tich
        boolean validInput = false;
        while(!validInput){
            screenPromt.print(quocTichPromt);
            screenPromt.flush();
            String quocTich = keyBoardInput.nextLine();

            if("VIET NAM".equalsIgnoreCase(quocTich)){
                screenPromt.print(doiTuongPromt);
                screenPromt.flush();
                String doiTuong = keyBoardInput.nextLine();
    
                if(!(doiTuong.equalsIgnoreCase("sinh hoat") || doiTuong.equalsIgnoreCase("kinh doanh") || doiTuong.equalsIgnoreCase("san xuat"))){
                    screenPromt.println("Doi tuong khong hop le. Vui long nhap lai!");
                }
                else{
                    int dinhMuc = 0;
                    while(true){
                        screenPromt.print(dinhMucPromt);
                        screenPromt.flush();
                        try {
                            dinhMuc = keyBoardInput.nextInt();
                            if(dinhMuc <= 0){
                                screenPromt.println("Dinh muc phai lon hon 0.");
                                continue;
                            }
                            break;
                        }
                        catch(InputMismatchException e){
                            screenPromt.println("Loi. Ban phai nhap vao mot so nguyen.");
                            keyBoardInput.next(); // xoa du lieu nhap sai khoi bo dem
                        }
                    }
    
                    themHoaDonCTL.addHD(maKh, hoTen, ngayHoaDon, soLuong, donGia, doiTuong, dinhMuc);
                    keyBoardInput.nextLine();
                    validInput = true;
                }
                
            }
            else if("NUOC NGOAI".equalsIgnoreCase(quocTich)){
                themHoaDonCTL.addHD(maKh, hoTen, ngayHoaDon, soLuong, donGia, quocTich);
                validInput = true;
            }
            else{
                screenPromt.println("Quoc tich khong hop le, vui long nhap lai.");
            }
        }  
    }

    public HoaDonKH nhapThongTinHDChinhSua(String maHD){
        HoaDonKH hoaDon = null; 

        // xu li truong hop nguoi dung nhap ma khong dung ban dau
        String maKh = null;
        boolean maValid = true;
        while(maValid){
            screenPromt.print(maKhPromtUpdate);
            screenPromt.flush();
            maKh = keyBoardInput.nextLine(); 

            if(maKh.equals(maHD)){
                maValid = false;
            }
            else{
                screenPromt.println("Ma hoa don khong the thay doi, ma hoa don la duy nhat. Vui long nhap lai.");
            }
        }

        screenPromt.print(hoTenPromt);
        screenPromt.flush();
        String hoTen = keyBoardInput.nextLine();

        // xu li dinh dang ngay
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ngayHoaDon = null;
        boolean validDate = false;

        while (!validDate) {
            screenPromt.print(ngayHoaDonPromt);
            screenPromt.flush();
            String ngayRaHoaDon = keyBoardInput.nextLine();

            try{
                ngayHoaDon = LocalDate.parse(ngayRaHoaDon, formatter);

                // kiem tra xem ngay da nhap co dung voi dau vao khong
                String formattedDate = ngayHoaDon.format(formatter);
                if(!formattedDate.equals(ngayRaHoaDon)){
                    throw new DateTimeParseException("Ngay khong hop le", ngayRaHoaDon, 0);
                }
                validDate = true;
            }
            catch(DateTimeParseException e){
                screenPromt.println("Dinh dang ngay khong hop le! Vui long nhap lai.");
            }
        }
        
        // xu li phan nhap so 
        int soLuong = 0;
        while(true){
            screenPromt.print(soLuongPromt);
            screenPromt.flush();
            try {
                soLuong = keyBoardInput.nextInt();
                if(soLuong <= 0){
                    screenPromt.println("So luong phai lon hon 0.");
                    continue;
                }
                break;
            }
            catch(InputMismatchException e){
                screenPromt.println("Loi. Ban phai nhap vao mot so nguyen.");
                keyBoardInput.next(); // xoa du lieu nhap sai khoi bo dem
            }
        }
       
        // xu li phan nhap so
        double donGia = 0.0;
        while(true){
            screenPromt.print(donGiaPromt);
            screenPromt.flush();
            try {
                donGia = keyBoardInput.nextDouble();
                if(donGia <= 0){
                    screenPromt.println("Don gia phai lon hon 0.");
                    continue;
                }
                break;
            }
            catch(InputMismatchException e){
                screenPromt.println("Loi. Ban phai nhap vao mot so thuc.");
                keyBoardInput.next(); // xoa du lieu nhap sai khoi bo dem
            }
        }
        
        keyBoardInput.nextLine();

        // xu li phan nhap quoc tich
        boolean validInput = false;
        while(!validInput){
            screenPromt.print(quocTichPromt);
            screenPromt.flush();
            String quocTich = keyBoardInput.nextLine();

            if("VIET NAM".equalsIgnoreCase(quocTich)){
                screenPromt.print(doiTuongPromt);
                screenPromt.flush();
                String doiTuong = keyBoardInput.nextLine();
    
                if(!(doiTuong.equalsIgnoreCase("sinh hoat") || doiTuong.equalsIgnoreCase("kinh doanh") || doiTuong.equalsIgnoreCase("san xuat"))){
                    screenPromt.println("Doi tuong khong hop le. Vui long nhap lai!");
                }
                else{
                    int dinhMuc = 0;
                    while(true){
                        screenPromt.print(dinhMucPromt);
                        screenPromt.flush();
                        try {
                            dinhMuc = keyBoardInput.nextInt();
                            if(dinhMuc <= 0){
                                screenPromt.println("Dinh muc phai lon hon 0.");
                                continue;
                            }
                            break;
                        }
                        catch(InputMismatchException e){
                            screenPromt.println("Loi. Ban phai nhap vao mot so nguyen.");
                            keyBoardInput.next(); // xoa du lieu nhap sai khoi bo dem
                        }
                    }
    
                    HoaDonKHVN khVN = new HoaDonKHVN(maKh, hoTen, ngayHoaDon, soLuong, donGia, doiTuong, dinhMuc);
                    keyBoardInput.nextLine();
                    hoaDon = khVN;
                    validInput = true;
                }
                
            }
            else if("NUOC NGOAI".equalsIgnoreCase(quocTich)){
                HoaDonKHNN khNN = new HoaDonKHNN(maKh, hoTen, ngayHoaDon, soLuong, donGia, quocTich);
                hoaDon = khNN;
                validInput = true;
            }
            else{
                screenPromt.println("Quoc tich khong hop le, vui long nhap lai.");
            }
        }
        return hoaDon;
    }
}         
    

