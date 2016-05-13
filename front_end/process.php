


<?php 
// export PATH=/usr/local/mysql/bin:$PATH

#$dbh = new PDO('sqlite:data.sqlite');


$school=$_POST['school'];
$hospital=$_POST['hospital'];
$mall=$_POST['mall'];
$temple=$_POST['temple'];
//$hotel=$_POST['hotel'];
$atm=$_POST['atm'];
$theatre=$_POST['theatre'];
$park=$_POST['park'];

?>

<html>
<body>
<style type="text/css">
body {
	          background-image:url("http://www.menucool.com/slider/prod/image-slider-2.jpg");
	          background-repeat:no-repeat;
	            background-size:cover;
	    }



</style>
</body>
</html>
<?php



//session_start();
$val=array();
$val=array( $school,$hospital,$mall,$temple,$atm,$theatre,$park);
//echo "this is val \n";
//var_dump($val);
//echo"kasdsa\n";
$user = 'cfuser';
$pass = 'cfpass';
$dbh = new PDO('mysql:host=localhost;dbname=hack', $user, $pass);

if($dbh!=null) {
	
	//echo "connected to db\n";
	}
	else {
		echo "error\n";
	}


  $dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	$stmt = 'SELECT locality,school,hospital,Malls,Temple,Bank,Movie,park  FROM abcd'; 
	    $q=$dbh->query($stmt);



$q->setFetchMode(PDO::FETCH_ASSOC);
//var_dump($q);
$result=array();
$sum_total=0;

while($r=$q->fetch()) {
	$k=0;
	$temp_result=0;
	foreach($r as $i){
		if(is_numeric($i ) ) {
		$temp_result=$temp_result+ ( $i * $val[$k] );
		$k=$k+1;
		}
		else 
			{$city=$i;
				//echo $city,"\n";
			}
	}

	$result[$city]= $temp_result;
	$sum_total = $sum_total + $temp_result;


	}
	//echo "sum_total= $sum_total \n";
 //echo "\n";
	//print_r($result)

	

	/*foreach ($result as $key => $values ){
		$values = bcdiv($values ,$sum_total,3);
		$result[$key]=$values *100;
		echo $values," ";
	}
*/

 $sorted=$result;
 arsort($sorted); 
 ?>

	<html>
	<head>
    <title>result</title>
	</head>
	<body>
		<h2 style = "color:green " > Buddy, you better hit on : </h2>
		<style>
    	    p.ex1 {
	   	    margin-left: 2cm;
	   	    color: green;
		   } </style>
    <?php foreach ( $sorted as $key => $values ) : ?>
        
	<p class="ex1"><?=$key , " " , $values  ?> </p>
    <?php endforeach; ?>
    <input type="hidden" id="data" value="<?php echo urlencode(json_encode($result)); ?>">
</body>
</html>



<style>
    	    p.ex1 {
	   	    margin-left: 2cm;
		   } </style>
<button id="view" style="color: #008000" >click for Heat Map View</button>

<script>

var btn = document.getElementById('view');
btn.addEventListener('click',function() {
	var data = document.getElementById('data').value;
	document.location.href = 'map17.php?data=' + data;
});
</script>









