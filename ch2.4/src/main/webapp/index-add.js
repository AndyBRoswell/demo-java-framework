const add_button = document.getElementById("add_button")
add_button.onclick = () => {
    const speaker = {}
    const new_speaker_form = document.getElementById("new-speaker")
    console.log(Date.now())
    console.log(new_speaker_form)
    console.log(new_speaker_form.children)

    const special_action = Object.freeze({
        comma: 0, lsquare: 1, rsquare: 2, lcurly: 3, rcurly: 4, colon: 5,
    })
    const s = [ new_speaker_form ]
    let request_body = []
    while (s.length !== 0) {
        const t = s[s.length - 1]
        s.pop()
        if (typeof t !== 'string') {
            switch (t.tag) {
                case 'fieldset':
                    const this_is_array = t.getAttribute('title').toLowerCase() === 'map-to-json-array'
                    // this_is_array ? s.push(special_action.rsquare) : s.push(special_action.rcurly)
                    this_is_array ? s.push(']') : s.push('}')
                    for (const child of t.children) {
                        s.push(child)
                    }
                    // this_is_array ? s.push(special_action.lsquare) : s.push(special_action.lcurly)
                    this_is_array ? s.push('{') : s.push('{')
                    break
                // case special_action.lsquare:
                //     request_body.push('[')
                //     break
                // case special_action.rsquare:
                //     request_body.push(']')
                //     break
                // case special_action.lcurly:
                //     request_body.push('{')
                //     break
                // case special_action.rcurly:
                //     request_body.push('}')
                //     break
                // case special_action.comma:
                //     request_body.push('')
                //     break
                case 'input':
                    if (t.getAttribute("type").toLowerCase() === 'checkbox') {
                        
                    } else {

                    }
                    break
                case 'label':

                    break
                default:
                    break
            }
        } else {
            request_body.push(t)
        }
    }
}