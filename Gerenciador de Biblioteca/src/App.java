
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
        Usuario user1 = new Usuario("tata", "tata", "tata", "tata", new LinkedList<>());
        controladorLivro.adicionarLivro(livroBraille);
        controladorUsuario.adicionarUsuario(user1);
        LocalDate dataEmprestimo = LocalDate.of(2050, 5, 15); // Exemplo: 15 de maio de 2024
        LocalDate dataDevolucaoPrevista = LocalDate.of(2028, 5, 22); 
        biblioteca.emprestarLivroParaUsuario(user1, "Teste", dataEmprestimo);
        System.out.println(user1);
        biblioteca.devolverLivroDeUsuario(user1, "Teste");
        System.out.println(user1);
    


    
 }
}
