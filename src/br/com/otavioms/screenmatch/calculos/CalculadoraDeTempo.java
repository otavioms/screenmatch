package br.com.otavioms.screenmatch.calculos;

import br.com.otavioms.screenmatch.modelos.Filme;
import br.com.otavioms.screenmatch.modelos.Serie;
import br.com.otavioms.screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

    /*
        public void inclui(Filme f) {
            tempoTotal += f.getDuracaoEmMinutos();
        }

        public void inclui(Serie s) {
            tempoTotal += s.getDuracaoEmMinutos();
        }
     */
    public void inclui(Titulo titulo) {
        System.out.println("Adicionando duração em minutos de: " + titulo);
        tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
