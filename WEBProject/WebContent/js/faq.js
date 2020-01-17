//devo capire perchè in pratica non mi carica il collapse dal momento che mi dice che sto appendendo il nulle e quindi diciamo sembra non essere pronto a questa operazione
//all'inizio è meno uno ma poi diventa la stringa che definisce l'id del td che in pratica è stato switchedOn
var switchedOn = "null";

// ATTENZIONE: questa classe potrebbe essere migliorata estraendo le stringhe delle domande e delle risposte dal database (COSA CHE ATTUALMENTE NON HO FATTO e non so se lo farò)

//funzione di creazione di un collapse
function createCollapse(question,  answer, dataToggle, id ){
	
	var collapse = document.createElement("button");
	collapse.innerHTML = question; 
	collapse.className = "btn btn-outline-secondary";
	collapse.setAttribute("data-toggle","collapse");
	collapse.setAttribute("data-target","#"+dataToggle);
	document.getElementById("istanzaDomande").appendChild(collapse);
	
	var div = document.createElement("div");
	div.innerHTML = answer;
	div.setAttribute("class","collapse");
	div.setAttribute("id",dataToggle);
	document.getElementById("istanzaDomande").appendChild(div);
	var br = document.createElement("br");
	document.getElementById("istanzaDomande").appendChild(br);
}

function createQuestionsResiRimborsi()
{
	var div =  document.getElementById("istanzaDomande");
	div.innerHTML = "";
	
//	question 
	var question = "E' possibile ottenere il rimborso di un prodotto?";
	var answer = "No dal momento che seguiamo delle politiche secondo cui ci assicuriamo che il cliente abbia sempre cio' che ha scelto";
	var dataToggle = "rimborsoProdotto";
	var id = "ResiRimborsi";
	createCollapse(question, answer, dataToggle, id);
//	question 
	question = "Cosa succede se sbaglio ad effettuare un acquisto?";
	answer = "Il prodotto restera' fino al marcire dei suoi giorni nella casa del cliente";
	dataToggle = "erroreAcquisto";
	id = "ResiRimborsi";
	createCollapse(question, answer, dataToggle, id);
//	question 
	question = "Cosa succede se mi arriva un prodotto di bassa qualita' rispetto a come viene presentato online?";
	answer = "Ti bastera' recarti presso i nostri specialisti in sede che provederanno a verificare e risolvere il problema a tuo vantaggio";
	dataToggle = "risoluzioneErrore";
	id = "ResiRimborsi";
	createCollapse(question, answer, dataToggle, id);
//	question 
	question = "Cosa succede se non mi dovesse arrivare il prodotto entro quanto stabilito?";
	answer = "In tal caso potra' recarsi in sede dove i nostri specialisti si occuperanno del caso ";
	dataToggle = "prodottoSmarrito";
	id = "ResiRimborsi";
	createCollapse(question, answer, dataToggle, id);
	
	if(switchedOn != "null")
	{
		var toTurnOff = document.getElementById(switchedOn);
		toTurnOff.style.fontWeight = 400;
	}
	var td = document.getElementById(id);
	td.style.fontWeight = 700;
	switchedOn = id;	
}

function createQuestionsSpedizioni() {
	var div =  document.getElementById("istanzaDomande");
	div.innerHTML = "";
	
//	question 
	var question = "In che modo posso accedere alla modalita' spedizione?";
	var answer = "Si puo' accedere alla modalita' spedizione selezionando la medesima poco prima di finalizzare il pagamento";
	var dataToggle = "accessoSpedizione";
	var id = "Spedizioni";
	createCollapse(question, answer, dataToggle, id);
//	question 
	question = "Quali sono i tempi medi della spedizione?";
	answer = "Generalmente la spedizione prevede massimo 10 giorni lavorativi e mediamente 5-6 giorni";
	dataToggle = "tempiSpedizione";
	id = "Spedizioni";
	createCollapse(question, answer, dataToggle, id);
//	question 
	question = "Chi si occupa della spedizione?";
	answer = "La spedizione del pacco avviene tramite delle compagnie del settore";
	dataToggle = "chiTrasporta";
	id = "Spedizioni";
	createCollapse(question, answer, dataToggle, id);
//	question 
	question = "La cifra da pagare per il prodotto aumenta nel momento in cui scelgo di farmelo spedire a casa?";
	answer = "No.";
	dataToggle = "costiDiSpedizione";
	id = "Spedizioni";
	createCollapse(question, answer, dataToggle, id);
	
	if(switchedOn != "null")
	{
		var toTurnOff = document.getElementById(switchedOn);
		toTurnOff.style.fontWeight = 400;
	}
	var td = document.getElementById(id);
	td.style.fontWeight = 700;
	switchedOn = id;	
}

function createQuestionsGestioneProfilo()
{
	var div =  document.getElementById("istanzaDomande");
	div.innerHTML = "";
	
//	question 
	var question = "Quanti tipi di utenti esistono?";
	var answer = "Esistono due tipi di utente: l'utente acquirente di un prodotto e l'utente amministratore del sito";
	var dataToggle = "tipiUtenti";
	var id = "GestioneProfilo";
	createCollapse(question, answer, dataToggle, id);
//	question 
	question = "A cosa serve la question di sicurezza?";
	answer = "A recuperare il tuo profilo nel momento in cui non riuscissi piu' ad effettuare l'accesso a causa dello smarrimento della password";
	dataToggle = "questionSicurezza";
	id = "GestioneProfilo";
	createCollapse(question, answer, dataToggle, id);
//	question 
	question = "Posso registrarmi solo come utente base?";
	answer = "Si. Non e' previsto un format per la registrazione di un account amministratore";
	dataToggle = "reg1";
	id = "GestioneProfilo";
	createCollapse(question, answer, dataToggle, id);
//	question 
	question = "Posso modificare il mio username in seguito alla registrazione?";
	answer = "No. I dati richiesti alla registrazione non possono essere modificati per il momento";
	dataToggle = "modificaDati";
	id = "GestioneProfilo";
	createCollapse(question, answer, dataToggle, id);
	
	if(switchedOn != "null")
	{
		var toTurnOff = document.getElementById(switchedOn);
		toTurnOff.style.fontWeight = 400;
	}
	var td = document.getElementById(id);
	td.style.fontWeight = 700;
	switchedOn = id;
}

