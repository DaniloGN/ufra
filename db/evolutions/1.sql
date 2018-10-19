# --- !Ups

CREATE TABLE "public"."usuario" ( 
	"id" Bigint DEFAULT nextval('usuario_id_seq'::regclass) NOT NULL,
	"email" Character Varying( 255 ),
	"nome" Character Varying( 255 ),
	"senha" Character Varying( 255 ),
	PRIMARY KEY ( "id" ) );
 ;
 
# --- !Downs

DROP TABLE IF EXISTS "public"."usuario" CASCADE