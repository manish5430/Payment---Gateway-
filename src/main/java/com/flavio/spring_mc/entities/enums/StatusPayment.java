package com.flavio.spring_mc.entities.enums;

public enum StatusPayment {
    PENDING(1, "PENDING"),
    PAID(2, "PAID"),
    CANCELED(3, "CANCELED");

    private int cod;
    private String descricacao;

    private StatusPayment(int cod, String descricacao) {
        this.cod = cod;
        this.descricacao = descricacao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricacao() {
        return descricacao;
    }

    public static StatusPayment toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        for(StatusPayment x : StatusPayment.values()){
            if(cod == x.getCod()){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido " + cod);
    }

}

