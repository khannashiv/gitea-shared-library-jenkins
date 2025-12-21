def call() { 
		// Change from 'slack_notification' to 'call'
		def buildResult = currentBuild.currentResult
		def buildUrl = env.BUILD_URL ?: 'URL not available'
		
		if (buildResult == 'UNSTABLE') {
			slackSend channel: 'demo-notificaions-1', 
						color: '#ff8c00ff', 
						message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER}\n${buildUrl}",
						teamDomain: 'jenkins-workspace', 
						tokenCredentialId: 'Slack-Jenkins-OAUTH-Token'
			println("Color of the build is: Orange")
		} 

		else if (buildResult == 'ABORTED') {
			slackSend channel: 'demo-notificaions-1', 
						color: '#809fff', 
						message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER}\n${buildUrl}",
						teamDomain: 'jenkins-workspace', 
						tokenCredentialId: 'Slack-Jenkins-OAUTH-Token'
			println("Color of the build is: Blue")
		} 

		else if (buildResult == 'SUCCESS') {
			slackSend channel: 'demo-notificaions-1', 
						color: '#99ff66', 
						message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER}\n${buildUrl}",
						teamDomain: 'jenkins-workspace', 
						tokenCredentialId: 'Slack-Jenkins-OAUTH-Token'
			println("Color of the build is: Green")
		} 

		else if (buildResult == 'FAILURE') {
			slackSend channel: 'demo-notificaions-1', 
						color: '#ff0000', 
						message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER}\n${buildUrl}",
						teamDomain: 'jenkins-workspace', 
						tokenCredentialId: 'Slack-Jenkins-OAUTH-Token'
			println("Color of the build is: Red")
		}

		else {
			slackSend channel: 'demo-notificaions-1', 
						color: '#808080', 
						message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER}\n${buildUrl}",
						teamDomain: 'jenkins-workspace', 
						tokenCredentialId: 'Slack-Jenkins-OAUTH-Token'
			println("Color of the build is: Gray (for other statuses)")
		}
}
