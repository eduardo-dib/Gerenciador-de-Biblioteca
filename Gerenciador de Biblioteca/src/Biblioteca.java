import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
   

    private String name;
    private List <Livros> livros;
    
    public Biblioteca(String name, List<Livros> livros) {
        this.name = name;
        this.livros = livros;
    }

    public void adicionarLivro(Livros livro){
        livro.setCod(criarCodigo());
        if (buscarLivroCodigo(livro.getCod()) == null) {
            livros.add(livro);
        }
    }

    public Livros buscarLivroCodigo(int cod){
        return livros.stream().
        filter(l -> l.getCod() == cod).
        findFirst().
        orElse(null);
    }

    public Livros buscarLivroTitulo(String titulo){
        String tituloFormatado = titulo.trim().toLowerCase();
        return livros.stream().
        filter(l -> l.getNome().trim().toLowerCase().equals(tituloFormatado)).
        findFirst().
        orElse(null);
    }

    public List<Livros> buscarLivroAutor(String autor){
        String autorFormatado = autor.trim().toLowerCase();
        return livros.stream()
        .filter(l -> l.getAutor().trim().toLowerCase().equals(autorFormatado))
        .collect(Collectors.toList());
    }

    public List<Livros> buscarLivroCategoria(String categoria){
        String categoriaFormatada = categoria.trim().toLowerCase();
        return livros.stream()
        .filter(l -> l.getCategoria().trim().toLowerCase().equals(categoriaFormatada))
        .collect(Collectors.toList());
    }
    private int criarCodigo(){
        int res = 0;
        for (Livros p : livros) {
            if (res <= p.getCod()) {
                res = p.getCod();
            }
        }        
        return ++res;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Livros> getLivros() {
        return livros;
    }

    public void setLivros(List<Livros> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "Biblioteca [name=" + name + ", livros=" + livros + "]";
    }
    
}
