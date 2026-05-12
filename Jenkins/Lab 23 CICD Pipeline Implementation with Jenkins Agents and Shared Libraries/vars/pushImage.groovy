def call(String imageName, String tag, String credId) {
    withCredentials([usernamePassword(credentialsId: credId, passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "echo \$PASS | docker login -u \$USER --password-stdin"
        sh "docker push ${imageName}:${tag}"
    }
}
