<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Result Page</title>
<link rel="stylesheet" href="<c:url value="/resources/css/common.css"/>"
	type="text/css" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/flightResult.css"/>" type="text/css" />
</head>
<body>
	<%@include file="header.jsp"%>
	<div id="content-wrapper">

		<form:form method="post" modelAttribute="matchedFlights">

			<div id="div-search-more">

				<a href="home">Search More...</a>
			</div>

			<div id="separator"></div>
			<div id="result-table">
				<table id="flight-result">
					<tr id="head-row">
						<th class="flight-table-cell-header">No.</th>
						<th class="flight-table-cell-header">flight Name</th>
						<th class="flight-table-cell-header">Flight Number</th>
						<th class="flight-table-cell-header">Departure Location</th>
						<th class="flight-table-cell-header">Arrival Location</th>
						<th class="flight-table-cell-header">Duration</th>
						<th class="flight-table-cell-header">Time</th>
						<th class="flight-table-cell-header">Seat Available</th>
						<th class="flight-table-cell-header">Fare</th>
						<th class="flight-table-cell-header">Class</th>
						<th class="flight-table-cell-header">Date</th>
					</tr>
					<c:if test="${empty matchedFlights }">
						<tr>
							<td colspan="15" id="no-result">No flights found that match
								your requirements!!</td>
						</tr>
					</c:if>

					<c:forEach items="${matchedFlights}" var="flightDetails"
						varStatus="status">
						<c:choose>
							<c:when test="${(status.count % 2)==0}">
								<tr>
									<td align="center" class="flight-table-cell">${status.count}</td>
									<td class="flight-table-cell center-aligned">${flightDetails.flight.flightName}</td>
									<td class="flight-table-cell center-aligned">${flightDetails.flightNumber}</td>
									<td class="flight-table-cell center-aligned">${flightDetails.departureLocation}</td>
									<td class="flight-table-cell center-aligned">${flightDetails.arrivalLocation}</td>
									<td class="flight-table-cell center-aligned">${flightDetails.flightDuration}</td>
									<td class="flight-table-cell center-aligned">${flightDetails.flightTime}</td>
									<td class="flight-table-cell center-aligned">${flightDetails.seatAvailable}</td>
									<td class="flight-table-cell center-aligned">${flightDetails.fare}</td>
									<td class="flight-table-cell center-aligned">${flightDetails.flightClass}</td>
									<td class="flight-table-cell center-aligned">${flightDetails.validTill}</td>

								</tr>
							</c:when>
							<c:otherwise>
								<tr class="alt">
									<td align="center" class="flight-table-cell">${status.count}</td>
									<td class="flight-table-cell center-aligned">${flightDetails.flight.flightName}</td>
									<td class="flight-table-cell center-aligned">${flightDetails.flightNumber}</td>
									<td class="flight-table-cell center-aligned">${flightDetails.departureLocation}</td>
									<td class="flight-table-cell center-aligned">${flightDetails.arrivalLocation}</td>
									<td class="flight-table-cell center-aligned">${flightDetails.flightDuration}</td>
									<td class="flight-table-cell center-aligned">${flightDetails.flightTime}</td>
									<td class="flight-table-cell center-aligned">${flightDetails.seatAvailable}</td>
									<td class="flight-table-cell center-aligned">${flightDetails.fare}</td>
									<td class="flight-table-cell center-aligned">${flightDetails.flightClass}</td>
									<td class="flight-table-cell center-aligned">${flightDetails.validTill}</td>

								</tr>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</table>
			</div>
		</form:form>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>