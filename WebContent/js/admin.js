$(document).ready(function() {
	
	//admin updates view to see all topics
	$('#adminGoToAllTopicsBtn').click(function(){
		$('#idNumOfReplyToEdit').val('');
		$('#newContentOfEditedReply').val('');
		$('#adminDeleteReplyView').hide();
		$('#adminEditReplyView').hide();
		$('#idNumOfTopicToEdit').val('');
		$('#newContentOfEditedTopic').val('');
		$('#adminDeleteTopicView').hide();
		$('#adminEditTopicView').hide();
		
		$.ajax({
			type:'POST',
			url:'ViewAllTopicsServlet',
			success: function(result){
				$('#result1').html(result);
				//$('#adminDeleteTopicView').show();
			}
		});
	});
	
	// admin can see all flagged topics
	$('#adminGoToAllTopicsForChangeBtn').click(function(){
		
		$('#idNumOfReplyToEdit').val('');
		$('#newContentOfEditedReply').val('');
		$('#adminDeleteReplyView').hide();
		$('#adminEditReplyView').hide();
		
		$.ajax({
			type:'POST',
			url:'ViewFlaggedTopicsServlet',
			success: function(result){
				$('#result1').html(result);
				$('#adminDeleteTopicView').show();
				$('#adminEditTopicView').show();
			}
		});
	});
	
	//admin can delete a topic IF IT IS FLAGGED
	$('#adminDeleteTopicBtn').click(function(){
		var idOfTopicToDelete = $('#idNumOfTopicToDelete').val();
		$.ajax({
			type:'POST',
			data: {
				idOfTopicToDelete: idOfTopicToDelete
			},
			url:'DeleteTopicServlet',
			success: function(result){
				$('#result1').html(result);
				$('#idNumOfTopicToDelete').val('');
			}
		});
	});
	
	// admin can edit a topic
	$('#adminEditTopicBtn').click(function(){
		var idNumOfTopicToEdit = $('#idNumOfTopicToEdit').val();
		var newContentOfEditedTopic = $('#newContentOfEditedTopic').val();
		$.ajax({
			type:'POST',
			data: {
				idNumOfTopicToEdit: idNumOfTopicToEdit,
				newContentOfEditedTopic: newContentOfEditedTopic
			},
			url:'EditTopicServlet',
			success: function(result){
				$('#result1').html(result);
				$('#idNumOfTopicToEdit').val('');
				$('#newContentOfEditedTopic').val('');
			}
		});
	});
	
	//admin can view all flagged replies
	$('#adminGoToAllRepliesForChangeBtn').click(function(){
		$('#idNumOfTopicToEdit').val('');
		$('#newContentOfEditedTopic').val('');
		$('#adminDeleteTopicView').hide();
		$('#adminEditTopicView').hide();
		$.ajax({
			type:'POST',
			url:'ViewFlaggedRepliesServlet',
			success: function(result){
				$('#result1').html(result);
				$('#adminDeleteReplyView').show();
				$('#adminEditReplyView').show();
			}
		});
	});
	
	//admin can delete a reply if it is flagged
	$('#adminDeleteReplyBtn').click(function(){
		var idNumOfReplyToDelete = $('#idNumOfReplyToDelete').val();
		$.ajax({
			type:'POST',
			data: {
				idNumOfReplyToDelete: idNumOfReplyToDelete
			},
			url:'DeleteReplyServlet',
			success: function(result){
				$('#result1').html(result);
				$('#idNumOfReplyToDelete').val('');
			}
		});
	});
	
	// admin can edit a REPLY
	$('#adminEditReplyBtn').click(function(){
		var idNumOfReplyToEdit = $('#idNumOfReplyToEdit').val();
		var newContentOfEditedReply = $('#newContentOfEditedReply').val();
		$.ajax({
			type:'POST',
			data: {
				idNumOfReplyToEdit: idNumOfReplyToEdit,
				newContentOfEditedReply: newContentOfEditedReply
			},
			url:'EditReplyServlet',
			success: function(result){
				$('#result1').html(result);
				$('#idNumOfReplyToEdit').val('');
				$('#newContentOfEditedReply').val('');
			}
		});
	});
	
	// admin can see all users
	$('#adminSeesAllUsersBtn').click(function(){
		
		$.ajax({
			type:'POST',
			url:'ViewAllUsersServlet',
			success: function(result){
				$('#result1').html(result);
				
				
				$('#idNumOfReplyToEdit').val('');
				$('#newContentOfEditedReply').val('');
				$('#adminDeleteReplyView').hide();
				$('#adminEditReplyView').hide();
				
				$('#idNumOfTopicToEdit').val('');
				$('#newContentOfEditedTopic').val('');
				$('#adminDeleteTopicView').hide();
				$('#adminEditTopicView').hide();
				
			}
		});
	});
	
});