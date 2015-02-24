<?php

class Teacher{
	
	public static function find($arr){
		global $db;
		
		if($arr['id']){
			$st = $db->prepare("SELECT * FROM teachers WHERE id=:id");
		}
		else if($arr['department']){
			$st = $db->prepare("SELECT * FROM teachers WHERE department = :department");
		}
		else{
			throw new Exception("Unsupported property!");
		}
		
		$st->execute($arr);
		
		return $st->fetchAll(PDO::FETCH_CLASS, "Teacher");
	}
}

?>