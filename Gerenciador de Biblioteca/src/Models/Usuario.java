package Models;
import java.time.LocalDate;
import java.util.List;
import Models.Livro.Livro;

public class Usuario implements Comparable <Usuario>{


    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private List <Livro> livros;
    private LocalDate datasEmprestimo;
    private LocalDate datasDevolucaoPrevista;

   

    public Usuario(String nome, String telefone, String endereco, String email, List<Livro> livros) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.livros = livros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
    
    public LocalDate getDatasEmprestimo() {
        return datasEmprestimo;
    }

    public void setDatasEmprestimo (LocalDate datasEmprestimo) {
        this.datasEmprestimo = datasEmprestimo;
    }

    public LocalDate getDatasDevolucaoPrevista() {
        return datasDevolucaoPrevista;
    }

    public void setDatasDevolucaoPrevista(LocalDate datasDevolucaoPrevista) {
        this.datasDevolucaoPrevista = datasDevolucaoPrevista;
    }

    public void adicionarLivroEmprestado(Livro livro, LocalDate dataEmprestimo) throws Exception{
        this.datasEmprestimo = dataEmprestimo;
        this.datasDevolucaoPrevista = dataEmprestimo.plusDays(14); 
        livros.add(livro);
    }

    public void devolverLivroEmprestado(Livro livro){
        livros.remove(livro);
        this.setDatasDevolucaoPrevista(null);
        this.setDatasEmprestimo(null);
    }

    public List<Livro> listarLivrosEmprestados() {
        return this.getLivros();
    }

    
    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco + ", email=" + email
                + ", livros=" + livros + ", Datas de Empréstimo=" + datasEmprestimo + ", Datas de Devolução=" + datasDevolucaoPrevista + "]";

    }

    @Override
    public int compareTo(Usuario o) {
        return nome.compareTo(o.getNome());
    }

   

    

  

}
