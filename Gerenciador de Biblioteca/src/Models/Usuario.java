package Models;
import Models.Livro.*;

import java.util.List;

public class Usuario implements Comparable <Usuario>{


    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private List <Livro> livros;

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

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco + ", email=" + email
                + ", livros=" + livros + "]";
    }

    @Override
    public int compareTo(Usuario o) {
        return nome.compareTo(o.getNome());
    }

    

  

}
