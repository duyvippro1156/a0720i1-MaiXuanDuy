package Controller;

import java.util.*;
import java.util.Scanner;

import commons.CustomerComparator;
import commons.validate;

import models.*;

public class MainController {
    static List<StkDaihan> StkDaihan = new ArrayList<>();
    static List<StkNganhanCothoihan> stk_nganhan = new ArrayList<>();
    static List<KhachHang> khachHangList = new ArrayList<>();

    public static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        System.out.print("---------------\nCHƯƠNG TRÌNH QUẢN LÝ SỔ TIẾT KIỆM: \n" +
                "Chọn chức năng theo số (để tiếp tục):\n" +
                "1. Thêm mới sổ tiết kiệm\n" +
                "2. Xóa sổ tiết kiệm\n" +
                "3. Xem danh sách sổ tiết kiệm\n" +
                "4. Xem thông tin khách hàng\n" +
                "5. Tìm kiếm sổ tiết kiệm\n" +
                "6. Thoát\n");
        String mainMenuIndex = scanner.nextLine();
        switch (mainMenuIndex) {
            case "1":
                themMoiSTK();
                break;
            case "2": {
                xoaSTK();
                break;
            }
            case "3":
                xemDsSTK();
                break;
            case "4": {
                xemThongtinKH();
                break;
            }
            case "5": {
                timSTK();
                break;
            }
            case "6": {
                System.exit(0);
            }
            default:
                System.out.println("Nhập lựa chọn không hợp lệ, bấm ENTER để tiếp tục !!!");
                scanner.nextLine();
                displayMainMenu();
        }
    }

    public static void themMoiSTK() {
        System.out.println("========== Thêm mới sổ tiết kiệm ==========");
        System.out.println("1. Sổ tiết kiệm dài hạn");
        System.out.println("2. Sổ tiết kiệm ngắn hạn");
        System.out.println("3. Quay lại menu chính");
        System.out.println("4. Thoát");
        System.out.println("======================================");
        System.out.print("Nhập lựa chọn: ");
        String choose = scanner.nextLine();
        switch (choose) {
            case "1": {
                themMoiStkDaihan();
                break;
            }
            case "2": {
                themMoiStkNganhan();
                break;
            }
            case "3": {
                displayMainMenu();
                break;
            }
            case "4": {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Fail!!! Please Choose again! Enter to continue.");
                scanner.nextLine();
                themMoiSTK();
            }
        }
    }

    public static void themMoiStkDaihan() {
        StkDaihan StkDaihan = new StkDaihan();
        System.out.println("Nhập mã số sổ tiết kiệm: ");
        String maSTK;
        do {
            System.out.print("ID: ");
            maSTK = scanner.nextLine();
        } while (!validate.checkMasoStk(maSTK));
        StkDaihan.setMaso(maSTK);

        System.out.println("Nhập mã khách hàng: ");
        String maKH;
        maKH = scanner.nextLine();
        StkDaihan.setMaKH(maKH);

        String ngaymoso;
        do {
            System.out.print("Ngày mở số: ");
            ngaymoso = scanner.nextLine();
        } while (!validate.checkdate(ngaymoso));
        StkDaihan.setNgaymoso(ngaymoso);


        String ngaybatdaugui;
        do {
            System.out.print("Ngày bắt đầu gửi: ");
            ngaybatdaugui = scanner.nextLine();
        } while (!validate.checkdate(ngaybatdaugui));
        StkDaihan.setNgaymoso(ngaybatdaugui);

        String kyhan;
        do {
            System.out.print("kỳ hạn: ");
            kyhan = scanner.nextLine();
        } while (!validate.checkKyhanStkDaihan(kyhan));
        StkDaihan.setKyhan(kyhan);

        String tien;
        do {
            System.out.print("Số tiền gửi: ");
            tien = scanner.nextLine();
        } while (!validate.checkSoTienGui(tien));
        StkDaihan.setSotiengui(tien);

        System.out.println("Nhập lãi suất: ");
        String laisuat;
        laisuat = scanner.nextLine();
        StkDaihan.setLaisuat(laisuat);

        System.out.println("Nhập ưu đãi: ");
        String uudai;
        uudai = scanner.nextLine();
        StkDaihan.setLaisuat(uudai);


        System.out.println("\nAdd new Villa completed!\n");
//        fileCSV.writeSTKFileCSV(stk_daihan, "name");
        themMoiSTK();
    }


    public static void themMoiStkNganhan() {
        StkNganhanCothoihan stk_daihan = new StkNganhanCothoihan();
        System.out.println("Nhập mã số sổ tiết kiệm: ");
        String maSTK;
        do {
            System.out.print("ID: ");
            maSTK = scanner.nextLine();
        } while (!validate.checkMasoStk(maSTK));
        stk_daihan.setMaso(maSTK);

        System.out.println("Nhập mã khách hàng: ");
        String maKH;
        maKH = scanner.nextLine();
        stk_daihan.setMaKH(maKH);

        String ngaymoso;
        do {
            System.out.print("Ngày mở số: ");
            ngaymoso = scanner.nextLine();
        } while (!validate.checkdate(ngaymoso));
        stk_daihan.setNgaymoso(ngaymoso);


        String ngaybatdaugui;
        do {
            System.out.print("Ngày bắt đầu gửi: ");
            ngaybatdaugui = scanner.nextLine();
        } while (!validate.checkdate(ngaybatdaugui));
        stk_daihan.setNgaymoso(ngaybatdaugui);

        String kyhan;
        do {
            System.out.print("kỳ hạn: ");
            kyhan = scanner.nextLine();
        } while (!validate.checkKyhanStkDaihan(kyhan));
        stk_daihan.setKyhan(kyhan);

        String tien;
        do {
            System.out.print("Số tiền gửi: ");
            tien = scanner.nextLine();
        } while (!validate.checkSoTienGui(tien));
        stk_daihan.setSotiengui(tien);

        System.out.println("Nhập lãi suất: ");
        String laisuat;
        laisuat = scanner.nextLine();
        stk_daihan.setLaisuat(laisuat);

        System.out.println("Nhập ưu đãi: ");
        String uudai;
        uudai = scanner.nextLine();
        stk_daihan.setLaisuat(uudai);


        System.out.println("\nAdd new Villa completed!\n");
//        fileCSV.writeSTKFileCSV(stk_daihan, "name");
        themMoiSTK();
    }

    public static void xoaSTK() {
    }

    public static void xemDsSTK() {
        for (Stk stk_daihan : StkDaihan) {
            System.out.println(stk_daihan.toString());
        }
        displayMainMenu();
    }

    public static void timSTK(){}

    public static void xemThongtinKH() {
        Comparator<KhachHang> customerComparator = new CustomerComparator();
        Collections.sort(khachHangList, customerComparator);
        for (KhachHang customer : khachHangList) {
            System.out.println(customer.toString());
        }
        displayMainMenu();
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}



