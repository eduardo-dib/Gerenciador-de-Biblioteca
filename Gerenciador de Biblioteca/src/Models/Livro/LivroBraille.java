package Models.Livro;


public class LivroBraille extends Livro{
    private String material;

    public LivroBraille(String titulo, String categoria, String autor, int anoPub, int exemDisp, String material) {
        super(titulo, categoria, autor, anoPub, exemDisp);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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

    @Override
    public String toString() {
        return "\nLivroBraille [cod=" + super.getCod() + ", titulo=" + super.getTitulo() + ", categoria=" + super.getCategoria() + ", autor=" + super.getAutor() + ", anoPub=" + super.getAnoPub()
            + ", exemDisp=" + super.getExemDisp() + ", material=" + material + "]";
    }
}
