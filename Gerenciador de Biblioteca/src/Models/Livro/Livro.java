package Models.Livro;



public abstract class Livro implements Comparable <Livro>{
    protected static int proximoCodigo = 1;
    protected int cod;
    protected String titulo;
    protected String categoria;
    protected String autor;
    protected int anoPub;
    protected int exemDisp;
    protected boolean emprestado;
    
    

    public Livro(String titulo, String categoria, String autor, int anoPub, int exemDisp) {
        this.cod = proximoCodigo++;
        this.titulo = titulo;
        this.categoria = categoria;
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

    public int getAnoPub() {
        return anoPub;
    }

    public void setAnoPub(int anoPub) {
        this.anoPub = anoPub;
    }

    public int getExemDisp() {
        return exemDisp;
    }

    public void setExemDisp(int exemDisp) {
        this.exemDisp = exemDisp;
    }
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    @Override
    public String toString() {
        return "Livro [titulo=" + titulo + ", categoria=" + categoria + ", autor=" + autor + ", anoPub=" + anoPub + ", exemDisp=" + exemDisp + ",cod=" + cod +"]";
    }

    @Override
    public int compareTo(Livro o) {
        return titulo.compareTo(o.getTitulo());
    }

}
