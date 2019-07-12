package br.com.caelum.model;

import java.util.Calendar;

public class Negociacao {
	private double preco;
    private int quantidade;
    private Calendar data;

    //getters e setters

    @Override
    public String toString() {
        return "Negociacao [preco=" + preco + ", quantidade=" + quantidade + "]";
    }
}
