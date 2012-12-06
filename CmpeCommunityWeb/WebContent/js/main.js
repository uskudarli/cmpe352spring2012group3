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
	},
	
	createWithTaggedId: function(tagId){
		var body = $("[name='tag_post']").val();
		$.post("/CmpeCommunityWeb/Tags/addPost/"+tagId, {body: body}, function(data){
			if(data["success"])
				window.location.reload();
			else if(data["error"] == "need_login")
				window.location.href = "/CmpeCommunityWeb/";
			else
				alert("An unknown error occured, sorry for the inconvenient we may have caused.");
		});
	}
};

var Reply = {
	create: function(postId){
		var body = $("[name='reply_"+postId+"']").val();
		$.post("/CmpeCommunityWeb/Posts/reply/"+postId, {body: body}, function(data){
			if(data["success"])
				window.location.reload();
			else if(data["error"] == "need_login")
				window.location.href = "/CmpeCommunityWeb/";
			else
				alert("An unknown error occured, sorry for the inconvenient we may have caused.");
		});
		return false;
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
		},
		addTag: function(userId){
			$("#contentBody").load("CmpeCommunityWeb/Tags/addTags/"+userId);
			$("#contentBody").load("/CmpeCommunityWeb/Tags/wall/16");
			console.log("loading wall");
		},
		
		add: function(userId){
			var tags = $("[name='hidden-tags']").val();
			$.post("/CmpeCommunityWeb/Tags/addTags/"+userId, {tags: tags}, function(data){
				if(data["success"])
					window.location.reload();
				else if(data["error"] == "need_login")
					window.location.href = "/CmpeCommunityWeb/";
				else
					alert("An unknown error occured, sorry for the inconvenient we may have caused.");
			});
		}
};