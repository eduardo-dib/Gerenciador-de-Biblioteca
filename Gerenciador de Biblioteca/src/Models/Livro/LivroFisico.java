package Models.Livro;


public class LivroFisico extends Livro {
    private int numPag;

    public LivroFisico(String titulo,String categoria, String autor, int anoPub, int exemDisp, int numPag) {
        super(titulo, categoria, autor, anoPub, exemDisp);
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
        return "\nLivroFisico [cod=" + super.getCod() + ", titulo=" + super.getTitulo() + ", categoria=" + super.getCategoria() + ", autor=" + super.getAutor() + ", anoPub=" + super.getAnoPub()
            + ", exemDisp=" + super.getExemDisp() + ", Número de páginas=" + numPag + "]";
    }

}
