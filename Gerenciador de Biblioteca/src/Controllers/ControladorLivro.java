package Controllers;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import Models.Livro.*;

public class ControladorLivro{
    

    private List <Livro> livros;

    public ControladorLivro(){
        this.livros = new LinkedList<>();
    }


    public Livro buscarLivroCod(int cod) throws Exception{
        Livro livroEncontrado = livros.stream().
        filter(c -> c.getCod() == cod).
        findFirst().
        orElse(null);
        if(livroEncontrado == null){
            throw new Exception("Livro com o código: " + cod + " não foi encontrado" );
        }
        return livroEncontrado;
    }

    private Livro buscarLivroAdd(String titulo){
        return livros.stream()
        .filter(c -> c.getTitulo() == titulo)
        .findFirst().
         orElse(null);
    }

    public Livro buscarLivroTitulo(String titulo) throws Exception{
        Livro livroEncontrado = livros.stream().
        filter(c -> c.getTitulo() == titulo).
        findFirst().
        orElse(null);
        if(livroEncontrado == null){
            throw new Exception("Livro com o título: " + titulo + " não foi encontrado" );
        }
        return livroEncontrado;
    };

   

    public List<Livro> buscarLivrosAutor(String autor) throws Exception {
        List<Livro> livrosEncontrados = livros.stream()
                .filter(livro -> livro.getAutor().equals(autor))
                .collect(Collectors.toList());
    
        if (livrosEncontrados.isEmpty()) {
            throw new Exception("Nenhum livro encontrado para o autor: " + autor);
        }
    
        return livrosEncontrados;
    }

    public List<Livro> buscarLivrosCategoria(String categoria) throws Exception {
        List<Livro> livrosEncontrados = livros.stream()
                .filter(livro -> livro.getCategoria().equals(categoria))
                .collect(Collectors.toList());
    
        if (livrosEncontrados.isEmpty()) {
            throw new Exception("Nenhum livro encontrado para o categoria: " + categoria);
        }
    
        return livrosEncontrados;
    }

    public void adicionarLivro(Livro livro) throws Exception{
        if (buscarLivroAdd(livro.getTitulo()) != null) {
            throw new Exception("Livro com o nome " + livro.getTitulo() + " já está cadastrado.");
        }
        livros.add(livro);
        
    }

    
    public List<Livro> listarLivrosOrdenadosPorQuantidade() {
        return livros.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Livro> listarTodosOsLivros() {
    return livros.stream()
            .sorted(Comparator.comparing(Livro::getCod))
            .collect(Collectors.toList());
}

    
    @Override
    public String toString() {
        return "Livros=" + livros;
    }

}
