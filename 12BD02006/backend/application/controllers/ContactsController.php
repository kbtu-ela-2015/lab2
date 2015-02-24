<?php

    class ContactsController extends Controller
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
                ));
        }
        
    }