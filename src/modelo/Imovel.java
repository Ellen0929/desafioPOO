package modelo;

public abstract class Imovel {
    protected String endereco;
    protected int numero;
    protected boolean alugado;
    protected Proprietario proprietario;
    protected Inquilino inquilino;

    public Imovel(String endereco, int numero, Proprietario proprietario) {
        this.endereco = endereco;
        this.numero = numero;
        this.proprietario = proprietario;
        this.alugado = false;
        this.inquilino = null;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public void alugar(Inquilino i){
        this.inquilino = i;
        this.alugado = true;
    }

    public void desocupar(){
        this.inquilino = null;
        this.alugado = false;
    }

    public Inquilino getInquilino(){
        return inquilino;
    }

    public abstract boolean estaAlugado();
    public abstract int calcularAluguel(int meses);

    public String contatoProprietario(){
        return proprietario.getNome() + " - " + proprietario.getTelefone();
    }
}
