<div id="menuBar" class="row">
	<a href="home" class="col">
	<div id="logo"></div>
	</a>
	<div id="whoWeAre" class="col">Chi Siamo</div>
	<div id="faq" class="col">
		<a href="faq">
			FAQ
		</a>
	</div>
	<div id="map" class="col">Mappa</div>
	<div id="assistance" class="col">Assistenza</div>	
	
	<div class="col">
      <div class="d-flex justify-content-center h-100">
        <div class="searchbar">
          <input class="search_input" type="text" name="" placeholder="Search...">
          <a href="#" class="search_icon"><i class="fa fa-search"></i></a>
        </div>
      </div>
    </div>
        
	<div class="col">
		<c:if test="${(utente == null)}">
			<c:if test="${amministratore == null}">
				<a href="registration">
					<button id="register" class="btn btn-outline-secondary">Registrati</button>
				</a>
			</c:if> 
			<c:if test="${amministratore != null}">
				<label id="welcomeAdm" class="badge badge-pill badge-warning text-wrap">
				<span> Ciao, ${amministratore.id}</span>
				</label>
			</c:if>
		</c:if>
		<c:if test="${utente != null}">
			<%-- <p id="welcomeUser">Benvenuto, ${utente.username}</p> --%>
		</c:if>
	</div>
	<div class="col">
		<c:if test="${(utente == null) && (amministratore == null)}">
			<a href="login">
				<button id="login" class="btn btn-primary">
					Accedi
				</button>
			</a>
		</c:if>
		<c:if test="${(utente != null) || (amministratore != null)}">
			<a href="login?logout=true">
				<button id="logout" class="btn btn-primary">
					Logout
				</button>
			</a>
		</c:if>
	</div>
	
</div>