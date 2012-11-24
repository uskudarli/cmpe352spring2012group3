var Posts = {
	loadNewsFeed: function(userId){
		$("#postList").load("/CmpeCommunityWeb/Profile/posts/"+userId);
	}
};