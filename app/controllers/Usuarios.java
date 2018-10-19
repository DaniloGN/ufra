package controllers;

import java.util.List;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import models.Reserva;
import models.Usuario;
import play.db.jpa.JPA;
import play.mvc.*;
import utils.Data;

public class Usuarios extends Controller {

    public static void getUsuarioById(Long id) {
        Usuario user = Usuario.findById(id);
    	if(user != null) 
    		renderText(user.nome);
    }

	public static void novoUsuario() {
		Usuario user = new GsonBuilder().create().fromJson(params.get("user"), Usuario.class);
		
		Usuario x = Usuario.find("byEmail", user.email).first();
		
		if (x == null) {
			user.save();
		}
	}

	public static void login(String body) {
		String[] parts = body.split("%");
		
		System.out.println(parts[0]);
		System.out.println(parts[1]);
		
		try {
			Object obj = JPA.em().createNativeQuery("SELECT * from Usuario u WHERE u.email = '" + parts[0] + "'AND u.senha = '" + parts[1] + "'", Usuario.class).getSingleResult();
			renderJSON(obj);
	
		}catch(Exception e) {
			renderText("Usuario não encontrado");
		}
	}
}
