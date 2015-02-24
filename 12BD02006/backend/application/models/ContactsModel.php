<?php

    class ContactsModel extends Model
    {
        
        public function getContacts($parameters) {
            list($token, $clientID) = $parameters;
            
            $request = array(
                'Request' => false                 
            );
            
            if (!empty($token)) {
                $userID = parent::getUserIdByToken($token);
                $userData = parent::getUserById($userID);
                $roleID = $userData['RoleID'];
                $companyID = $userData['CompanyID'];
                switch($roleID) {
                    case 1:
                        $request = ContactsModel::getCompanyContacts($companyID);
                        break;
                    case 2:
                        $request = ContactsModel::getUserContacts($userID);
                        break;
                }
            }
            header('Content-Type: application/json');
            print json_encode($request);
        }
        
        private function getUserContacts($userID) {
            $data = parent::getUserOrders($userID);
            $array = array();
            foreach($data as $key=>$item) {
                $clientData = parent::getClientById($item['ClientID']);
                $array[] = array(
                    'ID' =>  $clientData['ID'],
                    'FName' => $clientData['FName'],
                    'SName' => $clientData['SName'],
                    'MobilePhone' => $clientData['MobilePhone'],
                    'Email' => $clientData['Email']
                );
            }
            return $array;
        }
        
        private function getCompanyContacts($companyID) {
            $data = parent::getContactsByCompanyID($companyID);
            $array = array();
            foreach($data as $key=>$item) {
                $array[] = array(
                    'ID' =>  $item['ID'],
                    'FName' => $item['FName'],
                    'SName' => $item['SName'],
                    'MobilePhone' => $item['MobilePhone'],
                    'Email' => $item['Email']
                );
            }
            return $array;
            
        }
        
    }