-- Upyoursoft tables

-- On commence par supprimer les tables éxistantes (si elles existent)
DROP TABLE IF EXISTS `utilisateur`;
DROP TABLE IF EXISTS `utilisateur_role`;
DROP TABLE IF EXISTS `utilisateur_niveau`;
DROP TABLE IF EXISTS `client`;
DROP TABLE IF EXISTS `relation_client_vendeur`;	
DROP TABLE IF EXISTS `prix_degressif_produit`;
DROP TABLE IF EXISTS `prix_degressif_option`;
DROP TABLE IF EXISTS `prix_degressif_produit`;
DROP TABLE IF EXISTS `plan_action_commercial_option`;
DROP TABLE IF EXISTS `plan_action_commercial`;
DROP TABLE IF EXISTS `produit_option`;
DROP TABLE IF EXISTS `produit_reference`;
DROP TABLE IF EXISTS `produit_sous_famille`;
DROP TABLE IF EXISTS `produit_famille`;


-- Niveau
-- id
-- nom
-- description
CREATE TABLE `utilisateur_niveau` (
	id_utilisateur_niveau TINYINT NOT NULL AUTO_INCREMENT, 
	nom varchar(40) NOT NULL,
	description varchar(100) NOT NULL,
	PRIMARY KEY(id_utilisateur_niveau)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO utilisateur_niveau (nom, description) VALUES ('niveau1','Niveau 1'),('niveau2','Niveau 2');

-- Role
-- id
-- nom (exemple vendeur)...
-- description
CREATE TABLE `utilisateur_role` (
	id_utilisateur_role TINYINT NOT NULL AUTO_INCREMENT, 
	nom varchar(40) NOT NULL,
	description varchar(100) NOT NULL,
	PRIMARY KEY(id_utilisateur_role)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO utilisateur_role (nom, description) VALUES ('admin','Administrateur'),('vendeur','Vendeur');


-- Utilisateur:
-- id
-- Login
-- Nom
-- Prenom
-- password
-- grade
CREATE TABLE `utilisateur` (
	id_utilisateur int unsigned NOT NULL AUTO_INCREMENT,
	prenom varchar(40) NOT NULL,
	nom varchar(40) NOT NULL,
	login varchar(40) NOT NULL,
	email varchar(255) NOT NULL, 
	password varchar(40) NOT NULL,
	id_utilisateur_role TINYINT(4) NOT NULL, 
	id_utilisateur_niveau TINYINT(4) NOT NULL, 
	date_creation datetime NOT NULL,
    last_login datetime DEFAULT NULL,
    actif tinyint(1) UNSIGNED DEFAULT false,
	INDEX (id_utilisateur_niveau), 
	FOREIGN KEY (id_utilisateur_niveau) REFERENCES utilisateur_niveau (id_utilisateur_niveau), 
	INDEX (id_utilisateur_role), 
	FOREIGN KEY (id_utilisateur_role) REFERENCES utilisateur_role (id_utilisateur_role), 
	PRIMARY KEY(id_utilisateur)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


CREATE TABLE `client` (
	id_client int unsigned NOT NULL AUTO_INCREMENT,
	nom_societe varchar(40) NOT NULL,
	siret varchar(14) NULL,
	forme_juridique varchar(40) NULL,
	tva varchar(40) NULL,
	adresse varchar(255) DEFAULT NULL,
	code_postal varchar(5) DEFAULT NULL,
	ville varchar(20) NOT NULL,
	telephone_fixe varchar(15) DEFAULT NULL,
	dirigeant_nom varchar(80) DEFAULT NULL,
	dirigeant_prenom varchar(80) DEFAULT NULL,
	secteur_activite varchar(40) NOT NULL,
	contact_nom varchar(80) DEFAULT NULL,
	contact_prenom varchar(80) DEFAULT NULL,
	contact_tel_fixe varchar(15) DEFAULT NULL,
	contact_tel_port varchar(15) DEFAULT NULL,
	contact_fonction varchar(40) NULL,
	contact_email varchar(255) DEFAULT NULL, -- La norme indique jusqu'à 320, mais 255 devrait suffire
	commentaire text DEFAULT NULL,
	url_img varchar(100) NULL,
	PRIMARY KEY(id_client)
)ENGINE=INNODB DEFAULT CHARSET=utf8;


CREATE TABLE `relation_client_vendeur` (
	id_relation_client_vendeur int unsigned NOT NULL AUTO_INCREMENT,
	id_utilisateur int unsigned NOT NULL,
	id_client int unsigned NOT NULL,
	date_contact datetime DEFAULT NULL,
	PRIMARY KEY(id_relation_client_vendeur)
)ENGINE=INNODB DEFAULT CHARSET=utf8;


CREATE TABLE `produit_famille` (
	id_produit_famille TINYINT NOT NULL AUTO_INCREMENT, 
	nom varchar(40) NOT NULL,
	description varchar(100) NOT NULL,
	url_img_famille varchar(50) DEFAULT NULL,
	PRIMARY KEY(id_produit_famille)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `produit_sous_famille` (
	id_produit_sous_famille TINYINT NOT NULL AUTO_INCREMENT, 
	id_produit_famille TINYINT NOT NULL,
	nom varchar(40) NOT NULL,
	description varchar(100) NOT NULL,
	url_img_sous_famille varchar(50) DEFAULT NULL,
	FOREIGN KEY (id_produit_famille) REFERENCES produit_famille (id_produit_famille), 
	PRIMARY KEY(id_produit_sous_famille)
) ENGINE=INNODB DEFAULT CHARSET=utf8;



CREATE TABLE `produit_reference` (
	id_produit_reference int unsigned NOT NULL AUTO_INCREMENT,
	id_produit_sous_famille TINYINT NOT NULL,
	reference_produit varchar(10) NOT NULL,
	nom varchar(40) NOT NULL,
	description_courte varchar(40) DEFAULT NULL,
	description_longue TEXT DEFAULT NULL,
	description_offre TEXT DEFAULT NULL,
	avantages TEXT DEFAULT NULL,
	benefices TEXT DEFAULT NULL,
	url_img_illustration_produit varchar(100) DEFAULT NULL,
	url_img_icone_produit varchar(100) DEFAULT NULL,
	url_img_processus varchar(100) DEFAULT NULL,
	cout_nominal FLOAT NOT NULL,
	prix_unitaire float DEFAULT NULL,
	commentaire text DEFAULT NULL,
	FOREIGN KEY (id_produit_sous_famille) REFERENCES produit_sous_famille (id_produit_sous_famille), 
	PRIMARY KEY(id_produit_reference)
)ENGINE=INNODB DEFAULT CHARSET=utf8;


CREATE TABLE `produit_option` (
	id_produit_option int unsigned NOT NULL AUTO_INCREMENT,
	id_produit_reference int unsigned NOT NULL,
	reference_option varchar(10) NOT NULL, 
	nom varchar(40) NOT NULL,
	obligatoire tinyint(1) UNSIGNED DEFAULT NULL,
	prix_unitaire FLOAT NOT NULL,
	PRIMARY KEY(id_produit_option),
	FOREIGN KEY (id_produit_reference) REFERENCES produit_reference (id_produit_reference)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `prix_degressif_option` (
	id_tableau_prix_degressif_option int unsigned NOT NULL AUTO_INCREMENT, 
	borne_inferieur int NOT NULL,
	borne_superieur int NOT NULL,
	prix_unitaire float DEFAULT NULL,
	id_produit_option int unsigned NOT NULL,
	INDEX (id_produit_option), 
	FOREIGN KEY (id_produit_option) REFERENCES produit_option (id_produit_option), 
	PRIMARY KEY(id_tableau_prix_degressif_option)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `prix_degressif_produit` (
	id_tableau_prix_degressif_produit int unsigned NOT NULL AUTO_INCREMENT, 
	borne_inferieure int NOT NULL,
	borne_superieure int NOT NULL,
	prix_unitaire float NOT NULL,
	id_produit_reference int unsigned NOT NULL,
	INDEX (id_produit_reference), 
	FOREIGN KEY (id_produit_reference) REFERENCES produit_reference (id_produit_reference), 
	PRIMARY KEY(id_tableau_prix_degressif_produit)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- plan_action_commercial
-- id_client
-- id_produit_ref
-- quantite
-- option
-- commentaire
-- date_realisation
-- date_fin_realisation
CREATE TABLE `plan_action_commercial` (
	id_plan_action_commercial int unsigned NOT NULL AUTO_INCREMENT, 
		id_client int unsigned NOT NULL,
	id_produit_reference int unsigned NOT NULL,
	quantite int unsigned NOT NULL,
	commentaire text DEFAULT NULL,
	date_commande date NOT NULL,
	date_realisation date NOT NULL,
	date_fin_realisation date DEFAULT NULL,
	INDEX (id_plan_action_commercial), 
	FOREIGN KEY (id_produit_reference) REFERENCES produit_reference (id_produit_reference), 
	PRIMARY KEY(id_plan_action_commercial)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `plan_action_commercial_option` (
	id_plan_action_commercial_option int unsigned NOT NULL AUTO_INCREMENT,
	id_plan_action_commercial int unsigned NOT NULL,
	id_produit_option int unsigned NOT NULL,
	FOREIGN KEY (id_plan_action_commercial) REFERENCES plan_action_commercial (id_plan_action_commercial), 
	FOREIGN KEY (id_produit_option) REFERENCES produit_option (id_produit_option), 
	PRIMARY KEY(id_plan_action_commercial_option)
) ENGINE=INNODB DEFAULT CHARSET=utf8;	


insert into produit_famille (nom, description, url_img_famille ) values ("E-Marketing", "Produits consacrés à tous se qui concerne l'e-marketing","EMARKETING.jpg");
insert into produit_famille (nom, description, url_img_famille ) values ("Graphisme", "Produits consacrés à tous se qui concerne le graphisme","GRAPHISME.jpg");
insert into produit_famille (nom, description, url_img_famille ) values ("Marqueting", "Produits consacrés à tous se qui concerne le marketing","MARKETING.jpg");
insert into produit_famille (nom, description, url_img_famille ) values ("Sites-internet", "Produits consacrés à tous se qui concerne le site internet","SITES-INTERNET.jpg");

insert into produit_sous_famille (nom, description, id_produit_famille,url_img_sous_famille) values ("E-Mailing", "Pour communiquer et informer", 1, "emailing.jpg");
insert into produit_sous_famille (nom, description, id_produit_famille,url_img_sous_famille) values ("Référencement naturel", "", 1,"refnat.jpg");
insert into produit_sous_famille (nom, description, id_produit_famille,url_img_sous_famille) values ("Community Management", "", 1,"commanage.jpg");
insert into produit_sous_famille (nom, description, id_produit_famille,url_img_sous_famille) values ("Annimation de site internet", "", 1,"animsite.jpg");
insert into produit_sous_famille (nom, description, id_produit_famille,url_img_sous_famille) values ("Plan Communication Web", "", 1,"plancomweb.jpg");
insert into produit_sous_famille (nom, description, id_produit_famille,url_img_sous_famille) values ("Référencement Payant", "", 1,"refpayant.jpg");


insert into produit_reference (
	id_produit_sous_famille,
	reference_produit,
	nom,
	description_courte,
	description_longue,
	description_offre,
	avantages,
	benefices,
	url_img_icone_produit) value (1, "REFMAIL", "Newsletter", "Pour communiquer et informer vos contacts sur votre entreprise ou votre secteur d’activité.", "La newsletter est un pilier de l’e-mailing communicationnel il n’existe rien de mieux pour conserver un lien avec vos contacts que l’envoi régulier d’une Newsletter.", "* Nous rédigeons et créons l’ensemble de vos Newsletter selon vos tendances et messages. * Nous établissons ensemble le planning de rédaction et d’envoi * Le routage de vos newsletters sont réalisées par nos soins *Après validation du contenu nous réalisons le routage et vous générons un rapport de retour sur investissement"," Informez <br/>L’e-mailing a un fort potentiel relationnel<br/> Donnez un coup de booste à un évènement ou à une offre commerciale <br/> Un rapport qualité prix imbattable !","Grâce aux contacts récurrents entretenus avec les clients ou fournisseurs, une fidélisation se met en place via l’envoi newsletter.<br/> l’envoi newsletter par mail est évidemment moins coûteux que d’autres techniques de communication <br/> Créé une relation client privilégié grâce à l’insertion de champs personnalisés", "newsletter.jpg");
	
insert into produit_reference (
	id_produit_sous_famille,
	reference_produit,
	nom,
	description_courte,
	description_longue,
	description_offre,
	avantages,
	benefices,
	url_img_icone_produit) value (1, "FLYERTRAD", "Flyer Traditionnel", "Pour communiquer et informer vos contacts sur votre entreprise ou votre secteur d’activité.", "La newsletter est un pilier de l’e-mailing communicationnel il n’existe rien de mieux pour conserver un lien avec vos contacts que l’envoi régulier d’une Newsletter.", "* Nous rédigeons et créons l’ensemble de vos Newsletter selon vos tendances et messages. * Nous établissons ensemble le planning de rédaction et d’envoi * Le routage de vos newsletters sont réalisées par nos soins *Après validation du contenu nous réalisons le routage et vous générons un rapport de retour sur investissement"," Informez <br/>L’e-mailing a un fort potentiel relationnel<br/> Donnez un coup de booste à un évènement ou à une offre commerciale <br/> Un rapport qualité prix imbattable !","Grâce aux contacts récurrents entretenus avec les clients ou fournisseurs, une fidélisation se met en place via l’envoi newsletter.<br/> l’envoi newsletter par mail est évidemment moins coûteux que d’autres techniques de communication <br/> Créé une relation client privilégié grâce à l’insertion de champs personnalisés","flyerTrad.jpg");

insert into produit_reference (
	id_produit_sous_famille,
	reference_produit,
	nom,
	description_courte,
	description_longue,
	description_offre,
	avantages,
	benefices,
	url_img_icone_produit) value (1, "FLYERDOUBLE", "Flyer Double", "Pour communiquer et informer vos contacts sur votre entreprise ou votre secteur d’activité.", "La newsletter est un pilier de l’e-mailing communicationnel il n’existe rien de mieux pour conserver un lien avec vos contacts que l’envoi régulier d’une Newsletter.", "* Nous rédigeons et créons l’ensemble de vos Newsletter selon vos tendances et messages. * Nous établissons ensemble le planning de rédaction et d’envoi * Le routage de vos newsletters sont réalisées par nos soins *Après validation du contenu nous réalisons le routage et vous générons un rapport de retour sur investissement"," Informez <br/>L’e-mailing a un fort potentiel relationnel<br/> Donnez un coup de booste à un évènement ou à une offre commerciale <br/> Un rapport qualité prix imbattable !","Grâce aux contacts récurrents entretenus avec les clients ou fournisseurs, une fidélisation se met en place via l’envoi newsletter.<br/> l’envoi newsletter par mail est évidemment moins coûteux que d’autres techniques de communication <br/> Créé une relation client privilégié grâce à l’insertion de champs personnalisés");
	

insert into prix_degressif_produit (
	borne_inferieure,
	borne_superieure,
	prix_unitaire,
	id_produit_reference) value (0, 1000, 10, 1);
	
insert into prix_degressif_produit (
	borne_inferieure,
	borne_superieure,
	prix_unitaire,
	id_produit_reference) value (1001, 2000, 8, 1);
	
insert into client (nom_societe, ville, secteur_activite) values ("BMW", "Le Mans", "Automobile");

insert into plan_action_commercial (
	id_client ,
	id_produit_reference ,
	quantite,
	date_commande,
	date_realisation) values (1,1,1,'2013-07-01', '2013-07-21');
	
select pr.id_produit_reference, psf.id_produit_famille, pr.id_produit_sous_famille, 
pr.reference_produit, pr.nom, pr.description_courte, pr.description_longue,
pr.description_offre, pr.avantages, pr.benefices, pr.url_img_illustration_produit, 
pr.url_img_icone_produit, pr.url_img_processus, pr.cout_nominal, pr.prix_unitaire, 
pr.commentaire, pdp.borne_inferieure, pdp.borne_superieure, pdp.prix_unitaire
from produit_reference pr 
inner join produit_sous_famille psf on psf.id_produit_sous_famille = pr.id_produit_sous_famille
inner join produit_famille pf on pf.id_produit_famille = psf.id_produit_famille
left join prix_degressif_produit pdp on pr.id_produit_reference = pdp.id_produit_reference 
where psf.id_produit_sous_famille = 1;

select util.nom, util.prenom, util.login, util.email, un.nom, ur.nom 
from utilisateur util
inner join utilisateur_niveau un on util.id_utilisateur_niveau=un.id_utilisateur_niveau
inner join utilisateur_role ur on util.id_utilisateur_role=ur.id_utilisateur_role;

insert into utilisateur (nom, prenom, login, password, email, id_utilisateur_role, id_utilisateur_niveau, date_creation, actif) values ("Legrand", "Eric", "elegrand","upyoursoft","elegrand@upyourbizz.fr",(select id_utilisateur_niveau from utilisateur_niveau where nom = "niveau1"), (select id_utilisateur_niveau from utilisateur_niveau where nom = "niveau1"), NOW(),true);
insert into utilisateur (nom, prenom, login, password, email, id_utilisateur_role, id_utilisateur_niveau, date_creation, actif) values ("Thibault", "Mikaël", "mthibault","upyoursoft","mthibault@upyourbizz.fr",(select id_utilisateur_niveau from utilisateur_niveau where nom = "niveau1"), (select id_utilisateur_niveau from utilisateur_niveau where nom = "niveau1"), NOW(),true);

select id_utilisateur_niveau from utilisateur_niveau where nom = "niveau1";
select id_utilisateur_role from utilisateur_role where nom = "admin"