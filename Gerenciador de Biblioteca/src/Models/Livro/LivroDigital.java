package Models.Livro;


public class LivroDigital extends Livro{
    private String arqFormato;

    public LivroDigital(String titulo, String categoria, String autor, int anoPub, int exemDisp, String arqFormato) {
        super(titulo, categoria, autor, anoPub, exemDisp);
        this.arqFormato = arqFormato;
    }

    @Override
    public boolean reduzirEstoque() {
        if (exemDisp > 0) {
            exemDisp--;
            return true;
        }
        return false;
    }

    @Override
    public void aumentarEstoque() {
        exemDisp++;
        
    }

    public String getArqFormato() {
        return arqFormato;
    }

    public void setArqFormato(String arqFormato) {
        this.arqFormato = arqFormato;
    }

    @Override
    public String toString() {
        return "LivroDigital [cod=" + super.getCod() + ", titulo=" + super.getTitulo() + ", categoria=" + super.getCategoria() + ", autor=" + super.getAutor() + ", anoPub=" + super.getAnoPub()
            + ", exemDisp=" + super.getExemDisp() + ", Formato do Arquivo=" + arqFormato + "]";
    }
}
