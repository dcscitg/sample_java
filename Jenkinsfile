



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
            def mvn = tool 'Default Maven';
            withSonarQubeEnv() {
          sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=sonar_test -Dsonar.projectName='sonar_test'"
        }
  }  stage('Deliver') { 
            steps {
                sh "chmod +x -R ${env.WORKSPACE}"
                sh './deploy.sh' 
            }
        }
    }
}





