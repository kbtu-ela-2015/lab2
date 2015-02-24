<?php render('_header',array('title'=>$title))?>

<p>Список учителей деканата ФИТ</p>
<p>Для написания сайта был использован MVC, template view, transform view, two-step view patterns</p>

<ul data-role="listview" data-inset="true" data-theme="e" data-dividertheme="e">
    <li data-role="list-divider">Выберите кафедру</li>
    <?php render($content) ?>
</ul>
