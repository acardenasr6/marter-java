package com.acardenas.pooclasesabstractas.form;

import com.acardenas.pooclasesabstractas.form.elementos.ElementoForm;
import com.acardenas.pooclasesabstractas.form.elementos.InputForm;
import com.acardenas.pooclasesabstractas.form.elementos.SelectForm;
import com.acardenas.pooclasesabstractas.form.elementos.TextareaForm;
import com.acardenas.pooclasesabstractas.form.elementos.select.Opcion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        InputForm password = new InputForm("clave", "password");
        InputForm email = new InputForm("email", "email");
        InputForm edad = new InputForm("edad", "number");

        TextareaForm experiencia = new TextareaForm("exp", 5,9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        Opcion java = new Opcion("1", "Java");
        lenguaje.addObcion(java)
                .addObcion(new Opcion("2","Python"))
                .addObcion(new Opcion("3","JavaStript"))
                .addObcion(new Opcion("4", "TypeScript"))
                .addObcion(new Opcion("5","PHP"));

        username.setValor("john.doe");
        password.setValor("a1b2c3");
        email.setValor("jhon.doe@correo.com");
        edad.setValor("28");
        experiencia.setValor("... más de diez años de experiencia");
        java.setSelected(true);

        List<ElementoForm> elementoForms = Arrays.asList(
                username,
                password,
                email,
                edad,
                experiencia,
                lenguaje);

        elementoForms.forEach(e -> System.out.println(e.dibujarHtml()));

    }
}
