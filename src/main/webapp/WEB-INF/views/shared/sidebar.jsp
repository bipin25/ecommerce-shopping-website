<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 class="my-4">My online Shop</h1>
<div class="list-group">
	<c:forEach items="${categoryList}" var="category">
	<a href="/productbycategoryid/${category.id}" class="list-group-item">${category.name}</a>
	</c:forEach> 

</div>

