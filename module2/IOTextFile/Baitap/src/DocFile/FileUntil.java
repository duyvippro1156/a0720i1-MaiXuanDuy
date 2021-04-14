package DocFile;

import java.io.*;


public class FileUntil {
    public static final String FILE_PATH = "E:\\codegym\\module2\\IOTextFile\\Baitap\\src\\DocFile\\country.csv";
    public static final String COMMA = ",";

    public static void main(String[] args) {
        String csvFile = FILE_PATH;
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] country = line.split(COMMA);
                System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}


