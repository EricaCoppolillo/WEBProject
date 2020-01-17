<div id="menuBar" class="row align-items-center">
	
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
	
	 <div id="containerSearchBar" class="col">
      <div class="d-flex justify-content-center">
        <div class="searchbar">
          <input class="search_input" type="text" name="" placeholder="Cerca...">
          <a href="#" class="search_icon"><i class="fa fa-search"></i></a>
        </div>
      </div>
    </div>
    	<c:choose>
		<c:when test="${(utente == null) && (amministratore == null)}">
			<div class="col">
				<a href="registration">
					<button id="register" class="btn btn-outline-secondary">Registrati</button>
				</a>
			</div>
		</c:when>
		<c:otherwise>
			
			<c:if test="${amministratore!=null}">
			<div class="col">
				<a href="..servletAddProduct">
					<button id="buttonAddProduct" class="btn btn">
						Aggiungi Prodotto
					</button>
				</a>
			</div>
			</c:if>
		</c:otherwise>
		</c:choose>
	
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