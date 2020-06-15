<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">

	<nav>
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="/home">Home</a></li>
			<li class="breadcrumb-item"><a href="/productlist">Products</a></li>
			<li class="breadcrumb-item active">${product.name}</li>
		</ol>
	</nav>

	<div class="row">

		<div class="col-xs-12 col-lg-5">
			<div class="thumbnail">
				<img alt="" src="/assets/images/${product.code}.jpg"
					class="img img-responsive" style="width: 100%">
			</div>
		</div>

		<div class="col-xs-12 col-lg-7">
			<h3>${product.name }</h3>
			<hr />
			<p>${product.description }</p>
			<hr />
			<h4>
				Price: <strong>${product.unitPrice}</strong>
			</h4>
			<hr />
			<c:choose>
				<c:when test="${product.quantity<1}">
					<h6>Qty. Available: <span style="color: red">Out of Stock</span></h6>
					<hr />
					<a href="#" class="btn btn-success disabled"><span><i
							class="fa fa-shopping-cart" aria-hidden="true"></i></span>Add to Cart</a>
				</c:when>
				<c:otherwise>
					<h6>Qty. Available: ${product.quantity}</h6>
					<hr />
					<a href="/cart/add/${product.id}" class="btn btn-success"><span><i
							class="fa fa-shopping-cart" aria-hidden="true"></i></span>Add to Cart</a>
				</c:otherwise>
			</c:choose>

			<a href="/productlist" class="btn btn-primary">Back</a>

		</div>
	</div>

</div>
