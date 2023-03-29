package Controllers;

import Views.Vista;
import core.RepoTestFinder;

public class Controlador {
    Vista vista1;
    RepoTestFinder core;
    public Controlador(View vista, RepoTestFinder coreX) {
        this.vista1 = vista;
        this.core = coreX;
        suscribirseAlCore();

    }

}
