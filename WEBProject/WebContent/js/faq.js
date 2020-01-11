//devo capire perchè in pratica non mi carica il collapse dal momento che mi dice che sto appendendo il nulle e quindi diciamo sembra non essere pronto a questa operazione
//all'inizio è meno uno ma poi diventa la stringa che definisce l'id del td che in pratica è stato acceso
var acceso = "null";

// ATTENZIONE: questa classe potrebbe essere migliorata estraendo le stringhe delle domande e delle risposte dal database (COSA CHE ATTUALMENTE NON HO FATTO e non so se lo farò)

//funzione di creazione di un collapse
function creaCollapse(domanda,  risposta, dataToggle, id ){
	
	var collapse = document.createElement("button");
	collapse.innerHTML = domanda; 
	collapse.className = "btn btn-outline-secondary";
	collapse.setAttribute("data-toggle","collapse");
	collapse.setAttribute("data-target","#"+dataToggle);
	document.getElementById("istanzaDomande").appendChild(collapse);
	
	var div = document.createElement("div");
	div.innerHTML = risposta;
	div.setAttribute("class","collapse");
	div.setAttribute("id",dataToggle);
	document.getElementById("istanzaDomande").appendChild(div);
	var br = document.createElement("br");
	document.getElementById("istanzaDomande").appendChild(br);
}

function creaDomandeResiRimborsi()
{
	var div =  document.getElementById("istanzaDomande");
	div.innerHTML = "";
	
//	domanda 
	var domanda = "E' possibile ottenere il rimborso di un prodotto?";
	var risposta = "No dal momento che seguiamo delle politiche secondo cui ci assicuriamo che il cliente abbia sempre cio' che ha scelto";
	var dataToggle = "rimborsoProdotto";
	var id = "ResiRimborsi";
	creaCollapse(domanda, risposta, dataToggle, id);
//	domanda 
	domanda = "Cosa succede se sbaglio ad effettuare un acquisto?";
	risposta = "Il prodotto restera' fino al marcire dei suoi giorni nella casa del cliente";
	dataToggle = "erroreAcquisto";
	id = "ResiRimborsi";
	creaCollapse(domanda, risposta, dataToggle, id);
//	domanda 
	domanda = "Cosa succede se mi arriva un prodotto di bassa qualita' rispetto a come viene presentato online?";
	risposta = "Ti bastera' recarti presso i nostri specialisti in sede che provederanno a verificare e risolvere il problema a tuo vantaggio";
	dataToggle = "risoluzioneErrore";
	id = "ResiRimborsi";
	creaCollapse(domanda, risposta, dataToggle, id);
//	domanda 
	domanda = "Cosa succede se non mi dovesse arrivare il prodotto entro quanto stabilito?";
	risposta = "In tal caso potra' recarsi in sede dove i nostri specialisti si occuperanno del caso ";
	dataToggle = "prodottoSmarrito";
	id = "ResiRimborsi";
	creaCollapse(domanda, risposta, dataToggle, id);
	
	if(acceso != "null")
	{
		var daSpegnere = document.getElementById(acceso);
		daSpegnere.style.fontWeight = 400;
	}
	var td = document.getElementById(id);
	td.style.fontWeight = 700;
	acceso = id;	
}

