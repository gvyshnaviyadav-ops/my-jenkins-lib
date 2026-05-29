def call(String tag,String dockerHubUsername) {
    sh """

        echo "Tagging and pushing images to Docker Hub..."
        docker tag todo-frontend:${tag} ${dockerHubUsername}/todo-frontend:${tag}
        docker tag todo-backend:${tag} ${dockerHubUsername}/todo-backend:${tag}
        docker push ${dockerHubUsername}/todo-backend:${tag}
        docker push ${dockerHubUsername}/todo-frontend:${tag}
    """
}