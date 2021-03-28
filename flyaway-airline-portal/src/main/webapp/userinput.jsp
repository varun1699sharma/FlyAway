<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<title>Passenger User Form</title>
</head>
<body>
<form action="action_form_process.jsp" method="GET">
<div class="radio"></div>
                <input type="radio" id="one" name="trip" value="oneway" checked>
                <label for="one">One Way</label>
                <input type="radio" id="round" name="trip" value="roundtrip">
                <label for="roundtrip">Round Trip</label><br>
                Flying From: <input type="text" name="source"><br>
				Flying To: <input type="text" name="destination"><br>
				<label>Departure Date</label>
    			<input type="date" name ="departure" class="form-control select-date"><br>
    			<label>Returning Date</label>
    			<input type="date" name="returning" class="form-control select-date"><br>
				<label>Adults</label>
    			<input type="number" class="form-control" value="1">
				<label>Children</label>
    			<input type="number" class="form-control" value="0"><br>
    			<label>Travel Class</label>
    			<select class="custom-select">
   				<option value='Eco'>Economy Class</option>
   				<option value='First'>First Class</option><br>
   				</select>
<input type="submit" value="Submit" />
</form>
</body>
</html>

