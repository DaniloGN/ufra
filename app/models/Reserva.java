package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Reserva extends GenericModel{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
    public Long idUsuario;
    
	public Long idSala;
    
	public Date data;
    
	public int horario;

	public Reserva(Long usuario, Long sala, Date data, int horario) {
		this.idUsuario = usuario;
		this.idSala = sala;
		this.data = data;
		this.horario = horario;
	}
    
    
    
}
