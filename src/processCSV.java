import java.io.*;

public class processCSV {
    private static String compare(String filePath1, String filePath2) throws IOException {
        // reads the files at the path
        BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
        BufferedReader reader2 = new BufferedReader(new FileReader(filePath2));
        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
        StringBuilder out = new StringBuilder();
        // header1 and header2 used to denote diff in returned string
        String hd1 = "\"First File\",";
        String hd2 = ",\"Second File\",";
        out.append(hd1).append(line1).append(hd2).append(line2).append("\n");
        while (line1 != null || line2 != null) {
            // first if and else if statement are to check if file 1 or file 2 terminates before the other
            // Thus the for loop is to ensure the rows are aligned and indicate that the entry is missing in one of the csv files
            if (line1 == null) {
                String[] arrOfline2 = line2.split(",");
                out.append(hd1);
                for (int i=0; i<arrOfline2.length; i++){
                    out.append("None,");
                }
                out.append(hd2).append(line2).append("\n");
            } else if(line2 == null){
                out.append(hd1).append(line1).append(hd2);
                String[] arrOfline1 = line1.split(",");
                for (int i=0; i<arrOfline1.length; i++){
                    if (i == arrOfline1.length - 1){
                        out.append("None").append("\n");
                    }else {
                        out.append("None,");
                    }
                }
                break;
            }
            else if (!line1.equals(line2)) {
                out.append(hd1).append(line1).append(hd2).append(line2).append("\n");
            }
            line1 = reader1.readLine();
            line2 = reader2.readLine();
        }
        return out.toString();
    }

    public static void overall(String filePath1, String filePath2, String filePathOut) throws IOException {
        String out = null;

        try {
            out = compare(filePath1, filePath2);
            System.out.println(out);
        } catch (IOException e) {
            System.out.println("Comparison Failed, file path invalid");
            e.printStackTrace();
        }

        // attempts to create a new file
        try {
            File myObj = new File(filePathOut);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists, overwriting...");
            }
        } catch (IOException e) {
            System.out.println("Creation of File Failed");
            e.printStackTrace();
        }
        // attempts to write to new file
        try {
            FileWriter myWriter = new FileWriter(filePathOut);
            myWriter.write(out);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        // Custom input file path stored in string type. Change strings below to alter the end result
        String filePath1 = "sample_file_1.csv";
        String filePath2 = "sample_file_3.csv";
        String filePathOut = "errors_found.csv";

        processCSV.overall(filePath1, filePath2, filePathOut);

    }
}

