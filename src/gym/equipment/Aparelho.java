package gym.equipment;
import java.util.*;

public class Aparelho {
    int id;
    String nome;
    int quantidade;
    float valor;

    public Aparelho(int id, String nome, int quantidade, float valor) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return id + " - " + nome + " - " + quantidade + " - " + valor;
    }
}
