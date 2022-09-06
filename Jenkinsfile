pipeline {
    agent any
    
    tools {
        maven 'mvn-3.8.6'
    }
    
    stages {
        stage('Build') {
            steps {
                sh "mvn clean package spring-boot:repackage"
                sh "printenv"
                slackSend channel: "#jenkins", color: "good", message: "Message build"
            }
        }
    }  
    
    post {
        failure {
            echo 'I failed :('
            slackSend channel: "#jenkins", color: "good", message: "Message pipline-test-2 fail"
        }
        
        always {
            junit testResults: "**/target/surefire-reports/*.xml"
        }
    }
}