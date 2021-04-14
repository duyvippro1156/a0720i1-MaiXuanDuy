package ValidatePhoneNumber;


public class Main {
    private static Example example;
    public static final String[] validPhoneNumber = new String[]{"(84)-(0978489648)"};
    public static final String[] invalidPhoneNumber = new String[]{"(a8)-(22222222)"};

    public static void main(String args[]) {
        example = new Example();
        for (String phoneNumber : validPhoneNumber) {
            boolean isvalid = example.validate(phoneNumber);
            System.out.println("Email is " + phoneNumber + " is valid: " + isvalid);
        }
        for (String phoneNumber : invalidPhoneNumber) {
            boolean isvalid = example.validate(phoneNumber);
            System.out.println("Email is " + phoneNumber + " is valid: " + isvalid);
        }
    }
}


