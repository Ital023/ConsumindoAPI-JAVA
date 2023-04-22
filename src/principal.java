import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        String apiKey = "57b012a6";
        Scanner sc = new Scanner(System.in);

        System.out.print("Insira o nome do filme: ");
        String filme = sc.nextLine();

        String endereco = "http://www.omdbapi.com/?t="+filme+"&apikey="+apiKey;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();

        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());


    }
}
