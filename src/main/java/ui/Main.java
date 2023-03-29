package ui;

import Views.Vista;
import core.RepoTestFinder;

import java.awt.*;

public class Main {

    public static void Main (String[] args){
        RepoTestFinder coreX = new RepoTestFinder();
        Vista testEnSwing = new Vista(coreX);

    }
}
