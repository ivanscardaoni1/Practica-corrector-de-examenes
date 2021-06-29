import java.util.List;

//Podria haber una clase respuesta que tenga un atributo string y un enum que sea Correcta/ParcialmenteCorrecta/Incorrecta
//y segun ese atributo calcular el porcentaje del peso que se devuelve en puntajeObtenido
//Podemos tener clases RespuestaCorrecta/RespuestaParcialmenteCorrecta/RespuestaIncorrecta que respondan a la interfaz Respuesta
//y que conozcan a su pregunta para saber su peso, y delegar en ellas el calculo de si es o no correcta.

public class Pregunta {
    String pregunta;
    Double peso;
    List<Respuesta> respuestasPosibles;
    Respuesta respuestaElegida;

    public Pregunta(String pregunta, Double peso, List<Respuesta> respuestasPosibles){
        this.pregunta = pregunta;
        this.peso = peso;
        this.respuestasPosibles = respuestasPosibles;
    }

    public void responder(Respuesta respuesta) {
        if(!respuestasPosibles.contains(respuesta)) {
            throw new RespuestaInvalidaException("La respuesta ingresada no es valida");
        }
        this.respuestaElegida = respuesta;
    }

    public Double getPeso() {
        return peso;
    }

    public Double puntajeObtenido() {
        if(respuestaElegida == null) {
            return 0.0;
        } else {
            return this.getPeso() * respuestaElegida.porcion();
        }
    }
}
