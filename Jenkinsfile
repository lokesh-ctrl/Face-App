pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'chmod a+x gradlew'
                sh './gradlew clean build'
            }
        }
    }
}
