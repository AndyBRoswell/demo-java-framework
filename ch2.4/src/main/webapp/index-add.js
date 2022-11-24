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
        console.log(t)
        if (typeof t !== 'string') {
            const tag_name = t.tagName.toLowerCase()
            switch (tag_name) {
                case 'fieldset':
                    const is_this_array = t.hasAttribute("title") && t.getAttribute('title').toLowerCase() === 'map-to-json-array'
                    is_this_array ? s.push(']') : s.push('}')
                    for (const child of t.children) {
                        const tag_name = child.tagName.toLowerCase()
                        switch (tag_name) {
                            case 'input':
                            case 'fieldset':
                                console.log("child tag name = " + tag_name)
                                s.push(child)
                                // s.push(child, ',')
                                break
                            default:
                                break
                        }
                    }
                    is_this_array ? s[s.length - 1] = '[' : s[s.length - 1] = '{'
                    break
                case 'input':
                    const input_type = t.getAttribute('type').toLowerCase()
                    switch (input_type) {
                        case 'checkbox':
                            if (t.parentElement.getAttribute("title").toLowerCase() === 'map-to-json-array') {
                                if (t.getAttribute('checked')) s.push(t.getAttribute('name'));
                            } else {
                                s.push(t.getAttribute('checked'), ':', t.getAttribute('name'))
                            }
                            s.push(',')
                            break
                        case 'number':
                        case 'text':
                            let value = t.getAttribute('value')
                            if (value === null) break
                            if (input_type === 'text') value = JSON.stringify(value)
                            const next_node = t.nextElementSibling
                            if (next_node !== null && next_node.tagName.toLowerCase() === 'label') {
                                s.push('}', next_node.textContent, ':', 'unit', ',', value, ':', 'value', '{', ':', t.getAttribute('name'))
                            } else {
                                s.push(value, ':', t.getAttribute('name'))
                            }
                            s.push(',')
                            break
                        default:
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
    request_body = request_body.join('')
    console.log(request_body)
}