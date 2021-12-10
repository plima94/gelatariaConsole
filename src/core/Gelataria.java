package core;

import java.util.ArrayList;

public class Gelataria {

    public static void main(String[] args) {

        ArrayList<Gelado> geladosEmStock = new ArrayList<>();
        ArrayList<Gelado> geladosVendidos = new ArrayList<>();
        ArrayList<String> listaSabor = new ArrayList<>();
        ArrayList<Integer> listaQtds = new ArrayList<>();

        int opcao = 0;
        Integer contadorVendas = 0;
        
        //menu
        do {
            System.out.println("\n\n----- Gestor de loja de gelados -----");
            System.out.println("1. Criar gelado");
            System.out.println("2. Eliminar gelado");
            System.out.println("3. Procurar gelado");
            System.out.println("-------------------");
            System.out.println("4. Listar gelados em stock");

            System.out.println("\n-----VENDA DE GELADOS-----");
            System.out.println("5. Fazer uma venda");
            System.out.println("6. Eliminar uma venda");

            System.out.println("\n----- ESTATISTICAS -----");
            System.out.println("7. Quantidade de gelados vendidos");
            System.out.println("8. Total arrecadado");
            System.out.println("9. Quantidade de gelados vendidos por sabor");
            System.out.println("----------------------------");
            System.out.println("0. Sair do programa");
            System.out.println("---------------------------------------------");

            opcao = Console.readInt("[Escolha uma opção]");
            
            switch (opcao) {
                case 1: //Criar gelado

                    Gelado novoGelado = new Gelado();

                    Integer id = Console.readInt("Id: ");
                    String nome = Console.readString("Nome do gelado: ");
                    Float preco = (float) Console.readDouble("Preco: ");
                    String sabor = Console.readString("Sabor do gelado: ");

                    novoGelado.setId(id);
                    novoGelado.setNome(nome);
                    novoGelado.setPreco(preco);
                    novoGelado.setSabor(sabor);

                    geladosEmStock.add(novoGelado);

                    break;

                case 2: //Eliminar gelado

                    Integer idGeladoRemover = Console.readInt("Indique o id do gelado a remover: ");

                    boolean testeRemocao = false;

                    for (int i = 0; i < geladosEmStock.size() && testeRemocao == false; i++) {

                        if (geladosEmStock.get(i).getId() == idGeladoRemover) {

                            geladosEmStock.remove(geladosEmStock.get(i));

                            testeRemocao = true;

                        }
                        if (testeRemocao == true) {
                            System.out.println("Gelado removido com sucesso");
                        } else {

                            System.out.println("Id inserido não existe.");

                        }
                    }

                    break;

                case 3: //procurar gelado

                    Integer idGeladoProcurar = Console.readInt("Indique o id do gelado que procura: ");

                    boolean testeProcurar = false;

                    for (int i = 0; i < geladosEmStock.size() && testeProcurar == false; i++) {

                        if (geladosEmStock.get(i).getId() == idGeladoProcurar) {

                            testeProcurar = true;
                        }

                    }
                    if (testeProcurar == true) {
                            System.out.println("O gelado é: ");
                            System.out.print(geladosEmStock.toString().replace("[", "").replace("]", ""));
                        } else {
                            System.out.println("O id introduzido não existe.");

                        }
                    break;

                case 4: //listar stock

                    boolean confirmarStock = geladosEmStock.isEmpty();

                    if (confirmarStock == true) {

                        System.out.println("Não há stock");
                    }

                    for (Gelado gelado : geladosEmStock) {

                        System.out.println(gelado.toString().replace("[", "").replace("]", ""));
                    }

                    break;

                case 5: //vender gelado

                    Integer venderGelado = Console.readInt("Qual o gelado que quer vender? (introduzir id)");
                    boolean existeGelado = false;
                    ;

                    for (int i = 0; i < geladosEmStock.size() && existeGelado == false; i++) {

                        if (geladosEmStock.get(i).getId() == venderGelado) {

                            existeGelado = true;
                        }

                        if (existeGelado == true) {

                            geladosVendidos.add(geladosEmStock.get(i));

                            contadorVendas++;

                            System.out.println("Gelado vendido.");

                            if (listaSabor.indexOf(geladosEmStock.get(i).getSabor()) < 0) {
                                listaSabor.add(geladosEmStock.get(i).getSabor());
                                listaQtds.add(1);
                            } else {
                                int qtdSabor = listaSabor.indexOf(geladosEmStock.get(i).getSabor());
                                listaQtds.set(qtdSabor, listaQtds.get(qtdSabor) + 1);

                            }

                        }

                    }
                    if (existeGelado == false) {

                        System.out.println("O gelado não existe em stock.");
                    }

                    break;

                case 6: //Eliminar uma venda

                    Integer removerGelado = Console.readInt("Venda a remover [0-x]: ");
                    boolean vendaCheck = false;

                    for (int i = 0; i < geladosVendidos.size() && vendaCheck == false; i++) {

                        if (i == removerGelado) {

                            vendaCheck = true;
                        }

                        if (vendaCheck == true) {

                            geladosVendidos.remove(i);
                            contadorVendas--;
                            System.out.println("Venda removida com sucesso.");
                        }
                    }

                    break;

                case 7: //Quantidade de gelados vendidos

                    System.out.println("Quantidade de gelados vendidos: " + contadorVendas);

                    break;

                case 8: //Total arrecadado  

                    double soma = 0;

                    for (Gelado gelado : geladosVendidos) {

                        soma = gelado.getPreco() + soma;
                    }

                    System.out.println("Total arrecadado: " + soma);

                    break;

                case 9: //Quantidade de gelados vendidos por sabor

                    System.out.println("Sabores vendidos: \n" + listaSabor + "\n" + listaQtds);

                    break;
                case 0:
                    System.out.println("Obrigado! \nVolte sempre.");

                    break;

                default:
                    System.out.println("Opção errada.");
            }

        } while (opcao != 0);

    }

}
