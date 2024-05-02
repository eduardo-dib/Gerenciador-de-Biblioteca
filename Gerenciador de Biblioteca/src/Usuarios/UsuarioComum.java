package Usuarios;

public class UsuarioComum extends Usuario{

    public UsuarioComum(String nome, String telefone, String endereco, String email) {
        super(nome, telefone, endereco, email);
    }

    @Override
    public boolean premium() {
        return false;
    }

   @Override
   public String toString() {
    return "Usuario[nome=" + nome + ", telefone=" + telefone + ", endereco=" + email + ", calcularArea()=" + calcularArea()
    + "]";
    
 }

}
