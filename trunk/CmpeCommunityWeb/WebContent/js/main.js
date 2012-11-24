var Posts = {
	loadNewsFeed: function(userId){
		$("#contentBody").load("/CmpeCommunityWeb/Profile/news/"+userId);
		console.log("loading news feed");
	},
	loadWall: function(userId){
		$("#contentBody").load("/CmpeCommunityWeb/Profile/wall/"+userId);
		console.log("loading wall");
	}
};