package br.com.otavioms.screenmatch.principal;

import br.com.otavioms.screenmatch.modelos.Filme;
import br.com.otavioms.screenmatch.modelos.Serie;
import br.com.otavioms.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme filme1 = new Filme("Uma Noite de Crime", 2013);
        filme1.avalia(10);
        Filme filme2 = new Filme("Avatar: O Camindo da Água", 2022);
        filme2.avalia(8.8);
        var filme3 = new Filme("Gato de Botas 2: O Último Pedido", 2022);
        filme3.avalia(9.3);
        Serie serie1 = new Serie("The walking dead", 2010);
        serie1.avalia(7);

        List<Titulo> lista = new LinkedList<>();
        lista.add(filme1);
        lista.add(filme2);
        lista.add(filme3);
        lista.add(serie1);
        for (Titulo item : lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme) {
                Filme filme = (Filme) item;
                System.out.println("Classificação: " + filme.getClassificacao());
            } else if (item instanceof Serie) {
                Serie serie = (Serie) item;
                System.out.println("Classificação: " + serie.getClassificacao());
            }

        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Otávio Medeiros");
        buscaPorArtista.add("Maria Clara");
        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);
        System.out.println("Depois da ordenação: " + buscaPorArtista);

        Collections.sort(lista);
        System.out.println("Lista de títulos ordenado: " + lista);
        //Comparator.comparing serve para comparar sem mudar o
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Lista ordenada por ano de lançamento: " + lista);
    }
}
