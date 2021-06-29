import java.util.List;

public class ExamenComun implements Examen{
    List<Pregunta> preguntas;
    CriterioDeRedondeo criterioDeRedondeo;

    public ExamenComun(List<Pregunta> preguntas) {
     this.preguntas = preguntas;
    }

    public Boolean aprobo() {
        return this.nota() > 0.6;
    }

    public Double puntajeTotal() {
        return preguntas.stream()
                        .mapToDouble(Pregunta :: getPeso)
                        .sum();
    }

    public Double puntajeObtenido() {
        return preguntas.stream()
                        .mapToDouble(Pregunta :: puntajeObtenido)
                        .sum();
    }

    public Double nota() {
        return (this.puntajeObtenido() / this.puntajeTotal()) * 10;
    }

    public Double notaRedondeada() {
        return criterioDeRedondeo.redondear(this.nota());
    }
}
