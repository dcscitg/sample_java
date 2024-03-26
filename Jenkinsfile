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
                script {
                    def mvn = tool 'Default Maven'
                    withSonarQubeEnv(sonarqube) {
                        sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=sonar_test -Dsonar.projectName='sonar_test'"
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



