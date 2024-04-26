package model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MaterialSapato {
    COURO(1, "Couro"),
    CAMURÇA(2, "Camurça"),
    TECIDO(3, "Tecido");
  

    private int id;
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    MaterialSapato(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getid() {
        return id;
    }

    public static MaterialSapato valueOf(int id) {
        for (MaterialSapato materialsapato : values()) {
            if (materialsapato.getid() == id) {
                return materialsapato;
            }
        }
        throw new IllegalArgumentException("id de material inválido: " + id);
    }


}