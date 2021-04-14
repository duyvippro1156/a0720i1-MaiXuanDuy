package CrawlTintuc;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.regex.*;

public class CrawlTintuc {
    public static void main(String[] args) {
        try {
            // Code here
            URL url = new URL("https://dantri.com.vn/the-gioi.htm ");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("\\R", "");
            Pattern p = Pattern.compile("<h3 class='news-item__title'> {20}<a {2}data-utm=\"(.*?)\" {2}href=\"(.*?)\" {2}title=\"(.*?)\">");
            Matcher m = p.matcher(content);
            System.out.println(content);
            while (m.find()) {
                System.out.println(m.group(3));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

