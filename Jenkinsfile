



pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh '''mvn clean verify sonar:sonar \
                    -Dsonar.projectKey=sonar_test \
                    -Dsonar.projectName='sonar_test' \
                    -Dsonar.host.url=http://localhost:9000 \
                    -Dsonar.token=sqp_6d0a6ed292eb7e0a7a6db6f61dc7885e3be35a79'''
                    echo 'SonarQube Analysis Completed'
                }
            }
        }
        stage('Deliver') { 
            steps {
                sh "chmod +x -R ${env.WORKSPACE}"
                sh './deploy.sh' 
            }
        }
    }
}





