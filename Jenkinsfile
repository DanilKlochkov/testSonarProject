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
                    commit = sh(returnStdout: true, script: 'git log -1 --oneline').trim()
                    println result
                    List commitMsgPre = commit.split(" ")
                    String commitMsg = ""

                    for (int i = 1; i < commitMsgPre.size(); i++) {
                        commitMsg += commitMsgPre.getAt(i) + " "
                    }
                }
            }
        }
    }
}