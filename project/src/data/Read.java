package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class Read {

    public static List<String> dates = new ArrayList<>();
    public static List<String> cases = new ArrayList<>();

    public static void CsvReader(String filename) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                dates.add(values[3]);
                cases.add(values[4]);
            }
        }
    }

    public static void downloadFile(URL url, String fileName) throws Exception {
        try (InputStream in = url.openStream()) {
            Files.copy(in, Paths.get(fileName));
        }
    }

    public static void main(String[] args) throws Exception {
        //URL url = new URL("https://coronavirus.data.gov.uk/api/v1/data?filters=areaType=overview&structure=%7B%22areaType%22:%22areaType%22,%22areaName%22:%22areaName%22,%22areaCode%22:%22areaCode%22,%22date%22:%22date%22,%22newDeaths28DaysByDeathDate%22:%22newDeaths28DaysByDeathDate%22,%22cumDeaths28DaysByDeathDate%22:%22cumDeaths28DaysByDeathDate%22%7D&format=csv");
        //URL url2 = new URL("https://coronavirus.data.gov.uk/api/v1/data?filters=areaType=overview&structure=%7B%22areaType%22:%22areaType%22,%22areaName%22:%22areaName%22,%22areaCode%22:%22areaCode%22,%22date%22:%22date%22,%22newCasesBySpecimenDate%22:%22newCasesBySpecimenDate%22,%22cumCasesBySpecimenDate%22:%22cumCasesBySpecimenDate%22%7D&format=csv");
        //downloadFile(url, "data_2021-Nov-03.csv");
        //(new File("data_2021-Nov-03.csv")).renameTo(new File("deaths.csv"));
        //downloadFile(url2, "data_2021-Nov-03.csv");
        //(new File("data_2021-Nov-03.csv")).renameTo(new File("cases.csv"));
        CsvReader("cases.csv");
        for (int i = 0; i < cases.size(); i++){
            System.out.println(dates.get(i));
            System.out.println(cases.get(i));
        }
    }
}
