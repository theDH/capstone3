
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.4/css/bulma.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" />
   
<link rel="stylesheet" href="css/site.css" />
<title>National Parks</title>
</head>
<body>
<c:url value="/" var="homePageURL" />
<c:url value="/survey" var="surveyURL"/>

<section class="hero is-medium is-dark is-bold ">
	<div class="hero-body">
		<div class="container">
			<img id="logo" src="img/logo.png"/>

		</div>
	</div>
  <div class="hero-foot">
    <nav class="tabs">
      <div class="container">
        <ul>
          <li class="is-active"><a>Overview</a></li>
          <li><a href="${homePageURL}">Home</a></li>
            <li><a href="${surveyURL}">Survey</a></li>
          
          
        </ul>
      </div>
    </nav>
  </div>
    
        
 </section>       


