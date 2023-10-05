package br.com.otavioms.screenmatch.modelos;

import br.com.otavioms.screenmatch.excecao.ErroDeConversaoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    @SerializedName("Title")
    private String nome;
    @SerializedName("Year")
    private int anoDeLancamento;
    private int duracaoEmMinutos;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb tituloOmdb) {
        this.nome = tituloOmdb.title();
        if (tituloOmdb.year().length() > 4){
            throw new ErroDeConversaoException("Não conseguiu converter o ano, porque tem mais de 4 caracteres");

        }
        this.anoDeLancamento = Integer.valueOf(tituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(tituloOmdb.runtime().substring(0, 3));

    }

    public String getNome() {
        return this.nome;
    }

    public int getAnoDeLancamento() {
        return this.anoDeLancamento;
    }

    public int getDuracaoEmMinutos() {
        return this.duracaoEmMinutos;
    }

    public boolean isIncluidoNoPlano() {
        return this.incluidoNoPlano;
    }

    public int getTotalDeAvaliacoes() {
        return this.totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void exibeFichaTecnica() {
        System.out.println("*******************************************************************************************");
        System.out.println("Nome do filme:                  " + nome);
        System.out.println("Ano de lançamento:              " + anoDeLancamento);
        System.out.println("Duração em minutos:             " + duracaoEmMinutos);
        System.out.println("Incluído no plano:              " + incluidoNoPlano);
        System.out.println("Média de avaliações do filme:   " + pegaMedia());
        System.out.println("*******************************************************************************************");
    }

    public void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia() {
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "Titulo Pesquisado:" +
                "\nNome = " + nome +
                "\nAno De Lancamento = " + anoDeLancamento +
                "\nDuracao Em Minutos = " + duracaoEmMinutos;
    }
}
