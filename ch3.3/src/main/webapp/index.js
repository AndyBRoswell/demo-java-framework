const response_area = document.getElementById('response')
const inputs = document.getElementsByTagName('input')
for (const input of inputs) {
    input.onclick = () => {
        const HTTP_request = new XMLHttpRequest()
        HTTP_request.open('get', input.getAttribute('value'), true)
        HTTP_request.send()
        HTTP_request.onloadend = () => {
            response_area.textContent = HTTP_request.responseText
        }
    }
}
