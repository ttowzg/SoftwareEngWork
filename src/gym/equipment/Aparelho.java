package gym.equipment;
import java.util.ArrayList;
import java.util.List;

public class Aparelho {
    private int id;
    private String nome;
    private int quantidade;
    private double valor;
    private static int nextId = 1;
    private static List<Aparelho> aparelhos = new ArrayList<>();

    public Aparelho(String nome, double valor, int quantidade) {
        this.id = nextId++;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    // Getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getValor() { return valor; }
    public int getQuantidade() { return quantidade; }

    // Métodos estáticos para gerenciamento
    public static void cadastrarAparelho(String nome, double valor, int quantidade) {
        aparelhos.add(new Aparelho(nome, valor, quantidade));
    }

    public static List<Aparelho> listarAparelhos() {
        return new ArrayList<>(aparelhos);
    }

    public static Aparelho buscarAparelhoPorId(int id) {
        return aparelhos.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Métodos de edição e exclusão
    public static boolean editarAparelho(int id, String novoNome, double novoValor, int novaQuantidade) {
        Aparelho aparelho = buscarAparelhoPorId(id);
        if (aparelho != null) {
            aparelho.nome = novoNome;
            aparelho.valor = novoValor;
            aparelho.quantidade = novaQuantidade;
            return true;
        }
        return false;
    }

    public static boolean excluirAparelho(int id) {
        Aparelho aparelho = buscarAparelhoPorId(id);
        if (aparelho != null && !estaAlocado(aparelho)) {
            aparelhos.remove(aparelho);
            return true;
        }
        return false;
    }

    private static boolean estaAlocado(Aparelho aparelho) {
        return Alocacao.listarAlocacoes().stream()
                .anyMatch(a -> a.getAparelho().equals(aparelho) && a.getStatus().equals("Ativa"));
    }
}