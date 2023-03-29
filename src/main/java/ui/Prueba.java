package ui;


import core.Robot;

public class Prueba{

    public static void main(String[] args) {
        Robot c = new Robot("",1,1);
        c.cargarBateria();
        c.mostrarEstado();
        c.moverse();
    }
}
