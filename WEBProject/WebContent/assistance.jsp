<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assistenza</title>

	<%@ include file="include.jsp" %>
	<script src="js/assistance.js"></script>
	<link rel="stylesheet" href="css/assistance.css">
	
</head>
<body <c:if test="${administrator != null}"> onload="changeColor()"</c:if> >
	
	<%@ include file="menuBar.jsp" %>
	
	<div id="assistanceContainer">
		<div id="chat">
			<c:if test="${user != null}">
			<c:if test="${needHelp == null}">
						<div id="noHelp">Non hai ancora fatto una domanda</div>
					</c:if>
				<div class="chatDisplay">
					<c:forEach var="myComment" items="${myComments}">
						<div <c:if test="${myComment.username != \"Tu\"}"> class="divAdmComment" </c:if> <c:if test="${myComment.username == \"Tu\"}"> class="divAssistanceComment" </c:if> > 
							<div <c:if test="${myComment.username != \"Tu\"}"> class="adminUsername" </c:if> <c:if test="${myComment.username == \"Tu\"}"> class="you" </c:if> >${myComment.username}</div><div>${myComment.content}</div>
						</div>
					</c:forEach>
				</div>
				<div id="divInputChat" class="input-group mb-3">
					<hr>
					<input id="inputQuestion" type="text" class="form-control" placeholder="Chiedi qualcosa agli amministratori..." aria-describedby="basic-addon2">
				  	<div class="input-group-append">
				    	<button id="buttonQuestion" class="btn btn-outline-warning" onclick="askQuestion()" type="button">Invia</button>
				  	</div>
				    <button id="buttonDelete" class="btn btn-outline-secondary" onclick="deleteComments()" type="button">Svuota chat</button>
				</div>
				
			</c:if>
			<c:if test="${administrator != null}">
			<c:if test="${thereAreQuestions == null}">
						<div id="noQuestions">Non ci sono domande dagli utenti</div>
					</c:if>
				<div class="chatDisplay adm">
					
					<c:forEach var="userQuestion" items="${allQuestions}" varStatus="loop">
						<div id="containerQuestion${loop.index}">
							<div class="divAssistanceComment">
								<div class="usernameQuestion">${userQuestion.username}</div><div>${userQuestion.content}</div>
							</div>
							<div class="divInput input-group mb-1">
								<input id="input${loop.index}" type="text" class="form-control" placeholder="Rispondi all'utente..." aria-describedby="basic-addon2">
							  	<div class="input-group-append">
							    	<button class="btn btn-outline-secondary buttonAnswer" onclick="answer('${loop.index}', '${userQuestion.username}', '${userQuestion.content}')" type="button">Invia</button>
							  	</div>
						  	</div>
							<hr class="chatHr">
						</div>
					</c:forEach>
				</div>
			</c:if>
		</div>
	</div>
	
	<%@ include file="footer.jsp" %>
</body>
</html>