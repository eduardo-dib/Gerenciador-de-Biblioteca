import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Biblioteca biblioteca = new Biblioteca("Biblioteca", new LinkedList<>());
        Livros livro1 = new Livros("Livro 1", "Um cara ai", 2013,"Terror", 3);
        Livros livro2 = new Livros("livro2", "Tom Jobim", 2024,"Samba", 4);
        Livros livro3 = new Livros("livro3", "Tom Jobim", 2024,"Samba", 4);
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);
        System.out.println(biblioteca.buscarLivroCategoria("samba "));


    }
}
