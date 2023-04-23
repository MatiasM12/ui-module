package main;

import controllers.ReportController;
import core.InitCore;
import core.PvCore;
import views.ReportView;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

	 public static void main(String[] args) throws MalformedURLException {

		 //1 Se crea el modelo y su estructura interna
	InitCore inicializador = new InitCore("./");
	PvCore core = inicializador.init("DefaultFinder", new URL("https://"), 5000);

		//2 Se crea la vista tomando como referencia el modelo
	 ReportView vista = new ReportView(core); //3,4,5

		 //6 La aplicacion comienza a procesar eventos.

	 }

}
