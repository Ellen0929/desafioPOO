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
        int total = valorMes * meses;

        if(meses >= 36){
            total = total - (total * 10 / 100);
        } else if(meses >= 24){
            total = total - (total * 5 / 100);
        }

        return total;
    }
}
