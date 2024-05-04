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

    private Usuario buscarUsuarioAdd(String nome) {
        return usuarios.stream()
                .filter(n -> n.getNome() == nome)
                .findFirst().orElse(null);
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




   

}
