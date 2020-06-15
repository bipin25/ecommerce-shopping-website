<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
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
			<c:if test="${not empty errorMessage}">
				<div class="alert alert-danger alert-dismissible fade show"
					role="alert">
					${errorMessage}
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
								path="name" />
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
</div>
