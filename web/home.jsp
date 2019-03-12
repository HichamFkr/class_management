<%-- 
    Document   : home
    Created on : 8 déc. 2018, 15:23:12
    Author     : Hicham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
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

<h1 style="text-align: center;">Welcome MR ${sessionScope.nom}</h1>
<div id="side-menu" class="side-nav">
  <a href="#" class="btn-close" onclick="closeSlideMenu()">&times;</a>
  <a href="home.jsp">Home</a>
  <a href="students.et">Students</a>
</div>

<div id="main">
  <div class="form-group">
  <form action="save.et" method="post">
    
    <div class="input-group">
      <div class="input-left">
         <label>Nom: </label>
          <div class="input-form">
            <input type="text" name="nom" required="required">
          </div>
      </div>
      <div class="input-right">
        <label>Prénom: </label>
          <div class="input-form">
            <input type="text" name="prenom" required="required">
          </div>
      </div>
    </div>
   
    <div class="input-group">
      <div class="input-left">
        <label>Matricule: </label>
          <div class="input-form">
            <input type="text" name="matricule" required="required">
          </div>
      </div>
      <div class="input-right">
        <label>Groupe: </label>
        <div id="select-grp">
        <select id="selectBox" name="selectGroupe" required="required">
          <option>---</option>
          <c:forEach items="${sessionScope.listGrp}" var="c">
              <option value="${c.code}">${c.libelle}</option>
          </c:forEach>
        </select>
        </div>
      </div>
    </div>

    
    <div class="input-group">
      <div class="input-left">
        <label>Date de naissance: </label>
          <div class="input-form">
            <input type="date" name="dateNais">
          </div>
      </div>
      <div class="input-right">
        <label>Lieu de naissance: </label>
        <div class="input-form">
          <input type="text" name="lieuNais">
        </div>
      </div>
    </div>
    
      <div class="input-group">
          <div class="input-form">
              <label>Password: </label>
              <div class="input-left">
                  <input type="password" name="pw">
              </div>
          </div>
      </div>
    <button type="submit" value="Valider">Valider </button> 
  </form>
</div>


</div>



</body>
</html>
