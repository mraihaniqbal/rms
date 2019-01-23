<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		
		<title>Login RMS</title>
		<meta name="description" content="Index">
		<meta name="author" content="Mitrais">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
		<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
		<link rel="stylesheet" href="css/styles.css?v=1.0">
		
		<!--[if lt IE 9]>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script>
		<![endif]-->
	</head>
	
	<body>
		<div class="mdl-layout mdl-js-layout mdl-color--grey-100">
			<main class="mdl-layout__content" style="margin: 0px auto;">
				<img src="https://www.jaspersoft.com/sites/default/files/partner_logos/mitrais2.jpg"
					 style="width: 330px;margin: 20px auto;">
				<div class="mdl-card mdl-shadow--6dp">
					<form action="login" method="post">
						<div class="mdl-card__supporting-text">
							${error != null ? error : ""}
								<div class="mdl-textfield mdl-js-textfield">
									<input class="mdl-textfield__input" type="text" id="username" name="username" />
									<label class="mdl-textfield__label" for="username">Username</label>
								</div>
								<div class="mdl-textfield mdl-js-textfield">
									<input class="mdl-textfield__input" type="password" id="userpass" name="password" />
									<label class="mdl-textfield__label" for="userpass">Password</label>
								</div>
						</div>
						<div class="mdl-card__actions mdl-card--border">
							<button type="submit" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">Log in</button>
						</div>
					</form>
				</div>
			</main>
		</div>
		<script src="js/scripts.js"></script>
	</body>
</html>