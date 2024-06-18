package Controllers;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Models.Usuario;
import Models.Livro.*;

public class Biblioteca {
    private ControladorLivro controladorLivro;
    private ControladorUsuario controladorUsuario;
    private List <Usuario> usuarios;
    private List<Livro> livrosEmprestados;


    public Biblioteca(ControladorLivro controladorLivro, ControladorUsuario controladorUsuario) {
        this.controladorLivro = controladorLivro;
        this.controladorUsuario = controladorUsuario;
        this.usuarios = new ArrayList<>();
        this.livrosEmprestados = new ArrayList<>();
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    
    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(List<Livro> livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }

    //EMPRÉSTIMO DE LIVROS
    public void emprestarLivroParaUsuario(Usuario usuario, String titulo, LocalDate dataEmprestimo) throws Exception {
        if (!usuario.getLivros().isEmpty()) throw new Exception("Usuário já tem um livro emprestado.");
        Livro livro = controladorLivro.buscarLivroTitulo(titulo);
        if (livro.getExemDisp() <= 0) throw new Exception("Não há exemplares disponíveis do livro desejado.");
        controladorUsuario.adicionarLivroEmprestado(usuario, livro, dataEmprestimo);
        livrosEmprestados.add(livro);
        livro.setEmprestado(true);
        livro.reduzirEstoque();
    }
    //DEVOLUÇÃO DE LIVROS
    public void devolverLivroDeUsuario(Usuario usuario, String titulo) throws Exception {
        if (usuario.getLivros().isEmpty()) throw new Exception("Usuário não tem livros emprestados");
        Livro livro = controladorLivro.buscarLivroTitulo(titulo);
        controladorUsuario.devolverLivroEmprestado(usuario, livro);
        livrosEmprestados.remove(livro);
        livro.aumentarEstoque();
    }

}
    

    



