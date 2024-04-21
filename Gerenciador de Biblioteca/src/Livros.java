public class Livros {
    private String nome, autor;
    private int anoPub;
    private int exemDisponiveis;
    private int cod;
    
   

    public Livros(String nome, String autor, int anoPub, int exemDisponiveis) {
        this.nome = nome;
        this.autor = autor;
        this.anoPub = anoPub;
        this.exemDisponiveis = exemDisponiveis;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPub() {
        return anoPub;
    }

    public void setAnoPub(int anoPub) {
        this.anoPub = anoPub;
    }

    public int getExemDisponiveis() {
        return exemDisponiveis;
    }

    public void setExemDisponiveis(int exemDisponiveis) {
        this.exemDisponiveis = exemDisponiveis;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "Livros [nome=" + nome + ", autor=" + autor + ", anoPub=" + anoPub + ", exemDisponiveis="
                + exemDisponiveis + ", cod=" + cod + "]";
    }

   
}
