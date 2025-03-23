package gym.equipment;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private static int nextId = 1;
    private static List<Cliente> clientes = new ArrayList<>();

    public Cliente(String nome, String cpf, String telefone, String endereco) {
        this.id = nextId++;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // Getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getTelefone() { return telefone; }
    public String getEndereco() { return endereco; }

    // Métodos estáticos para gerenciamento
    public static void cadastrarCliente(String nome, String cpf, String telefone, String endereco) {
        clientes.add(new Cliente(nome, cpf, telefone, endereco));
    }

    public static List<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }

    public static Cliente buscarClientePorId(int id) {
        return clientes.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Métodos de edição e exclusão
    public static boolean editarCliente(int id, String novoNome, String novoTelefone, String novoEndereco) {
        Cliente cliente = buscarClientePorId(id);
        if (cliente != null) {
            cliente.nome = novoNome;
            cliente.telefone = novoTelefone;
            cliente.endereco = novoEndereco;
            return true;
        }
        return false;
    }

    public static boolean excluirCliente(int id) {
        Cliente cliente = buscarClientePorId(id);
        if (cliente != null) {
            clientes.remove(cliente);
            return true;
        }
        return false;
    }
}