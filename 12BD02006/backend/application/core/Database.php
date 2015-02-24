<?php
    
    class Database {
    
        public function connect() {
            $connection = mysql_connect('localhost', 'v_16017_alem', '2201875aaBBcc');
            mysql_select_db('v_16017_alembeauty');
            mysql_query("SET NAMES utf8");
        }
    
    }


