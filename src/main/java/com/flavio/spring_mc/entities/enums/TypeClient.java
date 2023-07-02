package com.flavio.spring_mc.entities.enums;

public enum TypeClient {
    PESSOAFISICA(1, "Pessoa Fisíca"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private int cod;
    private String descricacao;

    private TypeClient(int cod, String descricacao) {
        this.cod = cod;
        this.descricacao = descricacao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricacao() {
        return descricacao;
    }

    public static TypeClient toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        for(TypeClient x : TypeClient.values()){
            if(cod == x.getCod()){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido " + cod);
    }

}

