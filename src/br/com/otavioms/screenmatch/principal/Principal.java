package br.com.otavioms.screenmatch.principal;

import br.com.otavioms.screenmatch.calculos.CalculadoraDeTempo;
import br.com.otavioms.screenmatch.calculos.FiltroRecomendacao;
import br.com.otavioms.screenmatch.modelos.Episodio;
import br.com.otavioms.screenmatch.modelos.Filme;
import br.com.otavioms.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        Filme filme1 = new Filme("Uma Noite de Crime", 2013);
        filme1.setDuracaoEmMinutos(86);
        filme1.setIncluidoNoPlano(true);
        filme1.avalia(10);
        filme1.avalia(10);
        filme1.avalia(10);
        filme1.exibeFichaTecnica();

        Serie serie1 = new Serie("The walking dead", 2010);
        serie1.exibeFichaTecnica();
        serie1.setTemporadas(12);
        serie1.setEpisodiosPorTemporada(10);
        serie1.setMinutosPorEpisodio(50);
        System.out.println("Duração para maranotonar a serie: " + serie1.getDuracaoEmMinutos());
        serie1.avalia(8.5);
        serie1.avalia(8);
        serie1.avalia(7);

        Filme filme2 = new Filme("Avatar: O Camindo da Água", 2022);
        filme2.setDuracaoEmMinutos(192);
        filme2.setIncluidoNoPlano(true);
        filme2.avalia(7.5);
        filme2.avalia(6.5);
        filme2.avalia(8);
        filme2.exibeFichaTecnica();

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        System.out.println(calculadora.getTempoTotal());

        Episodio episodio1 = new Episodio();
        episodio1.setNumero(1);
        episodio1.setSerie(serie1);
        episodio1.setTotalVizualizacoes(300);

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(filme1);
        filtro.filtra(filme2);
        filtro.filtra(serie1);
        filtro.filtra(episodio1);

        var filme3 = new Filme("Gato de Botas 2: O Último Pedido", 2022);
        filme3.setDuracaoEmMinutos(100);
        filme3.setIncluidoNoPlano(true);
        filme3.avalia(8);
        filme3.avalia(7);
        filme3.avalia(7.7);
        filme3.exibeFichaTecnica();

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filme1);
        listaDeFilmes.add(filme2);
        listaDeFilmes.add(filme3);

        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
        System.out.println(listaDeFilmes.get(0).toString());

    }
}