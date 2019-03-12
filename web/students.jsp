<%-- 
    Document   : students
    Created on : 8 déc. 2018, 15:27:33
    Author     : Hicham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <script type="text/javascript" src="script.js"></script>
    </head>
<body>
<nav class="navbar">
    <span class="open-slide">
      <a href="#" onclick="openSlideMenu()">
        <svg width="30" height="30">
            <path d="M0,5 30,5" stroke="#fff" stroke-width="5"/>
            <path d="M0,14 30,14" stroke="#fff" stroke-width="5"/>
            <path d="M0,23 30,23" stroke="#fff" stroke-width="5"/>
        </svg>
      </a>
    </span>
    <ul class="navbar-nav">
      <li><a href="login.jsp">Logout</a></li>
    </ul>
</nav>
<h1 style="text-align: center;">Welcome MR Student Name</h1>
<div id="side-menu" class="side-nav">
  <a href="#" class="btn-close" onclick="closeSlideMenu()">&times;</a>
  <a href="home.jsp">Home</a>
  <a href="students.jsp">Students</a>
</div>

<div id="main">
<div id="select-grp">
    <form method="" action="listStudents.et">
        <select id="selectBox" name="selectGroupe">
          <option value="tout">Tout</option>
            <c:forEach items="${sessionScope.listGrp}" var="c">
                  <option value="${c.code}">${c.libelle}</option>
            </c:forEach>
        </select>
        <button type="submit" value="filtrer">Filtrer</button> 
    </form>
    <button>
        <a href="home.jsp">ADD</a>
    </button>
    
    
</div>

<div id="studentsList">
        <c:forEach items="${sessionScope.listEtudiant}" var="c">
            <div class="student">
		<div class="studentImg">
			<img src="profile-placeholder.png">
		</div>
		<div class="studentInfo">
			<p class="studentName">${c.nom} ${c.prenom}</p>
			<p class="studentMat">${c.matricule}</p>
                        <p class="studentGrp"> Groupe ${c.code}</p>
		</div>
            </div>
        </c:forEach>	
</div>

</div>

</body>
</html>
