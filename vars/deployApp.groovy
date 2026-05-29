def call(String stackName,String tag,String dockerHubUsername) {
    sh """
        echo "deploying ${stackName}"
        export tag=${tag}
        export duser=${dockerHubUsername}
        docker stack rm ${stackName} || true
        sleep 20
        docker images
        docker stack deploy  -c docker-compose.yml ${stackName}
        echo "Verify"
        docker stack ps ${stackName}
    """
}