package ValidateNameClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNameClass {
    /*Không chứa các ký tự đặc biệt
      Phải dài hơn 6 ký tự
      Không chứa các ký tự viết hoa
      Cho phép dấu gạch dưới (_)
    */
    private static final String NAMECLASS_REGEX = "^[ACP][0-9]{4}[GHIKLM]$";

    public ValidateNameClass() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(NAMECLASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}

