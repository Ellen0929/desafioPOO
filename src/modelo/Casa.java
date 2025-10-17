package modelo;

public class Casa extends Imovel {
    public Casa (String endereco, int numero, Proprietario proprietario){
        super(endereco, numero, proprietario);
    }

    @Override
    public boolean estaAlugado() {
        return alugado;
    }

    @Override
    public int calcularAluguel(int meses) {
        int valorMes = 1000;
        return valorMes * meses;
    }
}
