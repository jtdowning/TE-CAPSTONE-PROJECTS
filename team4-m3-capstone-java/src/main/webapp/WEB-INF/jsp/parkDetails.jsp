<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:formatNumber type="number" maxFractionDigits="2" value="${amount}"/>

<c:import url ="/WEB-INF/jsp/header.jsp"/>

	<div style="padding: 30px;">
		<div style="width: 100%, padding: 30px;">
			<img style="margin: 0 auto; display: block;" src="img/parks/${park.parkCode}.jpg">
		</div>		
		<p style="font-style: italic; font-size: 1.1em;">"${park.inspirationalQuote}" - ${park.inspirationalQuoteSource}</h4>
		<p><b>${park.name}</b></p>
		
		<table>
			<tr>
				<th>State:</th>
				<td>${park.state}</td>
			</tr>
			<tr>
				<th>Park Description:</th> 
				<td>${park.description}</td>
			</tr>
			<tr>
				<th>Park Acreage:</th>
				<td> ${park.acreage}</td>

			</tr>
			<tr>	
				<th>Elevation in Feet:</th>
				<td>	${park.elevationInFeet}</td>
			</tr>
			<tr>
				<th>Miles of Trail:</th>
				<td>${park.milesOfTrail}</td>
			</tr>
			<tr>
				<th>Number of Campsites:</th>
				<td>${park.numberOfCampsites}</td>
			</tr>
			<tr>
				<th>Climate:</th>
				<td>${park.climate}</td>
			</tr>
			<tr>
				<th>Year Founded:</th>
				<td>${park.yearFounded}</td>
			</tr>
			<tr>
				<th>Annual Visitor Count:</th>
				<td>${park.annualVisitorCount}</td>
			</tr>
			<tr>
				<th>Entry Fee:</th>
				<td>${park.entryFee}</td>
			</tr>
			<tr>
				<th>Number of Animal Species</th>
				<td>${park.numberOfAnimalSpecies}</td>
			</tr>
		</table><br>
		
		<h3>Park Forecasts</h3>
 		<div style="display: block">
			<c:url var="parkDetails" value="/parkDetails"/>
			<form action="${parkDetails}" method="POST">				
  				<input type="hidden" name="parkCode" value="${park.parkCode}"/>
				<input type="submit" class="To Celsius" value=<c:if test="${sessionScope.isCelsius}">
															 "Convert To Fahrenheit"</c:if>
															 <c:if test="${!sessionScope.isCelsius}">
															 "Convert To Celsius"</c:if>>
			</form>
		</div> 
		<div class="forecast">
			<div class="today-forecast">
				<p id="date">${formatter.format(parkForecast[0].date)}</p><br>
				<img src="${parkForecast[0].imgSrc}"/><br>
				<c:choose>
				<c:when test="${isCelsius}">
					<span class="hi-temp">Hi: ${((parkForecast[0].high - 32) * (5/9)).intValue()}C</span><br>  
					Low: ${((parkForecast[0].low - 32) * (5/9)).intValue()}C<br>
				</c:when>
				<c:otherwise>
					<span class="hi-temp">Hi: ${parkForecast[0].high}F</span><br>  
					Low: ${parkForecast[0].low}F<br>
				</c:otherwise>
				</c:choose>	
				<p>${parkForecast[0].recommendation}</p>
			</div>
			
			<c:forEach begin="1" end="${parkForecast.size() - 1}" var="i">
			<div class="daily-forecast">
				<p id="date">${formatter.format(parkForecast[i].date)}</p><br>
				<img src="${parkForecast[i].imgSrc}"/><br>
				<c:choose>
				<c:when test="${isCelsius}">
 					Hi: ${((parkForecast[i].high - 32) * (5/9)).intValue()}C<br>   
 					Low: ${((parkForecast[i].low - 32) * (5/9)).intValue()}C<br> 
				</c:when>
				<c:otherwise>
					Hi: ${parkForecast[i].high}F<br>  
					Low: ${parkForecast[i].low}F<br>
				</c:otherwise>
				</c:choose>		
			</div>
			</c:forEach>
		</div>

	</body>
</html>
