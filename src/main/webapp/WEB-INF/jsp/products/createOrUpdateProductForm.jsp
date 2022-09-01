<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="product">
	<jsp:body>
	<h2>
	Product
	</h2>
	<form:form modelAttribute="product" class="form-horizontal">
		<div class="form-group has-feedback">
			<petclinic:inputField label="Name" name="name" />
			<petclinic:inputField label="Price" name="price" />
		</div>
		<div>
			<petclinic:selectField label="Product type" name="productType"
					size="${productTypes.size()}" names="${productTypes }" />
		</div>
		<div class="form-group">
			<input type="hidden" name="id" value="${card.id}">
			<button class="btn btn-default" type="submit">Add product</button>
		</div>
	</form:form>
	
	</jsp:body>

</petclinic:layout>