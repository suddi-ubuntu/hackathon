function markUpVote(reviewId)
{

	var myurl = "http://172.16.123.190:8080/yoda/review/"+reviewId+"/upvote/demo";
	//alert(myurl);
   $.ajax({
       url:myurl
       
}).then(function(data){
	alert(data);
});
