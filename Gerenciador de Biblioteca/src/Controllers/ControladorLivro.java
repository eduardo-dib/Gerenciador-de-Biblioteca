package Controllers;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import Models.Livro.*;

public class ControladorLivro{
    

    private List <Livro> livros;

    public ControladorLivro(){
        this.livros = new LinkedList<>();
    }

    public void cadastrarLivro(){

    }

    public Livro buscarLivroCod(int cod) throws Exception{
        Livro livroEncontrado = livros.stream().
        filter(c -> c.getCod() == cod).
        findFirst().
        orElse(null);
        if (livroEncontrado == null) {
        throw new Exception("Livro com código " + cod + " não encontrado.");
    }
    return livroEncontrado;
    }

    public Livro buscarLivroTitulo(String titulo) throws Exception{
        Livro livroEncontrado = livros.stream().
        filter(n -> n.getTitulo() == titulo).
        findFirst().
        orElse(null);
        if (livroEncontrado == null) {
        throw new Exception("Livro com título " + titulo + " não encontrado.");
    }
    return livroEncontrado;
    }

    public List<Livro> buscarLivrosAutor(String autor) throws Exception {
        List<Livro> livrosEncontrados = livros.stream()
                .filter(livro -> livro.getAutor().equals(autor))
                .collect(Collectors.toList());
    
        if (livrosEncontrados.isEmpty()) {
            throw new Exception("Nenhum livro encontrado para o autor: " + autor);
        }
    
        return livrosEncontrados;
    }

    public void adicionarLivro(Livro livro) throws Exception{
        if(buscarLivroTitulo(livro.getTitulo()) != null) {
            throw new Exception("Livro com título " + livro.getTitulo() + " já está cadastrado.");
        }
        livros.add(livro);
        
    }

    @Override
    public String toString() {
        return "Livros=" + livros;
    }

}