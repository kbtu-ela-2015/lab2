<?php

    class OrdersController extends Controller
    {
        
        function action_index($parameters)
        {
            list($token, $clientID) = $parameters;
            $model = new ContactsModel();
            if ($model::accessToken($token) === true) 
                $model::getContacts($parameters);
            else 
                print json_encode(array(
                    'Token' => false             
                ))  ;
        }
        
        function action_client($parameters)
        {
            list($token, $clientID) = $parameters;
            $model = new OrdersModel();
            if ($model::accessToken($token) === true)
                $model::getClientOrders($parameters);
            else
                print json_encode(array(
                    'Token' => false                        
                ));
        }
        
    }