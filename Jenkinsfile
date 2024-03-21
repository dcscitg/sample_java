pipeline {
    agent any // Runs the pipeline on any available agent/node

    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from the Git repository configured in Jenkins
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Use the configured Maven installation to build the project
                // Replace 'Maven 3.6.3' with the name of your Maven installation in Jenkins
                // Specify the Maven goals and options as needed (e.g., clean, package, -DskipTests)
                script {
                    def mvnHome = tool 'Maven 3.9.6'
                    if (mvnHome) {
                        sh "${mvnHome}/bin/mvn -B -DskipTests clean package"
                    } else {
                        error "Maven installation not found"
                    }
                }
            }
        }
    }

    post {
        success {
            // Actions to perform if the build is successful
            echo 'Build successful! Deploying artifacts...'
            // Add deployment steps or notifications here
        }
        failure {
            // Actions to perform if the build fails
            echo 'Build failed! Sending notifications...'
            // Add notification steps (e.g., email, Slack) here
        }
    }
}


