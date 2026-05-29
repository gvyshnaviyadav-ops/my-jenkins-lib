def call(String stackName,String tag,String dockerHubUsername) {
    sh """
        echo "deploying ${stackName}"
        export tag=${tag}
        export duser=${dockerHubUsername}
        sleep 20
        docker stack deploy  -c docker-compose.yml ${stackName}
        echo "Verify"
        echo"docker stack ps ${stackName}"
    """
}