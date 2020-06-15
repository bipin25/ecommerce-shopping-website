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


//code for dataTable
$(document).ready(function () {
    $('#productListTable').DataTable({
    	//lengthMenu:[[3,5,10,-1],['3 Record','5 Record','10 Record','All']]
    	//pageLength:5
    });
});