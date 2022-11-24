const add_button = document.getElementById("add_button")
add_button.onclick = () => {
    const speaker = {}
    const new_speaker_form = document.getElementById("new-speaker")
    console.log(Date.now())
    console.log(new_speaker_form)
    console.log(new_speaker_form.children)

    const s = [ new_speaker_form ]
    let request_body = []
    while (s.length !== 0) {
        const t = s[s.length - 1]
        s.pop()
        if (typeof t !== 'string') {
            switch (t.tagName.toLowerCase()) {
                case 'fieldset':
                    const this_is_array = t.hasAttribute("title") && t.getAttribute('title').toLowerCase() === 'map-to-json-array'
                    this_is_array ? s.push(']') : s.push('}')
                    for (const child of t.children) {
                        s.push(child, ',')
                    }
                    this_is_array ? s[s.length - 1] = '{' : s[s.length - 1] = '{'
                    break
                case 'input':
                    const input_type = t.getAttribute('type').toLowerCase()
                    switch (input_type) {
                        case 'checkbox':
                            if (t.parentElement.getAttribute("title").toLowerCase() === 'map-to-json-array') {
                                s.push(t.getAttribute('name'));
                            } else {
                                s.push(t.getAttribute('checked'), ':', t.getAttribute('name'))
                            }
                            break
                        case 'number':
                        case 'text':
                            const next_node = t.nextElementSibling
                            if (next_node !== null && next_node.tagName.toLowerCase() === 'label') {
                                s.push(next_node.textContent, ':', 'unit', ',')
                            }
                            let value = t.getAttribute('value')
                            if (input_type === 'text') {
                                value = JSON.stringify(value)
                            }
                            s.push(value, ':', t.getAttribute('name'))
                            break
                    }
                    break
                default:
                    break
            }
        } else {
            request_body.push(t)
        }
    }
    request_body.join('')
    console.log(request_body)
}