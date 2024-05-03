package Controllers;
import java.util.ArrayList;
import java.util.List;

import Models.*;

public class ControladorUsuario {
     private List <Usuario> usuarios;

    public ControladorUsuario() {
        this.usuarios = new ArrayList<>();
    }

    private Usuario buscarUsuarioAdd(String nome){
        return usuarios.stream()
        .filter(n -> n.getNome() == nome)
        .findFirst().
         orElse(null);
    }

    public void adicionarUsuario(Usuario usuario) throws Exception{
        if (buscarUsuarioAdd(usuario.getNome()) != null) {
            throw new Exception("Usuário com o nome " + usuario.getNome() + " já está cadastrado.");
        }
        usuarios.add(usuario);
        
    }
}
