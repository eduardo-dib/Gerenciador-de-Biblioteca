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

    //MÉTODOS PARA BUSCA DE LIVROS
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

    private Livro buscarLivroAdd(String titulo) throws Exception{
        return livros.stream()
        .filter(c -> c.getTitulo().trim().equalsIgnoreCase(titulo.trim()))
        .findFirst()
        .orElse(null);
        
    }

    public Livro buscarLivroTitulo(String titulo) throws Exception{
        Livro livroEncontrado = livros.stream()
        .filter(c -> c.getTitulo().trim().equalsIgnoreCase(titulo.trim()))
        .findFirst()
        .orElse(null);
        if(livroEncontrado == null){
            throw new Exception("Livro com o título: " + titulo + " não foi encontrado" );
        }
        return livroEncontrado;
    };

   

    public List<Livro> buscarLivrosAutor(String autor) throws Exception {
        List<Livro> livrosEncontrados = livros.stream()
                .filter(livro -> livro.getAutor().equalsIgnoreCase(autor.trim()))
                .collect(Collectors.toList());
    
        if (livrosEncontrados.isEmpty()) {
            throw new Exception("Nenhum livro encontrado para o autor(a): " + autor);
        }
    
        return livrosEncontrados;
    }

    public List<Livro> buscarLivrosCategoria(String categoria) throws Exception {
        List<Livro> livrosEncontrados = livros.stream()
                .filter(livro -> livro.getCategoria().trim().equalsIgnoreCase(categoria.trim()))
                .collect(Collectors.toList());
    
        if (livrosEncontrados.isEmpty()) {
            throw new Exception("Nenhum livro encontrado para a categoria: " + categoria);
        }
    
        return livrosEncontrados;
    }
    //CADASTRO DE LIVROS
    public void adicionarLivro(Livro livro) throws Exception{
        if (buscarLivroAdd(livro.getTitulo()) != null) {
            throw new Exception("Livro com o nome " + livro.getTitulo() + " já está cadastrado.");
        }
        livros.add(livro);
        
    }
    //RELATÓRIOS
    public List<Livro> listarLivrosPopularidade() {
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


