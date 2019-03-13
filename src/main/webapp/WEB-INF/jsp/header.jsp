
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" />
   
<link rel="stylesheet" href="css/site.css" />
<title>National Parks</title>
</head>
<body>
<c:url value="/" var="homePageURL" />
<c:url value="/survey" var="surveyURL"/>


    <header>
        <h1>National Parks</h1>        
    </header>
    <nav>
        <ul>
            <li><a href="${homePageURL}">Home</a></li>
            <li><a href="${surveyURL}">Survey</a></li>
           
            
        </ul>
    </nav>    
        


