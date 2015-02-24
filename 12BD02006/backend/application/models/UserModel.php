<?php

    class UserModel extends Model
    {
        
        
        public function login($parameters)
        {
            
            list($email, $password) = $parameters;
            
            $request = array(
                'Request' => false                 
            );
            
            if (!empty($email) && !empty($password)) {
                
                //$model = new Model;
            
                $result = parent::getUserAuth($email, $password);
                
                if (!empty($result)) {
                    
                    $token = parent::createToken($result['ID']);

                    $request = array(
                        'Request' => true,
                        'Name' => $result['FName'],
                        'Surname' => $result['SName'],
                        'Lastname' => $result['LName'],
                        'Token' => $token
                    );
                }
            
            }
            
            
            header('Content-Type: application/json');
            print json_encode($request);
        
        }

    }