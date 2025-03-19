package gym.equipment;
import java.util.*;

public class Cliente {
    int id;
    String nome;
    String cpf;
    String telefone;
    String endereco;

    public Cliente(int id, String nome, String cpf, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return id + " - " + nome + " - " + cpf + " - " + telefone + " - " + endereco;
    }
}
