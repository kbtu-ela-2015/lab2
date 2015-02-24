<?php
class HomeController{
	public function handleRequest(){
		$content = Department::find();
		
		render('home',array(
			'title'		=> 'Факультет информаионных технологии',
			'content'	=> $content
		));
	}
}

?>