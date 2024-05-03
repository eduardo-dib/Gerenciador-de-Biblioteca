
import Controllers.ControladorLivro;
import Models.Livro.LivroBraille;
import Models.Livro.LivroDigital;

//Ver estrutura do projeto(Herança-Usuario, UsuarioComum e UsuarioPremium, Interface-ILivro, LivroComum e LivroPremium)
//Como funcionaria a interface Ilivros? sendo que todos os métodos de adicionar, remover livros ficariam na biblioteca
//Como funcionaria pra classe usuário ter uma lista de livros, seria na classe mãe ou cada classe teria uma lista?

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Gerenciamento de Biblioteca");

        ControladorLivro controladorLivro = new ControladorLivro();
        LivroBraille livro1 = new LivroBraille("Teste", "Teste", "Teste", 2023, 5, "Papel");
        LivroBraille livro2 = new LivroBraille("Teste2", "Teste", "Teste", 2023, 5, "Papel");
        LivroDigital livro3 = new LivroDigital("Oi", "nsei", "Teste", 0, 0, "Sim");
        controladorLivro.adicionarLivro(livro1);
        controladorLivro.adicionarLivro(livro2);
        controladorLivro.adicionarLivro(livro3);
        System.out.println(controladorLivro.buscarLivrosCategoria("Teste"));
        System.out.println(controladorLivro.buscarLivrosCategoria("nsei"));

    }
}
