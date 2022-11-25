const file_list = document.getElementById('file-list')

function del_file_node(file_node) {
    file_list.removeChild(file_node)
}

function add_file_node() {
    const li = document.createElement('li')
    const file_input = document.createElement('input')
    file_input.setAttribute('type', 'file')
    file_input.setAttribute('name', 'file')
    const description_input = document.createElement('input')
    description_input.setAttribute('type', 'text')
    description_input.setAttribute('name', 'description')
    const del_button = document.createElement('input')
    del_button.setAttribute('type', 'button')
    del_button.setAttribute('value', '➖')
    del_button.onclick = (event) => {
        del_file_node(event.target.parentNode)
    }
    li.append(file_input, description_input, del_button)
    file_list.append(li)
}

const upload_form = document.getElementById('upload-form')
const add_buttons = upload_form.querySelectorAll(':scope>input[type="button"]')
for (const button of add_buttons) {
    const n = button.getAttribute('id').split('_')[1]
    button.onclick = () => {
        for (let i = 0; i < n; ++i) add_file_node()
    }
}