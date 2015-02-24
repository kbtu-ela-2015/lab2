<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>LabWork</title>
        <link href="public/css/bootstrap.min.css" rel="stylesheet">
        <link href="public/css/styles.css" rel="stylesheet">
    </head>
    <body>
        <?php
            require_once('template/header.php');
            echo '<div class="content">';
            if ($_GET['page'] == null)
                require_once('template/pages/login.php');
            else
                require_once('template/pages/main.php');
            echo '</div>';
            require_once('template/footer.php');
        ?>
        <div id="page-preloader">
            <span class="spinner"></span>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="public/js/bootstrap.min.js"></script>
        <script src="public/js/frontend.js"></script>
    </body>
</html>