$(document).ready(function() {
		
		// submitting a new topic
		$('#postNewTopicBtnDisplay').click(function(){
			//document.getElementById("result1").style.display = "block";
			var userWhoPostedTopic = $('#loggedInUsername').text();
			var newTopicPostText = $('#newTopicPostText').val();
			$.ajax({
				type:'POST',
				data: {
					userWhoPostedTopic: userWhoPostedTopic,
					newTopicPostText: newTopicPostText
				},
				url:'PostNewTopicServlet',
				success: function(result){
					$('#result1').html(result);
					$('#newTopicPostText').val('');
				}
			});
		});
		
		
		// viewing all of the topics
		$('#viewAllTopicsBtnDisplay').click(function(){
			$.ajax({
				type:'POST',
				url:'ViewAllTopicsServlet',
				success: function(result){
					$('#result1').html(result);
					$('#userSelectsOneTopic').show();
					$('#userFlagsOneTopicView').show();
				}
			});
		});
		
		//user can see all the replies and is given a text area to make their own reply
		$('#getTopicDetailsBtn').click(function(){
			var topicId = $('#topicId').val();
			var userThatMightReply = $('#loggedInUsername').text();
			$.ajax({
				type:'POST',
				data: {
					topicId: topicId,
					userThatMightReply: userThatMightReply,
				},
				url:'ViewTopicDetailsServlet',
				success: function(result){
					$('#result1').html(result);
					$('#userSelectsOneTopic').hide();
					$('#userFlagsOneTopicView').hide();
					$('#userEntersReplyView').show();
					$('#userFlagsReplyView').show();
				}
			});
		});
		
		// user can flag a topic
		$('#flagTopicBtn').click(function(){
			var topicIdToFlag = $('#topicIdToFlag').val();
			$.ajax({
				type:'POST',
				data: {
					topicIdToFlag: topicIdToFlag,
				},
				url:'UserFlagsTopicServlet',
				success: function(result){
					$('#result1').html(result);
					$('#topicIdToFlag').val("");
				}
			});
		});
		
		// user can add their own reply
		$('#submitReplyBtn').click(function(){
			var originalTopicId = $('#topicId').val();
			var userReplyEntry = $('#userReplyEntry').val();
			var userThatMightReply = $('#loggedInUsername').text();
			$.ajax({
				type:'POST',
				data: {
					originalTopicId: originalTopicId,
					userReplyEntry: userReplyEntry,
					userThatMightReply: userThatMightReply,
				},
				url:'PostNewReplyServlet',
				success: function(result){
					$('#result1').html(result);
					$('#userReplyEntry').val('');
				}
			});
		});
		
		// user can flag a reply
		$('#submitFlagReplyBtn').click(function(){
			var userFlagReplyEntry = $('#userFlagReplyEntry').val();
			
			$.ajax({
				type:'POST',
				data: {
					userFlagReplyEntry: userFlagReplyEntry
				},
				url:'UserFlagsReplyServlet',
				success: function(result){
					$('#result1').html(result);
					$('#userFlagReplyEntry').val('');
					$('#userReplyEntry').val('');
					$("#userEntersReplyView").hide();
					$("#userFlagsReplyView").hide();
				}
			});
		});
		
		// user can view all of their replies
		$('#viewYourRepliesBtn').click(function(){
			var username = $('#loggedInUsername').text();
			$.ajax({
				type:'POST',
				data: {
					username: username
				},
				url:'UserViewsTheirRepliesServlet',
				success: function(result){
					$('#result1').html(result);
					$('#userUpdatesTheirProfileView').hide();
					$('#userFlagReplyEntry').val('');
					$('#userReplyEntry').val('');
					$("#userEntersReplyView").hide();
					$("#userFlagsReplyView").hide();
				}
			});
		});
		
		// display the profile update form to the user
		$('#updateYourProfileBtn').click(function(){
			document.getElementById("result1").style.display = "none";
			document.getElementById("userUpdatesTheirProfileView").style.display = "block";
			document.getElementById("updateYourProfileBtnDisplay").style.display = "none";
		});
		
		// submit profile update changes
		$('#submitProfileUpdatesBtn').click(function(){
			var username = $('#loggedInUsername').text();
			var userNewAge = $('#userNewAge').val();
			var userNewLocation = $('#userNewLocation').val();
			var userNewOccupation = $('#userNewOccupation').val();
			$.ajax({
				type:'POST',
				data: {
					username: username,
					userNewAge: userNewAge,
					userNewLocation: userNewLocation,
					userNewOccupation: userNewOccupation
				},
				url:'UserSubmitsProfileChangesServlet',
				success: function(result){
					$('#result1').html(result);
					$('#result1').show();
					$('#userNewAge').val("");
					$('#userNewLocation').val("");
					$('#userNewOccupation').val("");
					$('#userUpdatesTheirProfileView').hide();
					$('#updateYourProfileBtnDisplay').show();
				}
			});
		});
		
		// user can view their profile
		$('#viewYourProfileBtn').click(function(){
			var username = $('#loggedInUsername').text();
			$.ajax({
				type:'POST',
				data: {
					username: username
				},
				url:'ViewProfileInfoServlet',
				success: function(result){
					$('#result1').html(result);
				}
			});
		});
});