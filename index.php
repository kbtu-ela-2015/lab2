<?php
require_once "includes/main.php";
try {
	render('_header_const');
	if($_GET['department']){
		$c = new DepartmentController();
	}
	else if(empty($_GET)){
		$c = new HomeController();
	}
	else throw new Exception('Wrong page!');
	
	$c->handleRequest();
	render('_footer');
}
catch(Exception $e) {
	// Display the error page using the "render()" helper function:
	render('error',array('message'=>$e->getMessage()));
}
?>