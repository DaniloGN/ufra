package controllers;

import java.io.InputStreamReader;
import java.util.List;

import com.google.gson.GsonBuilder;
import com.jamonapi.utils.Logger;

import models.Reserva;
import play.db.jpa.JPA;
import play.mvc.*;
import utils.Data;

public class Reservas extends Controller {

	public static void getReservaBySalaEData(Long sala) {
		
		
		Data data = new GsonBuilder().create().fromJson(params.get("data"), Data.class);
		
		List<Reserva> reservas = JPA.em().createNativeQuery(
				"SELECT * FROM Reserva WHERE EXTRACT(YEAR FROM Reserva.data) = " + data.ano + " AND EXTRACT(MONTH FROM Reserva.data) = " + data.mes + 
				" AND EXTRACT(DAY FROM Reserva.data) = " + data.dia + " AND Reserva.idSala = " + sala ,
				Reserva.class).getResultList();
		
		renderJSON(reservas);
	}

	public static void getReservasByUsuario(Long idUser) {
		List<Reserva> reservas = JPA.em().createNativeQuery("SELECT * FROM Reserva WHERE Reserva.idUsuario = " + idUser, Reserva.class).getResultList();
		
		renderJSON(reservas);
	}

	public static void deleteReserva(Long idReserva, Long idUsuario) {
		Reserva reserva = Reserva.findById(idReserva);
		
		if(reserva.idUsuario == idUsuario) {
			reserva.delete();
		}
		
	}

}
