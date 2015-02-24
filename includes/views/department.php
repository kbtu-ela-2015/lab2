<?php render('_header',array('title'=>$title))?>

<div class="rightColumn">
	<ul data-role="listview" data-inset="true" data-theme="e" data-dividertheme="e">
        <?php render($teachers) ?>
    </ul>
</div>

<div class="leftColumn">
    <ul data-role="listview" data-inset="true" data-theme="e" data-dividertheme="e">
        <li data-role="list-divider">Кафедры</li>
        <?php render($departments,array('active'=>$_GET['department'])) ?>
    </ul>
</div>