package br.com.otavioms.screenmatch.principal;

import br.com.otavioms.screenmatch.excecao.ErroDeConversaoException;
import br.com.otavioms.screenmatch.modelos.Titulo;
import br.com.otavioms.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o filme que desjesa procurar");
        String busca = leitor.nextLine();
        String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=1ba307af";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

            TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(tituloOmdb);
            //try {
            Titulo titulo = new Titulo(tituloOmdb);
            System.out.println(titulo);
        } catch (NumberFormatException e){
            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("Algum erro no argumento de busca, verifique o endereço!");
            System.out.println(e.getMessage());
        } catch (ErroDeConversaoException e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Porgrama finalizado!");
        }
    }
}
