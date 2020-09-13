<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="container">
	<div class="row">
		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				<div class="panel-body">
					<!-- FORM ELEMENTS -->
					<sf:form class="form-horizontal" modelAttribute="product" action="${contextRoot}/manage/products" method="POST" enctype="multipart/form-data">
						<div class="form-grorp">
							<label class="control-label col-md-4" for="name">Enter Product Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name" placeholder="Product Name" class="form-control"/>
								<sf:errors path="name" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-grorp">
							<label class="control-label col-md-4" for="brand">Enter Brand Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand" placeholder="Brand Name" class="form-control"/>
								<sf:errors path="brand" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-grorp">
							<label class="control-label col-md-4" for="description">Product Description:</label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4" placeholder="Give a description" class="form-control"></sf:textarea>
								<sf:errors path="description" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-grorp">
							<label class="control-label col-md-4" for="unitPrice">Enter Unit Price:</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice" placeholder="Unit Price in &#8377" class="form-control"/>
								<sf:errors path="unitPrice" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-grorp">
							<label class="control-label col-md-4" for="quantity">Quantity Available:</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity" placeholder="Quantity Available" class="form-control"/>
							</div>
						</div>
						<div class="form-grorp">
							<label class="control-label col-md-4">Select an Image:</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control"/>
								<sf:errors path="file" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-grorp">
							<label class="control-label col-md-4" for="categoryId">Select Category:</label>
							<div class="col-md-8">
								<sf:select class="form-control" path="categoryId" id="categoryId"
									items="${categories}"
									itemLabel="name"
									itemValue="id"
								/>
							</div>
						</div>
						<div class="form-grorp">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary"/>
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
	
	<hr/>	
	<h1>Available Products</h1>
	<hr/>
	
	<div class="row">	
		<div class='col-xs-12'>
			<table id="productsTable" class="table table-condensed table-bordered">		
				<thead>					
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>					
				</thead>
				<tfoot>
					<tr>					
						<th>4</th>
						<th>
							<img class="adminDataTableImg" src="${contextRoot}/resources/images/PRDMNO123PQRX.jpg" alt="Macbook Pro"/>
						</th>
						<th>Macbook Pro</th>
						<th>3</th>
						<th>&#8377; 54000.00/-</th>
						<th>
							<!-- Toggle Switch -->
							<label class="switch">
								<input type="checkbox" checked="checked" value="4"/>
								<div class="slider"></div>
							</label>
						</th>				
						<th>
							<a href="${contextRoot}/manage/4/product" class="btn btn-light">
								<span class="fas fa-pencil"></span>
							</a>
						</th>
					</tr>									
				</tfoot>		
			</table>
		</div>
	</div>
</div>