pipeline {
    agent any
    stages {
        stage('Get from GitHub') {
            steps {
                git url: 'https://github.com/DanilKlochkov/testSonarProject.git'
            }
        }
        stage('build && SonarQube analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    withMaven(maven:'Maven 3.6.3') {
                        sh 'mvn clean package sonar:sonar'
                    }
                }
            }
        }
        stage("Quality Gate") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}