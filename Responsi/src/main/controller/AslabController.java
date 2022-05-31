package main.controller;

import main.model.Aslab_m;
import main.model.StructAslab;
import main.view.dataView;

public class AslabController {
    private dataView view;
    private Aslab_m model;

    public AslabController(dataView view, Aslab_m model){
        this.view = view;
        this.model = model;
    }

    public void index(){
        StructAslab[] data = this.model.getAll();
        new dataView(data);
    } 
}
