const response_area = document.getElementById('response')
const test_button = document.getElementById('test')
const show_response_body = () => {
    const HTTP_request = new XMLHttpRequest()
    HTTP_request.open('get', 'test', true)
    HTTP_request.send()
    HTTP_request.onloadend = () => {
        response_area.textContent = HTTP_request.responseText
    }
}
test_button.onclick = show_response_body
