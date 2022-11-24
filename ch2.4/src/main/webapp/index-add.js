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
    const actions = []
    const request_body = ""
    while (s.length !== 0) {
        const t = s[s.length - 1]
        s.pop()
        switch (t.tag) {
            case 'fieldset':
                actions.push(special_action.lcurly)
                let checkbox_only = true
                for (const child of t.children) {
                    s.push(child);
                    if (child.tagName.toLowerCase() === 'input' && child.getAttribute("type") !== "checkbox") {
                        checkbox_only = false
                    }
                }

                break
            case 'input':
                break
            case 'label':
                break
            default:
                break
        }
    }
}