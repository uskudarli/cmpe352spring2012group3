var Posts = {
	loadNewsFeed: function(userId){
		$("#contentBody").load("/CmpeCommunityWeb/Profile/news/"+userId);
		console.log("loading news feed");
	},
	loadWall: function(userId){
		$("#contentBody").load("/CmpeCommunityWeb/Profile/wall/"+userId);
		console.log("loading wall");
	},
	
	createWithTaggedUserId: function(targetId){
		var body = $("[name='posts']").val();
		var users = [targetId];
		$.post("/CmpeCommunityWeb/Posts/addPost", {posts: body, users: users}, function(data){
			if(data["success"])
				window.location.reload();
			else if(data["error"] == "need_login")
				window.location.href = "/CmpeCommunityWeb/";
			else
				alert("An unknown error occured, sorry for the inconvenient we may have caused.");
		});
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