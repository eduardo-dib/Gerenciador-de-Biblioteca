
import java.time.LocalDate;
import java.util.LinkedList;
import Controllers.Biblioteca;
import Controllers.ControladorLivro;
import Controllers.ControladorUsuario;
import Models.Livro.LivroBraille;
import Models.Livro.LivroDigital;
import Models.Livro.LivroFisico;
import Models.*;

//Ver estrutura do projeto(Herança-Usuario, UsuarioComum e UsuarioPremium, Interface-ILivro, LivroComum e LivroPremium)
//Como funcionaria a interface Ilivros? sendo que todos os métodos de adicionar, remover livros ficariam na biblioteca
//Como funcionaria pra classe usuário ter uma lista de livros, seria na classe mãe ou cada classe teria uma lista?

public class App {
    public static void main(String[] args) throws Exception {
        LivroFisico senhorDosAneis = new LivroFisico(null, null, null, 0, 0, 0)
        ControladorLivro controladorLivro = new ControladorLivro();
        controladorLivro.adicionarLivro(null);
 }
}
