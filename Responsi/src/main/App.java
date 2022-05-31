package main;
import main.view.*;
import main.controller.*;
import main.model.*;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Aslab_m model = new Aslab_m();
        dataView view = new dataView();
        new AslabController(view, model);
       

    }
}
