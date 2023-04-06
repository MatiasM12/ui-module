package Views;

import Controllers.Mediador;
import core.Report;
import core.RepoTestFinder;

import javax.naming.ldap.Control;
import java.util.Observable;
import java.util.Observer;

public class Vista implements Observer {
    protected Mediador controller;
    protected Report  coreX ;

    public Vista(RepoTestFinder coreX) {
        //        repoTestFinde.attach(this);
      //  this.controller = new Controlador(this, coreX);
        suscribirseAlCore(coreX);
    }

    private void suscribirseAlCore(RepoTestFinder coreX){
        coreX.addObserver(this);
    }

    @Override
    public void update(Observable coreViejo, Object coreNuevo) {
        //creo que el core manda la version vieja y la actualizada. Habria que leer como fucniona
    }
}
