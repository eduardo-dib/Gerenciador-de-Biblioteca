package Controllers;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Models.*;
import Models.Livro.*;

public class ControladorUsuario {
    private List <Usuario> usuarios;

    public ControladorUsuario() {
        this.usuarios = new ArrayList<>();
    }

    public Usuario buscarUsuarioAdd(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                return usuario; 
            }
        }
        return null; 
    }

    public void adicionarUsuario(Usuario usuario) throws Exception {
        if (buscarUsuarioAdd(usuario.getNome()) != null) {
            throw new Exception("Usuário com o nome " + usuario.getNome() + " já está cadastrado.");
        }
        usuarios.add(usuario);

    }

    public void adicionarLivroEmprestado(Usuario usuario, Livro livro, LocalDate dataEmprestimo) throws Exception{
        usuario.adicionarLivroEmprestado(livro, dataEmprestimo);
    }

    public void devolverLivroEmprestado(Usuario usuario, Livro livro) {
        usuario.devolverLivroEmprestado(livro);
    }

    public List<Usuario> listarUsuariosComAtraso() {
        List<Usuario> usuariosComAtraso = new ArrayList<>();
        LocalDate dataAtual = LocalDate.now();
        
        for (Usuario usuario : usuarios) {
            LocalDate dataDevolucaoPrevista = usuario.getDatasDevolucaoPrevista();
            if (dataDevolucaoPrevista != null && dataDevolucaoPrevista.isBefore(dataAtual)) {
                usuariosComAtraso.add(usuario);
            }
        }
        
        return usuariosComAtraso;
    }

    @Override
    public String toString() {
        return "[Usuários=" + usuarios + "]";
    }




   

}
