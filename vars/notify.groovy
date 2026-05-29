def call(
    String credentialId,
    String jobName,
    String buildNumber,
    String buildUrl,
    String status,
    Boolean mentionAll = false,
) {

    def prefix = mentionAll ? '<users/all> ' : ''
    def extra  = extraMessage?.trim() ? "\\n${extraMessage}" : ''

    def payload = """{
        "text":"${prefix} *${jobName}* — Build *#${buildNumber}*\\n*Status:* ${status}\\n*Link:* ${buildUrl}${extra}"
    }"""

    withCredentials([string(credentialsId: credentialId, variable: 'WEBHOOK_URL')]) {

        sh """
            curl -s -o /dev/null -w "%{http_code}" \
            -X POST \
            -H 'Content-Type: application/json' \
            -d '${payload}' \
            "\${WEBHOOK_URL}"
        """
    }
}