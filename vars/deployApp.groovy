def call(String stackName,String tag,String dockerHubUsername) {
    sh """
        echo "deploying ${stackName}"
        export tag=${tag}
        export duser=${dockerHubUsername}
        echo "docker stack rm ${stackName} || true"
        sleep 20
        echo "docker stack deploy  -c docker-compose.yml ${stackName}"
        docker compose up --build
            
        echo "Verify"
        echo"docker stack ps ${stackName}"
    """
}