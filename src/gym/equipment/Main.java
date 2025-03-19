package gym.equipment;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner input = new Scanner(System.in);
    static List<Cliente> clientes = new ArrayList<>();
    static List<Aparelho> aparelhos = new ArrayList<>();
    static List<Alocacao> alocacoes = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("========================");
            System.out.println("        MENU        ");
            System.out.println("========================");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Aparelho");
            System.out.println("3. Registrar Alocação");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Listar Aparelhos");
            System.out.println("6. Listar Alocações");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarAparelho();
                    break;
                case 3:
                    registrarAlocacao();
                    break;
                case 4:
                    listarClientes();
                    break;
                case 5:
                    listarAparelhos();
                    break;
                case 6:
                    listarAlocacoes();
                    break;
            }

        } while (opcao != 0);
    }

    static void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("CPF: ");
        String cpf = input.nextLine();
        System.out.print("Telefone: ");
        String telefone = input.nextLine();
        System.out.print("Endereço: ");
        String endereco = input.nextLine();
        clientes.add(new Cliente(clientes.size() + 1, nome, cpf, telefone, endereco));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    static void cadastrarAparelho() {
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("Quantidade: ");
        int quantidade = input.nextInt();
        System.out.print("Valor: ");
        float valor = input.nextFloat();
        input.nextLine();
        aparelhos.add(new Aparelho(aparelhos.size() + 1, nome, quantidade, valor));
        System.out.println("Aparelho cadastrado com sucesso!");
    }

    static void registrarAlocacao() {
        if (clientes.isEmpty() || aparelhos.isEmpty()) {
            System.out.println("Erro: Não há clientes ou aparelhos cadastrados.");
            return;
        }

        System.out.print("ID do Cliente: ");
        int idCliente = input.nextInt();
        input.nextLine();
        if (idCliente <= 0 || idCliente > clientes.size()) {
            System.out.println("Erro: Cliente não encontrado.");
            return;
        }
        Cliente cliente = clientes.get(idCliente - 1);

        System.out.print("ID do Aparelho: ");
        int idAparelho = input.nextInt();
        input.nextLine();
        if (idAparelho <= 0 || idAparelho > aparelhos.size()) {
            System.out.println("Erro: Aparelho não encontrado.");
            return;
        }
        Aparelho aparelho = aparelhos.get(idAparelho - 1);

        if (aparelho.quantidade == 0) {
            System.out.println("Erro: Aparelho indisponível.");
            return;
        }

        aparelho.quantidade--;

        System.out.print("Data Início: ");
        String dataInicio = input.nextLine();
        System.out.print("Data Fim: ");
        String dataFim = input.nextLine();
        System.out.print("Status: ");
        String status = input.nextLine();

        alocacoes.add(new Alocacao(alocacoes.size() + 1, cliente, aparelho, dataInicio, dataFim, status));
        System.out.println("Alocação registrada com sucesso!");
    }

    static void listarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    static void listarAparelhos() {
        for (Aparelho aparelho : aparelhos) {
            System.out.println(aparelho);
        }
    }

    static void listarAlocacoes() {
        if (alocacoes.isEmpty()) {
            System.out.println("Erro: Nenhuma alocação registrada.");
            return;
        }
        for (Alocacao alocacao : alocacoes) {
            System.out.println(alocacao);
        }
    }
}
