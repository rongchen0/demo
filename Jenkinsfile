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
        stage('test') {
           steps {
               sh 'mvn clean test -Dmaven.test.failure.igonre=true -DfailIfNoTests=false'
           }
           post {
               success {
                   jacoco (
                       execPattern: '**/target/jacoco.exec',
                       classPattern: '**/classes',
                       sourcePattern: '**/src/main/java',
                       exclusionPattern: '**/src/test*',
                       inclusionPattern: '**/com/hel/auto/service/*.class,**/com/hel/auto/controller/*.class',
                       )
               }
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