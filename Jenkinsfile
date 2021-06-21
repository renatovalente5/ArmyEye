def remote = [:]
remote.host = "192.168.160.87"
remote.name = "Playground"

pipeline {
    agent any
    tools {
        jdk 'jdk11'
        maven "maven36"
    }

    stages {
        stage('Cloning repository') {
            steps {
                git(
                    branch: 'main',
                    url: 'https://github.com/o2valente/es-2020-2021-P21.git'
                    
                )
                sh "chmod +x -R ${env.WORKSPACE}"
            }
        }
        stage('Build') {
            steps {
                dir("ArmyEye"){
                sh 'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                dir("ArmyEye") {
                    echo "Testing"
                    sh "mvn test"
                }
            }
        }
        stage('Deploy') {
            steps {
                dir("ArmyEye"){
                    echo "Deploying Artifact .."
                    sh "mvn deploy -f pom.xml -s settings.xml"
                }
            }
        }
        stage("Build image"){
            steps{
                script{
                        docker.withRegistry('http://192.168.160.48:5000') {
                            db = docker.build("esp21/armyeye", "./ArmyEye")
                            react = docker.build("esp21/react", "./ArmyEye/src/main/frontend")
                   }
                }
            }
        }
        stage("Publish image"){
            steps{
                script{
                        docker.withRegistry('http://192.168.160.48:5000') {
                            db.push()
                            react.push()
                   }
                sh "docker images"
                }
            }
        }
        
        stage('PlayGround Deploy') { 
            steps {
                 withCredentials([usernamePassword(credentialsId: 'esp21_vms', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    
                    script {
                      remote.user = USERNAME
                      remote.password = PASSWORD
                      remote.allowAnyHosts = true
                        
                    }
                    
                    sshCommand remote: remote, command: "docker stop esp21-armyeye"
                    sshCommand remote: remote, command: "docker rm esp21-armyeye"
                    sshCommand remote: remote, command: "docker rmi 192.168.160.48:5000/esp21/armyeye"
                    sshCommand remote: remote, command: "docker pull 192.168.160.48:5000/esp21/armyeye"
                    sshCommand remote: remote, command: "docker create -p 21001:8080 --name esp21-armyeye 192.168.160.48:5000/esp21/armyeye"
                    sshCommand remote: remote, command: "docker start esp21-armyeye"
                    
                    sshCommand remote: remote, command: "docker stop esp21-react"
                    sshCommand remote: remote, command: "docker rm esp21-react"
                    sshCommand remote: remote, command: "docker rmi 192.168.160.48:5000/esp21/react"
                    sshCommand remote: remote, command: "docker pull 192.168.160.48:5000/esp21/react"
                    sshCommand remote: remote, command: "docker create -p 21004:3000 --name esp21-react 192.168.160.48:5000/esp21/react"
                    sshCommand remote: remote, command: "docker start esp21-react"
                    
                  }
                  
                
            }
        }
    }
}