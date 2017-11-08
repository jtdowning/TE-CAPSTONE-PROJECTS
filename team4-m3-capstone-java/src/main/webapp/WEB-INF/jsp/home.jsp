<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url ="/WEB-INF/jsp/header.jsp"/>

	<div>
		
		<c:forEach var="park" items="${allParks}">
			<div class="park" style="padding:30px;"> 
				<div class="park-image">
					<c:url var="parkDetails" value="/parkDetails">
						<c:param name="parkCode" value="${park.parkCode}"/></c:url>
					<a href="${parkDetails}">
						<img src="img/parks/${park.parkCode}.jpg">
				</div>
				<div class="park-details">
					 <h3> <c:out value="${park.name}"/></h3></a>			
					 Location:<c:out value ="${park.state}"/><br><br>
					 Description:<c:out value ="${park.description}"/><br>
				 </div>
			</div>
			<hr>
		</c:forEach>
	</div>

</body>
</html>