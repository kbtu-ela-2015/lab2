<?php

    class MainController extends Controller
    {

        function action_index()
        {
            MainModel::get_data();
        }
        
    }