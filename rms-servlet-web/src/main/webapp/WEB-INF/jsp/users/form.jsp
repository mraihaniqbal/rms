<%@include file="../templates/header.jsp"%>
	<div class="mdl-card mdl-shadow--6dp">
		<div class="mdl-card__title mdl-color--primary mdl-color-text--white">
			<h2 class="mdl-card__title-text">${path == "add" ? "Add" : "Update" } User</h2>
		</div>
		<form action="${pageContext.request.contextPath}/users/${path}" method="post">
			<c:if test="${not empty user}">
				<input type="hidden" name="id" value="${user.id}"/>
			</c:if>
			<div class="mdl-card__supporting-text">
				<div class="mdl-textfield mdl-js-textfield">
					<input class="mdl-textfield__input" type="text" id="username" name="username"
							value="${empty user ? '' : user.userName}" />
					<label class="mdl-textfield__label" for="username">Username</label>
				</div>
				<div class="mdl-textfield mdl-js-textfield">
					<input class="mdl-textfield__input" type="password" id="userpass" name="password"
						   value="${empty user ? '' : user.password}"/>
					<label class="mdl-textfield__label" for="userpass">Password</label>
				</div>
			</div>
			<div class="mdl-card__actions mdl-card--border">
				<button type="submit" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">Save</button>
			</div>
		</form>
	</div>
<%@include file="../templates/footer.jsp"%>