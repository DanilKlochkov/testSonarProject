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
                    def url = "https://efp6.sm-soft.ru:8243/repo/restscanner/2.0/repo/info?branch=develop&defineDataFromExistingDraft=false&name=https://gitlab.sm-soft.ru/cloudcom/ms.intern.delivery_service"
                    println("Get info from ${url}")

                    def res = sh(script: "curl -X GET --header 'Content-Type: *' --header 'Accept: */*' --header 'Authorization: 840d2bd9-c0d9-3b92-914d-5a40d67760df' '${url}' -k",
                            returnStdout: true
                    )
                    println(res)

//                     def exists = fileExists 'repo.json'
//
//                     if (!exists) {
//                         println 'Такого файла нет!'
//                     }
                }
            }
        }
    }
}