package com.acardenas.poo.clasesabstractas;

import com.acardenas.poo.clasesabstractas.form.elementos.ElementoForm;
import com.acardenas.poo.clasesabstractas.form.validador.*;
import com.acardenas.poo.clasesabstractas.form.elementos.InputForm;
import com.acardenas.poo.clasesabstractas.form.elementos.SelectForm;
import com.acardenas.poo.clasesabstractas.form.elementos.TextareaForm;
import com.acardenas.poo.clasesabstractas.form.elementos.select.Opcion;
import com.acardenas.poo.clasesabstractas.form.validador.*;

import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("clave", "password");
        password.addValidador(new RequeridoValidador())
                .addValidador(new LargoValidador(6,12));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextareaForm experiencia = new TextareaForm("exp", 5,9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());

        Opcion java = new Opcion("1", "Java");
        lenguaje.addObcion(java)
                .addObcion(new Opcion("2","Python"))
                .addObcion(new Opcion("3","JavaStript"))
                .addObcion(new Opcion("4", "TypeScript"))
                .addObcion(new Opcion("5","PHP"));

        ElementoForm saludar = new ElementoForm("saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name='"+this.nombre+"' value=\""+this.valor+"\">";
            }
        };

        saludar.setValor("Hola que tal este campo está deshabilitado!");
        username.setValor("");
        password.setValor("a1b2c");
        email.setValor("jhon.doecorreo.com");
        edad.setValor("28");
        experiencia.setValor("... más de diez años de experiencia");
        java.setSelected(true);

        List<ElementoForm> elementoForms = Arrays.asList(
                username,
                password,
                email,
                edad,
                experiencia,
                lenguaje,
                saludar);

        elementoForms.forEach(e -> System.out.println(e.dibujarHtml()));
        elementoForms.forEach(e -> {
            if (!e.esValido()){
                e.getErrores().forEach(System.out::println);
            }
        });
    }
}
