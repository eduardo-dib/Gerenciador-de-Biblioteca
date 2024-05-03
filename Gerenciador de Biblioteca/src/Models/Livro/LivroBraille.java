package Models.Livro;

import java.time.LocalDate;

public class LivroBraille extends Livro{
    private String material;

    public LivroBraille(String titulo, String autor, LocalDate anoPub, int exemDisp, String material) {
        super(titulo, autor, anoPub, exemDisp);
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
        return "LivroDigital [titulo=" + super.getAutor() + ", autor=" + super.getAutor() + ", anoPub="
                + super.getAnoPub() + ", exemDisp=" + super.getExemDisp() + "arqFormato=" + material +"]";
    }
}
