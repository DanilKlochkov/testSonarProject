pipeline {
    agent any
    tools {
        jdk 'jdk17'
        maven 'mvn'
    }
    stages {
        stage('Get from GitHub') {
            steps {
                git url: 'https://github.com/DanilKlochkov/testSonarProject.git'
            }
        }
        stage('build && SonarQube analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    withMaven {
                        sh 'mvn clean package sonar:sonar'
                    }
                }
            }
        }
        stage("Quality Gate") {
            def qg = waitForQualityGate()
            if (qg.status != 'OK') {
              error "Pipeline aborted due to quality gate failure: ${qg.status}"
            }
        }
    }
}