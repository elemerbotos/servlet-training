<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my" uri="myBeautifulTags" %>

<html>
<%@ include file="/WEB-INF/JPSF/header.jspf" %>
<body>
<div class="noMargin page-header">
	<h1 id="title">STAR WARS</h1>
</div>
<div class="row">
<div class="col-md-8">
<h2 id="setPaddingToLarger">  ${battle.name} </h2>
<h3 id="setPaddingToLarger">  The 2 armies:</h3>
<my:forEach var="army" items="${battle.battlefield.armies}">
     <table class="table" id="darkBg">
      	<tr id="tableHeader1">
      	 <td id="tableHeader">Name</td>
      	 <td id="tableHeader">Gender</td>
      	</tr>
      	<tr><td colspan="3">Attacker Soldiers</td></tr>
      	<my:forEach var="soldier" items="${army.attackers}">
      	<tr>
   			<td>${soldier.name} </td>
   			<td>${soldier.gender} </td>
	    </tr>
	    </my:forEach>
	    <tr><td colspan="3">Defender Soldiers</td></tr>
	    <my:forEach var="soldier" items="${army.defenders}">
	    <tr>
     		<td>${soldier.name} </td>
   			<td>${soldier.gender} </td>
	    </tr>
	    </my:forEach>
	    <tr><td colspan="3">Jedis</td></tr>
	    <my:forEach var="soldier" items="${army.jedis}">
	    <tr>
      		<td>${soldier.name} </td>
   			<td>${soldier.gender} </td>
	    </tr>
	    </my:forEach>
      </table>
     <br>
</my:forEach>
</div>
<div class="col-md-4"></div>
</div>
<button class="startButton">START BATTLE </button>
<div id="attackersWon">Attackers won!</div>
<div id="defendersWon">Defenders won!</div>
<div id="battleReport"></div>
</body>
<%@ include file="/WEB-INF/JPSF/footer.jspf" %>
</html>