function creaDomandeSpedizioni() {
	var div =  document.getElementById("istanzaDomande");
	div.innerHTML = "";
	
//	domanda 
	var domanda = "In che modo posso accedere alla modalita' spedizione?";
	var risposta = "Si puo' accedere alla modalita' spedizione selezionando la medesima poco prima di finalizzare il pagamento";
	var dataToggle = "accessoSpedizione";
	var id = "Spedizioni";
	creaCollapse(domanda, risposta, dataToggle, id);
//	domanda 
	domanda = "Quali sono i tempi medi della spedizione?";
	risposta = "Generalmente la spedizione prevede massimo 10 giorni lavorativi e mediamente 5-6 giorni";
	dataToggle = "tempiSpedizione";
	id = "Spedizioni";
	creaCollapse(domanda, risposta, dataToggle, id);
//	domanda 
	domanda = "Chi si occupa della spedizione?";
	risposta = "La spedizione del pacco avviene tramite delle compagnie del settore";
	dataToggle = "chiTrasporta";
	id = "Spedizioni";
	creaCollapse(domanda, risposta, dataToggle, id);
//	domanda 
	domanda = "La cifra da pagare per il prodotto aumenta nel momento in cui scelgo di farmelo spedire a casa?";
	risposta = "No.";
	dataToggle = "costiDiSpedizione";
	id = "Spedizioni";
	creaCollapse(domanda, risposta, dataToggle, id);
	
	if(acceso != "null")
	{
		var daSpegnere = document.getElementById(acceso);
		daSpegnere.style.fontWeight = 400;
	}
	var td = document.getElementById(id);
	td.style.fontWeight = 700;
	acceso = id;	
}

function creaDomandeGestioneProfilo()
{
	var div =  document.getElementById("istanzaDomande");
	div.innerHTML = "";
	
//	domanda 
	var domanda = "Quanti tipi di utenti esistono?";
	var risposta = "Esistono due tipi di utente: l'utente acquirente di un prodotto e l'utente amministratore del sito";
	var dataToggle = "tipiUtenti";
	var id = "GestioneProfilo";
	creaCollapse(domanda, risposta, dataToggle, id);
//	domanda 
	domanda = "A cosa serve la domanda di sicurezza?";
	risposta = "A recuperare il tuo profilo nel momento in cui non riuscissi piu' ad effettuare l'accesso a causa dello smarrimento della password";
	dataToggle = "domandaSicurezza";
	id = "GestioneProfilo";
	creaCollapse(domanda, risposta, dataToggle, id);
//	domanda 
	domanda = "Posso registrarmi solo come utente base?";
	risposta = "Si. Non e' previsto un format per la registrazione di un account amministratore";
	dataToggle = "reg1";
	id = "GestioneProfilo";
	creaCollapse(domanda, risposta, dataToggle, id);
//	domanda 
	domanda = "Posso modificare il mio username in seguito alla registrazione?";
	risposta = "No. I dati richiesti alla registrazione non possono essere modificati per il momento";
	dataToggle = "modificaDati";
	id = "GestioneProfilo";
	creaCollapse(domanda, risposta, dataToggle, id);
	
	if(acceso != "null")
	{
		var daSpegnere = document.getElementById(acceso);
		daSpegnere.style.fontWeight = 400;
	}
	var td = document.getElementById(id);
	td.style.fontWeight = 700;
	acceso = id;
}

function creaDomandeAcquisti()
{
	var div =  document.getElementById("istanzaDomande");
	div.innerHTML = "";
	
//	domanda 
	var domanda = "Quali sono le tipologie di acquisti che si possono finalizzare all'interno del sito?";
	var risposta = "La nostra piattaforma si occupa piu' della vendita di prodotti a carattere tecnologico e digitale";
	var dataToggle = "tipologieDiAcquisti";
	var id = "Acquisti";
	creaCollapse(domanda, risposta, dataToggle, id);
//	domanda 
	domanda = "Esiste un numero limitato di acquisti che possono effettuare quotidianamente?";
	risposta = "Certo che no! Piu acquisti farai e meglio sara' sia per te che per noi naturalmente";
	dataToggle = "quantiAcquistiPossoFare";
	id = "Acquisti";
	creaCollapse(domanda, risposta, dataToggle, id);
//	domanda 
	domanda = "Esiste la possibilita' di inserire dei coupon per ottenere degli sconti relativamente ad un prodotto a cui sono interessato?";
	risposta = "Per il momento all'interno della piattaforma non e' stata inserita alcuna funzione a riguardo dal momento che il nostro sito presenta i prezzi migliori del mercato";
	dataToggle = "coupon";
	id = "Acquisti";
	creaCollapse(domanda, risposta, dataToggle, id);
//	domanda 
	domanda = "In quanti modi e' possibile finalizzare gli acquisti dei prodotti che intendo effettuare?";
	risposta = "Precedemente alla fase di pagamento e' possibile selezionare il tipo di ritiro che si vuole seguire: consegna a domicilio o ritiro in sede";
	dataToggle = "finalizzazione";
	id = "Acquisti";
	creaCollapse(domanda, risposta, dataToggle, id);
//	domanda 
	domanda = "Come posso ricercare un prodotto all'interno della piattaforma?";
	risposta = "Si puo fare per categorie oppure tramite la barra di ricerca in alto a sinistra nel menubar";
	dataToggle = "ricercaProdotti";
	id = "Acquisti";
	creaCollapse(domanda, risposta, dataToggle, id);

	if(acceso != "null")
	{
		var daSpegnere = document.getElementById(acceso);
		daSpegnere.style.fontWeight = 400;
	}
	var td = document.getElementById(id);
	td.style.fontWeight = 700;
	acceso = id;
}

