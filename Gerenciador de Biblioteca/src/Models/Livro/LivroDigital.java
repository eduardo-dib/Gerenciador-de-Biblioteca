package Models.Livro;

import java.time.LocalDate;

public class LivroDigital extends Livro{
    private String arqFormato;

    public LivroDigital(String titulo, String autor, LocalDate anoPub, int exemDisp, String arqFormato) {
        super(titulo, autor, anoPub, exemDisp);
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
        return "LivroDigital [titulo=" + super.getAutor() + ", autor=" + super.getAutor() + ", anoPub="
                + super.getAnoPub() + ", exemDisp=" + super.getExemDisp() + "arqFormato=" + arqFormato +"]";
    }
}
