package ui;

import Controllers.Mediador;
import Views.PvViews;
import Views.Vista;
import core.Report;

public class Main {

    public static void main (String[] args){
    	PvViews viewPv = new PvViews();
    	Report acceptanceTest = new Report();
        Mediador controller = new Mediador(viewPv, acceptanceTest);
    }
}
