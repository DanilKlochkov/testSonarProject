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
        stage('build') {
            steps {
                withMaven {
                    sh 'mvn clean install'
                }
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
        stage('Quality gate') {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }
    }
}