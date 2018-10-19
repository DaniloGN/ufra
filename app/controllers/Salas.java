package controllers;

import models.Sala;
import play.mvc.*;

public class Salas extends Controller {

    public static void getAllSalas() {
        renderJSON(Sala.findAll());
    }

}
