package ui;

import java.io.PrintWriter;
import java.util.Scanner;

import controller.HoaDonTrongThangCTL;
import controller.InHoaDonCTL;
import controller.SuaHoaDonCTL;
import controller.ThemHoaDonCTL;
import controller.TimHoaDonCTL;
import controller.TongSoLuongCTL;
import controller.TrungBinhThanhTienCTL;
import controller.XoaHoaDonCTL;
import database.GetListFromFile;
import database.HoaDonCoSoDuLieu;
import database.HoaDonTrongThangDAO;
import database.HoaDonTrongThangDAOFile;
import database.InHoaDonDAO;
import database.InHoaDonDAOFile;
import database.SuaHoaDonDAO;
import database.SuaHoaDonDAOFile;
import database.ThemHoaDonDAO;
import database.ThemHoaDonDAOFile;
import database.TimHoaDonDAO;
import database.TimHoaDonDAOFile;
import database.TongSoLuongDAO;
import database.TongSoLuongDAOFile;
import database.TrungBinhThanhTienDAO;
import database.TrungBinhThanhTienDAOFile;
import database.XoaHoaDonDAO;
import database.XoaHoaDonDAOFile;



public class QuanLyHoaDonApp {
    public static void main(String[] args) {
        
        // HoaDonCoSoDuLieu.initDatabase();
        PrintWriter screenOutRemote = new PrintWriter(System.out, true);
        Scanner keyBoardInputRemote = new Scanner(System.in);
        GetListFromFile getListFromFile = new GetListFromFile("HoaDon.txt");

        // them
        ThemHoaDonDAOFile themHoaDonDAO = new ThemHoaDonDAOFile(getListFromFile,"HoaDon.txt");
        ThemHoaDonCUI themHDOutputCUI = new ThemHoaDonCUI(screenOutRemote);
        // ThemHoaDonDAO themHoaDonDAO2 = new ThemHoaDonDAO();        

        ThemHoaDonCTL themHDCTL = new ThemHoaDonCTL(themHoaDonDAO, themHDOutputCUI);
        
        InputHDUI inputHDUI = new InputHDUI(screenOutRemote, keyBoardInputRemote, themHDCTL);

        // xoa
        XoaHoaDonDAOFile xoaHoaDonDAO = new XoaHoaDonDAOFile(getListFromFile, "HoaDon.txt");
        XoaHoaDonCUI xoaHoaDonCUI = new XoaHoaDonCUI(screenOutRemote);
        // XoaHoaDonDAO xoaHoaDonDAO2 = new XoaHoaDonDAO();

        XoaHoaDonCTL xoaHoaDonCTL = new XoaHoaDonCTL(xoaHoaDonDAO, xoaHoaDonCUI);

        // sua
        SuaHoaDonDAOFile suaHoaDonDAO = new SuaHoaDonDAOFile(getListFromFile,"HoaDon.txt");
        SuaHoaDonCUI suaHoaDonCUI = new SuaHoaDonCUI(screenOutRemote);
        // SuaHoaDonDAO suaHoaDonDAO2 = new SuaHoaDonDAO();

        SuaHoaDonCTL suaHoaDonCTL = new SuaHoaDonCTL(suaHoaDonDAO, suaHoaDonCUI, inputHDUI);

        // lay tong so luong
        TongSoLuongDAOFile tongSoLuongDAO = new TongSoLuongDAOFile(getListFromFile);
        TongSoLuongCUI tongSoLuongCUI = new TongSoLuongCUI(screenOutRemote);
        // TongSoLuongDAO tongSoLuongDAO2 = new TongSoLuongDAO();

        TongSoLuongCTL tongSoLuongCTL = new TongSoLuongCTL(tongSoLuongDAO, tongSoLuongCUI);

        // Trung binh khach hang nuoc ngoai
        TrungBinhThanhTienDAOFile trungBinhThanhTienDAO = new TrungBinhThanhTienDAOFile(getListFromFile);
        TrungBinhThanhTienCUI trungBinhThanhTienCUI = new TrungBinhThanhTienCUI(screenOutRemote);
        // TrungBinhThanhTienDAO trungBinhThanhTienDAO2 = new TrungBinhThanhTienDAO();

        TrungBinhThanhTienCTL trungBinhThanhTienCTL = new TrungBinhThanhTienCTL(trungBinhThanhTienDAO, trungBinhThanhTienCUI);

        // hoa don theo thang
        HoaDonTrongThangDAOFile hoaDonTrongThangDAO = new HoaDonTrongThangDAOFile(getListFromFile);
        HoaDonTrongThangCUI hoaDonTrongThangCUI = new HoaDonTrongThangCUI(screenOutRemote);
        // HoaDonTrongThangDAO hoaDonTrongThangDAO2 = new HoaDonTrongThangDAO();

        HoaDonTrongThangCTL hoaDonTrongThangCTL = new HoaDonTrongThangCTL(hoaDonTrongThangDAO, hoaDonTrongThangCUI);

        // tim hoa don
        TimHoaDonDAOFile timHoaDonDAO = new TimHoaDonDAOFile(getListFromFile);
        TimHoaDonCUI timHoaDonCUI = new TimHoaDonCUI(screenOutRemote);
        // TimHoaDonDAO timHoaDonDAO2 = new TimHoaDonDAO();

        TimHoaDonCTL timHoaDonCTL = new TimHoaDonCTL(timHoaDonDAO, timHoaDonCUI);
        
        // in
        InHoaDonDAOFile inHoaDonDAO = new InHoaDonDAOFile(getListFromFile);
        InHoaDonCUI inHoaDonCUI = new InHoaDonCUI(screenOutRemote);
        // InHoaDonDAO inHoaDonDAO2 = new InHoaDonDAO();

        InHoaDonCTL inHoaDonCTL = new InHoaDonCTL(inHoaDonDAO, inHoaDonCUI);

        // Menu
        MenuUI menu = new MenuUI(screenOutRemote, keyBoardInputRemote, inputHDUI, xoaHoaDonCTL,suaHoaDonCTL,
                                 tongSoLuongCTL, trungBinhThanhTienCTL, hoaDonTrongThangCTL, timHoaDonCTL, inHoaDonCTL);
        menu.controlLoop(); 
    }  
}
