<?php ?>
<html>
<head><title>preference page</title>
<?php ?>
</head>
<body>
<style type = "text/css">
h1 {
	color:green;
	text-align:center;
}
p {
	color:green;
	text-align:center;
}
label{
	text-align:left;
	color:green;
}
body {background-image:url("http://images.sodahead.com/polls/003916849/5450734216_10stars_answer_1_xlarge.jpeg");
	           background-repeat:no-repeat;
	            background-position: right ;
	            background-size: 300px 300px;
	    }
</style>
<h1>Preference Rating</h1>
<p>As a seeker enter your preferences on a scale of 1 to 10. A rating of 10 means you prefer that amenity the most and a rating of 1 means you do not bother about that place</p>
<label for = "label"><i>Please enter your rating on a scale of 1 to 10:</i></label><br><br><br>
</body>
</html>
<html>
<head>
<script type='text/javascript'>
function formValidator(){
	var sch=document.getElementById('s');
	var hos=document.getElementById('h');
	var mal=document.getElementById('m');
	var tem=document.getElementById('t');
	var atm=document.getElementById('a');
	var the=document.getElementById('th');
	var par=document.getElementById('p');
/*if(sch>=1&&sch<=10){
	if(hos>=1&&hos<=10){
	if(mal>=1&&mal<=10){
	if(tem>=1&&tem<=10){
	if(atm>=1&&atm<=10){
	if(the>=1&&the<=10){
	if(par>=1&&par<=10)){
*/	
//check
if(notEmpty(sch,"Please enter valid integer ratings!")){
	if(notEmpty(hos,"Please enter valid integer ratings!")){
	if(notEmpty(mal,"Please enter valid integer ratings!")){
	if(notEmpty(tem,"Please enter valid integer ratings!")){
	if(notEmpty(atm,"Please enter valid integer ratings!")){
	if(notEmpty(the,"Please enter valid integer ratings!")){
	if(notEmpty(par,"Please enter valid integer ratings!")){
if(isNumeric(sch, "Numbers Only Please")){
	if(isNumeric(hos, "Numbers Only Please")){
	if(isNumeric(mal, "Numbers Only Please")){
	if(isNumeric(tem, "Numbers Only Please")){
	if(isNumeric(atm, "Numbers Only Please")){
	if(isNumeric(the, "Numbers Only Please")){
	if(isNumeric(par, "Numbers Only Please")){
		return true;
		}
	      }
	    }
	  }
	 }
        }
       }
    }
}}}}}}
return false;
}
function notEmpty(elem, helperMsg){
    if(elem.value.length == 0){
	alert(helperMsg);
	elem.focus(); // set the focus to this input
	return false;							
	}
    return true;
}
function isNumeric(elem, helperMsg){
		var numericExpression = /^[0-9]+$/;
			if(elem.value.match(numericExpression)){
						return true;
							}else{
										alert(helperMsg);
												elem.focus();
														return false;
															}
}

</script>
</head>
<style type = "text/css">
.submit {

	background: #C0C0C0;

	color: #fff;

	border: 1px solid #eee;

	border-radius: 20px;

	box-shadow: 5px 5px 5px #eee;
	
}

.submit:hover {

	background: #008000;

	color: #fff;

	border: 1px solid #eee;

	border-radius: 20px;

	box-shadow: 5px 5px 5px #eee;

}
.reset {

	background: #C0C0C0;

	color: #fff;

	border: 1px solid #eee;

	border-radius: 20px;

	box-shadow: 5px 5px 5px #eee;

}

.reset:hover {

	background: #008000;

	color: #fff;

	border: 1px solid #eee;

	border-radius: 20px;

	box-shadow: 5px 5px 5px #eee;

}
label{
	color:green;
	display:inline-block;
	float:left;
	clear:left;
	width:250px;
	text-align:center;
}
input{
	display:inline-block;
	float:left;
}
</style>
<form onsubmit='return formValidator()'action = "process.php" method = "post">
<div>
   <label>Schools:</label><input type = "number" name = "school" id='s'><br>
   <label>Hospitals:</label><input type = "number" name = "hospital"id='h'><br>
   <label>Malls:</label><input type = "number" name = "mall" id='m'><br>
   <label>Temples:</label><input type = "number" name = "temple"id='t'><br>
   <label>ATM:</label><input type = "number" name = "atm" id='a'><br>
   <label>Theatre:</label><input type = "number" name = "theatre"id='th'><br>
   <label>Park:</label><input type = "number" name = "park" id='p'><br>
   <br>
   <br>
   <input class = "submit" type = "submit" value = "Submit">
   <input class = "reset" type = "reset" value = "Clear">
</div>
</form>
</html>
