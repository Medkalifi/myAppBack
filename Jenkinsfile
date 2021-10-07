pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                mvn clean install
            }
        }
        stage('Test') {
            steps {
               mvn test 
            }
        }
    }
}
