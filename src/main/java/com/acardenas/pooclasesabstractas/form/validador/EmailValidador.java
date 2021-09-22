package com.acardenas.pooclasesabstractas.form.validador;

import com.acardenas.utilidad.RegExpUtil;

public class EmailValidador extends Validador{

    protected String mensaje = "el formato del email es inválido";

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        return valor.matches(RegExpUtil.EMAIL_REGEX);
    }
}
