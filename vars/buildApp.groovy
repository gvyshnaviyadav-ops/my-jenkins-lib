def call(String tag,String dockerHubUsername) {
    sh """
        echo "Building images..."
        
        docker build -t todo-frontend:${tag} ./todo-frontend
        docker build -t todo-backend:${tag} ./todo_project

        echo "Tagging and pushing images to Docker Hub..."
        docker tag todo-frontend:${tag} ${dockerHubUsername}/todo-frontend:${tag}
        docker tag todo-backend:${tag} ${dockerHubUsername}/todo-backend:${tag}
        docker push ${dockerHubUsername}/todo-backend:${tag}
        docker push ${dockerHubUsername}/todo-frontend:${tag}
    """
}