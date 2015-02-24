<?php

    class OrdersModel extends Model
    {
        
        public function getClientOrders($parameters) {
            list($token, $clientID) = $parameters;
            
            $userID = parent::getUserIdByToken($token);
            //$userData = parent::getUserById($userID);
            //$roleID = $userData['RoleID'];
            //$companyID = $userData['CompanyID'];
            $data = parent::getClientOrders($clientID);
            
            $array = array();
            
            foreach($data as $item) {
                
                list($date, $time) = explode(' ', $item['StartTime']);
                list($year, $month, $day) = explode('-', $date);
                list($hour, $minute) = explode(':', $time);
                $date = $day.'.'.$month.'.'.$year;
                $time = $hour.':'.$minute;
                
                
                $array[] = array(
                    'Company' => parent::getCompanyByID($item['CompanyID'])['Name'],
                    'Service' => parent::getServiceByID($item['ServiceID'])['Name'],
                    'Date' => $date,
                    'Time' => $time,
                    'Rating' => 5
                );
            }
                
            header('Content-Type: application/json');
            print json_encode($array);
        }
        
    }