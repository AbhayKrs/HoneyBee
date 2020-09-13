 $(function() {
	//Solving active menu problem
	switch(menu) {
		case 'About Us':
			$('#about').addClass('active');
			break;
		case 'Contact Us':
			$('#contact').addClass('active');
			break;
		case 'All products':
			$('#listProducts').addClass('active');
			break;
		case 'Manage Products':
			$('#manageProducts').addClass('active');
			break;
		default:
			if(menu=="Home") break;
			$('#listProducts').addClass('active');
			$('#a_'+menu).addClass('active');
			break;
	}
	
	//Code for jQuery dataTable	
	var $table = $('#productListTable');
	
	//excute only when we have this table
	if($table.length) {
		console.log('Inside the table!');
		
		var jsonURL = '';
		if(window.categoryId == '') {
			jsonURL = window.contextRoot + '/json/data/all/products';
		} else {
			jsonURL = window.contextRoot + '/json/data/category/'+window.categoryId+'/products';
		}
		
		$table.DataTable({
			lengthMenu: [[3,5,10,-1], ['3 Records','5 Records','10 Records','ALL']],
			pageLength: 5,
			ajax: {
				url: jsonURL,
				dataSrc: ''
			},
			columns: [
				{data: 'code',
				 mRender: function(data,type,row) {
					return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
				}},
				{data: 'name'},
				{data: 'brand'},
				{data: 'unitPrice',
				 mRender: function(data,type,row){
					return '&#8377; '+data;
				}},
				{data: 'quantity',
				 mRender: function(data,type,row){
					if(data<1) {
						return '<span style="color:red">Out of Stock!</span>';
					}
					return data;
				}},
				{data: 'id',
				 bSortable: false,
				 mRender: function(data,type,row){
					var str = '';
					str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-dark">View</a> &#160;';
					
					if(row.quantity<1){
						str += '<a href="javascript:void(0)" class="btn btn-light disabled"><i class="fas fa-shopping-cart"></i></a>';
					} else {
						str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-light"><i class="fas fa-shopping-cart"></i></a>';
					}
					return str;
				}}			
			],
			"autoWidth": false
		});
	}
	
});

var $alert = $('.alert');
if($alert.length){
	setTimeout(function() {
		$alert.fadeOut('slow');
	},3000)
}