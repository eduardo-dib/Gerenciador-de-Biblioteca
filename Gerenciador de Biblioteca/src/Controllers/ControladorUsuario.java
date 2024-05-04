package Controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Models.*;
import Models.Livro.*;

public class ControladorUsuario {
    private ControladorLivro controladorLivro;
    

    private List <Usuario> usuarios;
    private List <Livro> livros;

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

   

}
