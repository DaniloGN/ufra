package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Sala extends GenericModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	public String nome;

	public Sala(String nome) {
		this.nome = nome;
	}
    
}
