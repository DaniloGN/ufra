package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class Usuario extends GenericModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
    public String nome;
    public String email;
    public String senha;
    
    public Usuario(String nome, String email, String senha) {
    	this.nome = nome;
    	this.email = email;
    	this.senha = senha;
    }
}
