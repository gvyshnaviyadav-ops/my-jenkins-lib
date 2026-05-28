def call(String stackName,String tag,String dockerHubUsername) {
    sh """
        echo "Deploying ${stackName}..."
        export tag=${tag}
        export duser=${dockerHubUsername}
        docker stack deploy \
            -c docker-compose.yml \
            ${stackName}
            
        echo "Verifying deployment..."
        docker stack ps ${stackName}
    """
}