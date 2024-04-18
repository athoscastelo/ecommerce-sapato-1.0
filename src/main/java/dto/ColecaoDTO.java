package dto;

import java.util.List;

import model.Sapato;

public record ColecaoDTO (
    String nome
) {

    public List<Sapato> getSapatos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSapatos'");
    }}
