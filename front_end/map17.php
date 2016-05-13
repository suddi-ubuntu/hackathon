

<?php //if (true): 



//include('process.php');
//echo "data: <br>";
$data = $_GET['data'];
$data = json_decode($data, true);

//$data1=$_POST['data'];
//var_dump($data); 
//$wt = $_SESSION["p"];
$wt=array();
 foreach($data as $key => $values){
 $wt[]=$values * 1000 ;
 }

//echo"heyyyyy11111 ";
//print_r($wt);

//$wt = array();
?>




<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Heatmaps</title>
	<style>
	html, body, #map-canvas {
		height: 100%;
		margin: 0px;
		padding: 0px
	}
	#panel {
		position: absolute;
		top: 5px;
		left: 50%;
		margin-left: -180px;
		z-index: 5;
		background-color: #fff;
		padding: 5px;
		border: 1px solid #999;
	}
	</style>
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true&libraries=visualization"></script>
	<script>






																			  // Adding 500 Data Points
var map, pointarray, heatmap;




	



var taxiData = [																	


{location: new google.maps.LatLng(12.941607,77.557853), weight: <?php echo  $wt[9];?>}, // bamshan (1)
{location: new google.maps.LatLng(12.839939,77.677003), weight: <?php echo  $wt[8];?>}, //electroni (2)
{location: new google.maps.LatLng(12.9699,77.6499),weight: <?php echo $wt[1];?>}, // indira (3)

{location: new google.maps.LatLng(12.899623,77.482698), weight: <?php echo $wt[6]; ?>}, //kengiri(4) 
{location: new google.maps.LatLng(12.961123,77.647247), weight: <?php echo  $wt[2];?>}, //kodihalli (5)
{location: new google.maps.LatLng(12.976664,77.571256),weight: <?php echo $wt[4];?>}, //majestic (6)

{location: new google.maps.LatLng(13.003062,77.564293), weight: <?php echo $wt[3]; ?>}, //malleshwar (7)

{location: new google.maps.LatLng(12.990058,77.552492), weight: <?php echo  $wt[5];?>},  //rajaji nagar (8)

{location: new google.maps.LatLng(12.985650,77.605693),weight: <?php echo $wt[7];?>},  //shivaji (9)


{location: new google.maps.LatLng(12.9700,77.7500), weight: <?php echo $wt[0]; ?>} //whitefield (10)

];


function initialize() {
	var mapOptions = {
		zoom: 13,
		center: new google.maps.LatLng(12.9667,77.5667),
		mapTypeId: google.maps.MapTypeId.SATELLITE
	};

	map = new google.maps.Map(document.getElementById('map-canvas'),
		mapOptions);

	var pointArray = new google.maps.MVCArray(taxiData);

	heatmap = new google.maps.visualization.HeatmapLayer({
		data: pointArray
	});

	heatmap.setMap(map);
	heatmap.set("radius",50);
}

function toggleHeatmap() {
	heatmap.setMap(heatmap.getMap() ? null : map);
}

function changeGradient() {
	var gradient = [
	'rgba(0, 255, 255, 0)',
	'rgba(0, 255, 255, 1)',
	'rgba(0, 191, 255, 1)',
	'rgba(0, 127, 255, 1)',
	'rgba(0, 63, 255, 1)',
	'rgba(0, 0, 255, 1)',
	'rgba(0, 0, 223, 1)',
	'rgba(0, 0, 191, 1)',
	'rgba(0, 0, 159, 1)',
	'rgba(0, 0, 127, 1)',
	'rgba(63, 0, 91, 1)',
	'rgba(127, 0, 63, 1)',
	'rgba(191, 0, 31, 1)',
	'rgba(255, 0, 0, 1)'
	]
	heatmap.set('gradient', heatmap.get('gradient') ? null : gradient);
}

function changeRadius() {
	heatmap.set('radius', heatmap.get('radius') ? null : 40);
}

function changeOpacity() {
	heatmap.set('opacity', heatmap.get('opacity') ? null : 0.2);
}

google.maps.event.addDomListener(window, 'load', initialize);

</script>



</head>

<body>
	<div id="panel">
		<button onclick="toggleHeatmap()">Toggle Heatmap</button>
		<button onclick="changeGradient()">Change gradient</button>
		<button onclick="changeRadius()">Change radius</button>
		<button onclick="changeOpacity()">Change opacity</button>
	</div>
	<div id="map-canvas"></div>
</body>
</html>