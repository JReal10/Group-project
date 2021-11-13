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

    public static List<String> x = new ArrayList<>();
    public static List<String> y = new ArrayList<>();


    //downloads the csv from location inputted then reads the csv to two lists x and y
    public Read(String url, String fileName) throws Exception{
        downloadFile(url, "resources/"+fileName);
        CsvReader("resources/"+fileName);
    }

    //prints the contents of the x and the y lists
    public void PrintLists(){
        System.out.println("--cases--");
        for (int i = 0; i < y.size(); i++)
            System.out.println(y.get(i));

        System.out.println("--deaths--");
        for (int i = 0; i < x.size(); i++)
            System.out.println(x.get(i));
    }

    //takes the dates and cumuliative data in the csv and writes them to the x and y lists
    public static void CsvReader(String filename) throws IOException {
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
    public static void downloadFile(String uri, String filename) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
        if (response.statusCode() != 200) throw new IOException();
        var gzip = new GZIPInputStream(response.body());
        Files.copy(gzip, Path.of(filename), StandardCopyOption.REPLACE_EXISTING);
    }
}
