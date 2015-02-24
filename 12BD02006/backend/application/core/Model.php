<?php

    class Model
    {

        public function get_data() {
            echo 'Model is Empty';
        }
        
        
        /* TOKEN */
        
        protected function createToken($userID) {
            self::deleteToken($userID);
            $token = md5($userID.time().rand(0, time()));
            $endQuery = time();
            $result = mysql_query("INSERT INTO Tokens (UserID, Token, Datetime, EndQuery) VALUES ('$userID', '$token', NOW(), '$endQuery') ") or die(mysql_error());
            return $token;
        }
        
        private function deleteToken($userID) {
            $result = mysql_query("DELETE FROM Tokens WHERE UserID = '$userID'") or die(mysql_error());    
        }
        
        public function accessToken($token) {
            $period = mktime(6, 0, 0, 0, 0, 0);
            $mktime = mktime(date('d-M-Y H:i:s'));
            $result = mysql_query("SELECT * FROM Tokens WHERE Token = '$token'") or die(mysql_error());
            $row = mysql_fetch_assoc($result);
            if ($mktime - $row['EndQuery'] > $period) {
                return false;
            } else {
                $update = mysql_query("UPDATE Tokens SET EndQuery = '$mktime' WHERE Token = '$token'") or die(mysql_error());
                return true;
            }
        }
        
        protected function getUserIdByToken($token) {
            $result = mysql_query("SELECT UserID FROM Tokens WHERE Token = '$token' LIMIT 1") or die(mysql_error());
            $row = mysql_fetch_assoc($result);
            return $row['UserID'];
        }
        
        /* USER */
        public function getUserById($userID) {  
            $result = mysql_query("SELECT * FROM Users WHERE ID = '$userID' LIMIT 1") or die(mysql_error());
            $row = mysql_fetch_assoc($result);
            return $row;
        }
        
        protected function getUserAuth($email, $password) {
            $result = mysql_query("SELECT ID, FName, SName, LName FROM Users WHERE Email = '$email' and Password = MD5('$password') LIMIT 1") or die(mysql_error());
            $row = mysql_fetch_assoc($result);
            return $row;
        }
        
        protected function getUserRoleByID($userID) {
            $result = mysql_query("SELECT RoleID FROM Users WHERE ID = '$userID' LIMIT 1") or die(mysql_error());
            $row = mysql_fetch_assoc($result);
            return $row['RoleID'];
        }
        
        protected function getUserOrders($userID) {
            $array = array();
            $result = mysql_query("SELECT ClientID FROM Orders WHERE UserID = '$userID' and Accepted = 1") or die(mysql_error());
            while ($row = mysql_fetch_assoc($result)) {
                $array[] = $row;
            }
            return $array;
        }
        
        /* COMPANIES */
        public function getCompanyByID($companyID) {
            $result = mysql_query("SELECT * FROM Companies WHERE ID = '$companyID' LIMIT 1") or die(mysql_error());
            $row = mysql_fetch_assoc($result);
                return $row;
        }
        
        /* SERVICES */
        public function getServiceByID($serviceID) {
            $result = mysql_query("SELECT * FROM Services WHERE ID = '$serviceID' LIMIT 1") or die(mysql_error());
            $row = mysql_fetch_assoc($result);
                return $row;
        }
        
        /* CLIENTS */
        public function getClientById($clientID) {
            $result = mysql_query("SELECT * FROM Clients WHERE ID = '$clientID' LIMIT 1") or die(mysql_error());
            $row = mysql_fetch_assoc($result);
                return $row;
        }
        
        protected function getContactsByCompanyID($mainOrgUnitID) {
            $array = array();
            $result = mysql_query("SELECT * FROM Clients WHERE CompanyID = '$mainOrgUnitID'") or die(mysql_query());
            while ($row = mysql_fetch_assoc($result)) {
                $array[] = $row;
            }
            return $array;            
        }
        
        protected function getClientOrders($clientID) {
            $array = array();
            $result = mysql_query("SELECT * FROM Orders WHERE ClientID = '$clientID' AND Accepted = 1 ORDER BY StartTime DESC") or die(mysql_error());
            while ($row = mysql_fetch_assoc($result)) {
                $array[] = $row;
            }
            return $array;
        }
        
    }