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
                    List commitMsg = commit.split(" ")
                    println commit
                    println commitMsg[1]

                    if (!(commitMsg[1] ==~ /[A-Z]+-\d+/)) {
                        error "Commit message should start with Jira task number!"
                    }
                }
            }
        }
        stage('repo scan') {
            steps {
                script {
                    def exists = fileExist 'repo.json'

                    if (!exists) {
                        println 'Такого файла нет!'
                    }

                }
            }
        }
    }
}