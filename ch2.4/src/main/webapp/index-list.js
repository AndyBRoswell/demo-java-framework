const list_button = document.getElementById('list_button')
const all_speakers_textarea = document.getElementById('all-speakers')
list_button.onclick = () => {
    const HTTP_request = new XMLHttpRequest()
    HTTP_request.open('get', window.location.href + 'list', true)
    HTTP_request.send()
    HTTP_request.onloadend = () => {
        all_speakers_textarea.textContent = HTTP_request.responseText
    }
}