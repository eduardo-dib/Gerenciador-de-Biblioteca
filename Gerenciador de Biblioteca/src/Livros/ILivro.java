package Livros;

public interface ILivro {
    String getTitulo();
    String getAutor();
    int getAnoPublicacao();
    boolean podeSerEmprestado();
}
