import modelo.Apartamento;
import modelo.Imovel;
import modelo.Proprietario;
import modelo.Casa;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Imovel> imoveis = new ArrayList<>();

       int opcao = -1;

       do{
           System.out.println("\n=========================");
           System.out.println("   Corretora Imobiliária   ");
           System.out.println("=========================\n");

           System.out.println("1- Cadastrar Casa");
           System.out.println("2- Cadastrar Apartamento");
           System.out.println("3- Listar Imóveis");
           System.out.println("4- Alugar/Disponiblizar Imóvel");
           System.out.println("5- Calcular Aluguel");
           System.out.println("6- Excluir Imóvel");
           System.out.println("0 - Sair");
           System.out.println("Escolha uma opção: ");

           try{
               opcao = sc.nextInt();
               sc.nextLine();

               switch (opcao){
                   case 1:
                       System.out.println("Endereço: ");
                       String endCasa = sc.nextLine();

                       System.out.println("Número: ");
                       int numCasa = sc.nextInt();
                       sc.nextLine();

                       System.out.println("Nome do proprietário: ");
                       String nomePropCasa = sc.nextLine();
                       while(nomePropCasa.matches(".*\\d.*")){
                           System.out.println("Erro! Nome inválido. Digite novamente: ");
                           nomePropCasa = sc.nextLine();
                       }

                       System.out.println("Telefone: ");
                       String telPropCasa = sc.nextLine();
                       while(!telPropCasa.matches(".\\d+")) {
                           System.out.println("Erro! telefone inválido. Digite novamente (somente números: ");
                           telPropCasa = sc.nextLine();
                       }
                       System.out.println("CPF: ");
                       String cpfPropCasa = sc.nextLine();
                       while(!cpfPropCasa.matches("\\d{11}")) {
                           System.out.println("Erro! CPF inválido. Digite novamente: ");
                           cpfPropCasa = sc.nextLine();
                       }
                       Proprietario propCasa = new Proprietario(nomePropCasa, telPropCasa, cpfPropCasa);
                       imoveis.add(new Casa(endCasa, numCasa,propCasa));
                       System.out.println("Casa cadastrada com sucesso!!");
                       break;

                   case 2:
                       System.out.println("Endereço: ");
                       String endApt = sc.nextLine();

                       System.out.println("Número: ");
                       int numApt = sc.nextInt();
                       sc.nextLine();

                       System.out.println("Nome do proprietário: ");
                       String nomePropApt = sc.nextLine();

                       System.out.println("Telefone: ");
                       String telPropApt = sc.nextLine();

                       System.out.println("CPF: ");
                       String cpfPropApt = sc.nextLine();

                       Proprietario propApt = new Proprietario(nomePropApt, telPropApt, cpfPropApt);
                       imoveis.add(new Apartamento(endApt, numApt,propApt));
                       System.out.println("Apartamento cadastrado com sucesso!!");
                       break;

                   case 3:
                       if(imoveis.isEmpty()){
                           System.out.println("Nenhum imóvel cadastrado.");
                       }else{
                           for(int i = 0; i < imoveis.size(); i++){
                               System.out.println("\n[" + i + "] " + imoveis.get(i).estaAlugado());
                               System.out.println("Endereço: " + imoveis.get(i).getEndereco());
                               System.out.println("Proprietário: " + imoveis.get(i).contatoProprietario());
                           }
                       }
                       break;

                   case 4:
                       System.out.println("Informe o índice do imóvel: ");
                       int indice = sc.nextInt();
                       sc.nextLine();

                       if(indice >= 0 && indice < imoveis.size()){
                           Imovel imovel = imoveis.get(indice);
                           imovel.setAlugado(!imovel.isAlugado());
                           System.out.println("Status alterado para: " + (imovel.isAlugado() ? "Alugado" : "Disponível"));
                       }else{
                           System.out.println("Indice inválido");
                       }
                       break;

                   case 5:
                       System.out.println("Informe o indice do imóvel: ");
                       int idx = sc.nextInt();

                       System.out.println("Meses de aluguel: ");
                       int meses = sc.nextInt();

                       if(idx >= 0 && idx < imoveis.size()){
                           Imovel imovel = imoveis.get(idx);
                           int valor = imovel.calcularAluguel(meses);
                           System.out.println("VAlor total do Aluguel: R$ " + valor);
                       }else{
                           System.out.println("Indice inválido.");
                       }
                       break;

                   case 6:
                       System.out.println("Informe o indice do imóvel para excluit: ");
                       int indExc = sc.nextInt();

                       if(indExc >= 0 && indExc < imoveis.size()){
                           imoveis.remove(indExc);
                           System.out.println("Imóvel removido com sucesso!!");
                       }else{
                           System.out.println("Indice inválido");
                       }
                       break;

                   case 0:
                       System.out.println("Encerrando sistema...");
                       break;

                   default:
                       System.out.println("Opção inválida");
               }
           }catch (InputMismatchException e){
               System.out.println("Entrada Inválida digite somente números.");
               sc.nextLine();
               opcao = -1;
           }

       }while(opcao != 0);

       sc.close();
    }
}
