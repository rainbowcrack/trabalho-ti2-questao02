import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // cria objetos da classe
        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Listar Clientes");
            System.out.println("2. Inserir Cliente");
            System.out.println("3. Excluir Cliente");
            System.out.println("4. Atualizar Cliente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // quebra de linha

            switch (opcao) {
                case 1:
                    List<Cliente> clientes = clienteDAO.listarClientes();
                    for (Cliente cliente : clientes) {
                        System.out.println(cliente);
                    }
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    Cliente novoCliente = new Cliente(nome, email, telefone);
                    clienteDAO.inserirCliente(novoCliente);
                    System.out.println("Cliente inserido");
                    break;

                case 3:
                    System.out.print("Digite o ID do cliente a ser excluido: ");
                    int idExcluir = scanner.nextInt();
                    clienteDAO.excluirCliente(idExcluir);
                    System.out.println("Cliente excluido");
                    break;

                case 4:
                    System.out.print("Digite o ID do cliente a ser atualizado: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();  // Consumir a quebra de linha
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo email: ");
                    String novoEmail = scanner.nextLine();
                    System.out.print("Novo telefone: ");
                    String novoTelefone = scanner.nextLine();
                    Cliente clienteAtualizado = new Cliente(idAtualizar, novoNome, novoEmail, novoTelefone);
                    clienteDAO.atualizarCliente(clienteAtualizado);
                    System.out.println("Cliente atualizado");
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;
                    
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 5);
    }
}
