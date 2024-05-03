package Models.Livro;

import java.time.LocalDate;

public abstract class Livro implements Comparable <Livro>{
    protected String titulo;
    protected String autor;
    protected LocalDate anoPub;
    protected int exemDisp;
    
    public Livro(String titulo, String autor, LocalDate anoPub, int exemDisp) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPub = anoPub;
        this.exemDisp = exemDisp;
    }

    public abstract boolean reduzirEstoque();

    public abstract void aumentarEstoque();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getAnoPub() {
        return anoPub;
    }

    public void setAnoPub(LocalDate anoPub) {
        this.anoPub = anoPub;
    }

    public int getExemDisp() {
        return exemDisp;
    }

    public void setExemDisp(int exemDisp) {
        this.exemDisp = exemDisp;
    }

    @Override
    public String toString() {
        return "Livro [titulo=" + titulo + ", autor=" + autor + ", anoPub=" + anoPub + ", exemDisp=" + exemDisp + "]";
    }

    @Override
    public int compareTo(Livro o) {
        return titulo.compareTo(o.getTitulo());
    }

}
