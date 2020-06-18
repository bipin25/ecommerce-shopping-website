$(function(){
	switch(document.title){
	case 'About us':
		$('#about').addClass('active');
		break;
	case 'Contact us':
		$('#contact').addClass('active');
		break;
	case 'Product List':
		$('#products').addClass('active');
		break;
	default:
		$('#home').addClass('active');
		break;
	}
});


//code for productListTable
$(document).ready(function () {
    $('#productListTable').DataTable({
    	//lengthMenu:[[3,5,10,-1],['3 Record','5 Record','10 Record','All']]
    	//pageLength:5
    });
});

//code for manageProductListTable
$(document).ready(function () {
    $('#manageProductListTable').DataTable({
    	//lengthMenu:[[3,5,10,-1],['3 Record','5 Record','10 Record','All']]
    	//pageLength:5
    });
});



//code for dataTable

 /*  $('#categoryForm').validate({
	   alert("hellppp");
	   rules: {
		   name:"required",
		   description:"required"
	   },
	   
   	   message:{
   		   name:"Please enter the name",
   		   description:"Please enter the description"
   	   },
   	   
   	   errorElement:'em',
   	   errorPlacement: function(error,Element){
   		   error.addClass('help-block');
   		   error.insertAfter(element);
   	   }
   });

*/