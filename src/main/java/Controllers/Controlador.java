package Controllers;

import Views.Vista;
import core.RepoTestFinder;

import java.util.Observable;
import java.util.Observer;

public class Controlador implements Observer {
    Vista vista1;
    RepoTestFinder core;
    public Controlador(Vista vista, RepoTestFinder coreX) {
        this.vista1 = vista;
        this.core = coreX;
        suscribirseAlCore();
    }

    private void suscribirseAlCore(){
        this.core.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        //ver como funciona; ver Vista
    }
}
