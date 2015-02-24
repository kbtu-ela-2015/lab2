<li <?php echo ($active == $department->id ? 'data-theme="e"' : '') ?>>
<a href="http://localhost/lab1/?department=<?php echo $department->id?>" data-transition="fade">
	<?php echo $department->name ?>
    <span class="ui-li-count"><?php echo $department->contains?></span></a>
</li>