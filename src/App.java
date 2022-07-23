import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // Fazer uma conexão HTTP e buscar os top 250 Filmes.
        String url = "https://alura-imdb-api.herokuapp.com/movies";
        URI endereco = URI.create(url);
        var Client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build(); // buscar dados de qualquer uri ou url de um serviço http.
        HttpResponse<String> response = Client.send(request, BodyHandlers.ofString());
        String body = response.body();
       


        // Pegar só os dados que interessam (Titulo, poster, classificação).
        var parser = new JsonParser(); // Objeto pra charmar
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        for (Map<String,String> filme : listaDeFilmes)
        {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();

        }

        //System.out.println(listaDeFilmes.size()); // para ver o tamanho da lista tamanho da lista
        //System.out.println(listaDeFilmes.get(0));
        // exibir e manipular os dados.
    }

}
