package data;

import java.io.*;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.net.http.HttpClient;
import java.util.zip.GZIPInputStream;

class Read {

    private static final String url = "https://coronavirus.data.gov.uk/api/v1/data?filters=areaType=overview&structure=%7B%22areaType%22:%22areaType%22,%22areaName%22:%22areaName%22,%22areaCode%22:%22areaCode%22,%22date%22:%22date%22,%22newCasesBySpecimenDate%22:%22newCasesBySpecimenDate%22,%22cumCasesBySpecimenDate%22:%22cumCasesBySpecimenDate%22,%22newDeaths28DaysByDeathDate%22:%22newDeaths28DaysByDeathDate%22,%22cumDeaths28DaysByDeathDate%22:%22cumDeaths28DaysByDeathDate%22%7D&format=csv";
    private static final String filename = "resources/data.csv";

    public List<String> x = new ArrayList<>();
    public List<String> y = new ArrayList<>();


    //downloads the csv from location inputted then reads the csv to two lists x and y
    public Read() throws IOException, InterruptedException {
        downloadFile(url, filename);
        CsvReader(filename);
    }

    //prints the contents of the x and the y lists
    public void PrintLists() {
        System.out.println("--cases--");
        for (int i = 0; i < y.size(); i++)
            System.out.println(y.get(i));

        System.out.println("--deaths--");
        for (int i = 0; i < x.size(); i++)
            System.out.println(x.get(i));
    }

    //takes the dates and cumuliative data in the csv and writes them to the x and y lists
    private void CsvReader(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                x.add(values[3]);
                y.add(values[5]);
            }
        }
    }

    //takes the file name and loction as input, goes to the website and downloads the file.
    private void downloadFile(String uri, String filename) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
        if (response.statusCode() != 200) throw new IOException();
        var gzip = new GZIPInputStream(response.body());
        Files.copy(gzip, Path.of(filename), StandardCopyOption.REPLACE_EXISTING);
    }
}
