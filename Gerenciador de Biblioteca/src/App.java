
import java.time.LocalDate;
import java.util.LinkedList;
import Controllers.Biblioteca;
import Controllers.ControladorLivro;
import Controllers.ControladorUsuario;
import Models.Livro.LivroBraille;
import Models.Livro.LivroFisico;
import Models.*;

//Ver estrutura do projeto(Herança-Usuario, UsuarioComum e UsuarioPremium, Interface-ILivro, LivroComum e LivroPremium)
//Como funcionaria a interface Ilivros? sendo que todos os métodos de adicionar, remover livros ficariam na biblioteca
//Como funcionaria pra classe usuário ter uma lista de livros, seria na classe mãe ou cada classe teria uma lista?

public class App {
    public static void main(String[] args) throws Exception {
        ControladorLivro controladorLivro = new ControladorLivro();
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        Biblioteca biblioteca = new Biblioteca(controladorLivro, controladorUsuario);
        LivroBraille livroBraille = new LivroBraille("Teste", "Teste", "Teste", 2023, 2023, "Papel");
        LivroFisico livroFisico = new LivroFisico("uhul", "Capoeira", "boitata", 2023, 7, 467);
        Usuario user1 = new Usuario("tata", "tata", "tata", "tata", new LinkedList<>());
        Usuario user2 = new Usuario("Cefwild", "123", "Something missing", "foundme", new LinkedList<>());
        controladorLivro.adicionarLivro(livroBraille);
        controladorLivro.adicionarLivro(livroFisico);
        controladorUsuario.adicionarUsuario(user1);
        controladorUsuario.adicionarUsuario(user2);
        LocalDate dataEmprestimo = LocalDate.of(2023, 4, 15); // Exemplo: 15 de maio de 2024
        biblioteca.emprestarLivroParaUsuario(user1, "Teste", dataEmprestimo);
        biblioteca.emprestarLivroParaUsuario(user2, "uhul", dataEmprestimo);
        System.out.println(controladorUsuario.listarUsuariosComAtraso());

        
    


    
 }
}
