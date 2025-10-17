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
        int total = valorMes * meses;

        if(meses >= 36){
            total = total - (total * 10 / 100);
        } else if(meses >= 24){
            total = total - (total * 5 / 100);
        }

        return total;
    }
}
