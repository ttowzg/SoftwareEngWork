package gym.equipment;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class Alocacao {
    private int id;
    private String dataInicio;
    private String dataFinal;
    private String status;
    private double valorFinal;
    private Cliente cliente;
    private Aparelho aparelho;
    private static int nextId = 1;
    private static List<Alocacao> alocacoes = new ArrayList<>();

    public Alocacao(String dataInicio, String dataFinal, Cliente cliente, Aparelho aparelho) {
        this.id = nextId++;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.cliente = cliente;
        this.aparelho = aparelho;
        this.status = "Ativa";
        this.valorFinal = calcularValorFinal();
    }

    // Cálculo do valor baseado nas datas
    private double calcularValorFinal() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate inicio = LocalDate.parse(dataInicio, formatter);
        LocalDate fim = LocalDate.parse(dataFinal, formatter);
        long dias = ChronoUnit.DAYS.between(inicio, fim);
        return dias * aparelho.getValor();
    }

    // Getters
    public int getId() { return id; }
    public String getStatus() { return status; }
    public double getValorFinal() { return valorFinal; }
    public Cliente getCliente() { return cliente; }
    public Aparelho getAparelho() { return aparelho; }

    public String getDataFinal() {
        return dataFinal;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    // Métodos estáticos para gerenciamento
    public static void cadastrarAlocacao(String dataInicio, String dataFinal, Cliente cliente, Aparelho aparelho) {
        alocacoes.add(new Alocacao(dataInicio, dataFinal, cliente, aparelho));
    }

    public static List<Alocacao> listarAlocacoes() {
        return new ArrayList<>(alocacoes);
    }

    // Métodos de edição e exclusão
    public static boolean cancelarAlocacao(int id) {
        Alocacao alocacao = alocacoes.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
        if (alocacao != null) {
            alocacao.status = "Cancelada";
            return true;
        }
        return false;
    }
}