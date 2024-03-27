pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    environment {
        mvn = tool 'maven'
    }
    stages {
        stage('Build') {
            steps {
                sh "${mvn}/bin/mvn -B -DskipTests clean package"
            }
        }
        stage('Test') {
            steps {
                sh "${mvn}/bin/mvn test"
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Git Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/dcscitg/sample_java.git']])
                echo 'Git Checkout Completed'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                script {
                    withSonarQubeEnv('sonarqube') {
                        sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=sonar_test -Dsonar.projectName='sonar_test' -Dsonar.host.url=http://192.168.2.247:9000"
                        echo 'SonarQube Analysis Completed'
                    }
                }
            }
        }
        stage('Deliver') { 
            steps {
                sh './deliver.sh' 
            }
        }
    }
}
