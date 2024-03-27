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
                        sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=sample_java -Dsonar.projectName='sample_java' -Dsonar.host.url=http://192.168.2.247:9000 -Dsonar.login=sqp_a8991c2ffea16facc46421e59ac07501da3ac843"
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
