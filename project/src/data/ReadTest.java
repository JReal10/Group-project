package data;

import java.io.IOException;
import java.util.zip.ZipException;

public class ReadTest {
    public static void main(String[] args) {
        String url = "https://coronavirus.data.gov.uk/api/v1/data?filters=areaType=overview&structure=%7B%22areaType%22:%22areaType%22,%22areaName%22:%22areaName%22,%22areaCode%22:%22areaCode%22,%22date%22:%22date%22,%22newCasesBySpecimenDate%22:%22newCasesBySpecimenDate%22,%22cumCasesBySpecimenDate%22:%22cumCasesBySpecimenDate%22%7D&format=csv";
        try {
            Read cases = new Read(url, "resources/deaths.csv");
            cases.PrintLists();
        } catch(ZipException e) {
            System.out.println("Failed to extract CSV data due to invalid gzip stream.");
        } catch(IOException e) {
            System.out.println("Failed to get CSV data.");
        } catch(InterruptedException e) {
            System.out.println("CSV data download/read interrupted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
