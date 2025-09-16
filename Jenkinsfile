

pipeline {
    agent any

    options {
        timestamps()
    }

    environment {
        MVN_HOME = tool 'M3'
        PATH = "${MVN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                cleanWs()
                checkout scm
                echo 'Código fonte baixado e workspace limpo.'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean package'
                echo 'Projeto compilado, testado e empacotado com sucesso.'
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                echo 'Artefato (.jar) arquivado.'
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline finalizado.'
        }
        success {
            echo 'Build concluído com SUCESSO!'
        }
        failure {
            echo 'Build FALHOU.'
        }
    }
}