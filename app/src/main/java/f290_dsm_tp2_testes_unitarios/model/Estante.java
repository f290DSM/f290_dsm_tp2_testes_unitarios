package f290_dsm_tp2_testes_unitarios.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Estante {

    private List<Livro> livros = new ArrayList<>();
    
    List<Livro> getLivros() {
        return livros;
    }

    public void adicionarLivro(Livro... livro) {
        Stream.of(livro).forEach(l -> livros.add(l));
    }
}

