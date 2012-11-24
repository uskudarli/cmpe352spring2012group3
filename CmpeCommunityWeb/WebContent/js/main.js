var Posts = {
	loadNewsFeed: function(userId){
		$("#contentBody").load("/CmpeCommunityWeb/Profile/posts/"+userId);
		console.log("loading");
	}
};