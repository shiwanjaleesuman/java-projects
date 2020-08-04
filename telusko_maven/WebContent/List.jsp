<%@page import="com.product.list.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.product.list.dao.ProductDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Product List</title>
	<!-- <link rel="stylesheet" href="stylesheet.css"/> -->
</head>
<body>
	<!-- <h1>Product(s) List</h1><hr> -->
	<!-- <div class="input"> -->
		<form action="list" method="post">
			<table>
				<tr>
					<td>
						<label>Code/SKU</label>&nbsp;&nbsp;&nbsp;<input type="text" name="code">
					</td>
					<td>
						<input type="submit" name="Find" value="Find">
					</td>
					<tr>
					<td>
						<a href="NewProductList.jsp"><input type="button" name="New" value="New"></a>
					</td>
					<td>
						<a href="NewProductList.jsp"><input type="button" name="Delete" value="Delete" ></a>
					</td>
					<td>
						<input type="button" onclick='selectAll()' value="Select All"/>
					</td>
					<td>
						<input type="button" onclick='UnSelectAll()' value="Unselect All"/>
					</td>
				</tr>
				</tr>
			</table>
		</form>
	<!-- </div> -->
		<table id="dataTable">
			<h3>Product(s) List</h3>
			<!-- Modal body -->
			<div class="modal-body">
		    	Are you sure you want to delete the record? You can not further view the record in your list, if you delete.
		    </div>
		    <div class="modal-footer">
		       <button type='button' class='btn btn-danger btn-sm btn-ok' id="action"  onclick='rejectRequest(this)' data-toggle='modal' data-target='#rejectModel'>Delete</button>         
		       <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
		    </div>
			<tr>
				<th><input id="checkAll" type="button"  value="Check All">
				<!-- <a href="#" id="checkAll" onclick='selectAll()'>Select All</a> --></th><th>Code/SKU</th><th>Name</th><th>Price</th>
			</tr>
			<% 
				String tCode = request.getParameter("code"); 
		        if (tCode == null || tCode.isEmpty()) { %> 
			     <div>
						<c:forEach items="${Products}" var="prod">
							<tr>
								<div class="button">
									<td>
										<input type="checkbox" name="checkbox">
									</td>
								</div>
								<td>
									<%-- <c:out value="${prod.code}"/> --%> <a href="UpdateProductRecord.jsp">${prod.code}</a> 
								</td>
								<td>
									${prod.name}
								</td>
								<td>
									${prod.price}
								</td>
							</tr>
						</c:forEach> 
				   </div>
		   <% } else { %>
				   <div>
					<tr>
					<%-- <%
						request.getAttribute("SKU");
						request.getAttribute("Name");
						request.getAttribute("Price");
					%> --%>
					<%
						request.getAttribute("Product");
					%>
						<td>
							<%-- ${SKU} --%>
							<a href="UpdateProductRecord.jsp">${Product.code}</a>
						</td>
						<td colspan=1>
							${Product.name}
						</td>
						<td colspan=1>
							${Product.price}
						</td>
					</tr>
				</div>
    		<% } %>
		</table>
		<script type="text/javascript">
			/* function delete(link){
				$('#deleteModel').show();
				$('.loader').show ();
				var url ="list"
				var action =$(link).attr('href');
				$.ajax({
				    url:url,
				    type:'Post',
				    data:{
				        action:action
				    },
	
				    success: function(result){
				        $('.loader').hide();
				        $('#confirm-reject').modal('hide');
				        var successUrl = "List.jsp"; 
				        window.location.href = successUrl;
				    },
				}); */
				
				/* function UnSelectAll(){
					var items=document.getElementsByName('acs');
					for(var i=0; i<items.length; i++){
						if(items[i].type=='checkbox')
							items[i].checked=false;
					}
				}
				function selectAll(){
					var items=document.getElementsByName('acs');
					for(var i=0; i<items.length; i++){
						if(items[i].type=='checkbox')
							items[i].checked=true;
					}
				} */
				
				/* $(document).ready(function () {
				    $('#checkAll').click(function (event) {
				        if (this.checked) {
				            $('.checkbox').each(function () { //loop through each checkbox
				                $(this).prop('checked', true); //check 
				            });
				        } else {
				            $('.checkbox').each(function () { //loop through each checkbox
				                $(this).prop('checked', false); //uncheck              
				            });
				        }
				    });
				}); */
				
				/* $(function() {
					  
					  $(document).on('click', '#checkAll', function() {
					  
					    if ($(this).val() == 'Check All') {
					      $('.button input').prop('checked', true);
					      $(this).val('Uncheck All');
					    } else {
					      $('.button input').prop('checked', false);
					      $(this).val('Check All');
					    }
					  });
					  
					}); */
			</script>
		</script>
	</body>
</html>