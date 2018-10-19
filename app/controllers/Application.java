package controllers;

import play.*;
import play.db.jpa.JPA;
import play.mvc.*;

import java.util.*;

import javax.persistence.TypedQuery;

import models.*;

public class Application extends Controller {

    public static void index() {
        Usuario user = new Usuario("Bruno","email","senha");
        user.save();
        
        Usuario user2 = new Usuario("Bruno","email","senha");
        
        user2.save();
        
        Sala sala = new Sala("sala 1");
        sala.save();
        
        sala = new Sala("sala 2");
        sala.save();
        
        sala = new Sala("sala 3");
        sala.save();
        
        Reserva reserva = new Reserva(user2.id, sala.id, new Date(118,02,15), 19);
        reserva.save();
        
        sala = new Sala("sala 4");
        sala.save();
        
        Reserva reserva2 = new Reserva(user2.id, sala.id, new Date(119,02,15), 19);
        reserva2.save();

        List<Reserva> reservas = JPA.em().createNativeQuery("SELECT * from Reserva WHERE EXTRACT(MONTH FROM Reserva.data) = 3", Reserva.class).getResultList();
        
        renderJSON(reservas);
    }

}