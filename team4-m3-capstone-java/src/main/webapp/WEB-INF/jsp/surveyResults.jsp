<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url ="/WEB-INF/jsp/header.jsp"/>
	<h3>Here are five of the top parks, according to our great site's visitors!</h3>
	<div>
		<c:forEach var="park" items="${topFiveParks}">
			<div class="survey-result" style="padding-left:30px;">
				<div>
					<img src="img/parks/${park.parkCode}.jpg">
				</div>
				<div>
					<h3>${park.name}</h3>
					<p>${park.description}</p>
				</div>
				<hr>
			</div>
		</c:forEach>
	</div>
</body>
</html>