package model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Numeracao {
    TRINTA_QUATRO(34, "Trinta e quatro"),
    TRINTA_CINCO(35, "Trinta e cinco"),
    TRINTA_SEIS(36, "Trinta e seis"),
    TRINTA_SETE(37, "Trinta e sete"),
    TRINTA_OITO(38, "Trinta e oito"),
    TRINTA_NOVE(39, "Trinta e nove"),
    QUARENTA(40, "Quarenta"),
    QUARENTA_UM(41, "Quarenta e um"),
    QUARENTA_DOIS(42, "Quarenta e dois"),
    QUARENTA_TRES(43, "Quarenta e três"),
    QUARENTA_QUATRO(44, "Quarenta e quatro"),
    QUARENTA_CINCO(45, "Quarenta e cinco");

    private int valor;
    private String nome;

    Numeracao(int valor, String nome) {
        this.valor = valor;
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }

    public static Numeracao valueOf(int valor) {
        for (Numeracao num : Numeracao.values()) {
            if (num.valor == valor) {
                return num;
            }
        }
        throw new IllegalArgumentException("Valor numérico inválido: " + valor);
    }


}

