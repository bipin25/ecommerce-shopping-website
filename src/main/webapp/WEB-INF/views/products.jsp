<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<div class="row">
		<div class="col-lg-3">
			<%@ include file="./shared/sidebar.jsp"%>
		</div>
		<div class="col-lg-9">
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="/home">Home</a></li>
					<li class="breadcrumb-item active">Products</li>
				</ol>
			</nav>
			<table id="productListTable"
				class="table  table-striped table-borderd">
				<thead>
					<tr>
						<th></th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Available</th>
						<th>Price</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productList }" var="product">
						<tr>
							<td><img alt="#" src="/assets/images/${product.code}.jpg"
								style="width: 80px; height: 80px" /></td>
							<td>${product.name}</td>
							<td>${product.unitPrice}</td>

							<c:choose>
								<c:when test="${product.quantity<1}">
									<td style="text-align: center; color: red">Out of Stock</td>
								</c:when>
								<c:otherwise>
									<td style="text-align: center;">${product.quantity}</td>
								</c:otherwise>
							</c:choose>


							<td>&#8377 ${product.unitPrice}</td>
							<td><a href="/productbyid/${product.id}"
								class="btn btn-primary btn-sm"><i class="fa fa-eye fa-2x"
									aria-hidden="true"></i></a></td>

							<c:choose>
								<c:when test="${product.quantity<1}">
									<td><a href="/cart/add/${product.id}"
										class="btn btn-success btn-sm disabled"><i
											class="fa fa-shopping-cart fa-2x" aria-hidden="true"></i></a></td>
								</c:when>
								<c:otherwise>
									<td><a href="/cart/add/${product.id}"
										class="btn btn-success btn-sm"><i
											class="fa fa-shopping-cart fa-2x" aria-hidden="true"></i></a></td>
								</c:otherwise>
							</c:choose>


						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
