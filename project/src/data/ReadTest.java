package data;

import java.io.IOException;
import java.util.zip.ZipException;

public class ReadTest {
    public static void main(String[] args) {
        try {
            Read cases = new Read();
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
