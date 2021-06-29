import java.util.List;

public class ExamenPorPartes implements Examen {
    List<Examen> partes;
    CriterioDeRedondeo criterioDeRedondeo;

    public ExamenPorPartes(List<Examen> partes) {
        this.partes = partes;
    }

    public Boolean aprobo() {
       return partes.stream()
                    .allMatch(examen -> examen.aprobo());
    }

    public Double puntajeTotal() {
        return partes.stream()
                     .mapToDouble(Examen :: puntajeTotal)
                     .sum();
    }

    public Double puntajeObtenido(){
        return partes.stream()
                     .mapToDouble(Examen :: puntajeObtenido)
                     .sum();
    }

    public Double nota() {
        return this.puntajeObtenido() / this.puntajeTotal();
    }

    public Double notaRedondeada() {
       return criterioDeRedondeo.redondear(this.nota());
    }
}
