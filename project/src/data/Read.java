package data;

import java.io.*;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.net.http.HttpClient;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;

class Read {

    public static List<String> dates = new ArrayList<>();
    public static List<String> cases = new ArrayList<>();

    public static void CsvReader(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                dates.add(values[3]);
                cases.add(values[4]);
            }
        }
    }

    public static void downloadFile(String uri, String filename) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
        if (response.statusCode() != 200) throw new IOException();
        var gzip = new GZIPInputStream(response.body());
        Files.copy(gzip, Path.of(filename), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void main(String[] args) {
        String url = "https://coronavirus.data.gov.uk/api/v1/data?filters=areaType=overview&structure=%7B%22areaType%22:%22areaType%22,%22areaName%22:%22areaName%22,%22areaCode%22:%22areaCode%22,%22date%22:%22date%22,%22newDeaths28DaysByDeathDate%22:%22newDeaths28DaysByDeathDate%22,%22cumDeaths28DaysByDeathDate%22:%22cumDeaths28DaysByDeathDate%22%7D&format=csv";
        String url2 = "https://coronavirus.data.gov.uk/api/v1/data?filters=areaType=overview&structure=%7B%22areaType%22:%22areaType%22,%22areaName%22:%22areaName%22,%22areaCode%22:%22areaCode%22,%22date%22:%22date%22,%22newCasesBySpecimenDate%22:%22newCasesBySpecimenDate%22,%22cumCasesBySpecimenDate%22:%22cumCasesBySpecimenDate%22%7D&format=csv";
        try {
            downloadFile(url, "resources/deaths.csv");
            downloadFile(url2, "resources/cases.csv");
        } catch(ZipException e) {
            System.out.println("Failed to extract CSV data due to invalid gzip stream.");
        } catch(IOException e) {
            System.out.println("Failed to get CSV data.");
        } catch(InterruptedException e) {
            System.out.println("CSV data download interrupted.");
        }
        try {
            CsvReader("resources/deaths.csv");
            CsvReader("resources/cases.csv");
        } catch(IOException e) {
            System.out.println("Failed to read CSV data.");
        }
        for (int i = 0; i < cases.size(); i++){
            System.out.println(dates.get(i));
            System.out.println(cases.get(i));
        }
    }
}
