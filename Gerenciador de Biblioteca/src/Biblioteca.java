import java.util.List;

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
