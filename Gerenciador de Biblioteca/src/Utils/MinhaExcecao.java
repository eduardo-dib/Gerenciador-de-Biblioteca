package Utils;

public class MinhaExcecao extends Exception{
    public MinhaExcecao(String mensagem){
        super("Minha Exceção: " + mensagem);
    }
}