function creaDomandeRegistrazione() {
	var div =  document.getElementById("istanzaDomande");
	div.innerHTML = "";
	
	var domanda = "Cosa succede se ho perso la password per effettuare l'accesso?";
	var risposta = "Potrai recuperare la password accedendo al settore dedicato per il recupero della password a cui si accede cliccando sul link 'Password Dimenticata' presente nella pagina del login";
	var dataToggle = "recuperoPassword";
	var id = "Registrazione";
	creaCollapse(domanda, risposta, dataToggle, id);
	domanda = "Per effettuare la registrazione e' necessario inserire i dati della propria Paypal?";
	risposta = "Per quanto riguarda l'accesso non e' richiesta l'immissione dei dati riguardanti la propria carta di credito";
	dataToggle = "richiestaPayPal";
	id = "Registrazione";
	creaCollapse(domanda, risposta, dataToggle, id);
	domanda = "Come ci si registra?";
	risposta = "Per registrarsi basta cliccare sul bottone 'Registrati' e e inserire i dati richiesti per completare i campi present in modo corretto";
	dataToggle = "comeRegistrarsi";
	id = "Registrazione";
	creaCollapse(domanda, risposta, dataToggle, id);
	domanda = "Come si accede?";
	risposta = "Per accedere basta cliccare sul bottone 'Accedi' e inserire username e password";
	dataToggle = "comeAccedere";
	id = "Registrazione";
	creaCollapse(domanda, risposta, dataToggle, id);
	domanda = "Devo essere maggiorenne per registrarmi?";
	risposta = "Per effettuare la registrazione non e' necessario avere 18 anni";
	dataToggle = "pegi18Uno";
	id = "Registrazione";
	creaCollapse(domanda, risposta, dataToggle, id);
	domanda = "E' richiesto un documento per la registrazione?";
	risposta = "No, per effettuare la registrazione non e' necessario inserire il codice o la foto di un documento";
	dataToggle = "richiestoDocumento";
	id = "Registrazione";
	creaCollapse(domanda, risposta, dataToggle, id);
	domanda = "Possono esistere due account con lo stesso username?";
	risposta = "No l'username e' univoco e quindi e' un identificativo per un account";
	dataToggle = "diversiAccount";
	id = "Registrazione";
	creaCollapse(domanda, risposta, dataToggle, id);
	domanda = "La password deve prevedere delle caratteristiche particolari?";
	risposta = "Si la password deve rispettare degli standard che se non rispettati verranno elencati in fase di registrazione";
	dataToggle = "password";
	id = "Registrazione";
	creaCollapse(domanda, risposta, dataToggle, id);
	
	if(acceso != "null")
	{
		var daSpegnere = document.getElementById(acceso);
		daSpegnere.style.fontWeight = 400;
	}
	
	var td = document.getElementById(id);
	td.style.fontWeight = 700;
	acceso = id;
	
	
}
//qua devo praticamente capire come fare a fare in modo che praticamente delle funzioni vengano richiamre all