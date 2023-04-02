package ui;

import Controllers.Mediador;
import Views.PvViews;
import Views.Vista;
import core.Acceptance_test;

public class Main {

    public static void main (String[] args){
    	PvViews viewPv= new PvViews();
    	Acceptance_test acceptanceTest = new Acceptance_test();
        Mediador controller = new Mediador(viewPv, acceptanceTest);
    }
}
