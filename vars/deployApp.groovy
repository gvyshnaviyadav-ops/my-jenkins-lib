def call(String stackName,String tag) {
    sh """
        echo "Deploying ${stackName}..."
        export tag=${tag}
        docker stack deploy \
            -c docker-compose.yml \
            ${stackName}
            
        echo "Verifying deployment..."
        docker stack ps ${stackName}
    """
}