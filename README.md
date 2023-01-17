
# CineMille

Questo progetto è stato sviluppato secondo le specifiche del **Coding Challenge** proposto da [Lascaux](https://www.lascaux.it). 

### Obiettivo

Creare un’applicazione web per la gestione dei film di un multisala.  
L’applicazione dovrà permettere la visualizzazione della lista dei film messi in programmazione in un cinema multisala, al fine di organizzare uno storico consultabile dai gestori.

### Frontend

La parte **Frontend** dell'applicazione si trova al seguente [link.](https://github.com/Ramzah/CineMille-FE)

### Requisiti

**Java 1.17** (JDK 17)

### Deploy

E' possibile clonare il repository e poi lanciare l'applicazione da terminale attraverso il comando `./mvnw spring-boot:run` oppure si può creare un file **JAR** con il comando `./mvnw clean package`.  
Il file così generato può essere lanciato con il comando `java -jar target/CineMille-0.0.1-SNAPSHOT.jar`

### Options

Le seguenti opzioni di accesso al database sono configurabili da terminale:
	
-		--datasource.url: "DatabaseUrl" (default: jdbc:mysql://localhost:3306/cinemille)
-		--datasource.username: "NomeUtente" (default: root)
-		--datasource.password: "Password" (default: root)
	
Esempi:

-		./mvnw spring-boot:run \-Dspring-boot.run.arguments="--datasource.url=jdbc:mysql://localhost:3306/myDatabaseURL"
-		./mvnw clean package \-Dspring-boot.run.arguments="--datasource.username=myUsername"
-		java -jar CineMille-0.0.1-SNAPSHOT.jar --datasource.username=myUsername --datasource.password=myDBPassword