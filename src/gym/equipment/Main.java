
package gym.equipment;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1 -> cadastrarCliente(scanner);
                case 2 -> editarCliente(scanner);
                case 3 -> excluirCliente(scanner);
                case 4 -> cadastrarAparelho(scanner);
                case 5 -> editarAparelho(scanner);
                case 6 -> excluirAparelho(scanner);
                case 7 -> cadastrarAlocacao(scanner);
                case 8 -> cancelarAlocacao(scanner);
                case 9 -> listarClientes();
                case 10 -> listarAparelhos();
                case 11 -> listarAlocacoes();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Editar Cliente");
        System.out.println("3 - Excluir Cliente");
        System.out.println("4 - Cadastrar Aparelho");
        System.out.println("5 - Editar Aparelho");
        System.out.println("6 - Excluir Aparelho");
        System.out.println("7 - Cadastrar Alocação");
        System.out.println("8 - Cancelar Alocação");
        System.out.println("9 - Listar Clientes");
        System.out.println("10 - Listar Aparelhos");
        System.out.println("11 - Listar Alocações");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Métodos de interação com o usuário
    private static void cadastrarCliente(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        Cliente.cadastrarCliente(nome, cpf, telefone, endereco);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void editarCliente(Scanner scanner) {
        System.out.print("ID do cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Novo endereço: ");
        String endereco = scanner.nextLine();
        if (Cliente.editarCliente(id, nome, telefone, endereco)) {
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    private static void excluirCliente(Scanner scanner) {
        System.out.print("ID do cliente: ");
        int id = scanner.nextInt();
        if (Cliente.excluirCliente(id)) {
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    private static void cadastrarAparelho(Scanner scanner) {
        System.out.print("Nome do aparelho: ");
        String nome = scanner.nextLine();
        System.out.print("Valor do aparelho: ");
        double valor = scanner.nextDouble();
        System.out.print("Quantidade disponível: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        Aparelho.cadastrarAparelho(nome, valor, quantidade);
        System.out.println("Aparelho cadastrado com sucesso!");
    }

    private static void editarAparelho(Scanner scanner) {
        System.out.print("ID do aparelho: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo valor: ");
        double valor = scanner.nextDouble();
        System.out.print("Nova quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        if (Aparelho.editarAparelho(id, nome, valor, quantidade)) {
            System.out.println("Aparelho atualizado com sucesso!");
        } else {
            System.out.println("Aparelho não encontrado!");
        }
    }

    private static void excluirAparelho(Scanner scanner) {
        System.out.print("ID do aparelho: ");
        int id = scanner.nextInt();
        if (Aparelho.excluirAparelho(id)) {
            System.out.println("Aparelho removido com sucesso!");
        } else {
            System.out.println("Aparelho não encontrado ou está alocado!");
        }
    }

    private static void cadastrarAlocacao(Scanner scanner) {
        System.out.print("ID do cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        System.out.print("ID do aparelho: ");
        int idAparelho = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Data de início (dd/MM/yyyy): ");
        String dataInicio = scanner.nextLine();
        System.out.print("Data final (dd/MM/yyyy): ");
        String dataFinal = scanner.nextLine();

        Cliente cliente = Cliente.buscarClientePorId(idCliente);
        Aparelho aparelho = Aparelho.buscarAparelhoPorId(idAparelho);

        if (cliente != null && aparelho != null) {
            Alocacao.cadastrarAlocacao(dataInicio, dataFinal, cliente, aparelho);
            System.out.println("Alocação cadastrada com sucesso!");
        } else {
            System.out.println("Cliente ou aparelho não encontrado!");
        }
    }

    private static void cancelarAlocacao(Scanner scanner) {
        System.out.print("ID da alocação: ");
        int id = scanner.nextInt();
        if (Alocacao.cancelarAlocacao(id)) {
            System.out.println("Alocação cancelada com sucesso!");
        } else {
            System.out.println("Alocação não encontrada!");
        }
    }

    private static void listarClientes() {
        List<Cliente> clientes = Cliente.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("\n===== LISTA DE CLIENTES =====");
            for (Cliente cliente : clientes) {
                System.out.println("ID: " + cliente.getId());
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("CPF: " + cliente.getCpf());
                System.out.println("Telefone: " + cliente.getTelefone());
                System.out.println("Endereço: " + cliente.getEndereco());
                System.out.println("-----------------------------");
            }
        }
    }

    private static void listarAparelhos() {
        List<Aparelho> aparelhos = Aparelho.listarAparelhos();
        if (aparelhos.isEmpty()) {
            System.out.println("Nenhum aparelho cadastrado.");
        } else {
            System.out.println("\n===== LISTA DE APARELHOS =====");
            for (Aparelho aparelho : aparelhos) {
                System.out.println("ID: " + aparelho.getId());
                System.out.println("Nome: " + aparelho.getNome());
                System.out.println("Valor: " + aparelho.getValor());
                System.out.println("Quantidade: " + aparelho.getQuantidade());
                System.out.println("-----------------------------");
            }
        }
    }

    private static void listarAlocacoes() {
        List<Alocacao> alocacoes = Alocacao.listarAlocacoes();
        if (alocacoes.isEmpty()) {
            System.out.println("Nenhuma alocação cadastrada.");
        } else {
            System.out.println("\n===== LISTA DE ALOCAÇÕES =====");
            for (Alocacao alocacao : alocacoes) {
                System.out.println("ID: " + alocacao.getId());
                System.out.println("Cliente: " + alocacao.getCliente().getNome());
                System.out.println("Aparelho: " + alocacao.getAparelho().getNome());
                System.out.println("Data Início: " + alocacao.getDataInicio());
                System.out.println("Data Final: " + alocacao.getDataFinal());
                System.out.println("Status: " + alocacao.getStatus());
                System.out.println("Valor Final: " + alocacao.getValorFinal());
                System.out.println("-----------------------------");
            }
        }
    }
}