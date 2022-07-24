import static org.junit.Assert.*;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class processCSVTest {
    @Test
    public void testInvalidFile() {
        processCSV tester = new processCSV();

//        Invalid Files Test
        String notCSVFilePath1 = "Campaign Mini Project Test/InvalidFiles/notCSV1.txt";
        String notCSVFilePath2 = "Campaign Mini Project Test/InvalidFiles/notCSV2.txt";
        String notCSVFilePathOut = "Campaign Mini Project Test/InvalidFiles/notCSVOut.txt";
        try {
            tester.overall(notCSVFilePath1, notCSVFilePath2, notCSVFilePathOut);
        } catch (IOException e) {
            System.out.println("Invalid File Test Unsuccessful");
            e.printStackTrace();
        }
    }

    @Test
    public void testValidFile() {
        processCSV tester = new processCSV();
//        Valid File Test
        String validFilePathAllSame1 = "Campaign Mini Project Test/ValidFiles/AllSame1.CSV";
        String validFilePathAllSame2 = "Campaign Mini Project Test/ValidFiles/AllSame2.CSV";
        String validFilePathAllSameOut = "Campaign Mini Project Test/ValidFiles/AllSameOut.CSV";
        try {
            tester.overall(validFilePathAllSame1, validFilePathAllSame2, validFilePathAllSameOut);
            BufferedReader reader = new BufferedReader(new FileReader(validFilePathAllSameOut));
            String line = reader.readLine();
            int count = 0;
            while(line != null){
                count++;
                line = reader.readLine();
            }
            assert (count == 1);
        } catch (IOException e) {
            System.out.println("Valid File Test, All Same, Unsuccessful");
            e.printStackTrace();
        }

        String validFilePathHalfSame1 = "Campaign Mini Project Test/ValidFiles/HalfSame1.CSV";
        String validFilePathHalfSame2 = "Campaign Mini Project Test/ValidFiles/HalfSame2.CSV";
        String validFilePathHalfSameOut = "Campaign Mini Project Test/ValidFiles/HalfSameOut.CSV";
        try {
            tester.overall(validFilePathHalfSame1, validFilePathHalfSame2, validFilePathHalfSameOut);
            BufferedReader reader1 = new BufferedReader(new FileReader(validFilePathHalfSame1));
            String line1 = reader1.readLine();

            BufferedReader readerOut = new BufferedReader(new FileReader(validFilePathHalfSameOut));
            String lineOut = readerOut.readLine();

            int count1 = 0;
            int countOut = 0;

            while(line1 != null){
                count1++;
                line1 = reader1.readLine();
                if(lineOut != null){
                    countOut++;
                    lineOut = readerOut.readLine();
                }
            }
            assert ((count1-1)/2 == countOut-1);
        } catch (IOException e) {
            System.out.println("Half Same Test Unsuccessful");
            e.printStackTrace();
        }

        String validFilePathNoSame1 = "Campaign Mini Project Test/ValidFiles/NoSame1.CSV";
        String validFilePathNoSame2 = "Campaign Mini Project Test/ValidFiles/NoSame2.CSV";
        String validFilePathNoSameOut = "Campaign Mini Project Test/ValidFiles/NoSameOut.CSV";
        try {
            tester.overall(validFilePathNoSame1, validFilePathNoSame2, validFilePathNoSameOut);
            BufferedReader reader1 = new BufferedReader(new FileReader(validFilePathNoSame1));
            String line1 = reader1.readLine();

            BufferedReader readerOut = new BufferedReader(new FileReader(validFilePathNoSameOut));
            String lineOut = readerOut.readLine();

            int count1 = 0;
            int countOut = 0;

            while(line1 != null){
                count1++;
                line1 = reader1.readLine();
                if(lineOut != null){
                    countOut++;
                    lineOut = readerOut.readLine();
                }
            }
            assert (count1 == countOut);
        } catch (IOException e) {
            System.out.println("No Same Test Unsuccessful");
            e.printStackTrace();
        }


    }

    @Test
    public void DifferentLengths() {
        processCSV tester = new processCSV();

//        Invalid Files Test
        String empty = "Campaign Mini Project Test/DifferentLengths/empty.CSV";
        String file = "Campaign Mini Project Test/DifferentLengths/file.CSV";
        String oneFileEmptyOut = "Campaign Mini Project Test/DifferentLengths/oneFileEmptyOut.CSV";
        try {
            tester.overall(empty, file, oneFileEmptyOut);
            BufferedReader readerEmpty = new BufferedReader(new FileReader(empty));
            String lineEmpty = readerEmpty.readLine();

            BufferedReader readerFile = new BufferedReader(new FileReader(file));
            String lineFile = readerFile.readLine();

            BufferedReader readerOut = new BufferedReader(new FileReader(oneFileEmptyOut));
            String lineOut = readerOut.readLine();

            int countEmpty = 0;
            int countFile = 0;
            int countOut = 0;

            while(lineEmpty != null || lineFile != null || lineOut != null){
                if(lineEmpty != null){
                    countEmpty++;
                    lineEmpty = readerEmpty.readLine();
                }
                if(lineFile != null){
                    countFile++;
                    lineFile = readerFile.readLine();
                }
                if(lineOut != null){
                    countOut++;
                    lineOut = readerOut.readLine();
                }
            }
            assert (countEmpty == 1 && countFile == countOut);
        } catch (IOException e) {
            System.out.println("One Empty File Test Unsuccessful");
            e.printStackTrace();
        }

        String halfFile = "Campaign Mini Project Test/DifferentLengths/halfFile.CSV";
//        String file = "Campaign Mini Project Test/DifferentLengths/file.CSV"; The Same Variable of File is Used
        String oneFileHalfEmptyOut = "Campaign Mini Project Test/DifferentLengths/oneFileEmptyOut.CSV";
        try {
            tester.overall(halfFile, file, oneFileHalfEmptyOut);
            BufferedReader readerhalfFile = new BufferedReader(new FileReader(halfFile));
            String lineHalfFile = readerhalfFile.readLine();

            BufferedReader readerFile = new BufferedReader(new FileReader(file));
            String lineFile = readerFile.readLine();

            BufferedReader readerOut = new BufferedReader(new FileReader(oneFileHalfEmptyOut));
            String lineOut = readerOut.readLine();

            int countHalfEmpty = 0;
            int countFile = 0;
            int countOut = 0;

            while(lineHalfFile != null || lineFile != null || lineOut != null){
                if(lineHalfFile != null){
                    countHalfEmpty++;
                    lineHalfFile = readerhalfFile.readLine();
                }
                if(lineFile != null){
                    countFile++;
                    lineFile = readerFile.readLine();
                }
                if(lineOut != null){
                    countOut++;
                    lineOut = readerOut.readLine();
                }
            }
            assert (countHalfEmpty == countOut && (countFile-1)/2 == countOut-1);
        } catch (IOException e) {
            System.out.println("One Empty File Test Unsuccessful");
            e.printStackTrace();
        }

//        For this test case, it is assumed that all other things in RandFile1 and 2 are the same
        String RandFile1 = "Campaign Mini Project Test/DifferentLengths/RandFile1.CSV";
        String RandFile2 = "Campaign Mini Project Test/DifferentLengths/RandFile2.CSV";
        String oneFileRandEmptyOut = "Campaign Mini Project Test/DifferentLengths/oneFileRandEmptyOut.CSV";
        try {
            tester.overall(RandFile1, RandFile2, oneFileRandEmptyOut);

            BufferedReader readerRandFile1 = new BufferedReader(new FileReader(RandFile1));
            String lineRandFile1 = readerRandFile1.readLine();

            BufferedReader readerRandFile2 = new BufferedReader(new FileReader(RandFile2));
            String lineRandFile2 = readerRandFile2.readLine();

            BufferedReader readerOut = new BufferedReader(new FileReader(oneFileRandEmptyOut));
            String lineOut = readerOut.readLine();

            int countEmptyLines = 0;
            int countOut = 0;

            while(lineRandFile1 != null || lineRandFile2 != null || lineOut != null){
                countOut++;
                if (lineRandFile1 == null || lineRandFile2 == null){
                    countEmptyLines++;
                }
            }
            assert (countEmptyLines==countOut);
        } catch (IOException e) {
            System.out.println("One Empty File Test Unsuccessful");
            e.printStackTrace();
        }
    }

    @Test
    public void DifferentVariables() {
        processCSV tester = new processCSV();

//        Invalid Files Test
        String DifferentVariables1 = "Campaign Mini Project Test/DifferentVariables/DiffVariables1.CSV";
        String DifferentVariables2 = "Campaign Mini Project Test/DifferentVariables/DiffVariables2.CSV";
        String DifferentVariablesOut = "Campaign Mini Project Test/DifferentVariables/DiffVariablesOut.CSV";
        try {
            tester.overall(DifferentVariables1, DifferentVariables2, DifferentVariablesOut);
            BufferedReader reader1 = new BufferedReader(new FileReader(DifferentVariables1));
            String line1 = reader1.readLine();

            BufferedReader reader2 = new BufferedReader(new FileReader(DifferentVariables2));
            String line2 = reader2.readLine();

            BufferedReader readerOut = new BufferedReader(new FileReader(DifferentVariablesOut));
            String lineOut = readerOut.readLine();

            int count1 = 0;
            int count2 = 0;
            int countOut = 0;

            while(line1 != null || line2 != null || lineOut != null){
                if(line1 != null){
                    count2++;
                    line2 = reader2.readLine();
                }
                if(line2 != null){
                    count2++;
                    line2 = reader2.readLine();
                }
                if(lineOut != null){
                    countOut++;
                    lineOut = readerOut.readLine();
                }
            }
            assert (count1 == countOut && count2 == countOut);
        } catch (IOException e) {
            System.out.println("Invalid File Test Unsuccessful");
            e.printStackTrace();
        }
    }
}