def call(String tag,String dockerHubUsername) {
    sh """
        echo "Building images..."
        
        docker build -t todo-frontend:${tag} ./todo-frontend
        docker build -t todo-backend:${tag} ./todo_project

    """
}