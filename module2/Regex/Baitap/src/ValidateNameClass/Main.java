package ValidateNameClass;

public class Main {
    private static ValidateNameClass example;
    public static final String[] validName = new String[]{"C0318G", "C0318G"};
    public static final String[] invalidName = new String[]{"M0318G", "P0323A"};

    public static void main(String args[]) {
        example = new ValidateNameClass();
        for (String name : validName) {
            boolean isvalid = example.validate(name);
            System.out.println("Email is " + name + " is valid: " + isvalid);
        }
        for (String name : invalidName) {
            boolean isvalid = example.validate(name);
            System.out.println("Email is " + name + " is valid: " + isvalid);
        }
    }
}

