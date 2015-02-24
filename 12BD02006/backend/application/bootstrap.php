<?php DEFINED ('CHECK') or die('File not found!');

    require_once 'core/Database.php';
    
    Database::connect();
    
    require_once 'core/Model.php';
    require_once 'core/View.php';
    require_once 'core/Controller.php';
    require_once 'core/Route.php';
    
    use Core\Route as Route;
    Route::start();
 