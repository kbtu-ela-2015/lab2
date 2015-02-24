<?php

class Department{
	
	public static function find($arr = array()){
		global $db;		
		if(empty($arr)){
			$st = $db->prepare("SELECT * FROM departments");
		}
		else if($arr['id']){
			$st = $db->prepare("SELECT * FROM departments WHERE id=:id");
		}
		else{
			throw new Exception("Unsupported property!");
		}
		
		$st->execute($arr);
		
		return $st->fetchAll(PDO::FETCH_CLASS, "Department");
	}
}

?>