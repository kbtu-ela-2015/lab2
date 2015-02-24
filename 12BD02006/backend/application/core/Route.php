<?php

    namespace Core;

    class Route
    {
        
        static function start()
        {

            list($empty, $controller, $action) = explode('/', $_SERVER['REQUEST_URI']);
            $routes = explode('/', $_SERVER['REQUEST_URI']);
            $uriCount = count($routes);
            
            $parameters = $routes[$uriCount-1];
            $parameters = explode(':', $parameters);
               
            if (empty($controller)) { $controller = 'Main'; }
            if (empty($action)) { $action = 'index'; }
            
            $data = Route::getClassName($controller, $action);
            
            list($model, $controller, $action) = explode(':', implode(':', $data));
            
            if (file_exists(MODELS.$model.EXT)) {
                require_once MODELS.$model.EXT;
            }
            
            if (file_exists(CONTROLLERS.$controller.EXT)) {
                require_once CONTROLLERS.$controller.EXT;
                $controller = new $controller();
            } else {
                Route::ErrorPage404();
            }
            
            if (method_exists($controller, $action)) {
                $controller::$action($parameters);
            } else {
                Route::ErrorPage404();
            }
        
        }
        
        public function getClassName($controller, $action)
        {
            
            $data['model'] = $controller.'Model';
            $data['controller'] = $controller.'Controller';
            $data['action'] = 'action_'.$action;
            
            return $data; 
        }
        
        function ErrorPage404()
        {
            header('HTTP/1.1 404 Not Found');
            die();
        }
        
    }