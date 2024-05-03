
import java.util.ArrayList;
import java.util.List;

import Controllers.ControladorLivro;
import Controllers.ControladorUsuario;
import Models.Livro.LivroBraille;
import Models.Livro.LivroDigital;
import Models.Livro.LivroFisico;
import Models.Livro.Livro;
import Models.*;

//Ver estrutura do projeto(Herança-Usuario, UsuarioComum e UsuarioPremium, Interface-ILivro, LivroComum e LivroPremium)
//Como funcionaria a interface Ilivros? sendo que todos os métodos de adicionar, remover livros ficariam na biblioteca
//Como funcionaria pra classe usuário ter uma lista de livros, seria na classe mãe ou cada classe teria uma lista?

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Gerenciamento de Biblioteca");

        ControladorLivro controladorLivro = new ControladorLivro();
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        Usuario user1 = new Usuario("Sim", "Sim", "Sim", "Sim", new ArrayList<Livro>());
        Usuario user2 = new Usuario("Sim", "Sim", "Sim", "Sim", new ArrayList<Livro>());
        controladorUsuario.adicionarUsuario(user1);
        System.out.println(user1);

    }
}
