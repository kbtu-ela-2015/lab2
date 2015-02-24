<?php
function render($template,$vars = array()){
	extract($vars);
	if(is_array($template)){		
		foreach($template as $x){
			
			$temp = strtolower(get_class($x));
			$$temp = $x;
			
			include "views/_$temp.php";
		}		
	}
	else {
		include "views/$template.php";
	}
}

function formatTitle($title = ''){
	if($title){
		$title.= ' | ';
	}
	
	$title .= $GLOBALS['defaultTitle'];
	
	return $title;
}

?>