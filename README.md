# PersonRegister
Cette API Springboot expose deux webservices:
1. **PUT** /person/register : qui permet d'enregistrer une personne
2. **GET** /person/information/{identifiant} : qui permet d'en récupérer les information

## **PUT** /person/register

###exemple de donnees
Cette url attend ces informations au format JSON :
~~~~
{
"userName":"",
"birthdate" : "",
"country" : "",
"phoneNumber":"",
"gender" : ""
}
~~~~

###condition d'appel

Il y a différente condition à respecter pour enregistrer une nouvelle personne:
* Les champs "userName", "birthdate", "country" sont obligatoire et ne peuvent donc pas null ou vide.
* Le champs birthdate doit être au format "dd/MM/yyyy' et doit avoir 18 annnées ou plus de différence au jour de l'enregistrement
* Les champs "phoneNumber" et "gender" sont optionnels donc peuvent ne pas être précisé.
* Si le champs "phoneNumber" est renseigné il doit contenir uniquement 10 chiffres.
* Si le champs "gender" est précisé alors il ne peut pas être vide

###retour de l'appel

Ce webservice retourne l'identifiant de base de données de la personne enregistré

## **GET** /person/information/{identifiant}

L'identifiant attendu dans l'url correspond à un identifiant retourné par le WS d'enregistrement.

## Le projet

Ce projet est réalisé en java, avec le framework springboot. 
La base de données H2 est en mémoire donc ne nécessite pas d'avoir un sgdb particulier d'installer.

### Compilation

Pour compiler ce projet il faut lancer la commande ```mvn install ```

### Exécution

Pour démarrer ce projet il faut lancer la commande ```mvn spring-boot:run ```