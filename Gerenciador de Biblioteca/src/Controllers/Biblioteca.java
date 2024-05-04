package Controllers;
import java.time.LocalDate;

import Models.Usuario;
import Models.Livro.*;

public class Biblioteca {
    private ControladorLivro controladorLivro;
    private ControladorUsuario controladorUsuario;

    public Biblioteca(ControladorLivro controladorLivro, ControladorUsuario controladorUsuario) {
        this.controladorLivro = controladorLivro;
        this.controladorUsuario = controladorUsuario;
    }

    public void emprestarLivroParaUsuario(Usuario usuario, String titulo, LocalDate dataEmprestimo) throws Exception {
        // Verificar se o usuário já tem livros emprestados
        if (!usuario.getLivros().isEmpty()) throw new Exception("Usuário já tem um livro emprestado.");
        Livro livro = controladorLivro.buscarLivroTitulo(titulo);
        usuario.setDatasEmprestimo(LocalDate.now());
        if (livro.getExemDisp() <= 0) throw new Exception("Não há exemplares disponíveis do livro desejado.");
        controladorUsuario.adicionarLivroEmprestado(usuario, livro, dataEmprestimo);
        livro.reduzirEstoque();
    }

    public void devolverLivroDeUsuario(Usuario usuario, String titulo) throws Exception {
        if (usuario.getLivros().isEmpty()) throw new Exception("Usuário não tem livros emprestados");
        Livro livro = controladorLivro.buscarLivroTitulo(titulo);
        controladorUsuario.devolverLivroEmprestado(usuario, livro);
        livro.aumentarEstoque();
    }



}
