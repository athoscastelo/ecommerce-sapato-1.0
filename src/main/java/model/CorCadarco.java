package model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CorCadarco {

    BEGE(1, "Bege"),
    BRANCO(2, "Branco"),
    PRETO(3, "Preto"),
    CINZA(4, "Cinza"),
    MARROM(5,"Marrom");
  

    private int id;
    private String nome;

    public String getNome() {
        return nome;
    }

    CorCadarco(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getid() {
        return id;
    }

    public static CorCadarco valueOf(int id) {
        for (CorCadarco cadarco : values()) {
            if (cadarco.getid() == id) {
                return cadarco;
            }
        }
        throw new IllegalArgumentException("id de cadarço inválido: " + id);
    }


}