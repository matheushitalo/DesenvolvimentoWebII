import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> produtos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        System.out.println("Sistema de Gerenciamento de Produtos");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar");
            System.out.println("2. Listar");
            System.out.println("3. Remover");
            System.out.println("4. Sair");
            System.out.print("Função Desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    //Adicionar
                    System.out.print("Nome do Produto: ");
                    String novoProduto = scanner.nextLine();
                    produtos.add(novoProduto);
                    System.out.println("Produto" + novoProduto + " adicionado.");
                    break;
                case 2:
                    //Listar
                    System.out.println("Lista de Produtos:");
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        final int[] index = {1};
                        produtos.forEach(produto -> {
                            System.out.println(index[0] + ". " + produto);
                            index[0]++;
                        });
                    }
                    break;
                case 3:
                    //Remover
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado para remover.");
                    } else {
                        System.out.print("Número do Produto a ser removido: ");
                        int numeroProduto = scanner.nextInt();
                        scanner.nextLine();
                        if (numeroProduto < 1 || numeroProduto > produtos.size()) {
                            System.out.println("Número inválido.");
                        } else {
                            String produtoRemovido = produtos.remove(numeroProduto - 1);
                            System.out.println("Produto " + produtoRemovido + " removido.");
                        }
                    }
                    break;
                case 4:
                    //Sair
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            }
        }
    }
