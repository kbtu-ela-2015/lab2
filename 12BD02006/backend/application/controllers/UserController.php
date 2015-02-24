<?php

    class UserController extends Controller
    {
        
        function action_index()
        {
            UserModel::get_data();
        }
        
        function action_login($parameters) {
            UserModel::login($parameters);
        }
        
    }