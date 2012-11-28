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

var Tags = {
		loadUsers: function(tagId){
			$("#contentBody").load("/CmpeCommunityWeb/Tags/users/"+tagId);
			console.log("loading news feed");
		},
		loadWall: function(tagId){
			$("#contentBody").load("/CmpeCommunityWeb/Tags/wall/"+tagId);
			console.log("loading wall");
		}
};