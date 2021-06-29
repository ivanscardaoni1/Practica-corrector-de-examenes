public class RedondeoHaciaArriba implements CriterioDeRedondeo{

    public Double redondear(Double puntaje) {
        Integer parteEntera = puntaje.intValue();
        if(puntaje - parteEntera != 0) {
            return puntaje + 1 - puntaje.floatValue();
        } else {
            return puntaje;
        }
    }
}
