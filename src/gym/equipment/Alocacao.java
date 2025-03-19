package gym.equipment;
import java.util.*;

class Alocacao {
    int id;
    Cliente cliente;
    Aparelho aparelho;
    String dataInicio;
    String dataFinal;
    String status;
    float valorFinal;

    public Alocacao(int id, Cliente cliente, Aparelho aparelho, String dataInicio, String dataFinal, String status) {
        this.id = id;
        this.cliente = cliente;
        this.aparelho = aparelho;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.status = status;
        this.valorFinal = aparelho.valor;
    }

    @Override
    public String toString() {
        return id + " - Cliente: " + cliente.nome + " - Aparelho: " + aparelho.nome + " - " + dataInicio + " - " + dataFinal + " - " + status + " - R$" + valorFinal;
    }
}
