package dto;

import java.util.List;
import model.Sapato;

public record ColecaoDTO (
    String nome
) {

    public List<Sapato> getSapatos() {
        return getSapatos();
    }
  }
