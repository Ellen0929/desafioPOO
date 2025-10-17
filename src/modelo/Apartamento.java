package modelo;

public class Apartamento extends Imovel{
    public Apartamento(String endereço, int numero, Proprietario proprietario){
        super(endereço, numero, proprietario);
    }

    @Override
    public boolean estaAlugado() {
        return alugado;
    }

    @Override
    public int calcularAluguel(int meses) {
        int valorMes = 800;
        return valorMes * meses;
    }
}
