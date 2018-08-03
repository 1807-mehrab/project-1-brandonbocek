$(document).ready(function() {	

		// user or admin logs in
		$('#loginBtn').click(function(){
			document.getElementById("result1").style.display = "block";
			var fullname = $('#fullname').val();
			var mypassword = $('#mypassword').val();
			$.ajax({
				type:'POST',
				data: {
					fullname: fullname, 
					mypassword: mypassword
				},
				url:'SignInServlet',
				success: function(result){
					$('#result1').html(result);
					// the user logged in successfully
					if(fullname == "admin" && mypassword == "admin"){
						$('#adminSeesAllTopicsView').show();
						$('#adminSeesAllFlaggedTopicsToChangeThemView').show();
						$('#adminSeesAllFlaggedRepliesToChangeThemView').show();
						$('#adminSeesAllUsersView').show();
						$('#logoutDisplay').show();
						$('#enterLoginCreds').hide();
						$('#loggedInUsername').html("The Admin is logged in");
						$('#result1').show();
						
					}else if($('#result1').text().substring(0,7) == "Welcome") {
						$('#logoutDisplay').show();
						$('#viewAllTopicsBtnDisplay').show();
						$('#postNewTopicBtnDisplay').show();
						$('#viewYourRepliesBtnDisplay').show();
						$('#viewYourProfileBtnDisplay').show();
						$('#updateYourProfileBtnDisplay').show();
			
						$('#enterLoginCreds').hide();
						$('#loggedInUsername').html(fullname);
						$('#result1').show();
						
					//user was not found in the db
					}else{
						$('#logoutDisplay').hide();
						$('#enterLoginCreds').show();
						$('#viewAllTopicsBtnDisplay').hide();
						$('#postNewTopicBtnDisplay').hide();
						$('#viewYourRepliesBtnDisplay').hide();
						$('#viewYourProfileBtnDisplay').hide();
						$('#updateYourProfileBtnDisplay').hide();
						$('#result1').show();
					}
					
				}
			});
			
		});
		
		// user or admin logs out
		$('#logoutBtn').click(function(){
			$('#result1').hide();
			$('#loggedInUsername').html("");
			$('#result1').html("");
			
			$('#logoutDisplay').hide();
			$('#enterLoginCreds').show();
			$('#viewAllTopicsBtnDisplay').hide();
			$('#postNewTopicBtnDisplay').hide();
			$('#viewYourRepliesBtnDisplay').hide();
			$('#viewYourProfileBtnDisplay').hide();
			$('#updateYourProfileBtnDisplay').hide();
			$('#userEntersReplyView').hide();
			$('#userSelectsOneTopic').hide();
			$('#userFlagsOneTopicView').hide();
			
			$('#adminDeleteTopicView').hide();
			$('#adminSeesAllTopicsView').hide();
			$('#adminSeesAllFlaggedTopicsToChangeThemView').hide();
			$('#adminSeesAllFlaggedRepliesToChangeThemView').hide();
			$('#adminSeesAllUsersView').hide();
		});
});