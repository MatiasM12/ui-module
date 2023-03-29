package Views;

import Controllers.Controlador;

import javax.naming.ldap.Control;
import java.util.Observable;
import java.util.Observer;

public class Vista implements Observer {
    protected Controlador controller;
    public Vista(RepoTestFinder core){
//        repoTestFinde.attach(this);
        this.controller = new Controlador(this, core);
        suscribirseAlCore(core);
    }

    private void suscribirseAlCore(RepoTestFinder coreX){
        //coreX.attach(this);
    }

    @Override
    public void update(Observable coreViejo, Object coreNuevo) {
        //creo que el core manda la version vieja y la actualizada. Habria que leer como fucniona
    }
}
