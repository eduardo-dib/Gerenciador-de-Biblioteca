package Controllers;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import Models.Livro.*;

public class Biblioteca {
    private String nome;
    private List<Livro> livros;
    
    public Biblioteca(String nome, List<Livro> livros) {
        this.nome = nome;
        this.livros = livros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<LivroFisico> emprestarLivros(List<LivroFisico> livros) {
        return livros.stream()
                .filter(livro -> livro.reduzirEstoque())
                .map(livro -> new LivroFisico(livro.getTitulo(), livro.getCategoria(), livro.getAutor(), livro.getAnoPub(), livro.getExemDisp(), livro.getNumPag()))
                .collect(Collectors.toList());
    }
}
