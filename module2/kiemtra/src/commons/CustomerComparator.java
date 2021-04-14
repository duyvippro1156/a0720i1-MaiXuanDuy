package commons;

import models.*;

import java.util.Comparator;

public class CustomerComparator implements Comparator<KhachHang> {
    @Override
    public int compare(KhachHang customer1, KhachHang customer2) {
        int result = customer1.getTenKH().compareTo(customer2.getTenKH());
        if (result == 0) {
            return customer1.getNgaysinh().compareTo(customer2.getNgaysinh());
        } else {
            return result;
        }
    }
}
