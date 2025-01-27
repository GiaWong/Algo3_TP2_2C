package edu.fiuba.algo3.Modelo.Casillas;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Movimiento.Direccion;
import edu.fiuba.algo3.Modelo.Movimiento.Posicion;

public class Casilla {
    Ocupable unaOcupacion;
    Ocupable unaSegundaOcupacion;

    int posicionEnX;
    int posicionEnY;

    String tipo;

    public Casilla(Ocupable primeraOcupacion, Ocupable segundaOcupacion, int posX, int posY, String tipo) {
        this.unaOcupacion = primeraOcupacion;
        this.unaSegundaOcupacion = segundaOcupacion;
        this.posicionEnX = posX;
        this.posicionEnY = posY;
        this.tipo = tipo;
    }

    public int obtenerposicionEnX() {
        return posicionEnX;
    }

    public int obtenerposicionEny() {
        return posicionEnY;
    }

    public Gladiador interactuarConLaOcupacion(Gladiador ungladiador) {

        ungladiador.aumentarEnergiaAlIniciarElTurno();
        ungladiador = unaSegundaOcupacion.interactuarConLaOcupacion(ungladiador);
        ungladiador = unaOcupacion.interactuarConLaOcupacion(ungladiador);

        return ungladiador;
    }

    public String obtenerPrimeraOcupacion(){
        if (unaOcupacion.getClass().getSimpleName().equals("Bacanal")){
            return "El gladiador asiste a un Bacanal.";
        }
        else if(unaOcupacion.getClass().getSimpleName().equals("Lesion")){
            return "El gladiador sufre una Lesion.";
        }
        else if (unaOcupacion.getClass().getSimpleName().equals("FieraSalvaje")){
            return "El gladiador se enfrenta a una fiera salvaje.";
        }
        else {
            return "Ninguno.";
        }
    }

    public String obtenerSegundaOcupacion(Gladiador unGladiador){


        if (unaSegundaOcupacion.getClass().getSimpleName().equals("PremioEquipamiento") && unGladiador.obtenerCantidadDeEquipamiento() == 1) {
            return "El gladiador recibe de equipamiento un Casco.";
        } else if (unaSegundaOcupacion.getClass().getSimpleName().equals("PremioEquipamiento") && unGladiador.obtenerCantidadDeEquipamiento() == 2) {
            return "El gladiador recibe de equipamiento una Armadura.";
        } else if (unaSegundaOcupacion.getClass().getSimpleName().equals("PremioEquipamiento") && unGladiador.obtenerCantidadDeEquipamiento() == 3) {
            return "El gladiador recibe de equipamiento un Escudo y una espada.";
        } else if (unaSegundaOcupacion.getClass().getSimpleName().equals("PremioEquipamiento") && unGladiador.obtenerCantidadDeEquipamiento() == 4) {
            return "El gladiador recibe una Llave.";
        }

        if(unaSegundaOcupacion.getClass().getSimpleName().equals("Comida")){
            return "El gladiador recibe Comida.";
        }

        else{
            return "Ninguno.";
        }
    }

}

