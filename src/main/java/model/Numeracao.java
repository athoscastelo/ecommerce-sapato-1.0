package model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Numeracao {
    TRINTA_QUATRO(34),
    TRINTA_CINCO(35),
    TRINTA_SEIS(36),
    TRINTA_SETE(37),
    TRINTA_OITO(38),
    TRINTA_NOVE(39),
    QUARENTA(40),
    QUARENTA_UM(41),
    QUARENTA_DOIS(42),
    QUARENTA_TRES(43),
    QUARENTA_QUATRO(44),
    QUARENTA_CINCO(45);

    private int id;

    Numeracao(int id) {
        this.id = id;
    }

    public int getid() {
        return id;
    }

    public static Numeracao valueOf(int id) {
        for (Numeracao numeracao : values()) {
            if (numeracao.getid() == id) {
                return numeracao;
            }
        }
        throw new IllegalArgumentException("id de enumeração inválido: " + id);
    }


}

