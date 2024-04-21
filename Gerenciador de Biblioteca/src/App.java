import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Biblioteca biblioteca = new Biblioteca("Biblioteca", new LinkedList<>());
        Livros livro1 = new Livros("Livro 1", "Um cara ai", 2013, 3);
        Livros livro2 = new Livros("livro2", "Tom Jobim", 2024, 4);
        System.out.println(livro1);
        System.out.println(livro2);
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        System.out.println(biblioteca);
        System.out.println(biblioteca.buscarLivroCodigo(1));
    }
}
