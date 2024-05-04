package Controllers;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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


    public void emprestarLivroParaUsuario(Usuario usuario, String titulo, LocalDate dataEmprestimo) throws Exception {
        // Verificar se o usuário já tem livros emprestados
        if (!usuario.getLivros().isEmpty()) throw new Exception("Usuário já tem um livro emprestado.");
        Livro livro = controladorLivro.buscarLivroTitulo(titulo);
        if (livro.getExemDisp() <= 0) throw new Exception("Não há exemplares disponíveis do livro desejado.");
        controladorUsuario.adicionarLivroEmprestado(usuario, livro, dataEmprestimo);
        livrosEmprestados.add(livro);
        livro.setEmprestado(true);
        livro.reduzirEstoque();
    }

    public void devolverLivroDeUsuario(Usuario usuario, String titulo) throws Exception {
        if (usuario.getLivros().isEmpty()) throw new Exception("Usuário não tem livros emprestados");
        Livro livro = controladorLivro.buscarLivroTitulo(titulo);
        controladorUsuario.devolverLivroEmprestado(usuario, livro);
        livrosEmprestados.remove(livro);
        livro.aumentarEstoque();
    }

    public List<Livro> listarLivrosEmprestados() {
        return new ArrayList<>(livrosEmprestados);
    }

    public List<Usuario> listarUsuariosComAtraso() {
        List<Usuario> usuariosComAtraso = new ArrayList<>();
        LocalDate dataAtual = LocalDate.now();
        
        for (Usuario usuario : usuarios) {
            for (Livro livro : usuario.getLivros()) {
                if (livro.isEmprestado() && usuario.getDatasEmprestimo().isBefore(dataAtual.minusDays(7))) {
                    usuariosComAtraso.add(usuario);
                }
            }
        }
        
        return usuariosComAtraso;
    }
}
    

    



