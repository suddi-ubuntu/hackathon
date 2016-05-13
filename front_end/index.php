<?php ?>
<html>
<head><title>home page</title></head>
<body>
<style type="text/css">
h1{
	color:green;
	text-align:center;
}
h2 {
	color:green;
	text-align:center;
}
p {
	text-align:center;
	color:green;
}
label {
	text-align:center;
	color:green;
}
body {
	text-align:center;
	background-image:url("http://static.giantbomb.com/uploads/original/2/22435/1465854-yoda1.jpg");
	background-repeat:no-repeat;
	background-size:347px 350px;
	background-position: left top;

}
#view:hover {
   background-color:#C0C0C0;
}
</style>
<!---<h1>My Smart locality! </h1> !-->
<h2>Welcome to  "Yoda Yoda Dharmasya!!!"</h2>
<h3>Give me the Property Id , I will direct you to what People say about that</h3>
<!---<label for = "label">
Click the below button to enter your preferences and find the best area for you...<br>
<br>
</label>
!-->
<br>
<br>



<form action = "review.php" method = "get">
<div>
   <label>Property Id:</label><input type = "text" name = "listingId" id='s'><br>
   
   <br>
   <br>
   <input class = "submit" type = "submit" value = "Submit">
   <!---<input class = "reset" type = "reset" value = "Clear">!-->
</div>
</form>


</body>
</html>

