package commons;

import models.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class fileCSV {


    private static final String NEW_LINE_SEPARATOR = "\n";

    private static final String HEADER_STKDAIHAN = "Mã số sổ, mã khách hàng, ngày mở sổ, ngày bắt đầu gửi, số tiền gửi, lãi suất, Kỳ hạn, Ưu đãi";
    private static final String HEADER_STKNGANHAN = "Mã số sổ, mã khách hàng, ngày mở sổ, ngày bắt đầu gửi, số tiền gửi, lãi suất, Kỳ hạn (Nếu là sổ có thời hạn)";
    private static final String FILE_STKDAIHAN = "src/data/stkdaihan.csv";
    private static final String FILE_STKNGANHAN = "src/data/stknganhan.csv";
    private static final String FILE_CUSTOMER = "src/data/khachhang.csv";

    public static <stk_daihan> void writeSTKFileCSV(List<stk_daihan> list, String value) {
        FileWriter fileWriter = null;

        try {
            if (value.equals("stkdaihan")) {
                fileWriter = new FileWriter(FILE_STKDAIHAN);
                fileWriter.append(HEADER_STKDAIHAN);
                fileWriter.append(NEW_LINE_SEPARATOR);
            } else if (value.equals("stknganhan")) {
                fileWriter = new FileWriter(FILE_STKNGANHAN);
                fileWriter.append(HEADER_STKNGANHAN);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            for (stk_daihan t : list) {
                fileWriter.append(t.toString());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception ex) {
            System.out.println("ERROR IN WRITE SERVICES TO FILE CSV");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception ex) {
                System.out.println("ERROR WHEN FLUSH OR CLOSE FILE CSV");
            }
        }
    }

    public static List<StkDaihan> readStkFileCSV(String value) {
        BufferedReader brReader = null;
        List<StkDaihan> list = new ArrayList<>();
        String filePath = null;
        filePath = FILE_STKDAIHAN;
        // check file is exit
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(filePath);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        try {
            brReader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = brReader.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("Name")) {
                    continue;
                }
                StkDaihan sktdh = new StkDaihan();
                sktdh.setMaso(splitData[0]);
                sktdh.setMaKH(splitData[1]);
                sktdh.setNgaymoso(splitData[2]);
                sktdh.setNgaybatdau(splitData[3]);
                sktdh.setSotiengui(splitData[4]);
                sktdh.setLaisuat(splitData[5]);
                list.add(sktdh);
            }
        } catch (Exception ex) {
            System.out.println("Error When Read File CSV");
        } finally {
            try {
                brReader.close();
            } catch (Exception ex) {
                System.out.println("Error In Close BufferedReader");
            }
        }
        return list;
    }

    public static List<StkNganhanCothoihan> readStkNhFileCSV(String value) {
        BufferedReader brReader = null;
        List<StkNganhanCothoihan> list = new ArrayList<>();
        String filePath = null;
        filePath = FILE_STKDAIHAN;
        // check file is exit
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(filePath);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        try {
            brReader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = brReader.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("Name")) {
                    continue;
                }
                StkNganhanCothoihan sktnh = new StkNganhanCothoihan();
                sktnh.setMaso(splitData[0]);
                sktnh.setMaKH(splitData[1]);
                sktnh.setNgaymoso(splitData[2]);
                sktnh.setNgaybatdau(splitData[3]);
                sktnh.setSotiengui(splitData[4]);
                sktnh.setLaisuat(splitData[5]);
                list.add(sktnh);
            }
        } catch (Exception ex) {
            System.out.println("Error When Read File CSV");
        } finally {
            try {
                brReader.close();
            } catch (Exception ex) {
                System.out.println("Error In Close BufferedReader");
            }
        }
        return list;
    }

    public static void writeFileCustomerToCSV(List<KhachHang> listCustomer) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(FILE_CUSTOMER);
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (KhachHang customer : listCustomer) {
                fileWriter.append(customer.toString());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception ex) {
            System.out.println("ERROR IN WRITE CUSTOMER TO FILE CSV");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception ex) {
                System.out.println("ERROR WHEN FLUSH OR CLOSE FILE CSV");
            }
        }
    }


    public static Map<String, KhachHang> readFileKhachhang() {
        BufferedReader brReader = null;
        Map<String, KhachHang> khachhangMap = new LinkedHashMap<>();
        Path path = Paths.get(FILE_CUSTOMER);

        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(FILE_CUSTOMER);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        try {
            brReader = new BufferedReader(new FileReader(FILE_CUSTOMER));
            String line;
            while ((line = brReader.readLine()) != null) {
                String[] splitdata = line.split(",");
                if (splitdata[0].equals("Name")) {
                    continue;
                }
                KhachHang khachhang = new KhachHang();
                khachhang.setMaKH(splitdata[0]);
                khachhang.setTenKH(splitdata[1]);
                khachhang.setNgaysinh(splitdata[2]);
                khachhang.setGioitinh(splitdata[3]);
                khachhang.setSdt(splitdata[4]);
                khachhang.setDiachi(splitdata[5]);
                String makhachhang = String.format("%d", khachhangMap.size() + 1);
                khachhangMap.put(makhachhang, khachhang);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                brReader.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return khachhangMap;
    }
}
