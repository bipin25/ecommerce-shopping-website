<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!-- Modal for add Category -->
<div class="modal fade" id="addCategoryModal" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Add New Category</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">

				<sf:form id="categoryForm" modelAttribute="category" action="/manage/category"
					method="POST">
					<div class="form-group">
						<label for="productName">Category Name</label>
						<sf:input type="text" class="form-control"
							path="name"/>
						<sf:errors path="name" cssStyle="color: #ff0000;" />
					</div>
					<div class="form-group">
						<label for="description">Category Description</label>
						<sf:textarea class="form-control"
							path="description"></sf:textarea>
						<sf:errors path="description" cssStyle="color: #ff0000;" />
					</div>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">Add Category</button>
				</sf:form>
			</div>
		</div>
	</div>
</div>

<div class="container">
	<div class="row">
		<div class=" col-md-8 offset-md-2 sm-12">
			<c:if test="${not empty message}">
				<div class="alert alert-success alert-dismissible fade show"
					role="alert">
					${message}
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:if>
			<c:if test="${not empty validationError}">
				<div class="alert alert-danger alert-dismissible fade show"
					role="alert">
					${validationError}
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:if>
			<div class="card">
				<div class="card-header text-center">
					<h3>Product Management</h3>
				</div>
				<div class="card-body">
					<sf:form modelAttribute="product" action="/manage/product"
						method="POST" enctype="multipart/form-data">
						<div class="form-group">
							<label for="productName">Product Name</label>
							<sf:input type="text" class="form-control" id="productName"
								path="name"/>
							<sf:errors path="name" cssStyle="color: #ff0000;" />
						</div>

						<div class="form-group">
							<label for="brandName">Brand Name</label>
							<sf:input type="text" class="form-control" id="brandName"
								path="brand" />
							<sf:errors path="brand" cssStyle="color: #ff0000;" />
						</div>
						<div class="form-group">
							<label for="description">Product Description</label>
							<sf:textarea class="form-control" id="description"
								path="description"></sf:textarea>
							<sf:errors path="description" cssStyle="color: #ff0000;" />
						</div>
						<div class="form-group">
							<label for="price">Price</label>
							<sf:input type="number" class="form-control" id="price"
								path="unitPrice" />
							<sf:errors path="unitPrice" cssStyle="color: #ff0000;" />
						</div>
						<div class="form-group">
							<label for="quantity">Quantity</label>
							<sf:input type="number" class="form-control" id="quantity"
								path="quantity" />
							<sf:errors path="quantity" cssStyle="color: #ff0000;" />
						</div>
						<div class="form-group">
							<label for="category">Category</label>
							<sf:select class="form-control" id="category" path="category.id"
								items="${categories}" itemLabel="name" itemValue="id" />
							<sf:errors path="category.id" cssStyle="color: #ff0000;" />
						</div>

						<div class="form-group">
							<label for="file">Select an Product Image: </label>
							<sf:input type="file" class="form-control" id="file" path="file" />
							<sf:errors path="file" cssStyle="color: #ff0000;" />
						</div>

						<div class="text-right">
							<button type="button" class="btn btn-secondary btn-sm"
								data-toggle="modal" data-target="#addCategoryModal">Add
								Category</button>
						</div>

						<div class="form-group" style="align-items: center;">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
						<!-- hidden field to avoid picking default values -->
						<sf:hidden path="id" />
						<sf:hidden path="code" />
						<sf:hidden path="userDetails.id" />
						<sf:hidden path="purchases" />
						<sf:hidden path="views" />
						<sf:hidden path="isActive" />

					</sf:form>
				</div>
			</div>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-xs-12 col-md-12">
			<h3 align="center">Available Products</h3>
			<hr>
			<table id="manageProductListTable"
				class="table  table-striped table-borderd">
				<thead>
					<tr>
						<th></th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Available</th>
						<th>Price</th>
						<th>Active</th>
						<th>Edit</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productList }" var="product">
						<tr>
							<td><img alt="#" src="/assets/images/${product.code}.jpg"
								style="width: 80px; height: 80px" /></td>
							<td>${product.name}</td>
							<td>${product.brand}</td>
							<c:choose>
								<c:when test="${product.quantity<1}">
									<td style="text-align: center; color: red">Out of Stock</td>
								</c:when>
								<c:otherwise>
									<td style="text-align: center;">${product.quantity}</td>
								</c:otherwise>
							</c:choose>
							<td>&#8377 ${product.unitPrice}</td>
							<td><label class="switch"> <input type="checkbox">
									<span class="slider round"></span>
							</label></td>

							<td><a href="/manage/product/${product.id}"
								class="btn btn-success btn-sm"><i
									class="fa fa-pencil-square-o fa-2x" aria-hidden="true"></i></a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
