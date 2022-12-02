pipeline {
    agent any
    tools {
        jdk 'jdk17'
        maven 'mvn'
    }
    stages {
//         stage('Get from GitHub') {
//             steps {
//                 git url: 'https://github.com/DanilKlochkov/testSonarProject.git'
//             }
//         }
//         stage('build') {
//             steps {
//                 withMaven {
//                     sh 'mvn clean test'
//                 }
//             }
//         }
//         stage('build && SonarQube analysis') {
//             steps {
//                 withSonarQubeEnv('sonarqube') {
//                     withMaven {
//                         sh 'mvn clean package sonar:sonar'
//                     }
//                 }
//             }
//         }
//         stage('Quality gate') {
//             steps {
//                 waitForQualityGate abortPipeline: true
//             }

//         }
        stage('name check') {
            steps {
                script {
                    String commit = sh(returnStdout: true, script: 'git log -1 --oneline').trim()
                    println commit
                    println commit[1]
                    if (!(commit[1] ==~ /\d+/)) {
                        error "Commit message should start with Jira task number!"
                    }
                }
            }
        }
    }
}