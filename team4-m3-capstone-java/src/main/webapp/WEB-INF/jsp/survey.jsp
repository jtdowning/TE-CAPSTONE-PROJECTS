<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url ="/WEB-INF/jsp/header.jsp"/>

	<div style="padding: 30px;">
		<c:url value="/survey" var="survey"/>
		<form method="POST" action="${survey}">
		<table id="survey-form">
			<tr>
				<th>Email Address:</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<th>State of Residence: </th>
				<td><input type="text" name="state"></td>
			</tr>
			<tr>
				<th>Physical Activity Level: </th>
				<td><select name="activityLevel">
						<option value="inactive">Inactive</option>
						<option value="sedentary">Sedentary</option>
						<option value="active">Active</option>
						<option value="extremely active">Extremely Active</option>
					</select></td>
			</tr>
			<tr>
				<th>Favorite National Park:</th>
				<td><select name="parkCode">
						<option value="GNP">Glacier National Park</option>
						<option value="GCNP">Grand Canyon National Park</option>
						<option value="GTNP">Grand Teton National Park</option>
						<option value="MRNP">Mount Rainer National Park</option>
						<option value="GSMNP">Great Smoky Mountain National Park</option>
						<option value="ENP">Everglades National Park</option>
						<option value="YNP">Yellowstone National Park</option>
						<option value="YNP2">Yosemite National Park</option>
						<option value="CVNP">Cuyahoga Valley National Park</option>
						<option value="RMNP">Rocky Mountain National Park</option>
					</select></td>
			</tr>
		</table><br>
		<input id="submit" type="submit">
		</form>
	</div>
</body>
</html>