function createQuestionsAcquisti()
{
	var div =  document.getElementById("istanzaDomande");
	div.innerHTML = "";
	
//	question 
	var question = "Quali sono le tipologie di acquisti che si possono finalizzare all'interno del sito?";
	var answer = "La nostra piattaforma si occupa piu' della vendita di prodotti a carattere tecnologico e digitale";
	var dataToggle = "tipologieDiAcquisti";
	var id = "Acquisti";
	createCollapse(question, answer, dataToggle, id);
//	question 
	question = "Esiste un numero limitato di acquisti che possono effettuare quotidianamente?";
	answer = "Certo che no! Piu acquisti farai e meglio sara' sia per te che per noi naturalmente";
	dataToggle = "quantiAcquistiPossoFare";
	id = "Acquisti";
	createCollapse(question, answer, dataToggle, id);
//	question 
	question = "Esiste la possibilita' di inserire dei coupon per ottenere degli sconti relativamente ad un prodotto a cui sono interessato?";
	answer = "Per il momento all'interno della piattaforma non e' stata inserita alcuna funzione a riguardo dal momento che il nostro sito presenta i prezzi migliori del mercato";
	dataToggle = "coupon";
	id = "Acquisti";
	createCollapse(question, answer, dataToggle, id);
//	question 
	question = "In quanti modi e' possibile finalizzare gli acquisti dei prodotti che intendo effettuare?";
	answer = "Precedemente alla fase di pagamento e' possibile selezionare il tipo di ritiro che si vuole seguire: consegna a domicilio o ritiro in sede";
	dataToggle = "finalizzazione";
	id = "Acquisti";
	createCollapse(question, answer, dataToggle, id);
//	question 
	question = "Come posso ricercare un prodotto all'interno della piattaforma?";
	answer = "Si puo fare per categorie oppure tramite la barra di ricerca in alto a sinistra nel menubar";
	dataToggle = "ricercaProdotti";
	id = "Acquisti";
	createCollapse(question, answer, dataToggle, id);

	if(switchedOn != "null")
	{
		var toTurnOff = document.getElementById(switchedOn);
		toTurnOff.style.fontWeight = 400;
	}
	var td = document.getElementById(id);
	td.style.fontWeight = 700;
	switchedOn = id;
}

function createQuestionsRegistrazione() {
	var div =  document.getElementById("istanzaDomande");
	div.innerHTML = "";
	
	var question = "Cosa succede se ho perso la password per effettuare l'accesso?";
	var answer = "Potrai recuperare la password accedendo al settore dedicato per il recupero della password a cui si accede cliccando sul link 'Password Dimenticata' presente nella pagina del login";
	var dataToggle = "recuperoPassword";
	var id = "Registrazione";
	createCollapse(question, answer, dataToggle, id);
	question = "Per effettuare la registrazione e' necessario inserire i dati della propria Paypal?";
	answer = "Per quanto riguarda l'accesso non e' richiesta l'immissione dei dati riguardanti la propria carta di credito";
	dataToggle = "richiestaPayPal";
	id = "Registrazione";
	createCollapse(question, answer, dataToggle, id);
	question = "Come ci si registra?";
	answer = "Per registrarsi basta cliccare sul bottone 'Registrati' e e inserire i dati richiesti per completare i campi present in modo corretto";
	dataToggle = "comeRegistrarsi";
	id = "Registrazione";
	createCollapse(question, answer, dataToggle, id);
	question = "Come si accede?";
	answer = "Per accedere basta cliccare sul bottone 'Accedi' e inserire username e password";
	dataToggle = "comeAccedere";
	id = "Registrazione";
	createCollapse(question, answer, dataToggle, id);
	question = "Devo essere maggiorenne per registrarmi?";
	answer = "Per effettuare la registrazione non e' necessario avere 18 anni";
	dataToggle = "pegi18Uno";
	id = "Registrazione";
	createCollapse(question, answer, dataToggle, id);
	question = "E' richiesto un documento per la registrazione?";
	answer = "No, per effettuare la registrazione non e' necessario inserire il codice o la foto di un documento";
	dataToggle = "richiestoDocumento";
	id = "Registrazione";
	createCollapse(question, answer, dataToggle, id);
	question = "Possono esistere due account con lo stesso username?";
	answer = "No l'username e' univoco e quindi e' un identificativo per un account";
	dataToggle = "diversiAccount";
	id = "Registrazione";
	createCollapse(question, answer, dataToggle, id);
	question = "La password deve prevedere delle caratteristiche particolari?";
	answer = "Si la password deve rispettare degli standard che se non rispettati verranno elencati in fase di registrazione";
	dataToggle = "password";
	id = "Registrazione";
	createCollapse(question, answer, dataToggle, id);
	
	if(switchedOn != "null")
	{
		var toTurnOff = document.getElementById(switchedOn);
		toTurnOff.style.fontWeight = 400;
	}
	
	var td = document.getElementById(id);
	td.style.fontWeight = 700;
	switchedOn = id;
	
	
}
