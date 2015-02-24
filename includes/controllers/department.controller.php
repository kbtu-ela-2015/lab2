<?php

class DepartmentController{
	public function handleRequest(){
		$cat = Department::find(array('id'=>$_GET['department']));
		
		if(empty($cat)){
			throw new Exception("There is no such department!");
		}

		$departments = Department::find();
		$teachers = Teacher::find(array('department'=>$_GET['department']));
		
		render('department',array(
			'title'			=> $cat[0]->name,
			'departments'	=> $departments,
			'teachers'		=> $teachers
		));		
	}
}


?>