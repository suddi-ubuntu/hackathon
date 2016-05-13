
<?php 

// export PATH=/usr/local/mysql/bin:$PATH

#$dbh = new PDO('sqlite:data.sqlite');


$id=$_GET['listingId'];
//$temple=$_POST['temple'];
//$hotel=$_POST['hotel'];
//$atm=$_POST['atm'];
//$theatre=$_POST['theatre'];
//$park=$_POST['park'];

?>

<html>
<head>
<script src="//tinymce.cachefly.net/4.2/tinymce.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!---<script>tinymce.init({selector:'newtextarea'});</script>
<script>tinymce.init({selector:'textarea',readOnly:true});</script>
!-->
<link href="rating.css" rel="stylesheet" type="text/css"/>
<!---
<script>
$(function() {
    $('#newReview_formId').submit(function() {
        // DO STUFF

        alert("before submitting form Review");
        var url = "http://172.16.122.191:8080/yoda/review/create?listingid=";
        url = url + $('#listingIdId').val();
        url =url + "&createdBy="+ $('#createdById').val();
        url = url +"&reviewComment="+$('#reviewCommentText').val();
        url = url + "&rating="+$('#ratingId').val();
        alert(url);
        jQuery.ajax({
            url: url,

          type: "GET",
        success: function(resultData) {
          alert("updated");


          },
          error: function(resultData){
            alert("failed");
        //handleData(resultData);
//document.getElementsByName("upvote"+this.invokedata.review_id).value = "upvote  "+resultData;
          }
          });


        return false; // return false to cancel form action
    });


}
</script>

-->
</head>
<body>

<style type="text/css">

</style>

<script >

function markUpVote(reviewId)
{
	alert(reviewId);
	alert(jQuery);
	alert("http://localhost:8080/yoda/review/"+reviewId+"/upvote/demo");

$.ajax({
  url: 'http://localhost:8080/yoda/review/'+reviewId+'/upvote/demo/',
})
.done(function(data) {
  alert(data)
})
.fail(function() {
  alert("Ajax failed to fetch data")
})

function markDownVote(reviewId)
{
   // alert(document.getElementsByName("upvote"+reviewId)[0].value);
    myDownVote(reviewId,function(output){

    document.getElementsByName("downvote"+reviewId)[0].value = "downvote "+output;
    //alert(document.getElementsByName("downvote"+reviewId)[0].value);

    });
}

function myDownVote(reviewId,handleData)
{
  var myURL = "http://172.16.122.191:8080/yoda/review/"+reviewId+"/downvote/demo";
jQuery.ajax({
url: myURL,

type: "GET",
success: function(resultData) {
handleData(resultData);
//document.getElementsByName("upvote"+this.invokedata.review_id).value = "upvote  "+resultData;
},
});
}

</script>


<script type="text/javascript" src="assets/review.js"></script>
<!---<iframe src='http://www.google.com' name="iframe_a"></iframe>!-->
<!---<p><a href="http://www.google.com" target="iframe_a">google</a></p>!-->
<iframe src="https://www.commonfloor.com/listing/asdsad/<?=$id?> "WIDTH=1300 HEIGHT=400 align= "top" ></iframe>
<?php 
  $starStat = file_get_contents("http://172.16.122.191:8080/yoda/listing/".$id."/starStats");
  $starStat=json_decode($starStat);
  $starStat=(array)$starStat;
?>
<h3> Overall Rating [out of 5 ]</h3>

<!-- div element full of empty stars -->


<div class='rating_bar'>
    <!-- div element that contains full stars with percentage width, 
    which represents rating -->
  
    <?php 
    $wid=($starStat["avgRating"]*100)/5; 
    ?>
    <div  class="rating" style="width:<?=$wid?>%;" > 
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<?=$starStat["avgRating"];?>
    </div>

    
</div>

<br>Rating &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Number Of Users 

<div class='rating_bar'>
    <!-- div element that contains full stars with percentage width, 
    which represents rating -->
    <div  class='rating' style='width:100%;'>
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<?=$starStat["fiveStartCount"]; ?> 
    </div>
</div>


<div class='rating_bar'>
    <!-- div element that contains full stars with percentage width, 
    which represents rating -->
    <div  class='rating' style='width:80%;'>
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<?=$starStat["fourStartCount"]; ?> 
    </div>
</div>


<div class='rating_bar'>
    <!-- div element that contains full stars with percentage width, 
    which represents rating -->
    <div  class='rating' style='width:60%;'>
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<?=$starStat["threeStartCount"]; ?> 
    </div>
</div>

<div class='rating_bar'>
    <!-- div element that contains full stars with percentage width, 
    which represents rating -->
    <div  class='rating' style='width:40%;'>
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<?=$starStat["twoStartCount"]; ?> 
    </div>
</div>

<div class='rating_bar'>
    <!-- div element that contains full stars with percentage width, 
    which represents rating -->
    <div  class='rating' style='width:20%;'>
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<?=$starStat["oneStartCount"]; ?> 
    </div>
</div>
<br>
<h3> Top Reviews:</h3>
 
<?php
#$handle = file_get_contents("/Users/sudarshan/Desktop/hackattack/exampleJson.txt"); 
<<<<<<< HEAD
$handle = file_get_contents("http://172.16.122.191:8080/yoda/review/listingId/".$id);#http://172.20.10.145:8080/yoda/review/");
$views7= file_get_contents("http://172.16.122.191:8080/yoda/listing/".$id."/numViews/7");
$views30= file_get_contents("http://172.16.122.191:8080/yoda/listing/".$id."/numViews/30");
$views365= file_get_contents("http://172.16.122.191:8080/yoda/listing/".$id."/numViews/365");
$groupStat = file_get_contents("http://172.16.122.191:8080/yoda/listing/".$id."/userGroupStats");

$make="http://172.16.122.191:8080/yoda/review/create";//."&reviewComment=comment&createdBy=chandra&rating=5"
#var_dump($groupStat);
#echo $groupStat[0];
$stat=json_decode($groupStat);
#var_dump($stat);
=======
$handle = file_get_contents("http://localhost:8080/yoda/review/listingId/".$id);#http://172.20.10.145:8080/yoda/review/");
>>>>>>> 94220a0f17d3b962357936d1f1a7858a1a71c0d4
$handle = json_decode($handle);
#echo $handle;
#$first_names = array_column($handle, 'id');
#var_dump($handle);
#echo $handle['id'];

echo " Rating &nbsp&nbsp&nbsp&nbsp Name &nbsp&nbsp&nbsp&nbsp Review <br>";
#foreach ($handle as $key=>$val) {
	
?>	

     <div style="width:100%;"> 

<div style="float:left; width:60%;">

 <?php
 foreach($handle as $arr)
    {

    
	$result = (array)$arr;
	$myRating = $result["rating"];
	$myName = $result["createdBy"];
	$myReview=$result["reviewComments"];
	$reviewId=$result["reviewId"];
  $ss=($myRating*100)/5;
  ?>
  <div class="rating_bar">
  
  <div  class="rating" style="width:<?=$ss?>%">
    </div>
</div>
<?php
    echo "$myRating &nbsp&nbsp&nbsp&nbsp $myName &nbsp&nbsp&nbsp&nbsp";   
    #echo "<h4 align=\"center\" ><font face=\"verdana\" color=\"blue\">$myReview</font></h4><p align=\"center\"></p>";
    
    echo "<form action=\"/html/tags/html_form_tag_action.cfm\" method=\"post\">
<textarea name=\"comments\" id=\"comments\" align=\"right\" style=\"width:90%;height:90px;align:right;background-color:olive;border:black;padding:2%;font:22px/30px sans-serif;\">
$myReview
</textarea>
</form> ";
  
     //<body>
  #echo '<input type="submit"  name = "upvote" value="upvote" onclick="markUpVote({$reviewId})"/>';
<<<<<<< HEAD
  $upvotekey = "upvote".$reviewId ;
  $downvotekey = "downvote".$reviewId ;
  
  $no_of_upvotes = file_get_contents("http://172.16.122.191:8080/yoda/review/".$reviewId."/upvotes") ;
  $no_of_downvotes = file_get_contents("http://172.16.122.191:8080/yoda/review/".$reviewId."/downvotes");

  $value_upvotes = "upvote".$no_of_upvotes;
  $value_downvotes = "downvote".$no_of_downvotes;

  echo "<input type=\"submit\"  name = $upvotekey value= $value_upvotes onclick=\"markUpVote($reviewId)\"/>";

    echo "<input type=\"submit\"   name =$downvotekey value= $value_downvotes onclick=\"markDownVote($reviewId)\"/>" ;
=======
  echo "<input type=\"submit\"  name = \"upvote\" value=\"upvote\" onclick=\"markUpVote($reviewId)\"/>";
  echo file_get_contents("http://localhost:8080/yoda/review/".$reviewId."/upvote/demo");
    echo '<input type="submit"   name = "downvote" value="downvote" onclick="markDownVote()"/>' ;
>>>>>>> 94220a0f17d3b962357936d1f1a7858a1a71c0d4
     //</body>
     
     echo "<br>";
     echo "<hr>";
     }
?>


</div>
<div style="float:right; width:40%; ">


<h3 ><font color="olive">This property was viewed: X times </font></h3>
<h4>Last Seven day:<?=$views7?> </h4>
<h4>Last 30 Days:<?=$views30 ?></h4>
<h4>Last 365 Days:<?=$views30?></h4>
<br>
<br>
<h4><font color="olive"> Relative to Other property :</font></h4>
<h5><font color="green">Lisiting Id &nbsp&nbsp&nbsp&nbspCount  </font></h5>
<?php
foreach($stat as $a){
  $ress=(array)$a;
  echo "$ress[listingId]  &nbsp&nbsp&nbsp $ress[count]";
  echo "<br>";
  
}
?>
<br>
<h4><font color="olive"> Your valuable feedback :</font></h4>
<form action="<?=$make?>" id="newReview_formId"> 
  <input type="hidden" name="listingId" id="listingIdId" value=<?=$id?>>
  Your Name:<br>
  <input type="text" name="createdBy" id="createdById" value="name">
  <br>

  Write Review<br>
  <textarea name="reviewComment" id="reviewCommentText" align="right" style="width:90%;height:90px;align:right;background-color:olive;border:black;padding:2%;font:22px/30px sans-serif;">
  myreview
  </textarea>

  <!---<input type="text" name="myreview" value="myReview">
  <br>
  !-->
  Overall Rating<br>
  <input type="text" name="rating" id="ratingId" value="0">
  <br>
  <input type="submit" value="Submit">
</form>

</div>
 
</div>
 
  

</body>
</html>
<?php
