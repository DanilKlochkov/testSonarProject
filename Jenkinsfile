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
    }
}