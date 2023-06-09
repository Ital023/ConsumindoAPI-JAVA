import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        ApiOmdb apiOmdbUser = new ApiOmdb("57b012a6");
        System.out.print("Insira o nome do filme: ");
        String filme = sc.nextLine();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiOmdbUser.gerandoApiRequest(filme))).build();

        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        TituloOmdb meuTituloOmdb = gson.fromJson(json,TituloOmdb.class);

        Titulo meuTitulo = new Titulo(meuTituloOmdb);

        System.out.println(meuTitulo);
    }
}
