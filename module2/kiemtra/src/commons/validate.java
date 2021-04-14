package commons;

import exeption.BirthdayException;



public class validate {
    private static String regex = "";
    public static boolean checkMasoStk(String id) {
        regex = "[S][T][K][-]\\d{4}";
        return id.matches(regex);
    }

    public static boolean checkKyhanStkDaihan(String kyhan) {
        regex = "(1 năm)|(3 năm)|(5 năm)|(10 năm)";
        return kyhan.matches(regex);
    }

    public static boolean checkKyhanStkNganhan(String kyhan) {
        regex = "(3 tháng)|(6 tháng)";
        return kyhan.matches(regex);
    }

    public static boolean checkSoTienGui(String sotien){
        int capacityNumber;
        try {
            capacityNumber = Integer.parseInt(sotien);
            if (capacityNumber > 1000000){
                return true;
            } else return false;
        } catch (Exception e){
            return false;
        }
    }

    public static boolean checkdate(String str) {
        String regex = "^[\\d]{2}\\/[\\d]{2}\\/[\\d]{4}$";
        boolean check = str.matches(regex);
        try {
            if (check) {
                int day = Integer.parseInt(str.substring(0, 2));
                int month = Integer.parseInt(str.substring(3, 5));
                int year = Integer.parseInt(str.substring(6, 10));
                if (year <= 1900) {
                    throw new BirthdayException("The year of birthday must be greater than 1900");
                }
            } else {
                throw new BirthdayException("Invalid date. Please input again (Birthday format: dd/mm/yyyy)");
            }
        } catch (BirthdayException e) {
            System.out.println(e.getMessage());
            check = false;
        }
        return check;
    }

}
