package controllers;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import models.Usuario;
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

}
