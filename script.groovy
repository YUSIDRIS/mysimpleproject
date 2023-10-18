def buildfile() {
    echo "building the application..."
    sh 'npm install'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker_psw', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t yusidris/simplenodemysqlapp:1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push yusidris/simplenodemysqlapp:1.0'
    }
} 

return this

