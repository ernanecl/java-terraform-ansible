package com.spring.danilo.web.teste.models;

import java.util.InputMismatchException;

public class Cliente {
    private String nome;
    private String cpf;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean validarCpf() {
        if(this.cpf == null) return false;
        
        this.cpf = this.cpf.replace(".", "").replace("-", "");

        if (this.cpf.equals("00000000000") || this.cpf.equals("11111111111") || this.cpf.equals("22222222222")
                || this.cpf.equals("33333333333") || this.cpf.equals("44444444444") || this.cpf.equals("55555555555")
                || this.cpf.equals("66666666666") || this.cpf.equals("77777777777") || this.cpf.equals("88888888888")
                || this.cpf.equals("99999999999") || (this.cpf.length() != 11))
            return (false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (this.cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48);

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (this.cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            if ((dig10 == this.cpf.charAt(9)) && (dig11 == this.cpf.charAt(10)))
                return (true);
            else
                return (false);
        } catch (InputMismatchException erro) {
            return (false);
        }
    }
}
