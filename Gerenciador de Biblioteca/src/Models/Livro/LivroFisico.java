package Models.Livro;

import java.time.LocalDate;

public class LivroFisico extends Livro {
    private int numPag;

    public LivroFisico(String titulo, String autor, LocalDate anoPub, int exemDisp, int numPag) {
        super(titulo, autor, anoPub, exemDisp);
        this.numPag = numPag;
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

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    @Override
    public String toString() {
        return "LivroFisico [ titulo=" + super.getTitulo() + ", autor=" + super.getAutor() + ", anoPub=" + super.getAnoPub()
                + ", exemDisp=" + super.getExemDisp()+ "numPag=" + numPag + "]";
    }

}
